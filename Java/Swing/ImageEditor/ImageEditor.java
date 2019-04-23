import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.util.Vector;
import java.awt.image.Kernel;
import java.awt.image.ConvolveOp;
import java.awt.image.RescaleOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

public class ImageEditor extends JFrame{  
	
	// I'm getting a warning about not having this, 
	// but have no idea what it's about
	final long serialVersionUID = 0;
	
    //private JPanel canvas;
	Vector<BufferedImage> vectrex; 
	Vector<BufferedImage> vectrexRestore; 
	int currImage = 0;
	BufferedImage aCurrentImage;
	ImagePanel anImagePanel;
	//JLabel aLabel;
	
    public static void main(String[] args){  
    	JFrame frame = new ImageEditor();	
    }

    public ImageEditor(){  
    	setSize(350, 400);
    	setTitle("Image Editor");	
    	setDefaultCloseOperation(EXIT_ON_CLOSE);

    	// getting a warning asking for this
    	final long serialVersionUID = 0;
    	
    	// variables I will need
    	vectrex = new Vector<BufferedImage>(); 
    	vectrexRestore = new Vector<BufferedImage>(); 
    	currImage = 0;
    	//aLabel = new JLabel();
    	
    	Container contentPane = getContentPane();
    	contentPane.setVisible(true);
    	anImagePanel = new ImagePanel();
    	anImagePanel.setSize(200, 100);
    	//anImagePanel.setVisible(true);
    	anImagePanel.setVisible(false);
    	//anImagePanel.add(aLabel);
    	//contentPane.add(anImagePanel, "Center");
    	
    	JPanel p = new JPanel();
    	p.setVisible(true);
    	
    	addButton(p, "<<",
    			  new ActionListener(){  
    				  public void actionPerformed(ActionEvent evt){ 
    					  System.out.println("Previous");
    					  if(currImage>0)
    						  currImage = currImage-1;
    					  	  anImagePanel.setImage(vectrex.elementAt(currImage));
    					  //repaint();
    				  }
    			      });
    	
    	JMenu fileMenu = new JMenu("File");
    	fileMenu.setVisible(true);

	addJMenuItem(fileMenu, "Open",
		new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				    System.out.println("Opening");
           			JFileChooser chooser = new JFileChooser();

    				final ExtensionFileFilter filter = new ExtensionFileFilter();
    				filter.addExtension("jpg");
    				filter.addExtension("gif");
    				filter.setDescription("JPG & GIF Images");
    				chooser.setFileFilter(filter);

         	  		chooser.setCurrentDirectory(new File("."));
           			int r = chooser.showOpenDialog(null);
           			if (r == JFileChooser.APPROVE_OPTION){
               				BufferedImage image;
               				String name = 
               					chooser.getSelectedFile().getAbsolutePath();

               				//stores this image into panel's iv
               				File f = new File(name);
               				try{
                   				image = ImageIO.read(f);
                   				anImagePanel.setImage(image);
                   				vectrex.add(image); 
                   				currImage = vectrex.indexOf(image);
/*                   				
                				BufferedImage temp = 
                					new BufferedImage(
                				  		vectrex.elementAt(currImage).getWidth(),
                				  		vectrex.elementAt(currImage).getHeight(),
                				  		vectrex.elementAt(currImage).getType()
                				);
                				// trying a cloned copy	
                   				temp = anImagePanel.copyBufferedImage(
           									vectrex.elementAt(currImage));
                   				vectrexRestore.add(currImage, temp); 
*/
                   				vectrexRestore.add(currImage, image);
                   				
       									
                   				//aLabel.setIcon(new ImageIcon(name));
                   				//repaint();
               				}
               				catch(IOException ioe){
                   				System.out.println("failed to read loaded image");
                   				return;
               				}
           			}
			}
		}
	);


	addJMenuItem(fileMenu, "Close Image",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				  System.out.println("Closing");
				  if (vectrex!=null)
					  vectrex.removeElementAt(currImage); 
					  vectrexRestore.removeElementAt(currImage);
				  if (vectrex.size() == 0)
					  repaint();
				  else
				  	  currImage = 0;
				  	  anImagePanel.setImage(vectrex.get(currImage));
			  }
		      });
	fileMenu.addSeparator();
	addJMenuItem(fileMenu, "Blur",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){
				  System.out.println("Blurring");
				  // creating convolve variables for blur
				  float weight = 1.0f/9.0f;
				  float[] elements = new float[9];
				  for (int i = 0; i < 9; i++)
					  elements[i] = weight;
				  convolve(elements);
			  }
		}
	);
	addJMenuItem(fileMenu, "Sharpen",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				System.out.println("Sharpening");
				float[] elements =
				    {  0.0f, -1.0f, 0.0f,
				       -1.0f,  5.f, -1.0f,
				       0.0f, -1.0f, 0.0f
				    };
				convolve(elements);
			  }
		      });
	addJMenuItem(fileMenu, "Brighten",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				System.out.println("Brightenizing");
				float a = 1.5f;
				float b = -20.0f;
				RescaleOp op = new RescaleOp(a, b, null);
				filter(op);
			  }
		      });
	addJMenuItem(fileMenu, "Detect Edge",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				  System.out.println("Edge Detectorizing");
				  float[] elements =
				  {		  0.0f, -1.0f, 0.0f,
						  -1.0f, 4.f, -1.0f,	  
						  0.0f, -1.0f, 0.0f
				  };
				  convolve(elements);
			  }
		      });
	addJMenuItem(fileMenu, "Negative",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				System.out.println("Negativizing");
				  byte negative[] = new byte[256];
				  for (int i = 0; i < 256; i++)
					  negative[i] = (byte)(255 - i);
				  ByteLookupTable table = new ByteLookupTable(0, negative);
				  LookupOp op = new LookupOp(table, null);
				  filter(op);

			  }
		      });
	addJMenuItem(fileMenu, "Rotate",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				System.out.println("Rotaterizing");
				double x = 0.5*vectrex.elementAt(currImage).getWidth();
				double y = 0.5*vectrex.elementAt(currImage).getHeight();
				AffineTransform at = new AffineTransform();
				at.rotate(Math.toRadians(90),x,y);
				Graphics2D g2 = vectrex.elementAt(currImage).createGraphics();
				g2.transform(at);

/*
				BufferedImage temp = 
					new BufferedImage(
				  		vectrex.elementAt(currImage).getWidth(),
				  		vectrex.elementAt(currImage).getHeight(),
				  		vectrex.elementAt(currImage).getType()
				);
*/
				//temp = anImagePanel.copyBufferedImage(vectrex.elementAt(currImage));
				g2.drawImage(vectrex.elementAt(currImage), 0, 0, null); 
				//vectrex.set(currImage, temp);
				//anImagePanel.setImage(temp);
				repaint();
			  }
		      });
	addJMenuItem(fileMenu, "Scale",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				    System.out.println("Scalifying");
				    aCurrentImage = vectrex.elementAt(currImage);
					Graphics2D g2 = aCurrentImage.createGraphics();
					g2.scale(.9, .9);
					g2.drawImage(aCurrentImage, 0, 0, null);
					anImagePanel.setImage(aCurrentImage);
			  }
		      });
	fileMenu.addSeparator();
	addJMenuItem(fileMenu, "Restore Original",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				  		System.out.println("Restoring original");
				  		vectrex.set(currImage, vectrexRestore.elementAt(currImage)); 
				  		anImagePanel.setImage(vectrex.elementAt(currImage));	
       			  }
		      });
	fileMenu.addSeparator();
	addJMenuItem(fileMenu, "Exit",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
				  System.out.println("Exiting");
				  System.exit(0);

       			  }
		      });


	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	menuBar.add(fileMenu);
	menuBar.setVisible(true);
    p.add(menuBar);
	//contentPane.add(menuBar, "North");
	//contentPane.add(p, "South");

	addButton(p, ">>",
		  new ActionListener()
		      {  public void actionPerformed(ActionEvent evt)
			  {  
		    	  if (currImage < vectrex.size())
		    		  System.out.println("Next");
				  	  currImage = currImage+1;
				      anImagePanel.setImage(vectrex.elementAt(currImage));
				  //repaint();
			  }
		      });

	// adding everything to the screen
//	if(anImagePanel.hasImage()==true)
//		anImagePanel.setVisible(true);
//	else
//		anImagePanel.setVisible(false);
	
	anImagePanel.setVisible(true);
	p.setVisible(true);
	contentPane.setVisible(true);
	contentPane.add(p, "South");
	contentPane.add(anImagePanel, "Center");
	show();
	//repaint();
    }
    
    public void addButton(Container c, String title, ActionListener a){  
    	JButton b = new JButton(title);
    	c.add(b);
    	b.addActionListener(a);
    	this.setVisible(true);
    }
    
    public void addJMenuItem(JMenu aJMenu, String title, ActionListener a){  
    	JMenuItem b = new JMenuItem(title);
    	aJMenu.add(b);
    	b.addActionListener(a);
    	this.setVisible(true);
    }

    public void convolve(float[] elements){
		  // creating a destination image
		  BufferedImage filteredImage = 
			  	new BufferedImage(
			  			vectrex.elementAt(currImage).getWidth(),
			  			vectrex.elementAt(currImage).getHeight(),
			  			vectrex.elementAt(currImage).getType()
			  	);
		  // creating a kernel
		  Kernel aKernel = new Kernel(3, 3, elements);
		  // creating convolveOp object
		  ConvolveOp aCop = new ConvolveOp(
					aKernel, 
					ConvolveOp.EDGE_NO_OP, 
					null
			);
		  // filtering
		  aCop.filter(
				  // source image
				  vectrex.elementAt(currImage),
				  //destination image
				  filteredImage
		  );
		  vectrex.set(currImage, filteredImage); 
		  anImagePanel.setImage(filteredImage);		
    }
    public void filter(RescaleOp anOp){
		  // creating a destination image
		  BufferedImage filteredImage = 
			  	new BufferedImage(
			  			vectrex.elementAt(currImage).getWidth(),
			  			vectrex.elementAt(currImage).getHeight(),
			  			vectrex.elementAt(currImage).getType()
			  	);
		  // filtering
		  anOp.filter(
				  // source image
				  vectrex.elementAt(currImage),
				  //destination image
				  filteredImage
		  );
		  vectrex.set(currImage, filteredImage); 
		  anImagePanel.setImage(filteredImage);		
  }
    public void filter(LookupOp anOp){
		  // creating a destination image
		  BufferedImage filteredImage = 
			  	new BufferedImage(
			  			vectrex.elementAt(currImage).getWidth(),
			  			vectrex.elementAt(currImage).getHeight(),
			  			vectrex.elementAt(currImage).getType()
			  	);
		  // filtering
		  anOp.filter(
				  // source image
				  vectrex.elementAt(currImage),
				  //destination image
				  filteredImage
		  );
		  vectrex.set(currImage, filteredImage); 
		  anImagePanel.setImage(filteredImage);		
    }
    

    
}// closes class

/*
class MyActionListener implements ActionListener
{
	private ImageEditor imageEditor;
	
	public MyActionListener(ImageEditor imageEditor)
	{
		this.imageEditor = imageEditor;
	}

	public void actionPerformed(ActionEvent e)
	{
		//this.imageEditor.
		if (e.getSource() == myPreviousButton){
			  		JOptionPane.showMessageDialog(null, "Previous");
		}
	}
    
}
*/
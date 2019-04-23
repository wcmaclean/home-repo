import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

class ImagePanel extends JPanel{
	
	final long serialVersionUID = 0;
	private BufferedImage aBufferedImage;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(aBufferedImage, 
			aBufferedImage.getMinX(), 
			aBufferedImage.getMinY(), 
			aBufferedImage.getHeight(),
			aBufferedImage.getWidth(),
			null
		);
	}
	
	public void setImage(BufferedImage aBufferedImage){
		this.aBufferedImage = aBufferedImage;
		repaint();
	}
	public BufferedImage getImage(){
		return this.aBufferedImage;
	}
	public boolean hasImage(){
		if(this.aBufferedImage!=null)
			return true;
		else
			return false;
	}
	public BufferedImage copyBufferedImage(BufferedImage original_image)
	{
		return (BufferedImage)original_image.getScaledInstance(original_image.getWidth(), 
				original_image.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
	}
	
}
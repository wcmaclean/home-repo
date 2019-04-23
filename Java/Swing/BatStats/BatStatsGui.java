// Will MacLean
// BatStatsGui.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;

public class BatStatsGui extends JFrame{

	//////////////////
	// variables
	//////////////////

	// input
	JFormattedTextField atBatsField;
	JFormattedTextField runsField;
	JFormattedTextField hitsField;
	JFormattedTextField dblField;
	JFormattedTextField trplField;
	JFormattedTextField hrField;
	JFormattedTextField rbiField;
	JFormattedTextField bbField;
	JFormattedTextField soField;
	JFormattedTextField hbpField;
	JFormattedTextField sfField;

	// output
	JTextArea tbDisplay;
	JTextArea avgDisplay;
	JTextArea slgDisplay;
	JTextArea obpDisplay;
	JTextArea taDisplay;
	JTextArea braDisplay;

	//////////////////
	// constructor
	//////////////////
	public BatStatsGui(){
		
		// main frame
		setSize(200, 400);
		setTitle("BatStatsGui Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// GUI components
		JFrame batStatsFrame = new JFrame();
		batStatsFrame.setVisible(true);
		//aDisplay = getDisplay();

		// input panel
                JPanel inPanel = new JPanel();
                inPanel.setLayout(new GridLayout(0, 6));

		// At Bats fields
		JLabel atBatsLabel = new JLabel("At Bats:");
		atBatsField = new
			JFormattedTextField(NumberFormat.getIntegerInstance());
		atBatsField.setColumns(1);
		inPanel.add(atBatsLabel);
		inPanel.add(atBatsField);

                // Runs fields
                JLabel runsLabel = new JLabel("Runs:");
                runsField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                atBatsField.setColumns(1);
                inPanel.add(runsLabel);
                inPanel.add(runsField);

                // Hits fields
                JLabel hitsLabel = new JLabel("Hits:");
                hitsField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                hitsField.setColumns(1);
                inPanel.add(hitsLabel);
                inPanel.add(hitsField);

                // Doubles fields
                JLabel dblLabel = new JLabel("Doubles:");
                dblField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                dblField.setColumns(1);
                inPanel.add(dblLabel);
                inPanel.add(dblField);

                // Triples fields
                JLabel trplLabel = new JLabel("Triples:");
                trplField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                trplField.setColumns(1);
                inPanel.add(trplLabel);
                inPanel.add(trplField);

                // Homeruns fields
                JLabel hrLabel = new JLabel("Homeruns:");
                hrField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                hrField.setColumns(1);
                inPanel.add(hrLabel);
                inPanel.add(hrField);

                // RBI fields
                JLabel rbiLabel = new JLabel("RBI:");
                rbiField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                rbiField.setColumns(1);
                inPanel.add(rbiLabel);
                inPanel.add(rbiField);

                // BB fields
                JLabel bbLabel = new JLabel("Walks:");
                bbField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                bbField.setColumns(1);
                inPanel.add(bbLabel);
                inPanel.add(bbField);

                // Strikeout fields
                JLabel soLabel = new JLabel("Strikeouts:");
                soField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                soField.setColumns(1);
                inPanel.add(soLabel);
                inPanel.add(soField);

                // Hit By Pitch fields
                JLabel hbpLabel = new JLabel("Hit By Pitch:");
                hbpField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                hbpField.setColumns(1);
                inPanel.add(hbpLabel);
                inPanel.add(hbpField);

                // Sacrifice Flies fields
                JLabel sfLabel = new JLabel("Runs:");
                sfField = new
                        JFormattedTextField(NumberFormat.getIntegerInstance());
                sfField.setColumns(1);
                inPanel.add(sfLabel);
                inPanel.add(sfField);
	
		// blanks
		JLabel blankLabel = new JLabel(" ");
		inPanel.add(blankLabel);
                JLabel blankLabel1 = new JLabel(" ");
                inPanel.add(blankLabel1);

		// total bases
		JLabel tbLabel = new JLabel("Total Bases:");
		tbDisplay = new JTextArea("n/a");
		inPanel.add(tbLabel);
		inPanel.add(tbDisplay);

                // batting averagve
                JLabel avgLabel = new JLabel("Batting Avg:");
                avgDisplay = new JTextArea("n/a");
                inPanel.add(avgLabel);
                inPanel.add(avgDisplay);

                // slugging percentage
                JLabel slgLabel = new JLabel("Slugging %:");
                slgDisplay = new JTextArea("n/a");
                inPanel.add(slgLabel);
                inPanel.add(slgDisplay);

                // on-base percentage
                JLabel obpLabel = new JLabel("On-base %:");
                obpDisplay = new JTextArea("n/a");
                inPanel.add(obpLabel);
                inPanel.add(obpDisplay);

                // total average
                JLabel taLabel = new JLabel("Total Average:");
                taDisplay = new JTextArea("n/a");
                inPanel.add(taLabel);
                inPanel.add(taDisplay);

                // batting runs average
                JLabel braLabel = new JLabel("Batting Runs Avg:");
                braDisplay = new JTextArea("n/a");
                inPanel.add(braLabel);
                inPanel.add(braDisplay);

                // calculate button
                JButton buttonCalc = new JButton("Calculate");
                buttonCalc.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
				calcStats();
                        }
                });



		// exit button
		JButton buttonQuit = new JButton("Quit");
		buttonQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				System.exit(0);
			}
		});

		// create the layout
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(0, 6));
		controlPanel.setVisible(true);
		controlPanel.add(buttonCalc);
                controlPanel.add(buttonQuit);


		// add fields
		batStatsFrame.add(inPanel, "North");	
		batStatsFrame.add(controlPanel, "South");

		// display
		batStatsFrame.pack();
	}

	////////////////////
	// calculate
	///////////////////
	public void calcStats(){

		// get all values
		int ab = Integer.parseInt(atBatsField.getText());
        	int r = Integer.parseInt(runsField.getText());
        	int h = Integer.parseInt(hitsField.getText());
        	int dbl = Integer.parseInt(dblField.getText());
        	int trpl = Integer.parseInt(trplField.getText());
        	int hr = Integer.parseInt(hrField.getText());
        	int rbi = Integer.parseInt(rbiField.getText());
        	int bb = Integer.parseInt(bbField.getText());
        	int so = Integer.parseInt(soField.getText());
        	int hbp = Integer.parseInt(hbpField.getText());
        	int sf = Integer.parseInt(sfField.getText());

		// create the calcs
		BatStats aBatStats = new BatStats(ab, r, h, dbl, trpl, hr, rbi, 
							bb, so, hbp, sf);

        	// output
        	tbDisplay.setText(Integer.toString(aBatStats.getTB()));
        	avgDisplay.setText(Float.toString(aBatStats.getAVG()));
        	slgDisplay.setText(Float.toString(aBatStats.getSLG()));
        	obpDisplay.setText(Float.toString(aBatStats.getOBP()));
        	taDisplay.setText(Float.toString(aBatStats.getRC()));
        	braDisplay.setText(Float.toString(aBatStats.getOPS()));

	}

	//////////////////
	// main
	/////////////////
	public static void main(String[] args){
		JFrame aBatStatsGui = new BatStatsGui();
	}

}		



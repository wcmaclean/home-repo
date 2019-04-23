// Will MacLean
// Calculator.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame{

	JTextArea aDisplay;
	String aNumber;
	String aSign;
	String aResult;

	public Calculator(){
		initNumber();
		initResult();

		// main frame
		setSize(250, 175);
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// GUI components
		JFrame calcFrame = new JFrame();
		calcFrame.setVisible(true);
		aDisplay = getDisplay();

		// create some buttons
		JButton buttonOne = new JButton("1");
		buttonOne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				setNumber("1");
				setDisplay(getNumber());
			}
		});

		JButton buttonTwo = new JButton("2");
		buttonTwo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				setNumber("2");
				setDisplay(getNumber());
			}
		});	

		JButton buttonThree = new JButton("3");
		buttonThree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				setNumber("3");
				setDisplay(getNumber());
			}
		});
		
		// create second row of buttons
		JPanel aPanel2 = new JPanel();
		aPanel2.setVisible(true);

		JButton buttonFour = new JButton("4");
		buttonFour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				setNumber("4");
				setDisplay(getNumber());
			}
		}); 

		JButton buttonFive = new JButton("5");
		buttonFive.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				setNumber("5");
				setDisplay(getNumber());
			}
		});

		JButton buttonSix = new JButton("6");
		buttonSix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				setNumber("6");
				setDisplay(getNumber());
			}
		});

                JButton buttonSeven = new JButton("7");
                buttonSeven.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
                                setNumber("7");
                                setDisplay(getNumber());
                        }
                });

                JButton buttonEight = new JButton("8");
                buttonEight.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
                                setNumber("8");
                                setDisplay(getNumber());
                        }
                });

                JButton buttonNine = new JButton("9");
                buttonNine.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
                                setNumber("9");
                                setDisplay(getNumber());
                        }
                });

                JButton buttonZero = new JButton("0");
                buttonZero.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
                                setNumber("0");
                                setDisplay(getNumber());
                        }
                });

                JButton buttonPlus = new JButton("+");
                buttonPlus.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
				doMath();
                                setSign("+");
				initNumber();
				setDisplay(getResult());
                        }
                });

                JButton buttonMinus = new JButton("-");
                buttonMinus.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
				doMath();
                                setSign("-");
				initNumber();
				setDisplay(getResult());
                        }
                });

                JButton buttonMultiply = new JButton("*");
                buttonMultiply.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
				doMath();
                                setSign("*");
				initNumber();
				setDisplay(getResult());
                        }
                });

                JButton buttonDivide = new JButton("/");
                buttonDivide.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
				doMath();
                                setSign("/");
				initNumber();
				setDisplay(getResult());
                        }
                });

                JButton buttonDecimal = new JButton(".");
                buttonDecimal.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
                                setNumber(".");
                                setDisplay(getNumber());
                        }
                });


                JButton buttonEquals = new JButton("=");
                buttonEquals.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
                                doMath();
                                setDisplay(getResult());
                        }
                });

                JButton buttonQuit = new JButton("Quit");
                buttonQuit.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
				System.exit(0);
                        }
                });

                JButton buttonClear = new JButton("Clear");
                buttonClear.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ev){
                                // setSign("+");
                                System.out.println("Clear");
				initNumber();
				initResult();
				setDisplay(getNumber());
                        }
                });


		// create display panel
		aDisplay = new JTextArea("I'm the operator of my pocket calculator");
		//aDisplay.setVisible(true);

		// create the button layout
		JPanel aPanel1 = new JPanel();
		aPanel1.setLayout(new GridLayout(0, 4));
                aPanel1.setVisible(true);
                aPanel1.add(buttonOne);
                aPanel1.add(buttonTwo);
                aPanel1.add(buttonThree);
                aPanel1.add(buttonPlus);
                aPanel1.add(buttonFour);
                aPanel1.add(buttonFive);
                aPanel1.add(buttonSix);
                aPanel1.add(buttonMinus);
                aPanel1.add(buttonSeven);
                aPanel1.add(buttonEight);
                aPanel1.add(buttonNine);
                aPanel1.add(buttonMultiply);
                aPanel1.add(buttonZero);
                aPanel1.add(buttonDecimal);
                aPanel1.add(buttonEquals);
                aPanel1.add(buttonDivide);
                aPanel1.add(buttonQuit);
                aPanel1.add(buttonClear);

		calcFrame.add(aDisplay, "North");
		calcFrame.add(aPanel1, "South");

		// display
		calcFrame.pack();
	}

	// mutators
	public void setDisplay(String text){
		this.aDisplay.setText(text);
	}
	public void initNumber(){
		this.aNumber = "";
	}
	public void initResult(){
		this.aResult = "";
	}
	public void setNumber(String newNumber){
		this.aNumber = this.aNumber + newNumber;
	}
        public void setSign(String newSign){
		this.aSign = newSign;
	}
	public void setResult(String newResult){
		this.aResult = newResult;
	}


	// accessors
	public JTextArea getDisplay(){
		return this.aDisplay;
	}
	public String getNumber(){
		return this.aNumber;
	}
	public String getSign(){
		return this.aSign;
	}
	public String getResult(){
		return this.aResult;
	}

	// do the math
	public void doMath(){
		float result = 0;
		if (this.aResult.equals("")){
			this.aResult = this.aNumber;
		}else{
			float val1 = Float.parseFloat(this.aResult);
			float val2 = Float.parseFloat(this.aNumber);
			if (aSign.equals("+")){
				result = val1 + val2;
			}else if (aSign.equals("-")){
				result = val1 - val2;
			}else if (aSign.equals("*")){
				result = val1 * val2;
			}else if (aSign.equals("/")){
				result = val1 / val2;
			}else{ 
				// we'll never get here 
			}
			aResult = Float.toString(result);
		}	
	}


	public static void main(String[] args){
		JFrame aCalculator = new Calculator();
	}
}

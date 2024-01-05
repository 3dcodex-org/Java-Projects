import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;


public class Calculator {
    
	private JFrame frame;
	private JTextField textField;
	
	double first;
	double second;
	double result;
	String operation;
	String answer;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.setBounds(100, 100, 306, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 17));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 269, 67);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		 
			//........................Row 1....................
		
		
						JButton btnBackspace = new JButton("\uF0E7");
						btnBackspace.setBounds(10, 89, 71, 55);
						btnBackspace.setFont(new Font("Windings", Font.BOLD, 19));
						btnBackspace.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
							String backspace=null;
							if (textField.getText().length() > 0) {
								StringBuilder strB=new StringBuilder(textField.getText());
								strB.deleteCharAt(textField.getText().length() - 1);
								backspace=strB.toString();
								textField.setText(backspace);
							 }
							
						   }
						});
						frame.getContentPane().add(btnBackspace);

						JButton btnClear = new JButton("C");
						btnClear.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								 textField.setText(null);
							}
						});
						btnClear.setBounds(76, 89, 71, 55);
						btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
						frame.getContentPane().add(btnClear);
				
		
						JButton btnPercent = new JButton("%");
						btnPercent.setBounds(142, 89, 71, 55);
						btnPercent.setFont(new Font("Tahoma", Font.BOLD, 23));
						btnPercent.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								first=Double.parseDouble(textField.getText());
								textField.setText("");
								operation="%";
		
							}
						});
						frame.getContentPane().add(btnPercent);
						
						 
						
						JButton btnPlus = new JButton("+");
						btnPlus.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								first=Double.parseDouble(textField.getText());
								textField.setText("");
								operation="+";									
							
							
							
							}
						});
						btnPlus.setBounds(208,89, 71, 55);
						btnPlus.setFont(new Font("Tahoma", Font.BOLD, 20));
						frame.getContentPane().add(btnPlus);
				
		
						
						
						
						//........................Row 2....................
						
						
						JButton btn7 = new JButton("7");
						btn7.setBounds(10, 155, 71, 55);
						btn7.setFont(new Font("Tahoma", Font.BOLD, 23));
						btn7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String number=textField.getText()+btn7.getText();
								textField.setText(number);
								
							}
						});
						frame.getContentPane().add(btn7);

						JButton btn8 = new JButton("8");
						btn8.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String number=textField.getText()+btn8.getText();
								textField.setText(number);
							}
						});
						btn8.setBounds(76, 155, 71, 55);
						btn8.setFont(new Font("Tahoma", Font.BOLD, 20));
						frame.getContentPane().add(btn8);
				
		
						JButton btn9 = new JButton("9");
						btn9.setBounds(142, 155, 71, 55);
						btn9.setFont(new Font("Tahoma", Font.BOLD, 23));
						btn9.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
								String number=textField.getText()+btn9.getText();
								textField.setText(number);
							}
						});
						frame.getContentPane().add(btn9);
						
						 
						
						JButton btnSub = new JButton("-");
						btnSub.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
								first=Double.parseDouble(textField.getText());
								textField.setText("");
								operation="-";
							}
						});
						btnSub.setBounds(208, 155, 71, 55);
						btnSub.setFont(new Font("Tahoma", Font.BOLD, 20));
						frame.getContentPane().add(btnSub);
				
		
						//........................Row 3....................
					
					
					    JButton btn4 = new JButton("4");
					    btn4.setBounds(10, 221, 71, 55);
						btn4.setFont(new Font("Tahoma", Font.BOLD, 23));
						btn4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								String number=textField.getText()+btn4.getText();
								textField.setText(number);

							}
						});
						frame.getContentPane().add(btn4);

						JButton btn5 = new JButton("5");
						btn5.setBounds(76, 221, 71, 55);
						btn5.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
								String number=textField.getText()+btn5.getText();
								textField.setText(number);

							}
						});
						btn5.setFont(new Font("Tahoma", Font.BOLD, 21));
						frame.getContentPane().add(btn5);
							
					
						JButton btn6 = new JButton("6");
						btn6.setBounds(142, 221, 71, 55);
						btn6.setFont(new Font("Tahoma", Font.BOLD, 23));
						btn6.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
							;String number=textField.getText()+btn6.getText();
							textField.setText(number);


							}
						});
						frame.getContentPane().add(btn6);
									
									 
									
						JButton btnMult = new JButton("*");
						btnMult.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
								first=Double.parseDouble(textField.getText());
								textField.setText("");
								operation="*";

							}
						});
						btnMult.setBounds(208, 221, 71, 55);
						btnMult.setFont(new Font("Tahoma", Font.BOLD, 20));
						frame.getContentPane().add(btnMult);
							
		
		
						//........................Row 4....................
						
						
					    JButton btn1 = new JButton("1");
					    btn1.setBounds(10, 287, 71, 55);
						btn1.setFont(new Font("Tahoma", Font.BOLD, 23));
						btn1.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
								String number=textField.getText()+btn1.getText();
								textField.setText(number);
							}
						});
						frame.getContentPane().add(btn1);

						JButton btn2 = new JButton("2");
						btn2.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
								String number=textField.getText()+btn2.getText();
								textField.setText(number);
							}
						});
						btn2.setBounds(76, 287, 71, 55);
						btn2.setFont(new Font("Tahoma", Font.BOLD, 21));
						frame.getContentPane().add(btn2);
							
					
						JButton btn3 = new JButton("3");
						btn3.setBounds(142, 287, 71, 55);
						btn3.setFont(new Font("Tahoma", Font.BOLD, 23));
						btn3.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
								String number=textField.getText()+btn3.getText();
								textField.setText(number);						
							}
						});
						frame.getContentPane().add(btn3);
									
									 
									
						JButton btnDivide = new JButton("/");
						btnDivide.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0 ) {
								first=Double.parseDouble(textField.getText());
								textField.setText("");
								operation="/";
		
							}
						});
						btnDivide.setBounds(208, 287, 71, 55);
						btnDivide.setFont(new Font("Tahoma", Font.BOLD, 20));
						frame.getContentPane().add(btnDivide);
							
		
		
		        //........................Row 5....................
						
						
					    JButton btn0 = new JButton("0");
					    btn0.setBounds(10, 353, 71, 55);
						btn0.setFont(new Font("Tahoma", Font.BOLD, 23));
						btn0.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0 ) {
								String number=textField.getText()+btn0.getText();
								textField.setText(number);
							}
						});
						frame.getContentPane().add(btn0);

						JButton btnDot= new JButton(".");
						btnDot.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0 ) {
								String number=textField.getText()+btnDot.getText();
								textField.setText(number);
							}
						});
						btnDot.setBounds(76, 353, 71, 55);
						btnDot.setFont(new Font("Tahoma", Font.BOLD, 20));
						frame.getContentPane().add(btnDot);
							
					
						JButton btnPM = new JButton("+ -");
						btnPM.setBounds(142, 353, 71, 55);
						btnPM.setFont(new Font("Tahoma", Font.BOLD, 20));
						btnPM.addActionListener(new ActionListener() {
							public void actionPerformed( ActionEvent arg0) {
						    double ops = Double.parseDouble(String.valueOf(textField.getText()));
							ops = ops * (-1);
							textField.setText(String.valueOf(ops));
								 }
						});
						frame.getContentPane().add(btnPM);
						
						
						JButton btnEquals = new JButton("=");
						btnEquals.addActionListener(new ActionListener() {
						    public void actionPerformed(ActionEvent arg0) {
						        second = Double.parseDouble(textField.getText());
						        if (operation.equals("+")) {
						            result = first + second;
						        } else if (operation.equals("-")) {
						            result = first - second;
						        } else if (operation.equals("*")) {
						            result = first * second;
						        } else if (operation.equals("/")) {
						            if (second != 0) {
						                result = first / second;
						            } else {
						                JOptionPane.showMessageDialog(frame, "Error: Division by zero");
						                textField.setText("");
						                return;
						            }
						        } else if (operation.equals("%")) {
						            result = first % second;
						        }
						        
						        answer = String.format("%.2f", result);
						        textField.setText(answer);
						    }
						});
						btnEquals.setBounds(208, 353, 71, 55);
						btnEquals.setFont(new Font("Tahoma", Font.BOLD, 20));
						frame.getContentPane().add(btnEquals);

						// ...	
						
	}
									
									 
}
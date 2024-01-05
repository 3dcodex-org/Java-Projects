import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.print.attribute.standard.Destination;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Travel {

	private JFrame frame;
	private JTextField txtFirstname;
	private JTextField txtSurname;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JTextField txtDate;
	protected AbstractButton JAccomodation;
	protected AbstractButton DeparturePoint;
	protected JComboBox Accomadation;
	private JComboBox cabAccomodation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Travel window = new Travel();
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
	public Travel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0 , 1360, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 114, 513, 293);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Firstname");
		lblNewLabel_2.setBounds(10, 13, 106, 28);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 65, 78, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 120, 78, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 211, 123, 21);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 250, 78, 21);
		panel.add(lblNewLabel_5);
		
		txtFirstname = new JTextField();
		txtFirstname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtFirstname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtFirstname.setBounds(137, 21, 277, 28);
		panel.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSurname.setBounds(137, 67, 277, 28);
		panel.add(txtSurname);
		txtSurname.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAddress.setBounds(137, 118, 277, 28);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPhoneNumber.setBounds(137, 209, 277, 28);
		panel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEmail.setBounds(137, 247, 277, 30);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel(" Date");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(10, 171, 93, 21);
		panel.add(lblNewLabel_9);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDate.setBounds(137, 164, 277, 30);
		panel.add(txtDate);
		txtDate.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 425, 513, 208);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel(" Transport Means");
		lblNewLabel_13.setBounds(10, 13, 151, 28);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_13);
		
		JRadioButton rdbtnPlane = new JRadioButton("Plane");
		rdbtnPlane.setBounds(20, 48, 109, 23);
		rdbtnPlane.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnPlane);
		
		JRadioButton rdbtnTrain = new JRadioButton("Train");
		rdbtnTrain.setBounds(17, 84, 109, 23);
		rdbtnTrain.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnTrain);
		
		JRadioButton rdbtnBus = new JRadioButton("Bus");
		rdbtnBus.setBounds(17, 121, 109, 23);
		rdbtnBus.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnBus);
		
		JLabel lblNewLabel_14 = new JLabel(" Ticket Type");
		lblNewLabel_14.setBounds(231, 15, 131, 23);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(lblNewLabel_14);
		
		JRadioButton rdbtnStandard = new JRadioButton(" Standard");
		rdbtnStandard.setBounds(162, 48, 109, 23);
		rdbtnStandard.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnStandard);
		
		JRadioButton rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.setBounds(162, 84, 109, 23);
		rdbtnEconomy.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnEconomy);
		
		JRadioButton rdbtnVip = new JRadioButton("Vip");
		rdbtnVip.setBounds(162, 121, 109, 23);
		rdbtnVip.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnVip);
		
		JRadioButton rdbtnSingleTicket = new JRadioButton("Single Ticket");
		rdbtnSingleTicket.setBounds(273, 48, 109, 23);
		rdbtnSingleTicket.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnSingleTicket);
		
		JRadioButton rdbtnReturnTicket = new JRadioButton("Return Ticket");
		rdbtnReturnTicket.setBounds(273, 84, 120, 23);
		rdbtnReturnTicket.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnReturnTicket);
		
		JRadioButton rdbtnAdult = new JRadioButton("Adult");
		rdbtnAdult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnAdult.setBounds(405, 48, 69, 23);
		rdbtnAdult.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnAdult);
		
		JRadioButton rdbtnChild = new JRadioButton("Child");
		rdbtnChild.setBounds(405, 84, 69, 23);
		rdbtnChild.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_3.add(rdbtnChild);
		
		JRadioButton rdbtnTaxPaid = new JRadioButton("Tax Paid");
		rdbtnTaxPaid.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnTaxPaid.setBounds(31, 166, 95, 23);
		panel_3.add(rdbtnTaxPaid);
		
		JRadioButton rdbtnTravellingInsurancePaid = new JRadioButton("Travelling Insurance Paid");
		rdbtnTravellingInsurancePaid.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnTravellingInsurancePaid.setBounds(138, 166, 208, 23);
		panel_3.add(rdbtnTravellingInsurancePaid);
		
		JRadioButton rdbtnExitLaugage = new JRadioButton("Exit Laugage");
		rdbtnExitLaugage.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnExitLaugage.setBounds(354, 166, 120, 23);
		panel_3.add(rdbtnExitLaugage);
		
		JRadioButton rdbtnRegisterLaugage = new JRadioButton("Register Laugage");
		rdbtnRegisterLaugage.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnRegisterLaugage.setBounds(352, 140, 142, 23);
		panel_3.add(rdbtnRegisterLaugage);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(973, 114, 361, 519);
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setToolTipText("Exit System");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit" , "TRAVEL MANAGEMENT SYSTEM",
					JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
					
					
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(251, 463, 89, 33);
		panel_2_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Receipt");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(21, 463, 120, 32);
		panel_2_2.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_1.setBounds(10, 11, 1324, 78);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRAVEL MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(177, 11, 1060, 56);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_2.setBounds(527, 174, 441, 404);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox cabDestination = new JComboBox();
		cabDestination.setFont(new Font("Tahoma", Font.BOLD, 18));
		cabDestination.setModel(new DefaultComboBoxModel(new String[] {"None", "Nigeria  - 2 Days in Lagos", "Ghana - 2 Days in Accra", "Kenya  - 3 Days in Nairobi", "Congo - 2 Days in kinshasa", "USA - 5 Days in Boston", "Uk - 4 Days in London", "France - 4 Days in Paris", "Canada - 5 Days in Ottawa", "Italy - 4 Days in Roma", "Brazil - 5 Days in Rio", "Portugal - 4 Days in Lisbon"}));
		cabDestination.setBounds(153, 76, 267, 35);
		panel_2.add(cabDestination);
		
		JComboBox Accomodation = new JComboBox();
		Accomodation.setFont(new Font("Tahoma", Font.BOLD, 18));
		Accomodation.setModel(new DefaultComboBoxModel(new String[] {"None", "Single", "Double", "Extra"}));
		Accomodation.setBounds(183, 129, 237, 35);
		panel_2.add(Accomodation);
		
		JLabel lblNewLabel_10 = new JLabel("   Sub Total");
		lblNewLabel_10.setBounds(10, 248, 133, 30);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("   Total");
		lblNewLabel_11.setBounds(10, 298, 123, 26);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_2.add(lblNewLabel_11);
		
		JLabel textTax = new JLabel(" ");
		textTax.setBounds(183, 202, 237, 28);
		textTax.setFont(new Font("Tahoma", Font.BOLD, 21));
		textTax.setHorizontalAlignment(SwingConstants.RIGHT);
		textTax.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.add(textTax);
		
		JLabel textSubTotal = new JLabel(" ");
		textSubTotal.setBounds(183, 250, 237, 28);
		textSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textSubTotal.setFont(new Font("Tahoma", Font.BOLD, 21));
		textSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.add(textSubTotal);
		
		JLabel textTotal = new JLabel(" ");
		textTotal.setBounds(183, 296, 237, 28);
		textTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textTotal.setFont(new Font("Tahoma", Font.BOLD, 21));
		textTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.add(textTotal);
		
		JButton Total = new JButton("Total");
		Total.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Total.addMouseListener(this);	

				double Canada = 320;
				double Brazil = 560;
				double Italy = 670;
				double Ghana = 470;
				double USA = 760;
				double kenya = 630;
				double Congo = 340;
				double UK = 650;
				double France = 610;
				double Portugal = 710;
				double Nigeria = 270;
				
				
				
				double Acc_Single = 45;
				double Acc_Double = 45;
				double Acc_Extra = 45;
				
				double Std = 2.5;
				double Eco = 65.5;
				double Vip = 122.5;
				
				double TaxPaid = 6.7;
				double Travelling_Insurance_Paid = 62.4;
				double Register_Laugage = 25.9;
				double Ext_Laugage = 25.9;
				
				
				double[] TravelCost = new double[20];
				double iTax = 4.5;
				
				if (cabDestination.getSelectedItem().equals("Nigeria - 2 Days in Lagos") &&
				Accomodation.getSelectedItem().equals("Single") && rdbtnPlane.isSelected()) {
					
				}
				 
				TravelCost[0] = Nigeria + Acc_Single + Std;
				TravelCost[1] = ((TravelCost[0] * iTax/100));
				String tax = String.format("$%.2f",TravelCost[1]);
				
				JLabel lblTax = new JLabel();
				lblTax.setText((tax));
				String subTotal = String.format("$%.2f",TravelCost[0]);
				
				
				
				}
		});
		Total.setToolTipText("Total cost of Ticket");
		Total.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Total.setBounds(38, 346, 105, 36);
		Total.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(Total);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setToolTipText("Reset System");
		btnNewButton_1.setBounds(263, 346, 105, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textTax.setText(null);
				textSubTotal.setText(null);
				textTotal.setText(null);
				txtFirstname.setText(null);
				txtSurname.setText(null);
				txtAddress.setText(null);
				txtDate.setText(null);
				txtPhoneNumber.setText(null);
				txtEmail.setText(null);
				rdbtnPlane.setSelected(false);
				rdbtnTrain.setSelected(false);
				rdbtnBus.setSelected(false);
				rdbtnStandard.setSelected(false);
				rdbtnEconomy.setSelected(false);
				rdbtnVip.setSelected(false);
				rdbtnTaxPaid.setSelected(false);
				rdbtnTravellingInsurancePaid.setSelected(false);
				rdbtnSingleTicket.setSelected(false);
				rdbtnReturnTicket.setSelected(false);
				rdbtnAdult.setSelected(false);
				rdbtnChild.setSelected(false);
				rdbtnRegisterLaugage.setSelected(false);
				rdbtnExitLaugage.setSelected(false);
				
				
				
				
				
				
				
				
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(btnNewButton_1);
		
		JLabel lblTax = new JLabel("   Tax");
		lblTax.setBounds(10, 202, 133, 35);
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblTax);
		
		JLabel lblNewLabel_6 = new JLabel(" Departure Point");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(10, 21, 163, 35);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(" Destination");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(10, 76, 133, 35);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_12 = new JLabel(" Accomodation");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_12.setBounds(10, 129, 147, 35);
		panel_2.add(lblNewLabel_12);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Yaounde", "Douala", "Ngoundere", "Buea", "Limbe", "Bafoussam"}));
		comboBox.setBounds(183, 30, 237, 35);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_15 = new JLabel("Receipt");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_15.setBounds(983, 92, 91, 22);
		frame.getContentPane().add(lblNewLabel_15);
	}
	
}


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateAccountFrame extends JFrame {

	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel bgPanel;
	private JPanel bgPanel2;
	private JComboBox comboBoxType;
	private int clearanceLevel = 0;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JCheckBox chckbxHeart;
	private JCheckBox chckbxPsychEval;
	private JCheckBox chckbxOther;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountFrame frame = new CreateAccountFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

	/**
	 * Create the frame.
	 */
	public CreateAccountFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new MigLayout("", "[100][50][50,grow][100,grow][100][100,grow][100][100][50][50][100]", "[100][100,grow][100][100][100][100][100]"));
		
		JLabel lblCreateAnAccount = new JLabel("Create an Account");
		lblCreateAnAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		mainPanel.add(lblCreateAnAccount, "cell 4 0 3 1,alignx center");
		
		bgPanel = new JPanel();
		mainPanel.add(bgPanel, "flowx,cell 3 2 5 3");
		bgPanel.setLayout(new BorderLayout());
		
		JPanel accountTypePanel = new JPanel();
		bgPanel.add(accountTypePanel, BorderLayout.CENTER);
		accountTypePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		accountTypePanel.setLayout(new MigLayout("", "[100][100][100][100][50]", "[100][100][100]"));
		
		JLabel lblAccountType = new JLabel("What type of account would you like to set up?");
		lblAccountType.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		accountTypePanel.add(lblAccountType, "cell 0 0 5 1,alignx center");
		
		comboBoxType = new JComboBox();
		accountTypePanel.add(comboBoxType, "cell 1 1 2 1,growx");
		//comboBoxType.setForeground(Color.BLUE);
		comboBoxType.addItem("Office Employee");
		comboBoxType.addItem("Doctor");
		comboBoxType.addItem("Technical Administrator");
		
		JButton btnCancel = new JButton("Cancel");
		accountTypePanel.add(btnCancel, "cell 1 2,alignx center");
		
		JButton btnNext = new JButton("Next");
		accountTypePanel.add(btnNext, "cell 2 2,alignx center");
		
		
		btnCancel.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  dispose();
				  MainMenu menu = new MainMenu();
				  menu.setVisible(true);
			  }
			});
		
		btnNext.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  //BRING UP NEXT PANEL TO CREATE INFO
				  bgPanel.removeAll();
				  repaint();
				  if(comboBoxType.getSelectedItem() == "Office Employee")
					  employeeAccount();
				  else if(comboBoxType.getSelectedItem() == "Doctor")
					  doctorAccount();
				  else if(comboBoxType.getSelectedItem() == "Technical Administrator")
					  adminAccount();
			  }
			});

	}
		
	public void employeeAccount() {
		//PANEL WITH EMPLOYEE INFO
		
		JPanel employeePanel = new JPanel();
		mainPanel.add(employeePanel, "cell 2 1 7 5");
		employeePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		employeePanel.setLayout(new MigLayout("", "[100][100][100][100][100][100]", "[50][50][50][50][50][50][50][50][50][50][50][50][50][50]"));
		
		JLabel lblEmployeeAccount = new JLabel("Employee Account");
		lblEmployeeAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		employeePanel.add(lblEmployeeAccount, "cell 2 0 2 1,alignx center");
		
		JLabel lblFirstName = new JLabel("First Name:");
		employeePanel.add(lblFirstName, "cell 1 2,alignx left");
		
		txtFirstName = new JTextField();
		employeePanel.add(txtFirstName, "cell 2 2 2 1,growx");
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		employeePanel.add(lblLastName, "cell 1 4,alignx left");
		
		txtLastName = new JTextField();
		employeePanel.add(txtLastName, "cell 2 4 2 1,growx");
		txtLastName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		employeePanel.add(lblUsername, "cell 1 6,alignx left");
		
		txtUsername = new JTextField();
		employeePanel.add(txtUsername, "cell 2 6 2 1,growx");
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>Usernames must be <br>at most 10 characters.</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		employeePanel.add(lblNewLabel, "cell 4 6 2 2,aligny top");
		
		JLabel lblPassword = new JLabel("Password:");
		employeePanel.add(lblPassword, "cell 1 8,alignx left");
		
		txtPassword = new JPasswordField();
		employeePanel.add(txtPassword, "cell 2 8 2 1,growx");
		txtPassword.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		employeePanel.add(lblConfirmPassword, "cell 1 10,alignx left");
		
		txtConfirmPassword = new JPasswordField();
		employeePanel.add(txtConfirmPassword, "cell 2 10 2 1,growx");
		txtConfirmPassword.setColumns(10);
		
		JLabel lblPassRules = new JLabel("<html>A password must be at least <br>8 characters and must<br>contain at least one number (0-9).</html>");
		lblPassRules.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		employeePanel.add(lblPassRules, "cell 4 8 2 2");
		
		JButton btnCancel = new JButton("Cancel");
		employeePanel.add(btnCancel, "cell 2 12");
		
		JButton btnSave = new JButton("Save");
		employeePanel.add(btnSave, "cell 3 12");
		
		btnCancel.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  //SHOW CREATE ACCOUNT PANEL
				  dispose();
				  CreateAccountFrame createAccount = new CreateAccountFrame();
				  createAccount.setVisible(true);
			  }
			});
		
		btnSave.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  //SUCCESS/PUT IN DATABASE
				  clearanceLevel = 2;
				  if(validateFields()) {
					  if(checkPassword()) {
						  insertDatabase(2);
						  dispose();
						  MainMenu menu = new MainMenu();
						  menu.setVisible(true);
					  }
				  }
			  }
			});
		
	}
	
	public void doctorAccount() {
		//PANEL WIHT DOCTOR INFO
		
		JPanel doctorPanel = new JPanel();
		mainPanel.add(doctorPanel, "cell 2 1 7 5");
		doctorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		doctorPanel.setLayout(new MigLayout("", "[100][100][100][100][100][100]", "[50][50][50][25][50][25][50][25][50][25][50][25][50][50][50][50]"));
		
		JLabel lblDoctorAccount = new JLabel("Doctor Account");
		lblDoctorAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		doctorPanel.add(lblDoctorAccount, "cell 2 0 2 1,alignx center");
		
		JLabel lblFirstName = new JLabel("First Name:");
		doctorPanel.add(lblFirstName, "cell 1 2,alignx left");
		
		txtFirstName = new JTextField();
		doctorPanel.add(txtFirstName, "cell 2 2 2 1,growx");
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		doctorPanel.add(lblLastName, "cell 1 4,alignx left");
		
		txtLastName = new JTextField();
		doctorPanel.add(txtLastName, "cell 2 4 2 1,growx");
		txtLastName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		doctorPanel.add(lblUsername, "cell 1 6,alignx left");
		
		txtUsername = new JTextField();
		doctorPanel.add(txtUsername, "cell 2 6 2 1,growx");
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>Usernames must be <br>at most 10 characters.</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		doctorPanel.add(lblNewLabel, "cell 4 6 2 2,aligny top");
		
		JLabel lblPassword = new JLabel("Password:");
		doctorPanel.add(lblPassword, "cell 1 8,alignx left");
		
		txtPassword = new JPasswordField();
		doctorPanel.add(txtPassword, "cell 2 8 2 1,growx");
		txtPassword.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		doctorPanel.add(lblConfirmPassword, "cell 1 10,alignx left");
		
		txtConfirmPassword = new JPasswordField();
		doctorPanel.add(txtConfirmPassword, "cell 2 10 2 1,growx");
		txtConfirmPassword.setColumns(10);
		
		JLabel lblPassRules = new JLabel("<html>A password must be at least <br>8 characters and must<br>contain at least one number (0-9).</html>");
		lblPassRules.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		doctorPanel.add(lblPassRules, "cell 4 8 2 2");
		
		JLabel lblProcedures = new JLabel("Procedure/s:");
		doctorPanel.add(lblProcedures, "cell 1 12");
		
		chckbxHeart = new JCheckBox("Heart Surgery");
		doctorPanel.add(chckbxHeart, "cell 2 12");
		
		chckbxPsychEval = new JCheckBox("Psych Eval");
		doctorPanel.add(chckbxPsychEval, "cell 3 12");
		
		chckbxOther = new JCheckBox("(other)");
		doctorPanel.add(chckbxOther, "cell 2 13");
		
		JButton btnCancel = new JButton("Cancel");
		doctorPanel.add(btnCancel, "cell 2 14");
		
		JButton btnSave = new JButton("Save");
		doctorPanel.add(btnSave, "cell 3 14");
		
		btnCancel.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  //SHOW CREATE ACCOUNT PANEL
				  dispose();
				  CreateAccountFrame createAccount = new CreateAccountFrame();
				  createAccount.setVisible(true);
			  }
			});
		
		btnSave.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  //SUCCESS/PUT IN DATABASE
				  clearanceLevel = 3;
				  if(validateFields()) {
					  if(checkPassword()) {
						  insertDatabase(3);
						  dispose();
						  MainMenu menu = new MainMenu();
						  menu.setVisible(true);
					  }
				  }
			  }
			});
	}
	
	public void adminAccount() {
		//PANEL WITH ADMIN INFO
		
		JPanel adminPanel = new JPanel();
		mainPanel.add(adminPanel, "cell 2 1 7 5");
		adminPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		adminPanel.setLayout(new MigLayout("", "[100][100][100][100][100][100]", "[50][50][50][50][50][50][50][50][50][50][50][50][50][50]"));
		
		JLabel lblAdminAccount = new JLabel("Administrator Account");
		lblAdminAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		adminPanel.add(lblAdminAccount, "cell 2 0 2 1,alignx center");
		
		JLabel lblFirstName = new JLabel("First Name:");
		adminPanel.add(lblFirstName, "cell 1 2,alignx left");
		
		txtFirstName = new JTextField();
		adminPanel.add(txtFirstName, "cell 2 2 2 1,growx");
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		adminPanel.add(lblLastName, "cell 1 4,alignx left");
		
		txtLastName = new JTextField();
		adminPanel.add(txtLastName, "cell 2 4 2 1,growx");
		txtLastName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		adminPanel.add(lblUsername, "cell 1 6,alignx left");
		
		txtUsername = new JTextField();
		adminPanel.add(txtUsername, "cell 2 6 2 1,growx");
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>Usernames must be <br>at most 10 characters.</html>");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		adminPanel.add(lblNewLabel, "cell 4 6 2 2,aligny top");
		
		JLabel lblPassword = new JLabel("Password:");
		adminPanel.add(lblPassword, "cell 1 8,alignx left");
		
		txtPassword = new JPasswordField();
		adminPanel.add(txtPassword, "cell 2 8 2 1,growx");
		txtPassword.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		adminPanel.add(lblConfirmPassword, "cell 1 10,alignx left");
		
		txtConfirmPassword = new JPasswordField();
		adminPanel.add(txtConfirmPassword, "cell 2 10 2 1,growx");
		txtConfirmPassword.setColumns(10);
		
		JLabel lblPassRules = new JLabel("<html>A password must be at least <br>8 characters and must<br>contain at least one number (0-9).</html>");
		lblPassRules.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		adminPanel.add(lblPassRules, "cell 4 8 2 2");
		
		JButton btnCancel = new JButton("Cancel");
		adminPanel.add(btnCancel, "cell 2 12");
		
		JButton btnSave = new JButton("Save");
		adminPanel.add(btnSave, "cell 3 12");
		
		btnCancel.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  //SHOW CREATE ACCOUNT PANEL
				  dispose();
				  CreateAccountFrame createAccount = new CreateAccountFrame();
				  createAccount.setVisible(true);
			  }
			});
		
		btnSave.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  //SUCCESS/PUT IN DATABASE
				  clearanceLevel = 1;
				  if(validateFields()) {
					  if(checkPassword()) {
						  insertDatabase(1);
						  dispose();
						  MainMenu menu = new MainMenu();
						  menu.setVisible(true);
					  }
				  }
			  }
			});
	}
	
	public Boolean validateFields() {
		String fname = txtFirstName.getText();
		String lname = txtLastName.getText();
		String username = txtUsername.getText();
		String password = new String(txtPassword.getPassword());
		
		if(fname.isEmpty() || lname.isEmpty() || username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill out all of the fields.","Cannot Create Account",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(username.length() > 10) {
			JOptionPane.showMessageDialog(this, "Please keep usernames 10 characters or less.","Cannot Create Account",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
			return true;
	}
	
	public Boolean checkPassword() {
		String pass1 = new String(txtPassword.getPassword());
		String pass2 = new String(txtConfirmPassword.getPassword());
		
		Boolean digit = false;
		
		if(pass1 != null && !(pass1.isEmpty())) {
			for(int i = 0; i < pass1.length(); i++) {
				if(digit = Character.isDigit(pass1.charAt(i)))
					break;
			}
		}
		
		if(pass1.length() < 8) {
			JOptionPane.showMessageDialog(this, "The password must be at least 8 characters long.","Cannot Create Account",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(!digit) {
			JOptionPane.showMessageDialog(this, "The password must contain at least one number.","Cannot Create Account",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(!(pass1.equals(pass2))) {
			JOptionPane.showMessageDialog(this, "The passwords must match.","Cannot Create Account",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
			return true;
	}
	
	
	public void insertDatabase(int access) {
		String fname = txtFirstName.getText();
		String lname = txtLastName.getText();
		String username = txtUsername.getText();
		String password = new String(txtPassword.getPassword());
		
		NimbusDAO dao;
		
		try {
			dao = new NimbusDAO();
			
			dao.createAccount(fname, lname, username, password, access);
			
			//ADD DOCTOR TO DOCTOR TABLE
			if(access == 3) {
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

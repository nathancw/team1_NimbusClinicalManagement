import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;



public class SearchAppointmentPanel extends JPanel{

	//String directoryList[] = {"Directory","Create New"};
	String[] colNames = {"Name","ID","DoB","Gender"};
	Object[][] patients = {
			{"Blank","111","080808","F"},
			{null,null,null,null,}};
	
	private JPanel contentPanel;
	private JTextField patientIDTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTable table;
	private JLabel topLabel;
	private JLabel lblMiddle;
	private JButton btnBookNewAppointment;
	private JComboBox procedureComboBox;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame frame = new SearchFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the frame.
	 */
	public SearchAppointmentPanel() {
		setLayout(new BorderLayout(0, 0));

		
		contentPanel = new JPanel();
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[100][100][100][100][100][100][100][100]", "[50][50][100][100][100][100][300]"));
		
		topLabel = new JLabel("Search for an Appointment by inputting data below.");
		topLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(topLabel, "cell 1 0 6 1,alignx center,aligny top");
	
		JLabel lblPatientID = new JLabel("Patient ID:");
		contentPanel.add(lblPatientID, "cell 0 1,alignx right,aligny center");
		
		patientIDTextField = new JTextField();
		contentPanel.add(patientIDTextField, "cell 1 1,alignx left,aligny center");
		patientIDTextField.setColumns(10);
		
		JLabel lblProcedure = new JLabel("Procedure:");
		contentPanel.add(lblProcedure, "cell 2 1,alignx trailing,aligny center");
		
		procedureComboBox = new JComboBox();
		contentPanel.add(procedureComboBox, "cell 3 1,growx");
		
		JLabel lblFirstName = new JLabel("First Name:");
		contentPanel.add(lblFirstName, "cell 4 1,alignx right,aligny center");
		
		firstNameTextField = new JTextField();
		contentPanel.add(firstNameTextField, "cell 5 1,alignx left,aligny center");
		firstNameTextField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		contentPanel.add(lblLastName, "cell 6 1,alignx right,aligny center");
		
		lastNameTextField = new JTextField();
		contentPanel.add(lastNameTextField, "cell 7 1,alignx left,aligny center");
		lastNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Search button pressed!");
			}
		});
		contentPanel.add(searchButton, "cell 2 2 2 1,alignx center,aligny center");
		
		btnBookNewAppointment = new JButton("Book New Appointment");
		contentPanel.add(btnBookNewAppointment, "cell 4 2 2 1,alignx center");
		
		lblMiddle = new JLabel("Click on a Respective Patient ID row to pull up their information.");
		contentPanel.add(lblMiddle, "cell 1 3 6 1,alignx center");
		
		JPanel resultsPanel = new JPanel();
		contentPanel.add(resultsPanel, "cell 0 4 8 3,alignx center,aligny top");
		resultsPanel.setLayout(new BorderLayout(0, 0));
		
		//Make the table uneditable
		TableModel model = new DefaultTableModel(patients, colNames)
		  {
		    public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		  };
		table = new JTable(model);
		  
		table.setBorder(null);
		resultsPanel.add(table);
		resultsPanel.add(new JScrollPane(table));
			
		
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    //if (e.getClickCount() == 1) {
				  	if(table.getSelectedColumn() == 0){
				  		
				  	//Edit on table click
			    	 System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
			    	 //PatientInformationFrame patientframe = new PatientInformationFrame();
			         //patientframe.show("Basic Information");
			         
			         
				  	}
			     //}
			   }
			});

	
	}

	
		
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class OptionMenuFrame extends JFrame {

	String directoryList[] = {"Book New Appointment","Search For Patient","Search For Appointment", "Bill Patient", 
			"Return to Main Menu"};
	
	private JPanel contentPane;	
	private JPanel contentPanel;	
	private JPanel bufferPanel;
	private JList categoriesList;
	private JPanel dataPanel;
	private JPanel removeablePanel;
	private int accessLevel = LoginFrame.accessLevel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionMenuFrame frame = new OptionMenuFrame();
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
	public OptionMenuFrame() {

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setTitle("Nimbus Clincial Software");
		setBounds(100, 100, 1000, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Create New");
		fileMenu.add(mntmNewMenuItem);
		
		
		contentPanel = new JPanel();
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		bufferPanel = new JPanel();
		contentPanel.add(bufferPanel);
		bufferPanel.setLayout(new MigLayout("", "[100][100][100][100][100][100][100][100][100][100]", "[50,grow][100][100][100][100][300][50]"));
		
		
		categoriesList = new JList(directoryList);
		categoriesList.setFont(new Font("Tahoma", Font.BOLD, 12));
		categoriesList.setBorder(new LineBorder(new Color(0, 0, 0)));
			
		bufferPanel.add(categoriesList, "cell 0 0 1 6,grow");
		
		//The data panel is a mig layout. This is the panel that we add the new panels too. The mig layout is so it can adjust correctly when resizing.
		dataPanel = new JPanel();
		bufferPanel.add(dataPanel, "cell 1 0 9 7,alignx center,aligny center");
		dataPanel.setLayout(new MigLayout("", "[900,grow]", "[700,grow]"));
		
		
		//ActionListener. Anon class. This is for when you click the action box. It will print out the value you clicked and right now it will switch on any value clicked. 
		categoriesList.addListSelectionListener(new ListSelectionListener()
		{
		  public void valueChanged(ListSelectionEvent ev)
		  {	
			  if (!ev.getValueIsAdjusting()) {//This line prevents double events Put the code for when to switch based on specific values in this if statement.		 
				 String selectedValue = (String)categoriesList.getSelectedValue();
				 show(selectedValue);
			  }
		  } 
		  
		});
	}
	
	public void show(String selectedValue){
		
		if(selectedValue.equals("Search For Patient")){
			 dataPanel.removeAll();
			 SearchPatientPanel searchPanel = new SearchPatientPanel();
			 getRootPane().setDefaultButton(searchPanel.getDefaultButton());
			 dataPanel.add(searchPanel,"cell 0 0,grow");
			 setVisible(true);
			 repaint();
			 
		 }
		 
		 else if(selectedValue.equals("Basic Information")){
			 dataPanel.removeAll();
			 BasicInformationPanel basicInfo = new BasicInformationPanel();
			 getRootPane().setDefaultButton(basicInfo.getDefaultButton());
			 dataPanel.add(basicInfo,"cell 0 0,grow");
			 setVisible(true);
			 repaint();
		 }
		 else if(selectedValue.equals("Book New Appointment")){		 
			 dataPanel.removeAll();
			 BookAppointmentPanel bookAppointment = new BookAppointmentPanel();
			 getRootPane().setDefaultButton(bookAppointment.getDefaultButton());
			 dataPanel.add(bookAppointment, "cell 0 0,grow");
			 setVisible(true);
			 repaint();
		 }
		 else if(selectedValue.equals("Search For Appointment")){
			 dataPanel.removeAll();
			 SearchAppointmentPanel searchApp = new SearchAppointmentPanel();
			 getRootPane().setDefaultButton(searchApp.getDefaultButton());
			 dataPanel.add(searchApp,"cell 0 0,grow");
			 setVisible(true);
			 repaint();
		 }	 
		 else if(selectedValue.equals("Return to Main Menu")){
			 dispose();
			 MainMenu main = new MainMenu();
			 main.setVisible(true);
		 }
	}
	
	public void populateAppointment(int appointmentID){
		 setBounds(100, 100, 900, 700);
		 bufferPanel.remove(categoriesList);
		dataPanel.removeAll();
		 BookAppointmentPanel bookAppointment = new BookAppointmentPanel(appointmentID);
		 dataPanel.add(bookAppointment, "cell 0 0,grow");
		 setVisible(true);
		 repaint();
	}

	
}

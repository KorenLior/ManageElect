package boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class BdrRideManage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableDrivers;
	private JTable tableRiders;
	private JTextField txtElector;
	private JTable tableRideReq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdrRideManage frame = new BdrRideManage();
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
	public BdrRideManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 592);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Manage");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmManageTransport = new JMenuItem("Transportation");
		mntmManageTransport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				appEngine.bdrRideManage();
			}
		});
		mnNewMenu.add(mntmManageTransport);
		
		JMenuItem mntmManagePositions = new JMenuItem("Election Day Roles");
		mntmManagePositions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				appEngine.bdrElectionDayPosition();
			}
		});
		mnNewMenu.add(mntmManagePositions);
		
		JMenuItem mntmSystem = new JMenuItem("System Management");
		mnNewMenu.add(mntmSystem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		txtElector = new JTextField();
		txtElector.setText("ElectorID");
		txtElector.setColumns(10);
		
		JComboBox<Integer> comboBoxRideID = new JComboBox<Integer>();
		
		comboBoxRideID.setToolTipText("Job ID");
		
		JComboBox<String> comboBoxRideTime = new JComboBox<String>();
		JButton btnUpdateRide = new JButton("Update Ride");
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Available Drivers");
		
		JLabel lblNewLabel_1 = new JLabel("Scheduled Rides");
		
		JLabel lblNewLabel_2 = new JLabel("Electors Requiring Rides");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(txtElector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxRideID, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxRideTime, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdateRide))
						.addComponent(lblNewLabel, Alignment.LEADING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, Alignment.LEADING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtElector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxRideID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxRideTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdateRide))
					.addContainerGap())
		);
		
		Vector<Vector<Object>> riderReq = appEngine.ctrlInterface.getRiders(false);
		Vector<Object> riderReqColumnNames = new Vector<Object>();
		riderReqColumnNames.add("ID");
		riderReqColumnNames.add("Call Date");
		riderReqColumnNames.add("From");
		riderReqColumnNames.add("Until");
		riderReqColumnNames.add("Name");
		riderReqColumnNames.add("Elector Phone");
		riderReqColumnNames.add("Elector Address");
		riderReqColumnNames.add("Ballot Address");
		riderReqColumnNames.add("Ballot");
		tableRideReq = new JTable(riderReq,riderReqColumnNames);
		scrollPane_2.setViewportView(tableRideReq);
		
		Vector<Vector<Object>> riderAss = appEngine.ctrlInterface.getRiders(true);
		Vector<Object> riderAssColumnNames = new Vector<Object>();
		riderAssColumnNames.add("Ride Key");
		riderAssColumnNames.add("Ride Time");
		riderAssColumnNames.add("Elector ID");
		riderAssColumnNames.add("Elector Name");
		riderAssColumnNames.add("Elector Phone");
		riderAssColumnNames.add("Elector Address");
		riderAssColumnNames.add("Ballot Address");
		riderAssColumnNames.add("Ballot");
		riderAssColumnNames.add("Driver ID");
		tableRiders = new JTable(riderAss,riderAssColumnNames);
		scrollPane_1.setViewportView(tableRiders);
		
		Vector<String> driversColumnNames = new Vector<String>();
		driversColumnNames.add("JobID");
		driversColumnNames.add("From");
		driversColumnNames.add("Until");
		driversColumnNames.add("Employee ID");
		Vector<Vector<Object>> drivers = appEngine.ctrlInterface.getDriversBranch();
		comboBoxRideID.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBoxRideTime.removeAllItems();
				int jobId = (int)comboBoxRideID.getSelectedItem();
				int start = 0;
				int end = 0;
				for (Vector<Object> driver:drivers) {
					if ((int)driver.get(0)==jobId) {
						start = (int)driver.get(1);
						end = (int)driver.get(2);
					}
					for (int i = start; i<end;i++) {
						comboBoxRideTime.addItem(""+i+":00");
						comboBoxRideTime.addItem(""+i+":15");
						comboBoxRideTime.addItem(""+i+":30");
						comboBoxRideTime.addItem(""+i+":45");
					}
				}
			}
		});
		Vector<Vector<Object>> drivers2 = new Vector<Vector<Object>>();
		for (Vector<Object> driver:drivers) {
			Vector<Object> driver2 = new Vector<Object>();
			driver2.add(driver.get(0));
			driver2.add(driver.get(1)+":00");
			driver2.add(driver.get(2)+":00");
			driver2.add(driver.get(3));
			drivers2.add(driver2);
		}
		tableDrivers = new JTable(drivers2, driversColumnNames);
		for (Vector<Object> driver:drivers) {
			comboBoxRideID.addItem((int)driver.get(0));
		}
		
		scrollPane.setViewportView(tableDrivers);
		contentPane.setLayout(gl_contentPane);
		
		btnUpdateRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				    int id = Integer.parseInt(txtElector.getText());
				    int rideKey = (int)comboBoxRideID.getSelectedItem();
				    String rideTime = (String)comboBoxRideTime.getSelectedItem();
				    appEngine.ctrlInterface.electorRideUpdate(id, rideKey, rideTime);
				    Vector<Vector<Object>> riderReq = appEngine.ctrlInterface.getRiders(false);
				    tableRideReq = new JTable(riderReq,riderReqColumnNames);
					scrollPane_2.setViewportView(tableRideReq);
					Vector<Vector<Object>> riderAss = appEngine.ctrlInterface.getRiders(true);
					tableRiders = new JTable(riderAss,riderAssColumnNames);
					scrollPane_1.setViewportView(tableRiders);
				}
				catch (NumberFormatException e)
				{
				    System.out.println("Not a number");
				    return;
				}
			}
		});
	}
}

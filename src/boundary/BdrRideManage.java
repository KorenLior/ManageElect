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
		
		Vector<String> driversColumnNames = new Vector<String>();
		driversColumnNames.add("JobID");
		driversColumnNames.add("From");
		driversColumnNames.add("Until");
		driversColumnNames.add("Employee ID");
		
		txtElector = new JTextField();
		txtElector.setColumns(10);
		
		JComboBox<String> comboBoxRideID = new JComboBox<String>();
		
		JComboBox<String> comboBoxRideTime = new JComboBox<String>();
		JButton btnAddRide = new JButton("New button");
		
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
							.addComponent(btnAddRide))
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
						.addComponent(btnAddRide))
					.addContainerGap())
		);
		
		Vector<Vector<Object>> riderReq = appEngine.ctrlInterface.getRiders(false);
		Vector<Object> riderReqcColumnNames = new Vector<Object>();
		riderReqcColumnNames.add("ID");
		riderReqcColumnNames.add("Call Date");
		riderReqcColumnNames.add("From");
		riderReqcColumnNames.add("Until");
		riderReqcColumnNames.add("Name");
		riderReqcColumnNames.add("Phone");
		riderReqcColumnNames.add("Elector Address");
		riderReqcColumnNames.add("Ballot Address");
		riderReqcColumnNames.add("Ballot");
		tableRideReq = new JTable(riderReq,riderReqcColumnNames);
		scrollPane_2.setViewportView(tableRideReq);
		
		
		tableRiders = new JTable();
		scrollPane_1.setViewportView(tableRiders);
		
				tableDrivers = new JTable(appEngine.ctrlInterface.getDriversBranch(),driversColumnNames);
				scrollPane.setViewportView(tableDrivers);
			contentPane.setLayout(gl_contentPane);
		
		
		
		
	}
}

package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.ConstsDbManageElect;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BdrRole extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmployeeId1;
	private JTextField txtEmployeeId2;
	private JTextField txtBallotNumber;
	private JTable tablePositions;
	private JTable tableEmployees;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdrRole frame = new BdrRole();
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
	public BdrRole() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 476);
		
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
		
		
		JMenuItem mntmEmployees = new JMenuItem("Employees");
		mntmEmployees.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				appEngine.bdrEmployee();
			}
		});
		mnNewMenu.add(mntmEmployees);
		
		JMenuItem mntmSystem = new JMenuItem("System Management");
		mnNewMenu.add(mntmSystem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		txtEmployeeId2 = new JTextField();
		txtEmployeeId2.setEnabled(false);
		txtEmployeeId2.setText("EmployeeId 2");
		txtEmployeeId2.setColumns(10);
		
		
		Vector<String> positionColumnNames = new Vector<String>();
		positionColumnNames.add("Position key");
		positionColumnNames.add("Start Hour");
		positionColumnNames.add("End Hour");
		positionColumnNames.add("Role");
		positionColumnNames.add("Ballot Num");
		positionColumnNames.add("Employee 1");
		positionColumnNames.add("Employee 2");
	
		
		JComboBox<String> comboBoxRole = new JComboBox();
		comboBoxRole.addItem("Driver");
		comboBoxRole.addItem("Ballot Rep");
		comboBoxRole.addItem("Branch");
		comboBoxRole.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxRole.getSelectedItem()=="Ballot Rep") {
					txtEmployeeId2.setEnabled(true);
					txtBallotNumber.setEnabled(true);
				}
				else {
					txtEmployeeId2.setEnabled(false);
					txtBallotNumber.setEnabled(false);
				}
			}
		});
		
		
		
		
		JButton btnAddPos = new JButton("Add Position");
		
		
		txtEmployeeId1 = new JTextField();
		txtEmployeeId1.setText("EmployeeID 1");
		txtEmployeeId1.setColumns(10);
		
		JComboBox<String> comboBoxFrom = new JComboBox();
		comboBoxFrom.addItem("8:00");
		comboBoxFrom.addItem("9:00");
		comboBoxFrom.addItem("10:00");
		comboBoxFrom.addItem("11:00");
		comboBoxFrom.addItem("12:00");
		comboBoxFrom.addItem("13:00");
		comboBoxFrom.addItem("14:00");
		comboBoxFrom.addItem("15:00");
		comboBoxFrom.addItem("16:00");
		comboBoxFrom.addItem("17:00");
		comboBoxFrom.addItem("18:00");
		comboBoxFrom.addItem("19:00");
		comboBoxFrom.addItem("20:00");
		comboBoxFrom.addItem("21:00");
		comboBoxFrom.addItem("22:00");
		
		
		JComboBox<String> comboBoxUntil = new JComboBox();
		comboBoxUntil.addItem("9:00");
		comboBoxUntil.addItem("10:00");
		comboBoxUntil.addItem("11:00");
		comboBoxUntil.addItem("12:00");
		comboBoxUntil.addItem("13:00");
		comboBoxUntil.addItem("14:00");
		comboBoxUntil.addItem("15:00");
		comboBoxUntil.addItem("16:00");
		comboBoxUntil.addItem("17:00");
		comboBoxUntil.addItem("18:00");
		comboBoxUntil.addItem("19:00");
		comboBoxUntil.addItem("20:00");
		comboBoxUntil.addItem("21:00");
		comboBoxUntil.addItem("22:00");
		comboBoxUntil.addItem("23:00");
		
		
		
		
		JLabel lblNewLabel = new JLabel("From");
		
		JLabel lblNewLabel_1 = new JLabel("Until");
		
		JLabel lblNewLabel_3 = new JLabel("Role");
		
		txtBallotNumber = new JTextField();
		txtBallotNumber.setText("Ballot Number");
		txtBallotNumber.setEnabled(false);
		txtBallotNumber.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
      
		btnAddPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int startHour, endHour;
				String role = null;
				int ballotNum, employee1, employee2;
				ballotNum = employee1 = employee2 = 0;
				startHour = comboBoxFrom.getSelectedIndex()+8;
				endHour = comboBoxUntil.getSelectedIndex() +9;
				switch (comboBoxRole.getSelectedIndex()) {
					case 0: role = "Drive";
					case 1: role = "Rep";
					case 2: role = "Branch";
				}
				try{
					String id1Txt = txtEmployeeId1.getText();
					employee1 = Integer.parseInt(id1Txt);
				}
				catch(Exception loadFail) {
					System.out.println("elector ID not parsed");
				}
				if (role=="Rep") {
					try{
						String id2Txt = txtEmployeeId2.getText();
						employee2 = Integer.parseInt(id2Txt);
					}
					catch(Exception loadFail) {
						System.out.println("elector ID not parsed");
					}
					try{
						String ballottxt = txtBallotNumber.getText();
						ballotNum = Integer.parseInt(ballottxt);
					}
					catch(Exception loadFail) {
						System.out.println("ballotNum not parsed");
					}
				}
				if (employee1!=0) {
					appEngine.ctrlInterface.insertPosition(startHour, endHour, role, ballotNum, employee1, employee2);
					tablePositions = new JTable(appEngine.ctrlInterface.getElectionDayPositions(),positionColumnNames);
					scrollPane.setViewportView(tablePositions);
				}
			}
		});    
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("Employees");
            
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxRole, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtBallotNumber, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtEmployeeId1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtEmployeeId2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnAddPos)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxUntil, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane)
							.addGap(3))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(2))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(comboBoxRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBallotNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmployeeId1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmployeeId2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBoxUntil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddPos)
					.addGap(15))
		);
		
		
		Vector<Object> emploeeColumnNames = new Vector<Object>();
		emploeeColumnNames.add("Employee ID");
		emploeeColumnNames.add("Full Name");
		emploeeColumnNames.add("Has Car");
		tableEmployees = new JTable(appEngine.ctrlInterface.getEmployees(), emploeeColumnNames);
		scrollPane_1.setViewportView(tableEmployees);
		
		Vector<Vector<Object>> data = appEngine.ctrlInterface.getElectionDayPositions();
		tablePositions = new JTable(data,positionColumnNames);
		scrollPane.setViewportView(tablePositions);
		contentPane.setLayout(gl_contentPane);
	}
}

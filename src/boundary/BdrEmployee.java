package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class BdrEmployee extends JFrame {

	private JPanel contentPane;
	private JTable tableEmployees;
	private JTextField txtEmployeeId;
	private JTextField txtBirthDate;
	private JTextField txtNation;
	private JTextField txtKids;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdrEmployee frame = new BdrEmployee();
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
	public BdrEmployee() {
		setBounds(100, 100, 639, 441);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Manage");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmManageTransport = new JMenuItem("Transportation");
		mntmManageTransport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu.add(mntmManageTransport);
		
		JMenuItem mntmManagePositions = new JMenuItem("Election Day Roles");
		mntmManagePositions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu.add(mntmManagePositions);
		
		JMenuItem mntmEmployees = new JMenuItem("Employees");
		mntmEmployees.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu.add(mntmEmployees);
		JMenuItem mntmSystem = new JMenuItem("System Management");
		mnNewMenu.add(mntmSystem);
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setToolTipText("ID number");
		txtEmployeeId.setText("Employee ID");
		txtEmployeeId.setColumns(10);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setText("0/0/0");
		txtBirthDate.setColumns(10);
		
		JComboBox<String> comboBoxGender = new JComboBox<String>();
		comboBoxGender.addItem("Male");
		comboBoxGender.addItem("Female");
		JLabel lblNewLabel = new JLabel("Gender:");
		
		txtNation = new JTextField();
		txtNation.setText("Israeli");
		txtNation.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nationality:");
		
		JCheckBox chckbxCar = new JCheckBox("Car Owner");
		
		JComboBox<String> comboBoxStatus = new JComboBox<String>();
		comboBoxStatus.addItem("Single");
		comboBoxStatus.addItem("Married");
		comboBoxStatus.addItem("Divorced");
		JLabel lblNewLabel_2 = new JLabel("Status:");
		
		txtKids = new JTextField();
		txtKids.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Kids:");
		
		JButton btnAddEmployee = new JButton("Add Employee");
		
		JComboBox<Integer> comboBoxBranch = new JComboBox<Integer>();
		if (appEngine.ctrlInterface.getPermission()<=2) {
			comboBoxBranch.addItem(appEngine.ctrlInterface.getBranch());
			comboBoxBranch.setEnabled(false);
		}
		else {
			ArrayList<Integer> branches = appEngine.ctrlInterface.getBranchList();
			for (Integer branch:branches) {
				comboBoxBranch.addItem(branch);
			}
			comboBoxBranch.setEnabled(true);
		}
		
		
		JLabel lblNewLabel_4 = new JLabel("Branch:");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxStatus, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtKids, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxBranch, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddEmployee))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtEmployeeId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtBirthDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxGender, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNation, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(chckbxCar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmployeeId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBirthDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(comboBoxGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxCar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(comboBoxStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtKids, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(comboBoxBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddEmployee))
					.addGap(14))
		);
		Vector<Vector<Object>> employeesData = appEngine.ctrlInterface.getEmployees();
		Vector<Object> employeesColumnNames = new Vector<Object>();
		employeesColumnNames.add("ID");
		employeesColumnNames.add("Last Name");
		employeesColumnNames.add("First Name");
		employeesColumnNames.add("Birth Date");
		employeesColumnNames.add("Gender");
		employeesColumnNames.add("Nationality");
		employeesColumnNames.add("Car Owner");
		employeesColumnNames.add("Status");
		employeesColumnNames.add("Children");
		tableEmployees = new JTable(employeesData, employeesColumnNames);
		scrollPane.setViewportView(tableEmployees);
		contentPane.setLayout(gl_contentPane);
		
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				String birthDate = txtBirthDate.getText();
				String gender = (String)comboBoxGender.getSelectedItem();
				String nationality = txtNation.getText();
				boolean car = chckbxCar.isSelected();
				int status = comboBoxStatus.getSelectedIndex();
				int kids = 0;
				int branch = (Integer)comboBoxBranch.getSelectedItem();
				try{
					id = Integer.parseInt(txtEmployeeId.getText());
					kids = Integer.parseInt(txtKids.getText());
					try {
						appEngine.ctrlInterface.addEmployee(id, birthDate, gender, nationality, car, status, kids, branch);
					}
					catch(Exception e){
						System.out.println("employee add failure");
					}
				}
				catch(Exception loadFail) {
					System.out.println("employee ID not parsed");
				}
				
			}
		});
	}

}

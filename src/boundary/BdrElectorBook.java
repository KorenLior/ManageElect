package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class BdrElectorBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tableElectors;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdrElectorBook frame = new BdrElectorBook();
					
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
	public BdrElectorBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Manage");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmElectorBook = new JMenuItem("Elector Book");
		mnNewMenu.add(mntmElectorBook);
		
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
		
		JButton btnUpdate = new JButton("Update Contact");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog popup = new BdrElectorContact();
				popup.setVisible(true);
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnInfo = new JButton("Contact Elector");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog popup = new BdrElectorInfoForm();
				popup.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUpdate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInfo)
					.addContainerGap(110, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUpdate)
						.addComponent(btnInfo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
		);
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("ID");
		columnNames.add("First Name");
		columnNames.add("Last Name");
		columnNames.add("Address");
		columnNames.add("Phone");
		columnNames.add("Ballot");
		tableElectors = new JTable(appEngine.ctrlInterface.getElectorsTable(),columnNames);
		scrollPane.setViewportView(tableElectors);
		contentPane.setLayout(gl_contentPane);
	}
	public void refreshTable() {
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("ID");
		columnNames.add("First Name");
		columnNames.add("Last Name");
		columnNames.add("Address");
		columnNames.add("Phone");
		columnNames.add("Ballot");
		tableElectors = new JTable(appEngine.ctrlInterface.getElectorsTable(),columnNames);
	}
}

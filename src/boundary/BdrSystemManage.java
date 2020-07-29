package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BdrSystemManage extends JFrame {

	private JPanel contentPane;
	private JTextField txtBranch;
	private JTextField txtManager;
	private JTextField txtTransportMng;
	private JTable tableBranch;
	private JTable tableBallot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdrSystemManage frame = new BdrSystemManage();
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
	public BdrSystemManage() {
		setBounds(100, 100, 485, 443);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		txtBranch = new JTextField();
		txtBranch.setColumns(10);
		
		txtManager = new JTextField();
		txtManager.setColumns(10);
		
		txtTransportMng = new JTextField();
		txtTransportMng.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Branch");
		
		JLabel lblNewLabel_1 = new JLabel("Branch Manager ID");
		
		JLabel lblNewLabel_2 = new JLabel("Transportation Manager ID");
		
		JScrollPane scrollPane = new JScrollPane();
		Vector<Object> branchColumnNames = new Vector<Object>();
		branchColumnNames.add("Branch Number");
		branchColumnNames.add("Manager ID");
		branchColumnNames.add("Transportation Manager ID");
		JScrollPane scrollPane_1 = new JScrollPane();
		Vector<Object> ballotColumnNames = new Vector<Object>();
		ballotColumnNames.add("Ballot Number");
		ballotColumnNames.add("Branch Number");
		ballotColumnNames.add("Ballot Address");
		ballotColumnNames.add("Ballot Position");
		ballotColumnNames.add("Ballot Phone");
		
		
		
		JComboBox<Integer> comboBoxBallot = new JComboBox<Integer>();
		Vector<Vector<Object>> ballots = appEngine.ctrlInterface.getBallotTable();
		for (Vector<Object> ballot:ballots) {
			comboBoxBallot.addItem((Integer)ballot.get(0));
		}
		JComboBox<Integer> comboBoxBranch = new JComboBox<Integer>();
		ArrayList<Integer> branches = appEngine.ctrlInterface.getBranchList();
		for (Integer branch:branches) {
			comboBoxBranch.addItem(branch);
		}
		JButton btnNewBranch = new JButton("New Branch");
		btnNewBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int branchNum = Integer.parseInt(txtBranch.getText());
					int managerId = Integer.parseInt(txtManager.getText());
					int transportMngId = Integer.parseInt(txtTransportMng.getText());
					appEngine.ctrlInterface.insertBranch(branchNum, managerId, transportMngId);
					
					
					ArrayList<Integer> branches = appEngine.ctrlInterface.getBranchList();
					for (Integer branch:branches) {
						comboBoxBranch.addItem(branch);
					}
					
					tableBranch = new JTable(appEngine.ctrlInterface.getBranchTable(),branchColumnNames);
					scrollPane.setViewportView(tableBranch);
				}
				catch (Exception e) {
					System.out.println("unable to parse BranchNum or ID");
				}
			}
		});
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Ballot");
		
		JLabel lblNewLabel_4 = new JLabel("Branch");
		
		JButton btnBallot = new JButton("Link Ballot");
		btnBallot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int branchNum = (Integer)comboBoxBranch.getSelectedItem();
				int ballotNum = (Integer)comboBoxBallot.getSelectedItem();
				appEngine.ctrlInterface.updateBallot(ballotNum, branchNum);
				
				tableBallot = new JTable(appEngine.ctrlInterface.getBallotTable(),ballotColumnNames);
				scrollPane_1.setViewportView(tableBallot);
			}
		});
		
		JButton btnImportData = new JButton("Import Ministry of Interior Data");
		btnImportData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtManager, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTransportMng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewBranch))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnBallot, 0, 0, Short.MAX_VALUE)
						.addComponent(comboBoxBranch, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxBallot, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(113))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnImportData)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnImportData)
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(comboBoxBallot, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3))
								.addGap(8)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(comboBoxBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_4)
									.addComponent(txtTransportMng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(54)
								.addComponent(btnBallot)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtManager, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addGap(7)
							.addComponent(btnNewBranch)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(5))
		);
		
		tableBallot = new JTable(appEngine.ctrlInterface.getBallotTable(),ballotColumnNames);
		scrollPane_1.setViewportView(tableBallot);
		
		
		tableBranch = new JTable(appEngine.ctrlInterface.getBranchTable(),branchColumnNames);
		scrollPane.setViewportView(tableBranch);
		contentPane.setLayout(gl_contentPane);
	}
}

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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class BdrRole extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmployeeId1;
	private JTextField txtEmployeeId2;
	private JTextField txtBallotNumber;
	private JTable table;

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
		setBounds(100, 100, 411, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtEmployeeId2 = new JTextField();
		txtEmployeeId2.setEnabled(false);
		txtEmployeeId2.setText("EmployeeId 2");
		txtEmployeeId2.setColumns(10);
		
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Position key");
		columnNames.add("Start Hour");
		columnNames.add("End Hour");
		columnNames.add("Role");
		columnNames.add("Ballot Num");
		columnNames.add("Employee 1");
		columnNames.add("Employee 2");
	
		Vector<Vector<Object>> data = appEngine.ctrlInterface.getElectionDayPositions();
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
		
		
		
		
		JButton btnNewButton_1 = new JButton("Add Position");
		
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
							.addComponent(txtEmployeeId2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxFrom, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxUntil, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
							.addGap(3)))
					.addGap(318))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
					.addGap(142))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addGap(3)
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
					.addComponent(btnNewButton_1)
					.addGap(15))
		);
		
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
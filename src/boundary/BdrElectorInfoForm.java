package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class BdrElectorInfoForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfE;
	private JTextField tfFrom;
	private JTextField tfUntil;
	private int electorId = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BdrElectorInfoForm dialog = new BdrElectorInfoForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BdrElectorInfoForm() {
		setBounds(100, 100, 351, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		tfE = new JTextField();
		tfE.setBounds(5, 6, 86, 20);
		tfE.setText("ElectorID");
		tfE.setColumns(10);
		JButton btnLoad = new JButton("Load Elector");
		btnLoad.setBounds(97, 5, 91, 23);
		
		
		
		
		JLabel lblElector = new JLabel("Elector Info");
		lblElector.setBounds(5, 34, 320, 55);
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int electorId = -1;
				try{
					String idTxt = tfE.getText();
					electorId = Integer.parseInt(idTxt);
				}
				catch(Exception loadFail) {
					System.out.println("elector ID not parsed");
				}
				String result = appEngine.loadElector(electorId);
				if (result!=null){
					lblElector.setText(result);
					setId(electorId);
					
				}
			}
		});
		
		
		
		JCheckBox chckbxAnswered = new JCheckBox("Elector Answered");
		chckbxAnswered.setBounds(5, 107, 109, 23);
		
		
		JComboBox comboBoxPlans = new JComboBox();
		comboBoxPlans.setBounds(144, 136, 86, 22);
		comboBoxPlans.setEnabled(false);
		
		JComboBox comboBoxSupports = new JComboBox();
		comboBoxSupports.setBounds(144, 164, 86, 22);
		comboBoxSupports.setEnabled(false);
		
		JComboBox comboBoxInterested = new JComboBox();
		comboBoxInterested.setBounds(144, 192, 86, 22);
		comboBoxInterested.setEnabled(false);
		
		JCheckBox chckbxRR = new JCheckBox("Ride Required");
		chckbxRR.setBounds(11, 228, 93, 23);
		chckbxRR.setEnabled(false);
		
		tfFrom = new JTextField();
		tfFrom.setText("08:00");
		tfFrom.setBounds(144, 258, 86, 20);
		tfFrom.setEnabled(false);
		tfFrom.setColumns(10);
		
		tfUntil = new JTextField();
		tfUntil.setText("22:00");
		tfUntil.setBounds(144, 284, 86, 20);
		tfUntil.setEnabled(false);
		tfUntil.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Plans to vote");
		lblNewLabel.setBounds(45, 140, 73, 14);
		
		
		contentPanel.setLayout(null);
		contentPanel.add(chckbxAnswered);
		contentPanel.add(comboBoxPlans);
		contentPanel.add(comboBoxSupports);
		contentPanel.add(comboBoxInterested);
		contentPanel.add(chckbxRR);
		contentPanel.add(tfFrom);
		contentPanel.add(tfUntil);
		contentPanel.add(lblNewLabel);
		contentPanel.add(tfE);
		contentPanel.add(btnLoad);
		contentPanel.add(lblElector);
		
		chckbxAnswered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				comboBoxPlans.setEnabled(true);
				comboBoxSupports.setEnabled(true);
				comboBoxInterested.setEnabled(true);
				chckbxRR.setEnabled(true);
			}
		});
		chckbxRR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tfFrom.setEnabled(true);
				tfUntil.setEnabled(true);
			}
		});
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Supports the party");
		lblNewLabel_1.setBounds(33, 168, 101, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Interested in class");
		lblNewLabel_2.setBounds(33, 196, 93, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("From");
		lblNewLabel_3.setBounds(108, 261, 26, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Until");
		lblNewLabel_4.setBounds(108, 287, 26, 14);
		contentPanel.add(lblNewLabel_4);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("Save Elector Info");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
						LocalDateTime now = LocalDateTime.now();
						
						String ans = "no";
						String rr = "no";
						String from,until;
						from = until = null;
						if (chckbxAnswered.isSelected()) {
							ans = "yes";
							if (chckbxRR.isSelected()) {
								rr = "yes";
								from = tfFrom.getText();
								until = tfUntil.getText();
							}
						}
						if (electorId !=-1) {
						appEngine.ctrlInterface.contactElector(electorId, dtf.format(now), ans, 
								(String)comboBoxPlans.getSelectedItem(),(String)comboBoxSupports.getSelectedItem(), 
								(String)comboBoxInterested.getSelectedItem(), rr, 
								from, until);
						}
					}
				});
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	
	private void setId(int id) {
		electorId = id;
	}
}

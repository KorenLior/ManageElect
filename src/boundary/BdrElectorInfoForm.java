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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class BdrElectorInfoForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfElectorId;
	private JTextField textField;
	private JTextField textField_1;

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
		tfElectorId = new JTextField();
		tfElectorId.setBounds(5, 6, 86, 20);
		tfElectorId.setText("ElectorID");
		tfElectorId.setColumns(10);
		JButton btnLoad = new JButton("Load Elector");
		btnLoad.setBounds(97, 5, 91, 23);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblElectorInfo = new JLabel("Elector Info");
		lblElectorInfo.setBounds(5, 34, 320, 55);
		
		JCheckBox chckbxAnswered = new JCheckBox("Elector Answered");
		chckbxAnswered.setBounds(5, 107, 109, 23);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(144, 136, 86, 22);
		comboBox.setEnabled(false);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(144, 164, 86, 22);
		comboBox_1.setEnabled(false);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(144, 192, 86, 22);
		comboBox_2.setEnabled(false);
		
		JCheckBox chckbxRideReq = new JCheckBox("Ride Required");
		chckbxRideReq.setBounds(11, 228, 93, 23);
		chckbxRideReq.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(144, 258, 86, 20);
		textField.setEnabled(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 284, 86, 20);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Plans to vote");
		lblNewLabel.setBounds(45, 140, 73, 14);
		contentPanel.setLayout(null);
		contentPanel.add(chckbxAnswered);
		contentPanel.add(comboBox);
		contentPanel.add(comboBox_1);
		contentPanel.add(comboBox_2);
		contentPanel.add(chckbxRideReq);
		contentPanel.add(textField);
		contentPanel.add(textField_1);
		contentPanel.add(lblNewLabel);
		contentPanel.add(tfElectorId);
		contentPanel.add(btnLoad);
		contentPanel.add(lblElectorInfo);
		
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
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BdrElectorContact extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfElector;
	private JTextField tfPhone;
	private int electorId = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BdrElectorContact dialog = new BdrElectorContact();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BdrElectorContact() {
		setBounds(100, 100, 386, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("Elector Phone Number");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		tfElector = new JTextField();
		tfElector.setText("ElectorID");
		tfElector.setColumns(10);
		
		JButton btnLoad = new JButton("Load Elector");
		
		
		JLabel lblElector = new JLabel("New label");
		
		tfPhone = new JTextField();
		tfPhone.setText("Phone Number");
		tfPhone.setColumns(10);
		
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int electorId = -1;
				try{
					String idTxt = tfElector.getText();
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblElector, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(tfElector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnLoad)
								.addContainerGap(231, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(tfPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfElector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblElector, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(tfPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (electorId>-1) {
							int phoneNum = -1;
							try{
								String idTxt = tfPhone.getText();
								phoneNum = Integer.parseInt(idTxt);
							}
							catch(Exception loadFail) {
								System.out.println("Phone Number not parsed");
							}
							if (phoneNum>0) {
								appEngine.ctrlInterface.electorPhoneUpdate(electorId, phoneNum);
							}
						}
					}
				});
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	private void setId(int id) {
		electorId = id;
	}
}

package boundary;

import control.CtrlInterface;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class appEngine {
	static CtrlInterface ctrlInterface = new CtrlInterface();
	
	private static JFrame main;
	public static void main(String[] args) {
		main = new BdrLogin();
		main.setVisible(true);
	}
	
	public static void login(int id) {
		ctrlInterface.login(id);
		if (ctrlInterface.getPermmission()>=0) //login successful
		{
			main.setVisible(false);
			main = new BdrMain();
			main.setVisible(true);
		}
	}
	
	public static void popUpElectorInfoForm() {
		JDialog popup = new BdrElectorInfoForm();
		popup.setVisible(true);
	}
	public static void popUpElectorContactForm() {
		JDialog popup = new BdrElectorContact();
		popup.setVisible(true);
	}
	public static void bdrElectionDayPosition() {
		if (ctrlInterface.getPermmission()>=3) {
			main.setVisible(false);
			main = new BdrRole();
			main.setVisible(true);
		}
		if (ctrlInterface.getPermmission()>=2) {
			main.setVisible(false);
			main = new BdrRole_Branch();
			main.setVisible(true);
		}
	}
	
	public static String loadElector(int electorId){
		String electorInfo = ctrlInterface.getElector(electorId);
		return electorInfo;
	}

	public static void bdrRideManage() {
		if (ctrlInterface.getPermmission()>=1) {
			main.setVisible(false);
			main = new BdrRideManage();
			main.setVisible(true);
		}
	}
}

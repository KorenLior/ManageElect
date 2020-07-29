package boundary;

import control.CtrlInterface;
import entity.JasperReportEntity;

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
		System.out.println("permission="+ctrlInterface.getPermission());
		ctrlInterface.login(id);
		System.out.println("permission="+ctrlInterface.getPermission());
		if (ctrlInterface.getPermission()>=0) //login successful
		{
			
			main.setVisible(false);
			main = new BdrElectorBook();
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
		if (ctrlInterface.getPermission()>=2) {
			main.setVisible(false);
			main = new BdrRole();
			main.setVisible(true);
		}
	}
	public static void bdrEmployee() {
		if (ctrlInterface.getPermission()>=2) {
			main.setVisible(false);
			main = new BdrEmployee();
			main.setVisible(true);
		}
	}
	public static String loadElector(int electorId){
		String electorInfo = ctrlInterface.getElector(electorId);
		return electorInfo;
	}

	public static void bdrRideManage() {
		if (ctrlInterface.getPermission()>=1) {
			main.setVisible(false);
			main = new BdrRideManage();
			main.setVisible(true);
		}
	}

	public static void popUpTransportReport() {
		JasperReportEntity jasperReportEntity = new JasperReportEntity();
		jasperReportEntity.compileTransportReport().setVisible(true);
	}

	public static void bdrElectorBook() {
		main.setVisible(false);
		main = new BdrElectorBook();
		main.setVisible(true);
	}

	public static void bdrSystem() {
		if (ctrlInterface.getPermission()>=3) {
		main.setVisible(false);
		main = new BdrSystemManage();
		main.setVisible(true);
		}
	}		
}
package boundary;

import control.CtrlInterface;
import javax.swing.JFrame;

public class appEngine {
	private static CtrlInterface ctrlInterface = new CtrlInterface();
	
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
}

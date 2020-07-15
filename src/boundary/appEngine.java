package boundary;

import control.CtrlInterface;

public class appEngine {
	private static CtrlInterface ctrlInterface = new CtrlInterface();
	
	
	public static void main(String[] args) {
		//TODO: launch BdrLogin
	}
	
	public static void login(int id) {
		ctrlInterface.login(id);
		if (ctrlInterface.getPermmission()>=0) //login successful
		{
			//TODO: launch BdrMain
		}
	}
}

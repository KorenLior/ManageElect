package control;

import java.util.Vector;

import entity.DbGetEmployeeList;
import entity.Employee;

public class CtrlInterface {
	
	private CtrlLogin ctrlLogin;
	private int loginId = -1;
	private int manager;
	private static CtrlSystemInfo ctrlSystemInfo;
	private Employee me = null;
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public CtrlInterface() {
		
		ctrlSystemInfo = new CtrlSystemInfo();
		manager = ctrlSystemInfo.getManagerId();
		
	}
	public void login(int employeeId)
	{
		
		try {
			ctrlLogin = new CtrlLogin(employeeId);
		} catch (Exception e) {
			System.out.print("EmployeeList Empty");
			e.printStackTrace();
		}
		if (ctrlLogin.getPermission()>-1)
		{
			this.loginId = employeeId;
			me = new DbGetEmployeeList().getEmployee(employeeId);
			System.out.println("loginId = "+loginId);
		}
	}
	public int getPermmission()
	{
		if (loginId==-1)
		{
			return -5556;
		}
		else
		{
			return ctrlLogin.getPermission();
		}
	}
	public int getId()
	{
		return loginId;
	}
	public int getBranch() {
		if (loginId==-1) {
			return 0;
		}
		return me.getBranchNum();
	}
	/**
	public void contactElector(int electorId, Date callDate,
			String gotAnswer, String planToVote, String supportTheParty, String interestInClass,
			String needRide, Time pickupFrom, Time pickupTo){
		
		 * add logic to test for valid input

		if (loginId != -1)
		{
			CtrlContactElector ctrlContactElector = new CtrlContactElector(loginId, electorId, callDate,
				gotAnswer, planToVote, supportTheParty, interestInClass,
				needRide, pickupFrom, pickupTo);
		}
	}
	*/
	public String getElectorName(int id)
	{
		CtrlElector ctrlElector = new CtrlElector();
		return ctrlElector.getElectorName(id);
	}
	
	public String getElectorAddress(int id)
	{
		CtrlElector ctrlElector = new CtrlElector();
		return ctrlElector.getElectorAddress(id);
	}
	
	public String getElectorContactInfo(int id)
	{
		CtrlElector ctrlElector = new CtrlElector();
		return ctrlElector.getElectorInfo(id);
	}
	
	public String getElector(int id)
	{
		CtrlElector ctrlElector = new CtrlElector();
		return ctrlElector.getElectorInfo(id);
	}
	
		
		
	public String getElector(String idTxt) {
		int idInt = Integer.parseInt(idTxt);
		String res = getElector(idInt);
		//System.out.println("control.getElector res= "+res);
		return res;
	}
	
	public void contactElector(int electorId, String date, Boolean gotAnswer, String planToVote, String supportTheParty,
			Boolean interestInClass, Boolean needRide, int pickupFrom, int pickupTo) {
		if (loginId != -1)
		{
			CtrlContactElector ctrlContactElector = new CtrlContactElector(loginId, electorId,
				gotAnswer, planToVote, supportTheParty, interestInClass,
				needRide, pickupFrom, pickupTo,date);
		}
		
	}
	
	public void electorPhoneUpdate(int electorId, int phoneNum) {
		(new CtrlElector()).updatePhone(electorId, phoneNum);
	}
	
	public Vector<Vector<Object>> getElectionDayPositions(){
		Vector<Vector<Object>> result = (new CtrlElectionDayPosition()).getPositionList();
		return result;
	}
	public Vector<Vector<Object>> getElectionDayPositionsBranch(){
		if (loginId==-1) {
			return null;
		}
		Vector<Vector<Object>> result = (new CtrlElectionDayPosition()).getPositionBranchList(me.getBranchNum());
		return result;
	}
	public Vector<Vector<Object>> getDriversBranch(){
		Vector<Vector<Object>> result = (new CtrlElectionDayPosition()).getDriverBranchList(1111);
		return result;
	}
	public Vector<Vector<Object>> getRiders(boolean assigned){
		Vector<Vector<Object>> result = null;
		if (!assigned) {
			result = (new CtrlElectionDayPosition()).getUnassignedRidersBranch(1111);
		}
		return result;
	}
	public Vector<Vector<Object>> getElectorsTable(){
		Vector<Vector<Object>> result = (new CtrlElector()).getElectorsTable();
		return result;
	}
	public void insertPosition(int startHour, int endHour, String role, int ballotNum, int employee1, int employee2) {
		CtrlElectionDayPosition ctrlElectionDayPosition = new CtrlElectionDayPosition();
		ctrlElectionDayPosition.insertPosition(startHour, endHour, role, ballotNum, employee1, employee2);
	}
}

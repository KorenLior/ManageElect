package control;

import java.util.ArrayList;
import java.util.Vector;

import entity.Branch;
import entity.DbEmployee;
import entity.DbBranches;
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
			me = new DbEmployee().getEmployee(employeeId);
			System.out.println("loginId = "+loginId);
		}
	}
	public int getPermission()
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
	public void electorRideUpdate(int electorId, int rideId, String rideTime) {
		(new CtrlElector()).updateRide(electorId, rideId, rideTime);
	}
	
	
	public Vector<Vector<Object>> getElectionDayPositions(){
		if (loginId<=0) {
			return null;
		}
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		if (getPermission()==2) {
			result = (new CtrlElectionDayPosition()).getPositionList(me.getBranchNum());
		}
		if (getPermission()==3) {
			result = (new CtrlElectionDayPosition()).getPositionList();
		}
		return result;
	}
	public Vector<Vector<Object>> getEmployees(){
		if (getPermission()<=0) {
			return null;
		}
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		if (getPermission()==2) {
			result = (new CtrlEmployee()).getEmploeeVec(me.getBranchNum());
		}
		if (getPermission()==3) {
			result = (new CtrlEmployee()).getEmploeeVec();
		}
		return result;
	}
	public Vector<Vector<Object>> getFullEmployees(){
		if (getPermission()<=0) {
			return null;
		}
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		if (getPermission()==2) {
			result = (new CtrlEmployee()).getFullEmploeeVec(me.getBranchNum());
		}
		if (getPermission()==3) {
			result = (new CtrlEmployee()).getFullEmploeeVec();
		}
		return result;
	}
	public Vector<Vector<Object>> getDrivers(){
		if (getPermission()<=0) {
			return null;
		}
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		if (getPermission()<=2) {
			result = (new CtrlElectionDayPosition()).getDrivers(me.getBranchNum());
		}
		if (getPermission()==3) {
			result = (new CtrlElectionDayPosition()).getDrivers();
		}
		return result;
	}
	public Vector<Vector<Object>> getRiders(boolean assigned){
		if (getPermission()<=0) {
			return null;
		}
		Vector<Vector<Object>> result = new Vector<Vector<Object>>();
		if (!assigned) {
			if (getPermission()<=2) {
				result = (new CtrlElectionDayPosition()).getUnassignedRiders(me.getBranchNum());
			}
			else {
				result = (new CtrlElectionDayPosition()).getUnassignedRiders();
			}
		}
		if(assigned) {
			if (getPermission()<=2) {
				result = (new CtrlElectionDayPosition()).getAssignedRiders(me.getBranchNum());
			}
			else {
				result = (new CtrlElectionDayPosition()).getAssignedRiders();
			}
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
	public void addEmployee(int id, String birthDate, String gender, String nation, boolean car, int status, int kids, int branchNum) {
		if (getPermission()==2) {
			(new CtrlEmployee()).addEmployee(id, birthDate, gender, nation, car, status, kids, me.getBranchNum());
		}
		if (getPermission()==3) {
			(new CtrlEmployee()).addEmployee(id, birthDate, gender, nation, car, status, kids, branchNum);
		}
	}
	public ArrayList<Integer> getBranchList(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Branch branch:((new DbBranches()).getBranches()) ) {
			result.add(branch.getBranchNum());
		}
		return result;
	}
	public Vector<Vector<Object>> getBallotTable(){
		return((new CtrlSystemInfo()).getBallotTable());
	}
	public Vector<Vector<Object>> getBranchTable(){
		return((new CtrlSystemInfo()).getBranchTable());
	}
	public void insertBranch(int branchNum, int managerId, int transportMngId) {
		if (getPermission()==3) {
			(new CtrlSystemInfo()).insertBranch(branchNum, managerId, transportMngId);
		}
	}
	public void updateBallot(int ballotNum, int branchNum) {
		if (getPermission()==3) {
			(new CtrlSystemInfo()).updateBallot(branchNum, ballotNum);
		}
	}
}

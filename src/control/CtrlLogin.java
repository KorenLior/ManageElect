package control;

import java.util.ArrayList;

import entity.Branch;
import entity.DbBranches;
import entity.DbEmployee;
import entity.Employee;

class CtrlLogin {
	//TODO HASH permission for greater security
	private int permission = -5555;
	private ArrayList<Employee> emplyeeList;
	public int getPermission()
	{
		return permission;
	}
	public CtrlLogin(int id) throws Exception {
		
		emplyeeList = (new DbEmployee()).getEmployees();
		new DbBranches();
		ArrayList<Branch> branchList = (new DbBranches()).getBranches();
		CtrlSystem ctrlSystemInfo = new CtrlSystem();
		
		
		if (ctrlSystemInfo.getManagerId()==id)
		{
			permission = 3;
			return;
		}
		for (Branch branch:branchList)
		{
			
			if (branch.getManagerId() == id)
			{
				permission = 2;
				return;
			}
			if (branch.getTransportRepId() == id)
			{
				permission = 1;
				return;
			}
		}
		if (emplyeeList.isEmpty()) {
			throw new Exception("EmployeeList empty");
		}
		for(Employee employee:emplyeeList)
		{
			
			if (employee.getId() == id)
			{
				permission = 0;
			}
		}
	}
}

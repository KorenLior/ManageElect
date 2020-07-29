package control;

import java.util.ArrayList;
import java.util.Vector;

import entity.DbElectors;
import entity.DbEmployee;
import entity.Employee;

public class CtrlEmployee {
	public void updateEmployee(int id, String birthDate, String gender, String nationality, boolean car, int status,
			int kids, int branch) {
		DbEmployee dbEmployee = new DbEmployee();
		dbEmployee.updateEmployee(id, birthDate, gender, nationality, car, status, kids, branch);
	}
	public void addEmployee(int id, String birthDate, String gender, String nation, boolean car, int status, int kids, int branchNum) {
		DbEmployee dbEmployee = new DbEmployee();
		dbEmployee.addEmployee(id, birthDate, gender, nation, car, status, kids, branchNum);
	}
	public Vector<Vector<Object>> getEmployeeVec(){
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		DbEmployee dbGetEmployeeList = new DbEmployee();
		ArrayList<Employee> employees = dbGetEmployeeList.getEmployees();
		for (Employee employee:employees) {
			Vector<Object> result  = new Vector<Object>();
			DbElectors dbElectors = new DbElectors();
			result.add(employee.getId());
			result.add(dbElectors.getElector(employee.getId()).getLastName()+" "+dbElectors.getElector(employee.getId()).getFirstName());
			result.add(employee.isCar());
			results.add(result);
		}
		return results;
	}
	public Vector<Vector<Object>> getEmployeeVec(int branchNum){
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		DbEmployee dbGetEmployeeList = new DbEmployee();
		ArrayList<Employee> employees = dbGetEmployeeList.getEmployees(branchNum);
		for (Employee employee:employees) {
			Vector<Object> result  = new Vector<Object>();
			DbElectors dbElectors = new DbElectors();
			result.add(employee.getId());
			result.add(dbElectors.getElector(employee.getId()).getLastName()+" "+dbElectors.getElector(employee.getId()).getFirstName());
			result.add(employee.isCar());
			results.add(result);
		}
		return results;
	}
	public Vector<Vector<Object>> getFullEmployeeVec(int branchNum) {
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		DbEmployee dbGetEmployeeList = new DbEmployee();
		ArrayList<Employee> employees = dbGetEmployeeList.getEmployees(branchNum);
		for (Employee employee:employees) {
			Vector<Object> result  = new Vector<Object>();
			DbElectors dbElectors = new DbElectors();
			result.add(employee.getId());
			result.add(dbElectors.getElector(employee.getId()).getLastName());
			result.add(dbElectors.getElector(employee.getId()).getFirstName());
			result.add(employee.getBirthDate());
			result.add(employee.getGender());
			result.add(employee.getNationality());
			result.add(employee.isCar());
			if (employee.getStatus()<=0) {
				result.add("Bachelor");
			}
			if (employee.getStatus()==1) {
				result.add("Married");
			}
			if (employee.getStatus()>=2) {
				result.add("Married");
			}
			result.add(employee.getNumChildren());
			results.add(result);
		}
		return results;
	}
	public Vector<Vector<Object>> getFullEmployeeVec() {
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		DbEmployee dbGetEmployeeList = new DbEmployee();
		ArrayList<Employee> employees = dbGetEmployeeList.getEmployees();
		for (Employee employee:employees) {
			Vector<Object> result  = new Vector<Object>();
			DbElectors dbElectors = new DbElectors();
			result.add(employee.getId());
			result.add(dbElectors.getElector(employee.getId()).getLastName());
			result.add(dbElectors.getElector(employee.getId()).getFirstName());
			result.add(employee.getBirthDate());
			result.add(employee.getGender());
			result.add(employee.getNationality());
			result.add(employee.isCar());
			if (employee.getStatus()<=0) {
				result.add("Bachelor");
			}
			if (employee.getStatus()==1) {
				result.add("Married");
			}
			if (employee.getStatus()>=2) {
				result.add("Married");
			}
			result.add(employee.getNumChildren());
			results.add(result);
		}
		return results;
	}
	
}

package entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbEmployee {

	public DbEmployee() {
		// TODO Auto-generated constructor stub
	}
	ConstsDbManageElect dbConsts = new ConstsDbManageElect();
	
	public ArrayList<Employee> getEmployees(int branchNum) {
		 ArrayList<Employee> results = new ArrayList<Employee>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_EMPLOYEES_BRANCH+branchNum);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;

		 results.add(new Employee(rs.getInt(i++), rs.getString(i++),
		 rs.getString(i++), rs.getString(i++), rs.getBoolean(i++),
		 rs.getInt(i++), rs.getInt(i++), rs.getInt(i++)));
		 }
		 } catch (SQLException e) {
			 System.out.print("Employee Read Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			 System.out.print("Employee Class Not Found");
		 e.printStackTrace();
		}

		return results;
	}
	
	public ArrayList<Employee> getEmployees() {
		 ArrayList<Employee> results = new ArrayList<Employee>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_EMPLOYEES);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;

		 results.add(new Employee(rs.getInt(i++), rs.getString(i++),
		 rs.getString(i++), rs.getString(i++), rs.getBoolean(i++),
		 rs.getInt(i++), rs.getInt(i++), rs.getInt(i++)));
		 }
		 } catch (SQLException e) {
			 System.out.print("Employee Read Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			 System.out.print("Employee Class Not Found");
		 e.printStackTrace();
		}

		return results;
	}
	
	
	public Employee getEmployee(int id) {
		 Employee result = null;
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_EMPLOYEE
				 +id);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;

		 result = new Employee(rs.getInt(i++), rs.getString(i++),
		 rs.getString(i++), rs.getString(i++), rs.getBoolean(i++),
		 rs.getInt(i++), rs.getInt(i++), rs.getInt(i++));
		 }
		 } catch (SQLException e) {
			 System.out.print("Employee Read Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
			 System.out.print("Employee Class Not Found");
		 e.printStackTrace();
		}

		return result;
	}
	public void addEmployee(int id, String birthDate, String gender, String nation, boolean car, int status, int kids, int branchNum) {
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsDbManageElect.SQL_INS_EMPLOYEE)) {	
		int i = 1;
	
		 stmt.setInt(i++, id);
		 stmt.setString(i++, birthDate);
		 stmt.setString(i++, gender);
		 stmt.setString(i++, nation);
		 stmt.setBoolean(i++, car);
		 stmt.setInt(i++, status);
		 stmt.setInt(i++, kids);
		 stmt.setInt(i++, branchNum);
		 stmt.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("insertEmployee Failure2");
		 e.printStackTrace();
		 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("insertEmployee ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
}

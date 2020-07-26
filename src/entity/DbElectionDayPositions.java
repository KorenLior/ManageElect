package entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbElectionDayPositions {
	public ArrayList<ElectionDayPosition> getPositions() {
		 ArrayList<ElectionDayPosition> results = new ArrayList<ElectionDayPosition>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_DAYPOSITIONS);
		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
			 int i = 1;
			 ElectionDayPosition result = null;
			 try
			 {
				 result = new ElectionDayPosition(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++),
						 rs.getString(i++), rs.getInt(i++), rs.getInt(i++), rs.getInt(i++));	 
			 }
			 catch (Exception e) {
				// TODO: handle exception
				 System.out.println("ElectionDayPosition readDb Failure");
			 }
			 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getElectionDayPosition() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	public ArrayList<ElectionDayPosition> getPositionsBranch(int branchNum){
		ArrayList<ElectionDayPosition> results = new ArrayList<ElectionDayPosition>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_DAYPOSITIONS_BRANCH1+branchNum+ConstsDbManageElect.SQL_SEL_DAYPOSITIONS_BRANCH2);
		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
			 int i = 1;
			 ElectionDayPosition result = null;
			 try
			 {
				 result = new ElectionDayPosition(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++),
						 rs.getString(i++), rs.getInt(i++), rs.getInt(i++), rs.getInt(i++));	 
			 }
			 catch (Exception e) {
				// TODO: handle exception
				 System.out.println("ElectionDayPosition readDb Failure");
			 }
			 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getElectionDayPosition() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	
	
	
	
	public ArrayList<ElectionDayPosition> getPositionsEmployee(int employeeId) {
		 ArrayList<ElectionDayPosition> results = new ArrayList<ElectionDayPosition>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_DAYPOSITIONS_EMPLOYEE1
				 +employeeId);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
			 int i = 1;
			 ElectionDayPosition result = null;
			 try
			 {
				 result = new ElectionDayPosition(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++),
						 rs.getString(i++), rs.getInt(i++), rs.getInt(i++), rs.getInt(i++));	 
			 }
			 catch (Exception e) {
				// TODO: handle exception
				 System.out.println("ElectionDayPosition readDb Failure");
			 }
			 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getElectionDayPosition() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

			 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_DAYPOSITIONS_EMPLOYEE2
					 +employeeId);

			 ResultSet rs = stmt.executeQuery()) {

			 while (rs.next()) {
				 int i = 1;
				 ElectionDayPosition result = null;
				 try
				 {
					 result = new ElectionDayPosition(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++),
							 rs.getString(i++), rs.getInt(i++), rs.getInt(i++), rs.getInt(i++));	 
				 }
				 catch (Exception e) {
					// TODO: handle exception
					 System.out.println("ElectionDayPosition readDb Failure");
				 }
				 results.add(result);
			 }
			 } catch (SQLException e) {
				 System.out.println("getElectionDayPosition() readFromDb Failure");
			 e.printStackTrace();
			 }
			} catch (ClassNotFoundException e) {
			 e.printStackTrace();
			}
		return results;
	}
	public ArrayList<ElectionDayPosition> getDriversBranch(int branchNum){
		ArrayList<ElectionDayPosition> results = new ArrayList<ElectionDayPosition>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_DRIVERS_BRANCH);)
		  {
			 try {
				stmt.setInt(1, branchNum);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
				 int i = 1;
				 ElectionDayPosition result = null;
				 try
				 {
					 result = new ElectionDayPosition(rs.getInt(i++), rs.getInt(i++), rs.getInt(i++),
							 "Drive", 0, rs.getInt(i++), 0);	 
				 }
				 catch (Exception e) {
					// TODO: handle exception
					 System.out.println("ElectionDayPosition readDb Failure");
				 }
				 results.add(result);
				}
			 }
			 catch (Exception e) {
				 System.out.println("getDriversBranch() readFromDb Failure");
			 }
			 } catch (SQLException e) {
				 System.out.println("getElectionDayPosition() readFromDb Failure");
			 e.printStackTrace();
			 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	public ArrayList<Rider> getUnaasignedRiders(int branchNum){
		ArrayList<Rider> results = new ArrayList<Rider>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_UNASSRIDERS_BRANCH1+branchNum+ConstsDbManageElect.SQL_SEL_UNASSRIDERS_BRANCH2);
		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
			 int i = 1;
			 Rider result = null;
			 try
			 {
				 int id = rs.getInt(i++);
				 String firstName = rs.getString(i++);
				 String lastName = rs.getString(i++);
				 int phoneNum = rs.getInt(i++);
				 String callDate = rs.getString(i++);
				 int from = rs.getInt(i++);
				 int until = rs.getInt(i++);
				 String electorAddress = rs.getString(i++);
				 String ballotAddress = rs.getString(i++);
				 int ballotNum = rs.getInt(i++);
				 result = new Rider((new DbElectors().getElector(id)), from, until, ballotAddress, callDate, new Ride());	 
			 }
			 catch (Exception e) {
				// TODO: handle exception
				 System.out.println("ElectionDayPosition readDb Failure");
			 }
			 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getElectionDayPosition() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	
	public void insertPosition(int startHour, int endHour, String role, int ballotNum,
			int employee1, int employee2) {
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsDbManageElect.SQL_INS_DAYPOSITION)) {

	/* (CallDate, GotAnswer, PlanToVote, SupportTheParty, InterestInClass, NeedRide, PickupFrom, PickupTo, ElectorId, EmployeeId)*/
			
		int i = 1;
		 //stmt.setString(i++, callDate);
		
		
		 stmt.setInt(i++, startHour);
		 stmt.setInt(i++, endHour);
		 stmt.setString(i++, role);
		 stmt.setInt(i++, ballotNum);
		 stmt.setInt(i++, employee1);
		 stmt.setInt(i++, employee2);
		 stmt.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("insertPosition Failure2");
		 e.printStackTrace();
		 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("insertPosition ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
	
}

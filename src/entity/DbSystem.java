package entity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

public class DbSystem {

	public DbSystem() {
		// TODO Auto-generated constructor stub
	}
	private ConstsDbManageElect dbConsts = new ConstsDbManageElect();
	
	
	
	public SystemInfo getSystem() {
	
		String partyName = null;
		int managerId = -5555;
		String startTime = null; 
		String endTime = null;
		String electionCalendarStart = null;
		String electionCalendarEnd = null;
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
			
			 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_SYSTEM);
			
			 ResultSet rs = stmt.executeQuery()) {
					rs.next();
					int i = 1;
					int ser = rs.getInt(i++);
					partyName = rs.getString(i++);
					managerId = rs.getInt(i++);
					startTime = rs.getString(i++);
					endTime = rs.getString(i++);
					electionCalendarStart = rs.getString(i++);
			 
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}
		SystemInfo results = new SystemInfo(partyName, managerId, startTime, endTime, electionCalendarStart);
		return results;
	}
	
	public ArrayList<Ballot> getBallots(){
		 ArrayList<Ballot> results = new ArrayList<Ballot>();
		 try {
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);

		 PreparedStatement stmt = conn.prepareStatement(ConstsDbManageElect.SQL_SEL_BALLOTS);

		 ResultSet rs = stmt.executeQuery()) {

		 while (rs.next()) {
		 int i = 1;
		 Ballot result = null;
		 try
		 {
			 result = new Ballot(rs.getInt(i++), rs.getString(i++),rs.getBoolean(i++), rs.getString(i++), rs.getString(i++), rs.getInt(i++));
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("Branch readDb Failure");
		 }
		 results.add(result);
		 }
		 } catch (SQLException e) {
			 System.out.println("getBranches() readFromDb Failure");
		 e.printStackTrace();
		 }
		} catch (ClassNotFoundException e) {
		 e.printStackTrace();
		}

		return results;
	}
	
	public void updateBallot(int ballotNum, int branchNum)
	{
		try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsDbManageElect.SQL_UPDATE_BALLOT)) {

			
			int i = 1;
	
			stmt.setInt(i++, branchNum);
			stmt.setInt(i++, ballotNum);
	
			 stmt.executeUpdate();
			 } catch (SQLException e) {
				 System.out.println("DbUpdateBallot Failure2");
			 e.printStackTrace();
			 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("DbUpdateBallot ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}

	public void updateBranchManager(int branch, int id) {
		try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsDbManageElect.SQL_UPDATE_BRANCHMAN)) {
			int i = 1;
	
			stmt.setInt(i++, id);
			stmt.setInt(i++, branch);
	
			 stmt.executeUpdate();
			 } catch (SQLException e) {
				 System.out.println("DbUpdateBranchMan Failure2");
			 e.printStackTrace();
			 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("DbUpdateBranchMan ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
	public void updateBranchTransportMan(int branch, int id) {
		try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR);
					 
				CallableStatement stmt = conn.prepareCall(ConstsDbManageElect.SQL_UPDATE_BRANCHTRANSPORTREP)) {
			int i = 1;
	
			stmt.setInt(i++, id);
			stmt.setInt(i++, branch);
	
			 stmt.executeUpdate();
			 } catch (SQLException e) {
				 System.out.println("DbUpdateBranchTransportMan Failure2");
			 e.printStackTrace();
			 }
		 } catch (ClassNotFoundException e) {
			 System.out.println("DbUpdateBranchTransportMan ClassNotFound Failure2");
		 e.printStackTrace();
		 }
	}
}

package entity;

import java.net.URLDecoder;

public class ConstsDbManageElect {
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	public static final String SQL_SEL_BRANCHES = "SELECT * FROM TblBranch";
	public static String SQL_SEL_ELECTOR = "SELECT * FROM TblElector";
	public static String SQL_SEL_ELECTOR_BALLOT = "SELECT * FROM TblElector WHERE BallotNum=";
	public static String SQL_SEL_ELECTOR_ID = "SELECT * FROM TblElector WHERE ID=";
	public static final String SQL_SEL_EMPLOYEES = "SELECT * FROM TblEmployee";
	public static final String SQL_INS_ELECTORINFO =  "{ call QRYNEWELECTORINFO(?,?,?,?,?,?,?,?,?,?) }";
	public static final String SQL_SEL_SYSTEM = "SELECT * FROM TblSystem";
	public static final String SQL_UPDATE_ELECTOR_PHONE =  "{ call QryUpdateElectorPhone(?,?) }";
	public static final String SQL_SEL_DAYPOSITIONS_BRANCH1 = "SELECT TblElectionDayPosition.JobID, TblElectionDayPosition.StartHour, TblElectionDayPosition.EndHour, TblElectionDayPosition.Role, TblElectionDayPosition.BallotNum, TblElectionDayPosition.EmpID1, TblElectionDayPosition.EmpID2\r\n" + 
			"FROM TblEmployee RIGHT JOIN TblElectionDayPosition ON TblEmployee.ID = TblElectionDayPosition.EmpID1\r\n" + 
			"WHERE (((TblEmployee.BranchNum)=";
	public static final String SQL_SEL_DAYPOSITIONS_BRANCH2 = "))\r\n" + 
			"GROUP BY TblElectionDayPosition.JobID, TblElectionDayPosition.StartHour, TblElectionDayPosition.EndHour, TblElectionDayPosition.Role, TblElectionDayPosition.BallotNum, TblElectionDayPosition.EmpID1, TblElectionDayPosition.EmpID2;";
	public static final String SQL_SEL_DAYPOSITIONS = "SELECT * FROM TblElectionDayPosition";
	public static final String SQL_INS_DAYPOSITION =  "{ call QryNewElectionDayPosition(?,?,?,?,?,?) }";
	public static final String SQL_SEL_DAYPOSITIONS_EMPLOYEE1 = "SELECT * FROM TblElectionDayPosition WHERE EmpID1=";
	public static final String SQL_SEL_DAYPOSITIONS_EMPLOYEE2 = "SELECT * FROM TblElectionDayPosition WHERE EmpID2=";
	public static final String SQL_SEL_EMPLOYEE = "SELECT * FROM TblEmployee WHERE ID=";
	private static String getDBPath() {
		 try {
		String path = ConstsDbManageElect.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		 decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/database/DbManageElect.accdb";
		} else {
		 decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
		return decoded + "src/entity/DbManageElect.accdb";
		}
		} catch (Exception e) {
		 e.printStackTrace();
		 return null;
		}
	}
}

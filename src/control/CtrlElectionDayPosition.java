package control;

import java.util.ArrayList;
import java.util.Vector;

import entity.DbElectionDayPositions;
import entity.DbGetEmployeeList;
import entity.ElectionDayPosition;
import entity.Employee;

public class CtrlElectionDayPosition {
	public boolean insertPosition(int startHour, int endHour, String role, int ballotNum, int employee1, int employee2) {
		if (positionValid(startHour, endHour, role, ballotNum, employee1, employee2)) {
			DbElectionDayPositions dbElectionDayPositions = new DbElectionDayPositions();
			dbElectionDayPositions.insertPosition(startHour, endHour, role, ballotNum, employee1, employee2);
			return true;
		}
		return false;
	}
	public Vector<Vector<Object>> getPositionList(){
		DbElectionDayPositions dbElectionDayPositions = new DbElectionDayPositions();
		ArrayList<ElectionDayPosition> positions = dbElectionDayPositions.getPositions();
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		for (ElectionDayPosition position:positions) {
			Vector<Object> result = new Vector<Object>();
			result.add(position.getKey());
			result.add(position.getStartHour()+":00");
			result.add(position.getEndHour()+":00");
			result.add(position.getRole());
			result.add(position.getBallot());
			result.add(position.getEmployee1());
			result.add(position.getEmployee2());
			results.add(result);
		}
		return results;
	}
	public Vector<Vector<Object>> getPositionBranchList(int branchNum){
		DbElectionDayPositions dbElectionDayPositions = new DbElectionDayPositions();
		ArrayList<ElectionDayPosition> positions = dbElectionDayPositions.getPositionsBranch(branchNum);
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		for (ElectionDayPosition position:positions) {
			Vector<Object> result = new Vector<Object>();
			result.add(position.getKey());
			result.add(position.getStartHour()+":00");
			result.add(position.getEndHour()+":00");
			result.add(position.getRole());
			result.add(position.getBallot());
			result.add(position.getEmployee1());
			result.add(position.getEmployee2());
			results.add(result);
		}
		return results;
	}
	private boolean positionValid(int startHour, int endHour, String role, int ballotNum, int employee1, int employee2) {
		if (employee1 == 0) {return false;}
		Employee emp = (new DbGetEmployeeList()).getEmployee(employee1);
		if (emp == null) {return false;} /*employee1 doesnt exist*/
		if (role=="Drive") {
			if (!emp.isCar()) {return false;} /*dosnt own car*/
		}
		if (role=="Rep") {/*Ballot Rep*/
			if (employee2==0) {return false;}
		}
		if (startHour>=endHour) {return false;}
		DbElectionDayPositions dbElectionDayPositions = new DbElectionDayPositions();
		ArrayList<ElectionDayPosition> positions = dbElectionDayPositions.getPositionsEmployee(employee1);
		for (ElectionDayPosition position:positions) {
			if ((startHour<position.getEndHour()) && (startHour>=position.getStartHour())) {
				return false;
			}
			if ((endHour<position.getEndHour()) && (endHour>=position.getStartHour())) {
				return false;
			}
		}
		if (employee2!=0) {
			ArrayList<ElectionDayPosition> positions2 = dbElectionDayPositions.getPositionsEmployee(employee2);
			for (ElectionDayPosition position:positions2) {
				if ((startHour<position.getEndHour()) && (startHour>=position.getStartHour())) {
					return false;
				}
				if ((endHour<position.getEndHour()) && (endHour>=position.getStartHour())) {
					return false;
				}
			}
		}
		
		return true;
	}
}

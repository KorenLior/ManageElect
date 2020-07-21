package control;

import java.util.ArrayList;
import java.util.Vector;

import entity.DbElectionDayPositions;
import entity.ElectionDayPosition;

public class CtrlElectionDayPosition {
	public void insertPosition(int startHour, int endHour, String role, int ballotNum, int employee1, int employee2) {
		DbElectionDayPositions dbElectionDayPositions = new DbElectionDayPositions();
		dbElectionDayPositions.insertPosition(startHour, endHour, role, ballotNum, employee1, employee2);
	}
	public Vector<Vector<Object>> getPositionList(){
		DbElectionDayPositions dbElectionDayPositions = new DbElectionDayPositions();
		ArrayList<ElectionDayPosition> positions = dbElectionDayPositions.getPositions();
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		for (ElectionDayPosition position:positions) {
			Vector<Object> result = new Vector<Object>();
			result.add(position.getKey());
			result.add(position.getStartHour());
			result.add(position.getEndHour());
			result.add(position.getRole());
			result.add(position.getBallot());
			result.add(position.getEmployee1());
			result.add(position.getEmployee2());
			results.add(result);
		}
		return results;
	}
}

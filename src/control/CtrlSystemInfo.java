package control;
import java.util.ArrayList;
import java.util.Vector;

import entity.*;

class CtrlSystemInfo {

	private SystemInfo systemInfo;
	public CtrlSystemInfo() {
		DbSystem dbGetSystem = new DbSystem();
		systemInfo = dbGetSystem.getSystem();
	}
	public String getPartyName()
	{
		return new String(systemInfo.getPartyName());
	}
	public int getManagerId()
	{
		return systemInfo.getManagerId();
	}
	public Vector<Vector<Object>> getBranchTable(){
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		DbBranches dbGetBranchList = new DbBranches();
		ArrayList<Branch> branches = dbGetBranchList.getBranches();
		for (Branch branch:branches) {
			Vector<Object> result = new Vector<Object>();
			result.add(branch.getBranchNum());
			result.add(branch.getManagerId());
			result.add(branch.getTransportRepId());
			results.add(result);
		}
		return results;
	}
	public Vector<Vector<Object>> getBallotTable(){
		Vector<Vector<Object>> results = new Vector<Vector<Object>>();
		DbSystem dbGetSystem = new DbSystem();
		ArrayList<Ballot> ballots = dbGetSystem.getBallots();
		for (Ballot ballot:ballots) {
			Vector<Object> result = new Vector<Object>();
			result.add(ballot.getBallotNum());
			result.add(ballot.getBranchNum());
			result.add(ballot.getAddress());
			result.add(ballot.getPositionInBuilding());
			result.add(ballot.getPhone());
			results.add(result);
		}
		return results;
	}
	public void insertBranch(int branchNum, int managerId, int transportMngId) {
		(new DbBranches()).addBranch(branchNum, managerId, transportMngId);
	}
	public void updateBallot(int branchNum, int ballotNum) {
		(new DbSystem()).updateBallot(ballotNum, branchNum);
	}
}

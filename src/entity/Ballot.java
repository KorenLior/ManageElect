package entity;

public class Ballot {
	int ballotNum;
	String address;
	boolean disbledAccess;
	String positionInBuilding;
	String phone;
	int branchNum;
	public Ballot(int ballotNum, String address, boolean disbledAccess, String positionInBuilding, String phone,
			int branchNum) {
		super();
		this.ballotNum = ballotNum;
		this.address = address;
		this.disbledAccess = disbledAccess;
		this.positionInBuilding = positionInBuilding;
		this.phone = phone;
		this.branchNum = branchNum;
	}
	public int getBallotNum() {
		return ballotNum;
	}
	public String getAddress() {
		return address;
	}
	public boolean isDisbledAccess() {
		return disbledAccess;
	}
	public String getPositionInBuilding() {
		return positionInBuilding;
	}
	public String getPhone() {
		return phone;
	}
	public int getBranchNum() {
		return branchNum;
	}
}

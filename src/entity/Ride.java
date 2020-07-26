package entity;

public class Ride {
	private int employeeId;
	private int time;
	public Ride(int employeeId, int time) {
		super();
		this.employeeId = employeeId;
		this.time = time;
	}
	public Ride() {
		employeeId = 0;
		time = 0;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public int getTime() {
		return time;
	}
	
}

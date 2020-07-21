package entity;

public class ElectionDayPosition {
	private int startHour, endHour, key;
    private String  role;
    private int ballot, employeeId1, Employee2;
	public ElectionDayPosition(int key, int startHour, int endHour, String role, int ballot, int employeeId1,
			int employee2) {
		super();
		this.key = key;
		this.startHour = startHour;
		this.endHour = endHour;
		this.role = role;
		this.ballot = ballot;
		this.employeeId1 = employeeId1;
		Employee2 = employee2;
	}
	public int getKey() {
		return key;
	}
	public int getStartHour() {
		return startHour;
	}
	public int getEndHour() {
		return endHour;
	}
	public String getRole() {
		return role;
	}
	public int getBallot() {
		return ballot;
	}
	public int getEmployee1() {
		return employeeId1;
	}
	public int getEmployee2() {
		return Employee2;
	}
}

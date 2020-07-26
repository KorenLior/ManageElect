package control;

import java.util.ArrayList;
import java.util.Vector;

import entity.DbElectionDayPositions;
import entity.DbElectors;
import entity.ElectionDayPosition;
import entity.Elector;

class CtrlElector {
	public Vector<Vector<Object>> getElectorsTable(){
		Vector<Vector<Object>> results  = new Vector<Vector<Object>>();
		DbElectors dbElectors = new DbElectors();
		ArrayList<Elector> electors = dbElectors.getElectors();
		for (Elector elector:electors) {
			Vector<Object> result = new Vector<Object>();
			result.add(elector.getId());
			result.add(elector.getFirstName());
			result.add(elector.getLastName());
			result.add(elector.getAddress());
			result.add(elector.getPhoneNumber());
			result.add(elector.getBallotNum());
			results.add(result);
		}
		return results;
	}
	public int getElectorPhone(int id) {
		Elector res = (new DbElectors()).getElector(id);
		if (res==null)
		{
			return 0;
		}
		int result = res.getPhoneNumber();
		return result;
	}
	
	public String getElectorName(int id) {
		Elector res = (new DbElectors()).getElector(id);
		if (res==null)
		{
			return "";
		}
		String result = res.getLastName() + res.getFirstName();
		return result;
	}
	
	public String getElectorAddress(int id) {
		Elector res = (new DbElectors()).getElector(id);
		if (res==null)
		{
			return "";
		}
		String result = res.getAddress();
		return result;
	}
	
	public String getElectorInfo(int id) {
		Elector res = (new DbElectors()).getElector(id);
		if (res==null)
		{
			return "";
		}
		String result = res.toString();
		return result;
	}
	
	public void updatePhone(int id, int phoneNum) {
		try {
			(new DbElectors()).updatePhone(id, phoneNum); 
		}
		catch (Exception e) {
			System.out.println("Elector phone update failure");
		}
	}
	public void updateRide(int id, int rideId, String rideTime) {
		try {
			(new DbElectors()).updateRide(id, rideId, rideTime);; 
		}
		catch (Exception e) {
			System.out.println("Elector phone update failure");
		}
	}
	
}

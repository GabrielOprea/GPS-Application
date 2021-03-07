package gpsSystem;
import java.util.ArrayList;

/**
 * The street class, that acts like a vertex from the start
 * point to the end point
 * It has a speed limit, a gauge limit and a list of roadblocks
 * @author oprea
 */
public class Street {
	
	private int cost;
	private int gauge;
	Point start;
	Point end;
	private ArrayList<Restriction> roadblocks;
	
	public Street() {
		start = null;
		end = null;
		cost = 0;
		gauge = 0;
	}
	
	/**
	 * 
	 * @param start point of the street
	 * @param end point (destination)
	 * @param cost of driving on this street
	 * @param gauge allowed on this street
	 */
	public Street(Point start, Point end, int cost, int gauge) {
		this.start = start;
		this.end = end;
		this.gauge = gauge;
		this.cost = cost;
		roadblocks = new ArrayList<Restriction>();
	}
	
	public Point getEnd() {
		return end;
	}
	
	public void addRoadblock(Restriction r) {
		roadblocks.add(r);
	}
	
	public int getGauge() {
		return gauge;
	}

	public void setGauge(int gauge) {
		this.gauge = gauge;
	}

	public int getCost() {
		return cost;
	}

	/**
	 * 
	 * @return the total cost of all restrictions on this street
	 */
	public int getRestrictionsCost() {
		int restrictionsCost = 0;
		for(Restriction r : roadblocks) {
			restrictionsCost += r.getCost();
		}
		return restrictionsCost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String toString() {
		String s =  start.toString() + "-->" + end.toString();
		if(!roadblocks.isEmpty()) {
			s += " with " + roadblocks.toString();
		}
		return s;
	}
}
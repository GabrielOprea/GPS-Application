package gpsSystem;

/**
 * Interface that provides functionalities for adding a street or
 * a restriction in memory, and driving between two points 
 * @author oprea
 */

public interface GPS {
	/**
	 * @param start a String representation of the start point of the one-way
	 * street
	 * @param end a String representation of the end point of the one-way
	 * street
	 * @param cost the cost of the street (the speed limit)
	 * @param gauge the maximum gauge of a vehicle allowed on the street
	 */
	void addStreet(String start, String end, int cost, int size);
	
	/**
	 * @param type restriction's type
	 * @param start source point 
	 * @param end destination point
	 * @param cost restriction's cost
	 */
	void addRestriction(String type, String start, String end, int cost);
	
	/**
	 * @param vehicle the vehicle driven
	 * @param start source point
	 * @param end destination point 
	 * @return the shortest path between the two points and the distance driven
	 */
	String drive(Vehicle vehicle, String start, String end);
}
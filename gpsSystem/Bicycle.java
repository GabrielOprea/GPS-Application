package gpsSystem;

/**
 * Bicycle class that extends vehicle, it has static
 * fields for its type, gauge, cost that are used
 * for the constructor of the vehicle
 * @author oprea
 */
public class Bicycle extends Vehicle{
	
	public static final String type = "Moped";
	public static final int gauge = 1;
	public static final int cost = 1;

	Bicycle() {
		super(type, gauge, cost);
	}
}
package gpsSystem;

/**
 * Motorcycle class that extends vehicle, it has static
 * fields for its type, gauge, cost that are used
 * for the constructor of the vehicle
 * @author oprea
 */
public class Motorcycle extends Vehicle {

	public static final String type = "Moped";
	public static final int gauge = 1;
	public static final int cost = 2;

	Motorcycle() {
		super(type, gauge, cost);
	}

}

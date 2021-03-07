package gpsSystem;

/**
 * Truck class that extends vehicle, it has static
 * fields for its type, gauge, cost that are used
 * for the constructor of the vehicle
 * @author oprea
 */
public class Truck extends Vehicle {

	public static final String type = "Van";
	public static final int gauge = 3;
	public static final int cost = 6;

	Truck() {
		super(type, gauge, cost);
	}
}

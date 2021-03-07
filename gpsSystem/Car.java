package gpsSystem;

/**
 * Car class that extends vehicle, it has static
 * fields for its type, gauge, cost that are used
 * for the constructor of the vehicle
 * @author oprea
 */
public class Car extends Vehicle{

	public static final String type = "Motor-Vehicle";
	public static final int gauge = 2;
	public static final int cost = 4;

	Car() {
		super(type, gauge, cost);
	}

}

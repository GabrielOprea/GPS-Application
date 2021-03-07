package gpsSystem;

/**
 * Abstract vehicle class, extended by bicycle, motorcycle, car, truck
 * @author oprea
 */
abstract public class Vehicle {
	private String type;
	private int gauge;
	private int cost;
	
	Vehicle() {
		type = "";
		gauge = 0;
		cost = 0;
	}
	
	/**
	 * 
	 * @param type of vehicle('a'(car), 'b'(bike), 'c'(truck), 'm'(motorcycle)
	 * @param gauge of the vehicle
	 * @param cost of driving the vehicle
	 */
	Vehicle(String type, int gauge, int cost) {
		this.type = type;
		this.gauge = gauge;
		this.cost = cost;
	}

	public int getGauge() {
		return gauge;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return type;
	}
	
}

package gpsSystem;

/**
 * Specific restriction that can appear on one street, like
 * accidents or traffic jams
 * @author oprea
 */
public class Restriction {

	private String type;
	private int cost;
	
	Restriction() {
		type = "";
		cost = 0;
	}

	/**
	 * 
	 * @param type restriction's type
	 * @param cost restriction's cost
	 */
	public Restriction(String type, int cost) {
		this.type = type;
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public int getCost() {
		return cost;
	}
	
	public String toString() {
		return type + " with cost " + cost;
	}	
}

package gpsSystem;

/**
 * The point class, which implements Comparable interface for
 * using the priority queue structure. Each point or node
 * has a name, a cost associated to it. If no cost is provided,
 * it is initialized as 0(source node)
 * @author oprea
 */
public class Point implements Comparable<Point>{

	private String name;
	private int cost;
	
	public int getCost() {
		return cost;
	}

	Point(String name) {
		this.name = name;
		cost = 0;
	}
	
	/**
	 * 
	 * @param name of the point, ex "P12"
	 * @param cost associated with it, useful in Djikstra algorithm
	 */
	Point(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return index associated with the point.
	 * For example if point's name is "P12", return 12
	 */
	public int getIndex() {
		return Integer.parseInt(name.substring(1));
	}
	
	/*Override equals and hashcode for using the points in a 
	hash map */
	@Override
	public boolean equals(Object o) {
		return name.equals(((Point)o).getName());
	}
	
	@Override
	public int hashCode() {
		return getIndex();
	}

	//Override compareTo for using the points in a Priority Queue 
	@Override
	public int compareTo(Point o) {
		return ((Point)o).cost - this.cost;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
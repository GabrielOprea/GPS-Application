package gpsSystem;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * the Map class, that stores a graph of all streets and points,
 * and implements GPS interface for adding streets, restrictions
 * and driving
 * @author oprea
 */
public class Map implements GPS {

	/*store the graph as a hash map between a point(node)
	and all vertices from that point */
	private HashMap<Point, ArrayList<Street>> graph;
	private int edges;
	private int vertices;
	
	/**
	 * 
	 * @return graph representation as a hash map
	 */
	public HashMap<Point, ArrayList<Street>> getGraph() {
		return graph;
	}

	public Map() {
		edges = 0;
		vertices = 0;
		graph = new HashMap<Point, ArrayList<Street>>();
	}

	/**
	 * 
	 * @param vertices number of vertices in the graph
	 * @param edges number of edges in the graph
	 */
	public Map(int vertices, int edges) {
		this.edges = edges;
		this.vertices = vertices;
		graph = new HashMap<Point, ArrayList<Street>>(edges);
		//for each node add an empty list
		for(int i = 0; i < edges; i++) {
			Point p = new Point("P" + i);
			graph.put(p, new ArrayList<Street>());
		}
	}
	
	/**
	 * 
	 * @param start source point
	 * @param end destination point
	 * @param cost new street's cost
	 * @param gauge maximum gauge allowed
	 */
	public void addStreet(String start, String end, int cost, int size) {
		Point pStart = new Point(start);
		Point pEnd = new Point(end);
		ArrayList<Street> crtList = graph.get(pStart);
		crtList.add(new Street(pStart, pEnd, cost, size));
	}

	/**
	 * 
	 * @return edge count
	 */
	public int getEdges() {
		return edges;
	}

	/**
	 * 
	 * @return vertex count
	 */
	public int getVertices() {
		return vertices;
	}

	/**
	 * adds a new restriction of a specific type and cost on a street
	 */
	public void addRestriction(String type, String start, String end, int cost) {
		Point pStart = new Point(start);
		Point pEnd = new Point(end);
		ArrayList<Street> crtList = graph.get(pStart);
		Restriction r = new Restriction(type, cost);

		for(Street s : crtList) {
			if(s.getEnd().equals(pEnd)) {
				s.addRoadblock(r);
			}
		}
	}

	/**
	 * Computes the optimal path between the points 
	 * @param vehicle vehicle driven
	 * @param start source point
	 * @param end destination point
	 */
	public String drive(Vehicle vehicle, String start, String end) {
		int src = Integer.parseInt(start.substring(1));
		int dest = Integer.parseInt(end.substring(1));
		
		Dijkstra dj = new Dijkstra(vehicle, this);
		return dj.findPath(src, dest);
	}

}

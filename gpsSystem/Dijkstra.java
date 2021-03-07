package gpsSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * class for applying the Djikstra algorithm using a Priority Queue
 * @author oprea
 */
public class Dijkstra {

	private int dist[];
	private int parent[];
	private HashSet<Integer> vizited;
	private PriorityQueue<Point> pq;
	private Vehicle v;
	private Map graph;
	private String result = "";
	
	
	public Dijkstra() {
	}

	/**
	 * Initializes the private fields, and allocates
	 * memory for the set, priority queue and auxiliary arrays
	 * @param v vehicle driven
	 * @param graph the graph to apply Djikstra algorithm on
	 */
	public Dijkstra(Vehicle v, Map graph) {
		this.v = v;
		this.graph = graph;
		vizited = new HashSet<Integer>();
		pq = new PriorityQueue<Point>();
		dist = new int[graph.getEdges()];	
		parent = new int[graph.getEdges()];
	}
	
	/**
	 * Method that finds the minimum path between two points,
	 * given as indexes
	 * @param src source node
	 * @param dest destination node
	 * @return string representation of the path and distance
	 */
	public String findPath(int src, int dest) {
		//initialise distance array to -infinity
		for(int i = 0; i < graph.getEdges(); i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		//source node has no parent
		parent[src] = -1;
		
		//add the source node to queue
		pq.enqueue(new Point("P" + src, 0));
		dist[src] = 0;
		
		while(!pq.isEmpty()) {
			Point crt = pq.dequeue();
			int index = crt.getIndex();
			//set the node as visited
			vizited.add(index);
			//evaluate its neighbors
			evalNeighbors(crt);
		}
		
		/*if the distance is -infinity, it means that there is no
		path between the two nodes */
		if(dist[dest] == Integer.MAX_VALUE) {
			return "P" + src + " P" + dest + " null";
		}
		//elsewise we return the path
		printPath(dest);
		result += dist[dest];
		return result;
	}
	
	private void evalNeighbors(Point evalNode) {
		
		int edgeDist = -1;
		int newDist = -1;
		
		HashMap<Point,ArrayList<Street>> hmap = graph.getGraph();
		//the array of all the streets starting from the node
		ArrayList<Street> crtList = hmap.get(evalNode);
		
		System.out.println(crtList);
		//if(crtList == null) return;
		
		//iterate through adjacent nodes 
		for(int i = 0; i < crtList.size(); i++) {
			Street crtStreet = crtList.get(i);
			if(v.getGauge() > crtStreet.getGauge())
				continue; //the vehicle cannot drive here
			//the destination node from this street
			Point destNode = crtStreet.getEnd();
			int dest = destNode.getIndex();
			
			if(!vizited.contains(dest)) {
				//the total cost to drive to this node
				int eval = evalNode.getIndex();
				
				int totalCost = v.getCost() * crtStreet.getCost() + crtStreet.getRestrictionsCost();
				edgeDist = totalCost;
				newDist =  dist[eval] + edgeDist;
				
				//check if the new distance is smaller than the previous
				if(newDist < dist[dest]) {
					//update the distance and parent arrays
					dist[dest] = newDist;
					parent[dest] = eval;
				}
				
				pq.enqueue(new Point(destNode.getName(), dist[dest])); 
			}
		}
	}
	
	//Print parents of destination node
	private void printPath(int dest) {
		if(parent[dest] == -1) { //we reached source
			result += "P" + dest + " ";
			return;
		}
		
		printPath(parent[dest]);
		result += "P" + dest + " ";
	}
	
}

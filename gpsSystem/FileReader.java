package gpsSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main class, reads information about streets and nodes from a file,
 * builds a graph representation of them, and then computes the
 * minimum distance between two points, based on the vehicle driven.
 */
public class FileReader {
	
	public static void main(String[] args) throws FileNotFoundException {

		File input = new File("map.in");
		File output = new File("map.out");
		Scanner reader = new Scanner(input);
		PrintWriter printer = new PrintWriter(output);
		int vertices = reader.nextInt();
		int edges = reader.nextInt();
		GPS graph = new Map(vertices, edges);
		
		//Builds the graph
		for(int i = 0; i < vertices; i++) {
			String start = reader.next();
			String end = reader.next();
			int cost = reader.nextInt();
			int gauge = reader.nextInt();
			graph.addStreet(start, end, cost, gauge);
		}
		
		//Reads from file until EOF
		while(reader.hasNext()) {
			//current command
			String info = reader.next();
			if(info.equals("drive")) {
				Vehicle v;
				String type = reader.next();
				switch(type) {
					case "a":
						v = new Car();
						break;
					case "b":
						v = new Bicycle();
						break;
					case "c":
						v = new Truck();
						break;
					case "m":
						v = new Motorcycle();
						break;
					default:
						v = new Vehicle(){};
				}
				String startPoint = reader.next();
				String endPoint = reader.next();
				//Computes the shortest path and writes it to file
				String path = graph.drive(v, startPoint, endPoint);
				printer.println(path);
			}
			else {
				//Reads info about a roadblock and then adds it in the graph
				String roadblockType = info;
				String startPoint = reader.next();
				String endPoint = reader.next();
				int cost = reader.nextInt();
				graph.addRestriction(roadblockType, startPoint, endPoint, cost);
			}
		}
		reader.close();
		printer.close();
	}
}

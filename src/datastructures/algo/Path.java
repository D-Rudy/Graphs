package datastructures.algo;

import java.util.Map;
import java.util.Stack;

import datastructures.data.DistanceEntry;
import datastructures.data.Graph;

public class Path {

	public static void shortestPath(Graph graph, int source, int destination) {

		Map<Integer, DistanceEntry> distanceTable = DistanceTab.buildDistanceTable(graph, source);

		Stack<Integer> stack = new Stack<>();

		stack.push(destination);

		int previousVertex = distanceTable.get(destination).getLastVertex();

		while (previousVertex != -1 && previousVertex != source) {
			stack.push(previousVertex);
			previousVertex = distanceTable.get(previousVertex).getLastVertex();

		}

		if (previousVertex == -1) {
			System.out.println("Il n'y a pas de chemin depuis le noeud " + source + " vers le noeud " + destination);
		} else {
			System.out.print("\nChemin le plus court: " + source);

			while (!stack.isEmpty()) {
				System.out.print(" -> " + stack.pop());
			}
			System.out.println("\n\nChemin le plus court FAIT");

		}
	}

	public static void shortestPathDijsktra(Graph graph, int source, int destination) {

		Map<Integer, DistanceEntry> distanceTable = DistanceTab.buildDistanceTableDijkrsta(graph, source);

		Stack<Integer> stack = new Stack<>();

		stack.push(destination);

		int previousVertex = distanceTable.get(destination).getLastVertex();

		while (previousVertex != -1 && previousVertex != source) {
			stack.push(previousVertex);
			previousVertex = distanceTable.get(previousVertex).getLastVertex();

		}

		if (previousVertex == -1) {
			System.out.println("Il n'y a pas de chemin depuis le noeud " + source + " vers le noeud " + destination);
		} else {
			System.out.print("\nChemin le plus court: " + source);

			while (!stack.isEmpty()) {
				System.out.print(" -> " + stack.pop());
			}
			System.out.println("\n\nChemin le plus court FAIT");

		}
	}
}

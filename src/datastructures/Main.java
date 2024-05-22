package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructures.algo.Path;
import datastructures.algo.Sort;
import datastructures.algo.Traversal;
import datastructures.data.Graph;
import datastructures.data.Graph.GraphType;
import datastructures.graph.structure.AdjacencyListGraph;
import datastructures.graph.structure.AdjacencyMatrixGraph;
import datastructures.graph.structure.AdjacencySetGraph;

public class Main {

	public static void main(String[] args) {
		Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);

		graph.addEdge(0, 3, 2);
		graph.addEdge(0, 4, 2);
		graph.addEdge(0, 1, 1);

		graph.addEdge(1, 3, 2);

		graph.addEdge(2, 7, 4);
		graph.addEdge(2, 1, 3);

		graph.addEdge(3, 6, 3);

		graph.addEdge(4, 7, 2);
		graph.addEdge(7, 5, 4);

		graph.displayGraph();

		Path.shortestPath(graph, 0, 5);
	}

	public static void shortestPath() {
		Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);

		graph.addEdge(2, 7);
		graph.addEdge(3, 0);
		graph.addEdge(0, 4);
		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(6, 3);

		graph.addEdge(0, 7);

		graph.displayGraph();

		Path.shortestPath(graph, 1, 7);
	}

	public static void courseScheduling() {
		List<String> courses = new ArrayList<>();

		courses.add("CS100");
		courses.add("CS101");
		courses.add("CS102");
		courses.add("CS103");
		courses.add("CS104");
		courses.add("CS105");
		courses.add("CS240");

		Map<String, List<String>> prereqs = new HashMap<>();
		List<String> list = new ArrayList<>();

		list.add("CS101");
		list.add("CS102");
		list.add("CS103");
		prereqs.put("CS101", list);

		list = new ArrayList<String>();
		list.add("CS104");
		prereqs.put("CS101", list);

		list = new ArrayList<String>();
		list.add("CS105");
		prereqs.put("CS103", list);

		list = new ArrayList<String>();
		list.add("CS240");
		prereqs.put("CS102", list);

		List<String> courseSchedule = Sort.order(courses, prereqs);
		System.out.println("Planning valide pour les étudiants: " + courseSchedule);
	}

	public static void topologicalSort() {
		Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.DIRECTED);

		graph.addEdge(2, 7);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(4, 7);

		graph.displayGraph();

		System.out.println("----------------------------------\n");

		System.out.println(Sort.topologicalSort(graph));

		System.out.println("----------------------------------\n");

		graph.addEdge(7, 0);
		System.out.println(Sort.topologicalSort(graph));

		System.out.println("----------------------------------\n");
	}

	public static void graph1() {

		Graph graphNonPondere = new AdjacencyMatrixGraph(8, GraphType.UNDIRECTED);
		System.out.println("GRAPH NON PONDERE");
		graphNonPondere.addEdge(1, 0);
		graphNonPondere.addEdge(1, 2);
		graphNonPondere.addEdge(1, 5);

		graphNonPondere.addEdge(3, 4);

		graphNonPondere.addEdge(2, 7);
		graphNonPondere.addEdge(2, 4);
		graphNonPondere.addEdge(2, 3);

		graphNonPondere.addEdge(5, 6);

		graphNonPondere.addEdge(6, 3);

		System.out.println("AFFICHAGE DU GRAPHE");

		graphNonPondere.displayGraph();

		System.out.println("\n*************************************\n");
		System.out.println("DEGRé D'UN SOMMET: ");

		System.out.println("\nDegré de 1: " + graphNonPondere.getIndegeree(1));
		System.out.println("\nDegré de 3: " + graphNonPondere.getIndegeree(3));
		System.out.println("\nDegré de 5: " + graphNonPondere.getIndegeree(5));

		System.out.println("\n*************************************\n");
		System.out.println("SOMMETS ADJACENTS: \n");

		System.out.println("Sommet adjacent à 1: " + graphNonPondere.getAdjacentVertices(1));
		System.out.println("Sommet adjacent à 2: " + graphNonPondere.getAdjacentVertices(2));
		System.out.println("Sommet adjacent à 5: " + graphNonPondere.getAdjacentVertices(5));
		System.out.println("Sommet adjacent à 7: " + graphNonPondere.getAdjacentVertices(7));

		System.out.println("\n*************************************\n");
		System.out.println("\n*************************************\n");

		Graph graphPondere = new AdjacencyMatrixGraph(8, GraphType.DIRECTED);
		System.out.println("GRAPHE PONDERE");
		graphPondere.addEdge(1, 0, 2);
		graphPondere.addEdge(1, 2, 1);
		graphPondere.addEdge(1, 5, 3);

		graphPondere.addEdge(3, 4);

		graphPondere.addEdge(2, 7);
		graphPondere.addEdge(2, 4);
		graphPondere.addEdge(2, 3, 5);

		graphPondere.addEdge(5, 6, 4);

		// graphPondere.addEdge(4, 6, 2);
		// graphPondere.addEdge(6, 7, 2);
		// graphPondere.addEdge(7, 3, 2);

		System.out.println("AFFICHAGE DU GRAPHE");

		graphPondere.displayGraph();

		System.out.println("\n*************************************\n");
		System.out.println("DEGRé D'UN SOMMET: ");

		System.out.println("\nDegré de 1: " + graphPondere.getIndegeree(1));
		System.out.println("\nDegré de 3: " + graphPondere.getIndegeree(3));
		System.out.println("\nDegré de 5: " + graphPondere.getIndegeree(5));

		System.out.println("\n*************************************\n");
		System.out.println("SOMMETS ADJACENTS: \n");

		System.out.println("Sommet adjacent à 1: " + graphPondere.getAdjacentVertices(1));
		System.out.println("Sommet adjacent à 2: " + graphPondere.getAdjacentVertices(2));
		System.out.println("Sommet adjacent à 5: " + graphPondere.getAdjacentVertices(5));
		System.out.println("Sommet adjacent à 7: " + graphPondere.getAdjacentVertices(7));

		System.out.println("\n*************************************\n");

		Graph adjacentList = new AdjacencyListGraph(8, GraphType.UNDIRECTED);

		System.out.println("LISTE D'ADJACENCE");
		System.out.println("\n*************************************\n");

		adjacentList.addEdge(1, 0, 2);
		adjacentList.addEdge(1, 2, 1);
		adjacentList.addEdge(1, 5, 3);

		adjacentList.addEdge(3, 4);

		adjacentList.addEdge(2, 7);
		adjacentList.addEdge(2, 4);
		adjacentList.addEdge(2, 3, 5);

		adjacentList.addEdge(5, 6, 4);

		adjacentList.addEdge(6, 3, 2);

		adjacentList.displayGraph();

		System.out.println("\n*************************************\n");
		System.out.println("DEGRé D'UN SOMMET: ");

		System.out.println("\nDegré de 1: " + adjacentList.getIndegeree(1));
		System.out.println("\nDegré de 3: " + adjacentList.getIndegeree(3));
		System.out.println("\nDegré de 5: " + adjacentList.getIndegeree(5));

		System.out.println("\n*************************************\n");
		System.out.println("SOMMETS ADJACENTS: \n");

		System.out.println("Sommet adjacent à 1: " + adjacentList.getAdjacentVertices1(1));
		System.out.println("Sommet adjacent à 2: " + adjacentList.getAdjacentVertices1(2));
		System.out.println("Sommet adjacent à 6: " + adjacentList.getAdjacentVertices1(6));
		System.out.println("Sommet adjacent à 7: " + adjacentList.getAdjacentVertices1(7));

		Graph adjacentSetGraph = new AdjacencySetGraph(8, Graph.GraphType.UNDIRECTED);

		adjacentSetGraph.addEdge(1, 0);
		adjacentSetGraph.addEdge(1, 2);
		adjacentSetGraph.addEdge(1, 5);

		adjacentSetGraph.addEdge(3, 4);

		adjacentSetGraph.addEdge(2, 7);
		adjacentSetGraph.addEdge(2, 4);
		adjacentSetGraph.addEdge(2, 3);

		adjacentSetGraph.addEdge(5, 6);

		adjacentSetGraph.addEdge(6, 3);

		adjacentSetGraph.displayGraph();

		boolean[] visited = new boolean[graphPondere.getNumVertices()];
		// Traversal.breadthFirstTraversal(graphPondere, visited, 2);
		// for (int i = 0; i < graphPondere.getNumVertices(); i++) {
		// Traversal.breadthFirstTraversal(graphPondere, visited, i);
		// }

		Traversal.depthFirstTraversal(graphPondere, visited, 1);
	}

}

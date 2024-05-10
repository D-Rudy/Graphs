package datastructures.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.data.Graph;

public class Traversal {

	public static void breadthFirstTraversal(Graph graph, boolean[] visited, int currentVertex) {

		Queue<Integer> queue = new LinkedList<>();

		queue.add(currentVertex);

		while (!queue.isEmpty()) {
			int vertex = queue.remove();

			if (visited[vertex]) {
				continue;
			}

			System.out.print(vertex + " -> ");
			visited[vertex] = true;

			List<Integer> list = graph.getAdjacentVertices(vertex);

			for (int v : list) {
				if (!visited[v]) {
					queue.add(v);
				}
			}
		}
	}

	public static void depthFirstTraversal(Graph graph, boolean[] visited, int currentVertex) {
		if(visited[currentVertex]) {
			return;
		}
		
		visited[currentVertex] = true;
		List<Integer> list = graph.getAdjacentVertices(currentVertex);

		for (int vertex : list) {
			depthFirstTraversal(graph,visited, vertex);
		}
		System.out.print(currentVertex + " -> ");
	}
}
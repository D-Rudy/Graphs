package datastructures.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import datastructures.data.Graph;
import datastructures.graph.structure.AdjacencyMatrixGraph;

public class Sort {

	public static List<Integer> topologicalSort(Graph graph) {

		LinkedList<Integer> queue = new LinkedList<>();

		Map<Integer, Integer> indegreeMap = new HashMap<>();

		for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
			int indegree = graph.getIndegeree(vertex);

			indegreeMap.put(vertex, indegree);

			if (indegree == 0) {
				queue.add(vertex);
			}
		}

		List<Integer> sortedList = new ArrayList<>();

		while (!queue.isEmpty()) {
			// Si plus d'un element existe, cela signifie que le tri à plus d'une solution

			int vertex = queue.remove();

			// Equivalent à une liste de traitement
			sortedList.add(vertex);

			List<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);

			for (int adjacentVertex : adjacentVertices) {
				int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
				indegreeMap.put(adjacentVertex, updatedIndegree);

				if (updatedIndegree == 0) {
					queue.add(adjacentVertex);
				}

			}

		}

		if (sortedList.size() != graph.getNumVertices()) {
			throw new RuntimeException("Le graphe est cyclique");
		}

		return sortedList;
	}

	public static List<String> order(List<String> courseList, Map<String, List<String>> prereqs) {

		Graph courseGraph = new AdjacencyMatrixGraph(courseList.size(), Graph.GraphType.DIRECTED);

		Map<String, Integer> courseIdMap = new HashMap<>();
		Map<Integer, String> idCourseMap = new HashMap<>();

		for (int i = 0; i < courseList.size(); i++) {

			courseIdMap.put(courseList.get(i), i);

			idCourseMap.put(i, courseList.get(i));

		}

		for (Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {
			for (String course : prereq.getValue()) {
				courseGraph.addEdge(courseIdMap.get(prereq.getKey()), courseIdMap.get(course));
			}

		}

		List<Integer> courseIdList = topologicalSort(courseGraph);

		List<String> courseScheduleList = new ArrayList<>();

		for (int courseId : courseIdList) {
			courseScheduleList.add(idCourseMap.get(courseId));
		}

		return courseScheduleList;
	}
}

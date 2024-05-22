package datastructures.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

import datastructures.data.DistanceEntry;
import datastructures.data.Graph;
import datastructures.data.VertexInfo;

public class DistanceTab {

	public static Map<Integer, DistanceEntry> buildDistanceTable(Graph graph, int source) {

		Map<Integer, DistanceEntry> distanceTable = new HashMap<>();

		for (int j = 0; j < graph.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceEntry());
		}

		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);

		while (!queue.isEmpty()) {

			int currentVertex = queue.pollFirst();

			for (int i : graph.getAdjacentVertices(currentVertex)) {

				int currentDistance = distanceTable.get(i).getDistance();

				if (currentDistance == -1) {

					currentDistance = 1 + distanceTable.get(currentVertex).getDistance();

					distanceTable.get(i).setDistance(currentDistance);
					distanceTable.get(i).setLastVertex(currentVertex);

					// On empile le sommet voisin seulement s'ils sont adjacent

					if (!graph.getAdjacentVertices(i).isEmpty()) {
						queue.add(i);
					}
				}
			}
		}
		return distanceTable;
	}

	public static Map<Integer, DistanceEntry> buildDistanceTableDijkrsta(Graph graph, int source) {

		Map<Integer, DistanceEntry> distanceTable = new HashMap<>();

		PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {

			@Override
			public int compare(VertexInfo v1, VertexInfo v2) {
				return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
			}
		});

		for (int j = 0; j < graph.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceEntry());
		}

		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
		queue.add(sourceVertexInfo);

		Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
		vertexInfoMap.put(source, sourceVertexInfo);

		while (!queue.isEmpty()) {

			VertexInfo vertexInfo = queue.poll();

			int currentVertex = vertexInfo.getVertexId();

			for (Integer neighbor : graph.getAdjacentVertices(currentVertex)) {

				// recupere la valeur du poids de l'arete
				int distance = distanceTable.get(currentVertex).getDistance()
						+ graph.getWeightedEdge(currentVertex, neighbor);

				// Si on trouve un chemin plus court, on met la distance à jour
				if (distanceTable.get(neighbor).getDistance() > distance) {

					distanceTable.get(neighbor).setDistance(distance);
					distanceTable.get(neighbor).setLastVertex(currentVertex);

					// On supprime l'ancien noeuds de la file prioritaire

					VertexInfo neighborVertexInfo = vertexInfoMap.get(neighbor);

					if (neighborVertexInfo != null) {
						queue.remove(neighborVertexInfo);
					}

					// Ajout du nouveau voisin avec une distance mise a jour
					neighborVertexInfo = new VertexInfo(neighbor, distance);

					queue.add(neighborVertexInfo);
					vertexInfoMap.put(neighbor, neighborVertexInfo);
				}
			}
		}
		return distanceTable;
	}

}

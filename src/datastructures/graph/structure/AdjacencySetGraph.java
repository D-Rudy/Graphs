package datastructures.graph.structure;

import java.util.ArrayList;
import java.util.List;

import datastructures.data.Graph;
import datastructures.data.Vertex;
import datastructures.data.VertexSet;

public class AdjacencySetGraph implements Graph {

	private List<VertexSet> vertexList = new ArrayList<>();

	private int numVertices = 0;

	private GraphType graphType = GraphType.DIRECTED;

	public AdjacencySetGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;

		for (int i = 0; i < numVertices; i++) {
			vertexList.add(new VertexSet(i));
		}
		this.graphType = graphType;
	}

	@Override
	public void addEdge(int v1, int v2) {

		if (v1 >= numVertices || v2 >= numVertices || v1 < 0 || v2 < 0) {
			throw new IllegalArgumentException("Nombre de sommet non valide..." + v1 + ", " + v2);
		}

		vertexList.get(v1).addEdge(v2);

		if (graphType == GraphType.UNDIRECTED) {
			vertexList.get(v2).addEdge(v1);
		}

	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if (v >= numVertices || v < 0) {
			throw new IllegalArgumentException("Numéro du sommet n'est pas valide" + v);
		}

		return vertexList.get(v).getAdjacentVertices();
	}

	@Override
	public int getNumVertices() {
		return numVertices;
	}

	@Override
	public int getIndegeree(int v) {

		int indegree = 0;

		for (VertexSet vertex : vertexList) {

			if (vertex.getAdjacentVertices().contains(v)) {
				indegree++;
			}

		}
		return indegree;
	}

	@Override
	public void displayGraph() {
		System.out.println("Liste d'adjacence: \n");

		for (VertexSet vertex : vertexList) {

			List<Integer> adjacentVertices = vertex.getAdjacentVertices();

			System.out.println("Aretes de " + vertex.getVertexNumber() + " à " + adjacentVertices);
		}
	}

	@Override
	public void addEdge(int v1, int v2, int weight) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vertex> getAdjacentVertices1(int v) {
		// TODO Auto-generated method stub
		return null;
	}

}

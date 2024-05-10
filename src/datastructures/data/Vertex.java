package datastructures.data;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int vertexNumber;
	private int weight;

	private List<Vertex> adjacencyList = new ArrayList<>();

	public Vertex(int vertexNumber, int weight) {
		this.vertexNumber = vertexNumber;
		this.weight = weight;
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public int getWeight() {
		return weight;
	}

	public void addEdge(int vertexNumber, int weight) {
		adjacencyList.add(new Vertex(vertexNumber, weight));
	}

	public List<Vertex> getAdjacentVertices() {
		return adjacencyList;
	}

	public String toString() {
		return "Sommet: "+ vertexNumber + " Poids: " + weight;
	}
}

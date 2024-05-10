package datastructures.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VertexSet {
	private int vertexNumber;

	private Set<Integer> adjacencySet = new HashSet<>();

	public VertexSet(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public void addEdge(int vertexNumber) {
		adjacencySet.add(vertexNumber);
	}

	public List<Integer> getAdjacentVertices() {
		return new ArrayList<>(adjacencySet);
	}

}

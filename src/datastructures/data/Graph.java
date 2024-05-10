package datastructures.data;

import java.util.List;

public interface Graph {

	enum GraphType {
		DIRECTED, UNDIRECTED
	}

	void addEdge(int v1, int v2);

	// Pour un graphe non orienté, on considère que le poids dans chaque sens sera
	// identique
	void addEdge(int v1, int v2, int weight);

	List<Integer> getAdjacentVertices(int v);

	List<Vertex> getAdjacentVertices1(int v);
	int getNumVertices();

	int getIndegeree(int v);

	void displayGraph();
}

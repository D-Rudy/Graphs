package datastructures.data;

public class VertexInfo {

	private int vertexId;
	private int distance;

	public VertexInfo(int vertexId, int distance) {
		this.vertexId = vertexId;
		this.distance = distance;

	}

	public int getVertexId() {
		return vertexId;
	}

	public void setVertexId(int vertexId) {
		this.vertexId = vertexId;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String toString() {
		return "Sommet: " + vertexId + " - Poids de l'arete: " + distance;
	}

}

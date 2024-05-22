package datastructures.data;

public class DistanceEntry {

	private int distance;
	private int lastVertex;

	// -1 signifie qu'il n'y a pas encore de distance
	public DistanceEntry() {
		distance = Integer.MAX_VALUE;
		lastVertex = -1;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getLastVertex() {
		return lastVertex;
	}

	public void setLastVertex(int lastVertex) {
		this.lastVertex = lastVertex;
	}

}

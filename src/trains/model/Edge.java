package trains.model;

public class Edge {

	private Node start;
	private Node end;
	private Integer weight;
	
	public Edge(Node start, Node end, Integer weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}

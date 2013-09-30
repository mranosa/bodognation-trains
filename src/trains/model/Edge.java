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
	
	public Edge(Node start, Node end) {
		this.start = start;
		this.end = end;
	}

	public Edge(String edgeToken) {
		String startToken = String.valueOf(edgeToken.charAt(0));
		String endToken = String.valueOf(edgeToken.charAt(1));
		Integer weight = Integer.parseInt(edgeToken.substring(2, edgeToken.length()));
		
		this.start = new Node(startToken);
		this.end = new Node(endToken);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [start=" + start + ", end=" + end + ", weight=" + weight
				+ "]";
	}

}

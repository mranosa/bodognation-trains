package trains.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import trains.TrainGraph;
import trains.exception.TrainGraphException;
import trains.model.Edge;
import trains.model.Node;

public class TrainGraphImpl implements TrainGraph {

	private Map<Node, Set<Edge>> graph;
	
	public TrainGraphImpl(String edges){
		graph = new HashMap<Node, Set<Edge>>();
		StringTokenizer tokenizer = new StringTokenizer(edges.replaceAll(" ", ""), ",");
		
		//consume input like "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
		while (tokenizer.hasMoreTokens()) {
			String edgeToken = tokenizer.nextToken();
			Edge edge = new Edge(edgeToken); // consume like "AB5"
			Node node = edge.getStart();
			
			if(!graph.containsKey(node)){
				graph.put(node, new HashSet<Edge>());
			}
			
			graph.get(node).add(edge);
		}
	}
	
	public TrainGraphImpl(Map<Node, Set<Edge>> graph) {
		this.graph = graph; 
	}

	@Override
	public Integer getDistance(List<Node> path) throws TrainGraphException {
		if(path.isEmpty()) throw new TrainGraphException("NO SUCH ROUTE");
		
		Integer distance = 0;
		
		for (int i = 0; i < path.size(); i++) {
			if(!(i == path.size() - 1)){
				Node start = path.get(i);
				Node end = path.get(i + 1);
				Set<Edge> edges = graph.get(start);
				Boolean edgeExists = false;
				
				// look for edge weight given the node key
				for(Edge edge : edges){
					if(edge.getStart().equals(start) && edge.getEnd().equals(end)){
						distance += edge.getWeight();
						edgeExists = true;
					}
				}
				
				// no edge for start and end was found
				if(!edgeExists) throw new TrainGraphException("NO SUCH ROUTE");
			}
		}
		
		if(distance == 0) throw new TrainGraphException("NO SUCH ROUTE");
		
		return distance;
	}

	public Map<Node, Set<Edge>> getGraph() {
		return graph;
	}

	public void setGraph(Map<Node, Set<Edge>> graph) {
		this.graph = graph;
	}

}

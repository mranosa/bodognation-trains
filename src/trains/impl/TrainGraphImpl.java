package trains.impl;

import java.util.List;

import trains.TrainGraph;
import trains.exception.TrainGraphException;
import trains.model.Edge;

public class TrainGraphImpl implements TrainGraph {

	public TrainGraphImpl(List<Edge> edgeList) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getDistance(Edge edge) throws TrainGraphException {
		if(edge.getWeight() == -1) {
			throw new TrainGraphException("NO SUCH ROUTE");
		} 
		
		return null;
	}

}

package trains;

import java.util.List;

import trains.exception.TrainGraphException;
import trains.model.Node;

public interface TrainGraph {

	Integer getDistance(List<Node> path) throws TrainGraphException;

}

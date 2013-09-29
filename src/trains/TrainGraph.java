package trains;

import trains.exception.TrainGraphException;
import trains.model.Edge;

public interface TrainGraph {

	Integer getDistance(Edge edge) throws TrainGraphException;

}

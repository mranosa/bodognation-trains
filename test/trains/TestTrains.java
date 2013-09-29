package trains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import trains.impl.TrainGraphImpl;
import trains.model.Edge;
import trains.model.Node;

/**
 * Tests for {@link Foo}.
 * 
 * @author user@example.com (John Doe)
 */
@RunWith(JUnit4.class)
public class TestTrains {

	TrainGraph graph;
	
	// input nodes
	Node A = new Node("A");
	Node B = new Node("B");
	Node C = new Node("C");
	Node D = new Node("D");
	Node E = new Node("E");
	
	@Before
	public void init(){
		//TODO generate edges
		
		List<Edge> edgeList = new ArrayList<Edge>();
		graph = new TrainGraphImpl(edgeList);
	}
	
	@Test
    public void sendTrainExceptionIfNoEdgeExists() {
		Edge nonExistingEdge = new Edge(E, D, -1);
		
		graph.getDistance(nonExistingEdge);
		fail("test must fail");
				
    }
}

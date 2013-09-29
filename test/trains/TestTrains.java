package trains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import trains.exception.TrainGraphException;
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
		List<Node> path = new ArrayList<Node>();
		path.add(E);
		path.add(D);
		
		try {
			graph.getDistance(path);
			fail("test must fail");
		} catch (Exception e) {
			assertEquals("NO SUCH ROUTE", e.getMessage());
		}
    }
	
	@Test
    public void distance_ABC() throws TrainGraphException {
		List<Node> path = new ArrayList<Node>();
		path.add(A);
		path.add(B);
		path.add(C);
		
		assertEquals(new Integer(9), graph.getDistance(path));
    }
}

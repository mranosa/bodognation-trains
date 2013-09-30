package trains;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		//TODO generate graph
		
		//TODO add implementation in later in TrainGraphImpl
		//TODO valid input should only be "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
		Map<Node, Set<Edge>> graphInfo = new HashMap<Node, Set<Edge>>();
		graph = new TrainGraphImpl(graphInfo);
	}
	
	@Test
    public void expectionIfNoPathAdded() {	
		List<Node> path = new ArrayList<Node>();
		
		try {
			graph.getDistance(path);
			fail("test must fail");
		} catch (Exception e) {
			assertEquals("NO SUCH ROUTE", e.getMessage());
		}
    }
	
	@Test
    public void expectionIfNoPathDestination() {	
		List<Node> path = new ArrayList<Node>();
		path.add(A);
		
		try {
			graph.getDistance(path);
			fail("test must fail");
		} catch (Exception e) {
			assertEquals("NO SUCH ROUTE", e.getMessage());
		}
    }
	
	@Test
    public void exceptionIfNoPathExists() {	
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

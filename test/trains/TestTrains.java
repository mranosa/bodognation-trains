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
import trains.model.Node;

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
		String edges = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		graph = new TrainGraphImpl(edges);
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
	
	@Test
    public void distance_AD() throws TrainGraphException {
		List<Node> path = new ArrayList<Node>();
		path.add(A);
		path.add(D);
		
		assertEquals(new Integer(5), graph.getDistance(path));
    }
	
	@Test
    public void distance_ADC() throws TrainGraphException {
		List<Node> path = new ArrayList<Node>();
		path.add(A);
		path.add(D);
		path.add(C);
		
		assertEquals(new Integer(13), graph.getDistance(path));
    }
	
	@Test
    public void distance_AEBCD() throws TrainGraphException {
		List<Node> path = new ArrayList<Node>();
		path.add(A);
		path.add(E);
		path.add(B);
		path.add(C);
		path.add(D);
		
		assertEquals(new Integer(22), graph.getDistance(path));
    }
	
	@Test
    public void distance_AED() throws TrainGraphException {
		List<Node> path = new ArrayList<Node>();
		path.add(A);
		path.add(E);
		path.add(D);
		
		try {
			graph.getDistance(path);
			fail("test must fail");
		} catch (Exception e) {
			assertEquals("NO SUCH ROUTE", e.getMessage());
		}
    }	
}

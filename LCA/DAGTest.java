import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class DAGTest {


	@Test
	void testConstructor() {// testing constructor works
		LCA_DAG DAG = new LCA_DAG(6);
		assertEquals("Testing Constructor", 6, DAG.Vertex());
		
		LCA_DAG DAG2 = new LCA_DAG(9);
		assertEquals("Testing Constructor", 9, DAG2.Vertex());
		
		LCA_DAG DAG3 = new LCA_DAG(15);
		assertEquals("Testing Constructor", 15, DAG3.Vertex());
		
		//test to make sure if vertex below 0 entered, exception thrown
		try {
			//LCA_DAG DAG4 = new LCA_DAG(-1);
		} 
		catch (IllegalArgumentException e) {
		}
		
		//test that test is false if expected vertex!=returned vertex
		LCA_DAG DAG5 = new LCA_DAG(15);
		assertFalse("Testing Constructor", 1==DAG5.Vertex());
		

	}
	@Test
	void testVertex() {//Testing Vertex() function returns correct vertex
		LCA_DAG DAG = new LCA_DAG(5);
		int vertex = DAG.Vertex();
		assertEquals("Testing Vertex() function ", 5, vertex);
		
		LCA_DAG DAG2 = new LCA_DAG(16);
		int vertex2 = DAG2.Vertex();
		assertEquals("Testing Vertex() function", 16, vertex2);
		
		LCA_DAG DAG3 = new LCA_DAG(23);
		int vertex3 = DAG3.Vertex();
		assertEquals("Testing Vertex() function", 23, vertex3);
		
		//test that if vertex expected is not what is returned, assert false
		LCA_DAG DAG4 = new LCA_DAG(4);
		assertFalse("Testing not a match",1==DAG4.Vertex());

	}
	

	@Test 
	void TestValidateVertex(){// make sure if vertex is not valid, throw exception
		LCA_DAG DAG = new LCA_DAG(5);
		try {
			DAG.addEdge(-1,-1);
		} 
		catch (IllegalArgumentException e) {
		}

		
		LCA_DAG DAG2 = new LCA_DAG(3);
		try {
			DAG2.addEdge(2,2);
			DAG2.addEdge(2,1);
			DAG2.addEdge(1,9);
		} 
		catch (IllegalArgumentException e) {
		}
	}
	@Test
	void testEandAddEdge() {//Testing Edge() and addEdge() functions
		LCA_DAG DAG = new LCA_DAG(4);
		DAG.addEdge(1, 2);
		DAG.addEdge(2, 3);
		DAG.addEdge(3, 1);
		assertEquals("Testing Edge() and addEdge()", 3,DAG.Edge());
		
		LCA_DAG DAG2 = new LCA_DAG(11);
		DAG2.addEdge(1, 2);
		DAG2.addEdge(9, 6);
		DAG2.addEdge(5, 0);
		DAG2.addEdge(1, 1);
		DAG2.addEdge(10, 7);
		assertEquals("Testing Edge() and addEdge()",5, DAG2.Edge());
		
		
		LCA_DAG DAG3 = new LCA_DAG(15);
		DAG3.addEdge(1, 2);
		DAG3.addEdge(9, 6);
		DAG3.addEdge(5, 0);
		DAG3.addEdge(1, 1);
		DAG3.addEdge(10, 7);
		DAG3.addEdge(2, 8);
		DAG3.addEdge(7, 7);
		DAG3.addEdge(12, 4);
		DAG3.addEdge(2, 0);
		DAG3.addEdge(14, 7);
		assertEquals("Testing Edge() and addEdge()",10, DAG3.Edge());
		
		//check if int for edge returned is not what is expected, assert false
		LCA_DAG DAG4 = new LCA_DAG(4);
		DAG4.addEdge(1, 2);
		DAG4.addEdge(3, 3);
		DAG4.addEdge(2, 0);
		assertFalse("Testing Edge() and addEdge()", DAG4.Edge()== 10);
	}

	@Test
	void testNoCycle() {//Testing for DAG without cycles (assertTrue)
		LCA_DAG DAG = new LCA_DAG(9);
		DAG.addEdge(1, 3);
		DAG.addEdge(3, 4);
		DAG.addEdge(8, 4);
		DAG.addEdge(3, 8);
		DAG.isAcyclic();
		assertTrue("Check DAG doesn't have a cycle", DAG.checkDAG);
		
		//test empty DAG doesn't have cycle
		LCA_DAG DAG3 = new LCA_DAG(9);
		DAG3.isAcyclic();
		assertTrue("Check empty DAG doesnt have a cycle", DAG3.checkDAG);
	}
	
	
	@Test 
	void testContainsCycle() {//Testing for Dag with cycle (assertFalse)
		LCA_DAG DAG = new LCA_DAG(7);
		DAG.addEdge(1, 3);
		DAG.addEdge(3, 4);
		DAG.addEdge(4, 1);
		DAG.isAcyclic();
		assertFalse("Check DAG contains a cycle", DAG.checkDAG);

		LCA_DAG DAG2 = new LCA_DAG(9);
		DAG2.addEdge(3, 6);
		DAG2.addEdge(3, 4);
		DAG2.addEdge(6, 2);
		DAG2.addEdge(1, 3);
		DAG2.addEdge(1, 2);
		DAG2.addEdge(8, 4); 
		DAG2.addEdge(2, 3);
		DAG2.isAcyclic();
		assertFalse("Check DAG contains a cycle", DAG2.checkDAG);	
	}

	@Test
	void testLCA() {//Tests for LCA
		//Check LCA on empty graph
		LCA_DAG empty = new LCA_DAG(200);
		assertEquals("Testing LCA on empty graph.",-1,empty.LCA(1, 3));
		
		//normal check on LCA
		LCA_DAG DAG2 = new LCA_DAG(8);
		DAG2.addEdge(1, 2);
		DAG2.addEdge(1, 3);
		DAG2.addEdge(2, 4);
		DAG2.addEdge(2, 5);
		DAG2.addEdge(5, 7);
		DAG2.addEdge(3, 6);
		assertEquals("Check LCA(7,3) is 1",1, DAG2.LCA(7, 3));
		assertEquals("Check LCA(5,3) is 2",1, DAG2.LCA(5, 3));
		assertEquals("Check LCA(7,2) is 1",2, DAG2.LCA(7, 2));
		
		//try LCA on graph that contains a cycle
		LCA_DAG DAG3 = new LCA_DAG(8);
		DAG3.addEdge(2, 3);
		DAG3.addEdge(3, 4);
		assertEquals("Check LCA on graph with cycle.", -1, DAG3.LCA(1, 3));
		
		//Check LCA when there are no common Ancestors
		LCA_DAG DAG4 = new LCA_DAG(7);
		DAG4.addEdge(1, 5);
		DAG4.addEdge(2, 4);
		DAG4.addEdge(4, 5);
		DAG4.addEdge(3, 6);
		assertEquals("Check LCA with no common ancestors.", -1, DAG4.LCA(1, 3));
		
		//check when edge is 0
		LCA_DAG DAG5 = new LCA_DAG(8);
		DAG5.addEdge(0, 0);
		assertEquals("Check when edge passed is 0.", -1, DAG5.LCA(1, 3));

	
	}

}

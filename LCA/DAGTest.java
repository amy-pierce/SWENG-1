import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class DAGTest {


	@Test
	void testConstructor() {
		LCA_DAG DAG = new LCA_DAG(6);
		assertEquals("Testing Constructor", 6, DAG.V());
		
		LCA_DAG DAG2 = new LCA_DAG(9);
		assertEquals("Testing Constructor", 9, DAG2.V());
		
		LCA_DAG DAG3 = new LCA_DAG(15);
		assertEquals("Testing Constructor", 15, DAG3.V());

	}
	@Test
	void testVertex() {
		LCA_DAG DAG = new LCA_DAG(5);
		int vertex = DAG.V();
		assertEquals("Testing V()", 5, vertex);
		
		LCA_DAG DAG2 = new LCA_DAG(16);
		int vertex2 = DAG2.V();
		assertEquals("Testing V()", 16, vertex2);
		
		LCA_DAG DAG3 = new LCA_DAG(23);
		int vertex3 = DAG3.V();
		assertEquals("Testing V()", 23, vertex3);
	}

	
	@Test
	void testEandAddEdge() {
		LCA_DAG DAG = new LCA_DAG(4);
		DAG.addEdge(1, 2);
		DAG.addEdge(2, 3);
		DAG.addEdge(3, 1);
		int edge = DAG.E();
		assertEquals("Testing E() and addEdge()", edge, 3);
		
		LCA_DAG DAG2 = new LCA_DAG(11);
		DAG2.addEdge(1, 2);
		DAG2.addEdge(9, 6);
		DAG2.addEdge(5, 0);
		DAG2.addEdge(1, 1);
		DAG2.addEdge(10, 7);
		int edge2 = DAG2.E();
		assertEquals("Testing E() and addEdge()", edge2, 5);
		
		
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
		int edge3 = DAG3.E();
		assertEquals("Testing E() and addEdge()", edge3, 10);
	}

	@Test
	void testAcyclic() {

	}

	@Test
	void testLCA() {
	
	}

}

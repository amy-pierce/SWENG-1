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
	void testEandAddEdge() {
	}

	@Test
	void testAcyclic() {

	}

	@Test
	void testLCA() {
	
	}

}

import static org.junit.Assert.*;


import org.junit.Test;

public class LowestCommonAncestorTest {


	
	@Test
	public void testCreateHead(){
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('a',8);
		assertEquals("Create a head", 'a', lca.returnKey(lca.head));
	}
	
	@Test
	public void testAddNode(){
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('d',0);
		lca.addNode('a',1);
		assertEquals("Add node a", 'a', lca.returnKey(lca.head.left));

	}
	
	@Test
	public void testFindNode(){
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('d',0);
		assertEquals("Find head Node", 'd', lca.returnKey(lca.findNode('d')));
		lca.addNode('a',1);
		assertEquals("Find left Node", 'a', lca.returnKey(lca.findNode('a')));
	}
	
	@Test
	public void testDepth(){
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('d',0);
		assertEquals("Depth of head", 0, lca.depth('d'));
		lca.addNode('a',1);
		assertEquals("Depth of a", 1, lca.depth('a'));
	
	}

	
	@Test
	public void testFull(){
		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.createHead('a',0);		
		assertEquals("Should return head", lca.findNode('f'), lca.lowestCommonAncestor(lca.findNode('f'), lca.findNode('f'), null));
		lca.addNode('g',1);
		lca.addNode('l',2);
		assertEquals("Should return head", lca.findNode('f'), lca.lowestCommonAncestor(lca.findNode('l'), lca.findNode('c'), lca.findNode('k')));
	}
	

}
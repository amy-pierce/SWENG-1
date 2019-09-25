import static org.junit.Assert.*;


import org.junit.Test;

public class LowestCommonAncestorTest {


	@Test 
	public void testemptyTree() {
		tree = new LowestCommonAncestor();
		assertEquals("", LowestCommonAncestor.computeLCA(8, 8, tree), -1);
	}

	@Test 
	public void testOneNodeTree() {
		tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		assertEquals("", LowestCommonAncestor.computeLCA(1, 2, tree), -1);
	}
	
	@Test 
	public void testTwoNodeTree() {
		tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		LowestCommonAncestor.print2D(tree.root);

		assertEquals("", LowestCommonAncestor.computeLCA(1, 2, tree), 1);
	}

	
	
	@Test
	public void testDepth() {
		//assumes that an empty tree has a depth of 0
		//assumes that a tree with only a root has depth of 1
		//assumes that a tree with a root and or left and right nodes has depth of 2
		// etc
		tree = new LowestCommonAncestor();
		tree.root = new Node(12);
		assertEquals("", LowestCommonAncestor.Depth(tree), 1);
		
		
		tree = new LowestCommonAncestor();
		assertEquals("", LowestCommonAncestor.Depth(tree), 0);
		
		
		tree = new LowestCommonAncestor();
		tree.root=new Node(1);
		
		tree.root.left = new Node(2);  
		tree.root.right = new Node(3);  

		tree.root.left.left = new Node(9);  
		tree.root.left.right = new Node(5);  
		tree.root.right.left = new Node(6);  
		tree.root.right.right = new Node(7);  

		tree.root.left.left.left = new Node(8);  
		tree.root.left.left.right = new Node(4);  
		tree.root.left.right.left = new Node(10);  
		assertEquals("", LowestCommonAncestor.Depth(tree), 4);
	}

	@Test
	public void testPass() 
	{
		tree = new LowestCommonAncestor();
		tree.root=new Node(1);
		tree.root.left = new Node(2);  
		tree.root.right = new Node(3);  

		tree.root.left.left = new Node(9);  
		tree.root.left.right = new Node(5);  
		tree.root.right.left = new Node(6);  
		tree.root.right.right = new Node(7);  

		tree.root.left.left.left = new Node(8);  
		tree.root.left.left.right = new Node(4);  
		tree.root.left.right.left = new Node(10);  

		//LowestCommonAncestor.print2D(tree.root);
		assertEquals("testing LCA of 3,2", LowestCommonAncestor.computeLCA(3,2,tree), 1);
		assertEquals("testing LCA of 8,4", LowestCommonAncestor.computeLCA(8,4,tree), 9);

		assertEquals("testing LCA of 6,7", LowestCommonAncestor.computeLCA(6,7,tree), 3);
	}
	
	@Test
	public void testCreateHead(){
	}
	
	@Test
	public void testAddNode(){
	}
	
	@Test
	public void testFindNode(){
	}
	
	
	

}

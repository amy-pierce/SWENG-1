import static org.junit.Assert.*;
import org.junit.Test;

public class LowestCommonAncestorTest 
{
	public static LowestCommonAncestor tree;

	@Test
	public void testPass() {//Check for LCA being passed nodes with valid LCA
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

		assertEquals("testing LCA of 3,2", LowestCommonAncestor.computeLCA(3,2,tree), 1);
		assertEquals("testing LCA of 8,4", LowestCommonAncestor.computeLCA(8,4,tree), 9);
		assertEquals("testing LCA of 6,7", LowestCommonAncestor.computeLCA(6,7,tree), 3);
	}

	@Test
	public void testFail() {//Test for LCA being passed nodes with no LCA
		tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		assertEquals("", LowestCommonAncestor.computeLCA(8, 8, tree), -1);
		assertEquals("", LowestCommonAncestor.computeLCA(1, 8, tree), -1);
		assertEquals("", LowestCommonAncestor.computeLCA(8, 2, tree), -1);
	}

	@Test
	public void testOneAncestor() {//Testing  tree with only one ancestor
		tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		assertEquals("", LowestCommonAncestor.computeLCA(2, 3, tree), 1);	
	}
	@Test 
	public void testemptyTree() {// Testing empty tree is invalid , has no LCA
		tree = new LowestCommonAncestor();
		assertEquals("", LowestCommonAncestor.computeLCA(8, 8, tree), -1);
	}

	@Test 
	public void testOneNodeTree() {// Testing tree with one node is invalid , has no LCA
		tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		assertEquals("", LowestCommonAncestor.computeLCA(1, 2, tree), -1);
	}
	@Test 
	public void testTwoNodeTree() {//Testing tree with two nodes returns valid LCA
		tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		LowestCommonAncestor.print2D(tree.root);
		assertEquals("", LowestCommonAncestor.computeLCA(1, 2, tree), 1);
	}

	@Test
	public void testMakeRoot() {//Test root is made correctly
		tree = new LowestCommonAncestor();
		tree.root = new Node(12);
		assertEquals("", tree.root.val, 12);
	}
	
}

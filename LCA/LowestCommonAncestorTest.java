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
		
		assertEquals("testing LCA of (3,2)",1, LowestCommonAncestor.computeLCA(3,2,tree));

		tree.root.left.left = new Node(9);  
		tree.root.left.right = new Node(5);  
		tree.root.right.left = new Node(6);  
		tree.root.right.right = new Node(7);  
		assertEquals("testing LCA of 9,6",1, LowestCommonAncestor.computeLCA(9,6,tree));


		tree.root.left.left.left = new Node(8);  
		tree.root.left.left.right = new Node(4);  
		tree.root.left.right.left = new Node(10);  

		assertEquals("testing LCA of 10,2",2, LowestCommonAncestor.computeLCA(10,2,tree));
		assertEquals("testing LCA of 8,4",9, LowestCommonAncestor.computeLCA(8,4,tree));
		assertEquals("testing LCA of 6,7", 3,LowestCommonAncestor.computeLCA(6,7,tree));
	}

	@Test
	public void testFail() {//Test for LCA being passed nodes with no LCA
		tree = new LowestCommonAncestor();
		tree.root = new Node(11);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.right.left = new Node(6);

		assertEquals("Testing LCA returns -1 for both nodes not in tree", -1,LowestCommonAncestor.computeLCA(8, 9, tree));
		assertEquals("Testing LCA returns -1 for first node not in tree", -1,LowestCommonAncestor.computeLCA(7, 11, tree));
		assertEquals("Testing LCA returns -1 for second node not in tree ", -1,LowestCommonAncestor.computeLCA(2, 8, tree));
	}

	@Test
	public void testOneAncestor() {//Testing  tree with only one ancestor
		tree = new LowestCommonAncestor();
		tree.root = new Node(9);
		tree.root.left = new Node(12);
		tree.root.right = new Node(6);
		assertEquals("Testing LCA of tree with one ancestor ",9, LowestCommonAncestor.computeLCA(12, 6, tree));	

		
	}
	@Test 
	public void testemptyTree() {// Testing empty tree is invalid , has no LCA
		tree = new LowestCommonAncestor();
		assertEquals("Testing LCA returns -1 for empty tree",-1, LowestCommonAncestor.computeLCA(8, 8, tree));
	}

	@Test 
	public void testOneNodeTree() {// Testing tree with one node is invalid , has no LCA
		tree = new LowestCommonAncestor();
		tree.root = new Node(1);
		assertEquals("Thesting LCA returns -1 for tree with one node",-1, LowestCommonAncestor.computeLCA(1, 2, tree));
	}
	@Test 
	public void testTwoNodeTree() {//Testing tree with two nodes returns valid LCA
		tree = new LowestCommonAncestor();
		tree.root = new Node(88);
		tree.root.left = new Node(6);
		assertEquals("Testing LCA returns correct for two node tree", 88,LowestCommonAncestor.computeLCA(88, 6, tree));
	}
	
	@Test 
	public void testLCAForSameNode() {//Testing when checking LCA of same node
		tree = new LowestCommonAncestor();
		tree.root = new Node(88);
		tree.root.left = new Node(6);
		tree.root.right = new Node(29);
		assertEquals("Testing LCA returns correct for two node tree", 88,LowestCommonAncestor.computeLCA(88, 88, tree));
		assertEquals("Testing LCA returns correct for two node tree", 29,LowestCommonAncestor.computeLCA(29, 29, tree));

	}

	@Test
	public void testMakeRoot() {//Test root is made correctly
		tree = new LowestCommonAncestor();
		tree.root = new Node(12);
		assertEquals("", 12,tree.root.val);
	}
	
}

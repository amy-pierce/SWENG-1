
public class LowestCommonAncestor {
	
	public class Node{  
		  int val;
   		 Node left, right;
 
   		 Node(int value) {
      			  val = value;
      			  left = right = null;
  		  }
	}
	
	static int Depth (LowestCommonAncestor x) {
		if(x.root==null) {
			return 0;
		}
		if(x.root.left==null&&x.root.right==null) {
			return 1;
		}
		return 2;
   	}
	
	public void addNode(char key, int value){

	}
	
	public Node findNode(char key){
	
	}
	
	public Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {		
            		return -1;
     		}
		
      		for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            		if (!path1.get(i).equals(path2.get(i)))
                		break;
        	}
 
        	return path1.get(i-1);
	 
	}
	
	
	public static void main(String args[]) {  
		Node root = new Node(1);  
		root.left = new Node(2);  
		root.right = new Node(3);  

		root.left.left = new Node(4);  
		root.left.right = new Node(5);  
		root.right.left = new Node(6);  
		root.right.right = new Node(7);  

		root.left.left.left = new Node(8);  
		root.left.left.right = new Node(9);  
		root.left.right.left = new Node(10);  
		root.left.right.right = new Node(11);  
		root.right.left.left = new Node(12);  
		root.right.left.right = new Node(13);  
		root.right.right.left = new Node(14);  
		root.right.right.right = new Node(15);  

	 
  	  } 
	
	
	
}

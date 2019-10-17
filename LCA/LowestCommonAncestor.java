import java.util.ArrayList;
import java.util.List;
 








class Node {
    int val;
    Node left, right;
 
    Node(int value) {
        val = value;
        left = right = null;
    }
}

public class LowestCommonAncestor
{
    Node root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();
 
    int findLCA(int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }
 
    private int findLCAInternal(Node root, int n1, int n2) {
 
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
           // System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            //System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }
 
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
 
        return path1.get(i-1);
    }
 
    private boolean findPath(Node root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }
 
        path.add(root.val);
 
        if (root.val == n) {
            return true;
        }
 
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
 
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
 
        path.remove(path.size()-1);
 
        return false;
    }

    public static int computeLCA(int a, int b, LowestCommonAncestor bst)
    {
    	int lca = bst.findLCA(a,b);
    	System.out.print("LCA(" + a + "," + b + ")=" + lca);
    	
    	return lca;
    }
     
 
    
    static void print2DUtil(Node root, int space)  
    {  
        if (root == null)  
            return;  
      
        space += 3;  
      
        print2DUtil(root.right, space);  
      
        System.out.print("\n");  
        for (int i = 3; i < space; i++)  
            System.out.print(" ");  
        System.out.print(root.val + "\n");  
      
        print2DUtil(root.left, space);  
    }  
      
    
    static void print2D(Node root)  
    {  
        print2DUtil(root, 0);  
    }  
    
    
    
    public static void main(String args[])  
    {  
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
          
        print2D(root);  
    } 
}

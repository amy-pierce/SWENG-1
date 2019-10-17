import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Used Sedgewick and Wayne's Digraph java class
 */
public class LCA_DAG {
	
	private final int Vertex;
	private int Edge;
	private ArrayList<Integer>[] adj;
	private int[] indegree;
	public boolean[] marked;
	public boolean[] stack;
	public boolean checkDAG;

	public LCA_DAG(int Vertex) {
		if (Vertex < 0)
			throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.Vertex = Vertex;
		this.Edge = 0;
		indegree = new int[Vertex];
		adj = (ArrayList<Integer>[]) new ArrayList[Vertex];
		for (int vertex = 0; vertex < Vertex; vertex++) {
			adj[vertex] = new ArrayList<Integer>();

		}
		checkDAG = true;
		marked = new boolean[Vertex];
		stack = new boolean[Vertex];
	}

	
	public int Vertex() {
		return Vertex;
	}

	
	public int Edge() {
		return Edge;
	}

	
	public void addEdge(int vertex1, int vertex2) {
		validateVertex(vertex1);
		validateVertex(vertex2);
		adj[vertex1].add(vertex2);
		indegree[vertex2]++;
		Edge++;
	}

	private void validateVertex(int vertex) {
		if (vertex < 0 || vertex >= Vertex)
			throw new IllegalArgumentException("vertex " + vertex + " is not between 0 and " + (Vertex - 1));

	}

	public Iterable<Integer> adj(int vertex) {
		validateVertex(vertex);
		return adj[vertex];
	}

	public void isAcyclic() {
		for (int i = 0; i < Vertex() && checkDAG; i++) {
			stack = new boolean[Vertex];
			marked = new boolean[Vertex];
			acyclic(i);
		}
	}

	private void acyclic(int vertex) {
		stack[vertex] = true;
		marked[vertex] = true;

		for (int vertex2 : adj(vertex)) {
			if (!marked[vertex2]) {
				acyclic(vertex2);
			} else if (stack[vertex2]) {
				checkDAG = false;
				return;
			}
		}
		stack[vertex] = false;
	}

	public LCA_DAG reverse() {
		LCA_DAG reverse = new LCA_DAG(Vertex);
		for (int vertex = 0; vertex < Vertex; vertex++) {

			for (int vertex2 : adj(vertex)) {
				reverse.addEdge(vertex2, vertex);
			}
		}
		return reverse;
	}

	public int LCA(int vertex, int vertex2) {		
		if (Edge == 0) {
			return -1;
		}
		boolean hasCommonAncestor = false;
		validateVertex(vertex);
		validateVertex(vertex2);

		LCA_DAG reversed = this.reverse();
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		ArrayList<Integer> search1 = reversed.BFS(vertex);
		ArrayList<Integer> search2 = reversed.BFS(vertex2);

		for (int i = 0; i < search1.size(); i++) {
			for (int t = 0; t < search2.size(); t++) {
				if (search1.get(i) == search2.get(t)) {
					commonAncestors.add(search1.get(i));
					hasCommonAncestor = true;
				}
			}
		}

		if (hasCommonAncestor) {
			return commonAncestors.get(0);
		} else {
			return -1;
		}
	}

	private ArrayList<Integer> BFS(int s) {
		boolean visited[] = new boolean[Vertex];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			result.add(s);
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

		return result;
	}

}

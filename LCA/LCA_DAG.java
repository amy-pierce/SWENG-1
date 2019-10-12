import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class LCA_DAG {
	
	private final int V;
	private int E;
	private ArrayList<Integer>[] adj;
	private int[] indegree;
	public boolean[] marked;
	public boolean[] stack;
	public boolean checkDAG;

	public LCA_DAG(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();

		}
		checkDAG = true;
		marked = new boolean[V];
		stack = new boolean[V];
	}

	
	public int V() {
		return V;
	}

	
	public int E() {
		return E;
	}

	
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));

	}

	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	public void isAcyclic() {
		for (int i = 0; i < V() && checkDAG; i++) {
			stack = new boolean[V];
			marked = new boolean[V];
			acyclic(i);
		}
	}

	private void acyclic(int v) {
		stack[v] = true;
		marked[v] = true;

		for (int w : adj(v)) {
			if (!marked[w]) {
				acyclic(w);
			} else if (stack[w]) {
				checkDAG = false;
				return;
			}
		}
		stack[v] = false;
	}

	public LCA_DAG reverse() {
		LCA_DAG reverse = new LCA_DAG(V);
		for (int v = 0; v < V; v++) {

			for (int w : adj(v)) {
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}

	public int LCA(int v, int w) {
		
		if (!checkDAG || E == 0) {
			return -1;
		}
		boolean hasCommonAncestor = false;
		validateVertex(v);
		validateVertex(w);

		LCA_DAG reversed = this.reverse();
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		ArrayList<Integer> search1 = reversed.BFS(v);
		ArrayList<Integer> search2 = reversed.BFS(w);

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
		boolean visited[] = new boolean[V];
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
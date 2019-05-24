package topological_sort;

import java.util.*;

public class Graph {

	private List<Integer> []adj;
	
	public Graph(int node) {
		adj = (List<Integer>[]) new List[node];
		for(int i=0; i<node; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int n1,int n2) {
		adj[n1].add(n2);
	}
	
	public Iterable<Integer> adj(int node){
		return adj[node];
	}
	
}

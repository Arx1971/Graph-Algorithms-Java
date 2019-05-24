package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

	public static void main(String args[]) {

		// time complexity of this code is O(V log E), v is number of vertices and E is number of edges. 
		
		graph(new int[][] { { 2, 1, 1 }, { 2, 3, 5 }, { 3, 4, 1 }, { 4, 2, 1 }, { 1, 4, 1 } }, 4, 2);
		
		/*		
		 * 		following picture represent the above graph. 		
		 * 
		 * 				1	
		 * 		2----------->1
		 *		|^			 |
		 *		| \			 |
		 *	5	|  \		 |1
		 *		|	\		 | 
		 * 		|	 \	1	 |
		 * 		|	  \		 |
		 * 		|	   \	 | 
		 * 		|	    \	 |
		 * 		|	  	 \	 |
		 * 		|	      \	 |
		 * 	   \|/	       \\|/
		 * 		3----------->4
		 * 				1
		 * */

	}

	public static int dist[];
	public static List<node> adj[];

	@SuppressWarnings("unchecked")
	
	public static void graph(int[][] times, int N, int K) {

		System.out.println("Number Of nodes: " + N);
		System.out.println("Source Vertex: " + K);

		adj = (List<node>[]) new List[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++)
			adj[i] = new ArrayList<>();

		for (int[] t : times) {
			int src = t[0], dst = t[1], w = t[2];
			adj[src].add(new node(dst, w));
			
			// Following lines of code make undirected graph, so you don't need perform n^2 operation in your matrix. 
			// The purpose of this line is creating a undirected graph. Simply Uncommented this line will give you directed graph. 
			
			adj[dst].add(new node(src, w));
		}

		dijkstra(K, N);

		for (int i = 1; i <= N; i++)
			System.out.println(i + " -> " + dist[i]);

	}

	public static void dijkstra(int src, int N) {

		Set<Integer> visited = new HashSet<>(); // to keep track of visited node you can use boolean array // boolean visited[]
		
		PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> (b.weight - a.weight)); // lambda expression nothing but min-heap 
		
		// we are adding node onto Priority Queue based on their weight, since node is object, by using lambda expression we are saying add node onto Priority Queue based on their weight
		
		pq.add(new node(src, 0));
		
		dist[src] = 0;

		while (!pq.isEmpty()) {

			node n = pq.poll();
			int u = n.dst;
			visited.add(u);					// visited[u] = true;

			for (node i : adj[u]) {

				int v = i.dst;

				if (dist[u] + i.weight < dist[v]) {
					dist[v] = dist[u] + i.weight;
					pq.add(new node(v, dist[v]));
				}

			}

		}

	}

	public static class node {
		int dst, weight;

		public node(int dst, int weight) {
			this.dst = dst;
			this.weight = weight;
		}
	}

}

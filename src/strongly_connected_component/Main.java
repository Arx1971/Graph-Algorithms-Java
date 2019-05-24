package strongly_connected_component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static boolean visited[];
	public static List<Integer> adj[];
	static List<Integer> path;
	static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {

		System.out.println(strongly_connected_components(7,
				new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 }, { 2, 3 }, { 2, 4 }, { 2, 7 }, { 4, 6 }, { 5, 6 } }));

		System.out.println(strongly_connected_components(9, new int[][] { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 2, 4 },
				{ 4, 6 }, { 5, 6 }, { 5, 3 }, { 6, 3 }, { 5, 7 }, { 7, 9 }, { 9, 8 }, { 8, 7 } }));

		System.out.println(strongly_connected_components(3, new int[][] { { 1, 2 }, { 2, 2 }, { 3, 1 } }));

		System.out.println(strongly_connected_components(3, new int[][] { { 1, 2 } }));

	}

	

	@SuppressWarnings("unchecked")
	public static List<List<Integer>> strongly_connected_components(int node, int graph[][]) {

		List<List<Integer>> myList = new ArrayList<>();
		path = new ArrayList<>();
		visited = new boolean[node + 1];

		adj = (List<Integer>[]) new List[node + 1];

		adj[0] = new ArrayList<>();
		for (int i = 0; i <= node; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			int v1 = graph[i][0];
			int v2 = graph[i][1];
			adj[v1].add(v2);
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i <= node; i++) {
			if (!visited[i]) {
				depth_first_search(i, stack);
			}
		}

		adj = (List<Integer>[]) new List[node + 1];

		adj[0] = new ArrayList<>();
		for (int i = 0; i <= node; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < graph.length; i++) {
			int v1 = graph[i][0];
			int v2 = graph[i][1];
			adj[v2].add(v1);
		}

		Arrays.fill(visited, false);

		Stack<Integer> stack2 = new Stack<>();

		while (!stack.isEmpty()) {
			path = new ArrayList<>();
			int u = stack.peek();
			if (!visited[u]) {
				depth_first_search(u, stack2);
				myList.add(path);

			}
			stack.pop();
		}
		return myList;
	}

	public static void depth_first_search(int src, Stack<Integer> stack) {
		visited[src] = true;
		path.add(src);
		ArrayList<Integer> list = new ArrayList<>(adj[src]);
		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)])
				depth_first_search(list.get(i), stack);
		}
		stack.push(src);
	}
}
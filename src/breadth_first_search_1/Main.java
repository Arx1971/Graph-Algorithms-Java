package breadth_first_search_1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);
	static Graph graph;
	static boolean visited[];
	static int level[];
	static int[] parent;
	private static Scanner in1;

	public static void main(String args[]) {

		String filename = new String();
		filename = "/home/adnanrahin/eclipse-workspace/Graph/src/breadth_first_search/input.txt";

		try {
			in1 = new Scanner(new FileReader(filename));

			while (in1.hasNext()) {
				int node = in1.nextInt();
				int edge = in1.nextInt();
				System.out.println(node);
				System.out.println(edge);
				graph = new Graph(node + 1);
				visited = new boolean[node + 1];
				level = new int[node + 1];
				parent = new int[node + 1];

				for (int i = 0; i < edge; i++) {
					int n1 = in1.nextInt();
					int n2 = in1.nextInt();
					System.out.println(n1 + " <-> " + n2);
					graph.addEdge(n1, n2);
				}

				for (int i = 0; i <= node; i++) {
					level[i] = 0;
					visited[i] = false;
					parent[i] = 0;
				}

				int src = in1.nextInt();
				int dest = in1.nextInt();

				breadth_first_search(src);
				print_path(src, dest);
				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void breadth_first_search(int src) {

		visited[src] = true;
		level[src] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		while (!q.isEmpty()) {
			int u = q.peek();

			q.remove();
			ArrayList<Integer> list = (ArrayList<Integer>) graph.adj(u);

			for (int i = 0; i < list.size(); i++) {
				int v = list.get(i);
				if (visited[v] == false) {
					visited[v] = true;
					level[v] = level[u] + 1;
					parent[v] = u;
					q.add(v);
				}
			}

		}

	}

	public static void print_path(int src, int dest) {
		if (dest == src) {
			System.out.print(dest);
			return;
		}
		print_path(src, parent[dest]);
		System.out.print(" -> " + dest);
	}

}

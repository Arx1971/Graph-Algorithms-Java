package depth_first_search;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import breadth_first_search_1.*;

public class Main {

	static boolean visited[];
	static Graph graph;
	static int []path;
	public static void main(String args[]) {

		String filename = new String();
		filename = "/home/adnanrahin/eclipse-workspace/Graph/src/depth_first_search/input.txt";

		try {
			Scanner in1 = new Scanner(new FileReader(filename));
			
			while (in1.hasNext()) {
				int node = in1.nextInt();
				int edge = in1.nextInt();
				System.out.println(node);
				System.out.println(edge);
				graph = new Graph(node + 1);
				visited = new boolean[node + 1];
				path = new int[node];

				for (int i = 0; i < edge; i++) {
					int n1 = in1.nextInt();
					int n2 = in1.nextInt();
					System.out.println(n1 + " <-> " + n2);
					graph.addEdge(n1, n2);
				}

				for (int i = 0; i <= node; i++) {
					visited[i] = false;
				}

				int src = in1.nextInt();
			
				depth_first_search(src);
				
				for(int i=0; i<path.length; i++) {
					System.out.print(path[i] + " ");
				}

				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static void depth_first_search(int src) {

		Stack<Integer> s = new Stack<>();
		s.push(src);
		visited[src] = true;
		
		int l = 0;
		
		while (!s.isEmpty()) {
			int u = s.peek();
			path[l++] = u;
			s.pop();
			ArrayList<Integer> list = (ArrayList<Integer>) graph.adj(u);
			for (int i = 0; i < list.size(); i++) {
				int v = list.get(i);
				if (visited[v] == false) {
					visited[v] = true;
					s.push(v);
				}
			}
		}

	}

}

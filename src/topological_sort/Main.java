package topological_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static ArrayList<Integer> myList = new ArrayList<>();
	static Scanner input = new Scanner(System.in);
	static boolean visited[] ;
	static Graph graph;
	public static void main(String args[]) {
		
		int node = input.nextInt();
		int edge = input.nextInt();
		
		graph = new Graph(node + 1);
		visited = new boolean [node + 1];
		Arrays.fill(visited, false);
		
		for(int i=0; i<edge; i++) {
			int n1 = input.nextInt();
			int n2 = input.nextInt();
			System.out.println(n1 + " -> " + n2);
			graph.addEdge(n1, n2);
		}
		for(int i=0; i<node; i++) {
			topological_Sort(i);
		}
		for(int i: myList) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void topological_Sort(int src) {
		
		visited[src] = true;
		Stack<Integer> S = new Stack<>();
		S.push(src);
		while(!S.isEmpty()) {
			
			int u = S.peek();
			ArrayList<Integer> list = (ArrayList<Integer>) graph.adj(u);
			S.pop();
			
			for(int i=0; i<list.size(); i++) {
				int v = list.get(i);
				if(visited[v] == false) {
					visited[v] = true;
					S.push(v);
					myList.add(v);
				}
			}
			
		}
		
		
	}
	
}

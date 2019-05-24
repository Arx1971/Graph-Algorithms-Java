package breadth_first_search;

import java.util.*;

public class Main {
	
	static Scanner input = new Scanner(System.in);
	
	static int [] level = new int[100];
	static boolean []visited = new boolean[100];
	static ArrayList<Integer> []graph = new ArrayList[100];
	static int []parent = new int [100];
	
	public static void main(String args[]) {

		/**Queue<Integer> queue = new Queue<>();
		System.out.println(queue.empty());
		queue.push_back(90);
		queue.push_back(10);
		queue.push_back(20);
		queue.push_back(30);
		queue.push_back(40);
		
		queue.display();
		queue.pop();
		System.out.println("Front: " + queue.front());
		queue.display();
		System.out.println(queue.empty());
		queue.pop();
		System.out.println("Front: " + queue.front());
		**/
		
		int node = input.nextInt();
		int edge = input.nextInt();
		
		for(int i=0; i<=node; i++) {
			level[i] = 0;
			visited[i] = false;
			graph[i] = new ArrayList<>();
		}
		int n1,n2;
		for(int i=1; i<=edge; i++) {
			n1 = input.nextInt();
			n2 = input.nextInt();
			graph[n1].add(n2);
			graph[n2].add(n1);
		}		
		breadth_first_search(1);
		print_path(1, node);
		
	}
	public static void breadth_first_search(int src) {
		
		int u,v;
		Queue<Integer> q = new Queue<>(); // Look at to the Queue class. 
		q.push_back(src);
		visited[src] = true;
		level[src] = 1;
		
		while(!q.empty()) {
			u = (int) q.front();
			q.pop();
			for(int i=0; i<graph[u].size(); i++) {
				v = graph[u].get(i);
				
				if(visited[v] == false) {
					visited[v] = true;
					level[v] = level[u] + 1;
					parent[v] = u;
					q.push_back(v);
				}
				
			}
			
		}
		
	}
	public static void print_path(int src, int dest) {
		if(dest == src) {
			System.out.print(dest);
			return;
		}
		print_path(src, parent[dest]);
		System.out.print(" -> " + dest);
	}
	
}


/**
 * Node - 6
 * Edge - 7
 * 1 -> 2,3 
 * 2 -> 1,3,4
 * 3 -> 1,2,4
 * 4 -> 5
 * 5 -> 6
 * 6 -> 5
 * 
 * 
 * 
 * 
 */

/**6
7
1 2
1 3
2 3
2 4
4 5
5 6
3 4*/
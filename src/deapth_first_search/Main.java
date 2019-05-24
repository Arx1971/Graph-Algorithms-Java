package deapth_first_search;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class Main {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Integer> []graph = new ArrayList[100];
	static boolean []visited = new boolean[100];
	static int []edge_id = new int[100];
	//static int []parent = new int[100];
	
	public static void main(String args[]) {
		
		/**Stack<Integer> stack = new Stack<>();
		System.out.println(stack.empty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println(stack.empty());
		stack.display();
		stack.pop();
		stack.display();
		System.out.println("Stack Top: " + stack.top());
		stack.pop();
		System.out.println("Stack Top: " + stack.top());
		stack.pop();
		System.out.println(stack.empty());
		stack.push(90);
		System.out.println("Stack Top: " + stack.top());
		**/
		
		int node = input.nextInt();
		int edge = input.nextInt();
		
		for(int i=0; i<=node; i++) {
			visited[i] = false;
			edge_id[i] = 0;
			graph[i] = new ArrayList<>();
		}
		
		int n1, n2;
		
		for(int i=1; i<=edge; i++) {
			n1 = input.nextInt();
			n2 = input.nextInt();
			
			graph[n1].add(n2);
			graph[n2].add(n1);
			
		}
		/**for(int i=1; i<=node; i++) {
			System.out.println("Data : ");
			for(int j=0; j<graph[i].size(); j++) {
				System.out.print(graph[i].get(j));
			}
			System.out.println();
		}**/
		
		deapth_first_search(1);

		
		for(int i=1; i<=node; i++) {
			System.out.println(visited[i]);
		}
		//System.out.println("Test;  " + visited[2]);
		
	}
	
	public static void deapth_first_search(int src) {
		
		int u,v;
		Stack<Integer> s = new Stack<>();
		s.push(src);
		
		while(!s.empty()){
			
			u =(int) s.top();
			s.pop();
			
			while(edge_id[u]<graph[u].size()){
				v = graph[u].get(edge_id[u]);
				edge_id[u]++;
				
				if(visited[v] == false){
					visited[v] = true;
					s.push(u);
					s.push(v);
					break;
				}
			}
		
		}
		
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

package dfs_2d_graph_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String args[]) {

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		mapping(board);
		grph(board);

	}

	public static List<Integer> adj[];
	public static boolean visited[];
	static ArrayList<Integer> path;
	public static Map<Integer, Character> map = new HashMap<Integer, Character>();

	public static void mapping(char[][] board) {

		int counter = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				map.put(counter, board[i][j]);
				counter++;
			}
		}
		for (Map.Entry<Integer, Character> itr : map.entrySet()) {
			System.out.println(itr.getKey() + " " + itr.getValue());
		}
	}

	@SuppressWarnings("unchecked")

	public static void grph(char[][] board) {

		int[][] mat = new int[board.length][board[0].length];

		int counter = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = counter++;
			}
		}

		adj = (List<Integer>[]) new List[(board.length * board[0].length)];

		for (int i = 0; i < board.length * board[0].length; i++)
			adj[i] = new ArrayList<Integer>();

		int row = mat.length - 1;
		int col = mat[0].length - 1;

		counter = 0;
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++) {

				if (i == 0 && j == 0) {
					adj[counter].add(mat[i][j + 1]);
					adj[counter].add(mat[i + 1][j]);
				} else if (i == 0 && j == col) {
					adj[counter].add(mat[i + 1][j]);
					adj[counter].add(mat[i][j - 1]);
				} else if (i == 0 && j > 0 && j < col) {
					adj[counter].add(mat[i][j - 1]);
					adj[counter].add(mat[i][j + 1]);
					adj[counter].add(mat[i + 1][j]);
				} else if (i > 0 && i < row && j == 0) {
					adj[counter].add(mat[i - 1][j]);
					adj[counter].add(mat[i + 1][j]);
					adj[counter].add(mat[i][j + 1]);
				} else if (j == col && i > 0 && i < row) {
					adj[counter].add(mat[i - 1][j]);
					adj[counter].add(mat[i + 1][j]);
					adj[counter].add(mat[i][j - 1]);
				} else if (i == row && j == 0) {
					adj[counter].add(mat[i - 1][j]);
					adj[counter].add(mat[i][j + 1]);
				} else if (i == row && j > 0 && j < col) {
					adj[counter].add(mat[i][j - 1]);
					adj[counter].add(mat[i][j + 1]);
					adj[counter].add(mat[i - 1][j]);
				} else if (i == row && j == col) {
					adj[counter].add(mat[i][j - 1]);
					adj[counter].add(mat[i - 1][j]);
				} else {
					adj[counter].add(mat[i - 1][j]);
					adj[counter].add(mat[i + 1][j]);
					adj[counter].add(mat[i][j + 1]);
					adj[counter].add(mat[i][j - 1]);
				}

				counter++;
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				path = new ArrayList<>();
				Stack<Integer> stack = new Stack<>();
				visited = new boolean[(mat.length * mat[0].length)];
				Arrays.fill(visited, false);
				if (!visited[mat[i][j]])
					depth_first_search(mat[i][j], stack);

				for (int l = 0; l < path.size(); l++) {
					System.out.print(map.get(path.get(l)) + " ");
				}
				System.out.println();
			}

			System.out.println();
		}

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

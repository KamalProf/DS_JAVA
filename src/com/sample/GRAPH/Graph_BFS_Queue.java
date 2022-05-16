package com.sample.GRAPH;

import java.util.LinkedList;
import java.util.Queue;

/*BFS pseudocode
create a queue Q 
mark v as visited and put v into Q 
while Q is non-empty 
    remove the head u of Q 
    mark and enqueue all (unvisited) neighbours of u
*/
public class Graph_BFS_Queue {
	int vertices;
	private LinkedList<Integer> adjList[];

	public Graph_BFS_Queue(int vertices) {
		this.vertices = vertices;
		adjList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjList[i] = new LinkedList();
		}
	}

	public void addEdge(int src, int dest) {
		// add forward edge
		adjList[src].addFirst(dest);
		// add back edge for undirected graph
		adjList[dest].addFirst(src);
	}

	public void BFS() {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		System.out.println("BFS: ");
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				queue.add(i);
				while (!queue.isEmpty()) {
					// get a vertex from queue
					int vertex = queue.poll();
					// mark the vertex visited
					visited[vertex] = true;
					// print the vertex
					System.out.print(vertex + " ");
					// add unvisited adjacent vertices
					for (int j = 0; j < adjList[vertex].size(); j++) {
						int adjVertex = adjList[vertex].get(j);
						if (!visited[adjVertex]) {
							visited[adjVertex] = true;
							queue.add(adjVertex);
						}
					}
				}
			}
		}
	}
	
	public void newBFS(int start) {
		boolean visited[] = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		System.out.println("BFS Traversal : ");
		visited[start] = true;
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			for (int adjVertex:adjList[vertex]) {
				if (!visited[adjVertex]) {
					queue.add(adjVertex);
				}
				
			}
		}
	}

	public static void main(String[] args) {
		Graph_BFS_Queue g = new Graph_BFS_Queue(5);
		g.addEdge(0, 1);
		g.addEdge(3, 2);
		g.addEdge(2, 4);
		g.addEdge(1, 4);
		g.addEdge(3, 1);
		g.addEdge(2, 0);
		g.BFS();
		//g.newBFS(0);
	}

}

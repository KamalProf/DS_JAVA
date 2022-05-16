package com.sample.GRAPH;

import java.util.LinkedList;

public class Graph_DFS_Recursive {
	private int vertices; // number of nodes
	private LinkedList<Integer> adjList[]; // adjacency list

	public Graph_DFS_Recursive(int vertices)
    {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices;i++)
        {
        	adjList[i] = new LinkedList<Integer>();
    	}
    }
	
	public void addEdge(int src,int edge) {
		adjList[src].add(edge);
	}
	
    public void DFS(int startVertex)
    {
    	//initialize a new boolean array to store the details of explored nodes
        boolean already[] = new boolean[startVertex]; 
        DFSUtil(startVertex, already);
    }
	
	
    void DFSUtil(int vertex, boolean nodes[])
	{
		nodes[vertex] = true; // mark the node as explored
		System.out.print(vertex + " ");
		int a = 0;
		// iterate through the linked list and then propagate to the next few nodes
		for (int i = 0; i < adjList[vertex].size(); i++)
		{
			a = adjList[vertex].get(i);
			if (!nodes[a]) // only propagate to next nodes which haven't been explored
			{
				DFSUtil(a, nodes);
			}
		}
	}

	public static void main(String[] args) {
		Graph_DFS_Recursive g = new Graph_DFS_Recursive(6);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);
 
        System.out.println(
            "Following is Depth First Traversal: ");
 
        g.DFS(0);

	}

}

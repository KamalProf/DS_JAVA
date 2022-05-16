package com.sample.GRAPH;

import java.util.LinkedList;

public class AdjListGraph {
	int vertex;
	LinkedList<Integer> list[];

	public AdjListGraph(int vertex) {
		this.vertex = vertex;
		list = new LinkedList[vertex];
		for (int i=0; i< vertex; i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source,int destination) {
		list[source].addFirst(destination);
		list[destination].addFirst(source);
	}
	
	public void printGraph() {
		for (int i=0; i< vertex; i++) {
			System.out.print("Vertex "+i+" connected to:");
			for (int j=0;j<list[i].size();j++) {
				System.out.print(list[i].get(j)+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		AdjListGraph graph = new AdjListGraph(5);
		
		graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        graph.printGraph();
	}

}

package com.sample.GRAPH;

//https://algorithms.tutorialhorizon.com/
public class AdjMatrixGraph {

	int matrix[][];
	int vertices;

	public AdjMatrixGraph(int vertices) {
		this.vertices = vertices;
		matrix = new int[vertices][vertices];
	}

	public void addEdge(int srcVertex, int destVertex) {
		// add edge = 1
		matrix[srcVertex][destVertex] = 1;
		// add backEdge = 1
		matrix[destVertex][srcVertex] = 1;
	}

	public void printGraph() {
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				System.out.print(matrix[i][j] + "");
			}
			System.out.println();
		}

		for (int i = 0; i < vertices; i++) {
			System.out.print("" + i + " adjacent matrix to :");
			for (int j = 0; j < vertices; j++) {
				if (matrix[i][j] == 1) {
					System.out.print("" + j + ",");
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjMatrixGraph graph = new AdjMatrixGraph(5);

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

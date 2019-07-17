package search;


import java.util.LinkedList;
public class Graph {
	int V; // No. of vertices
	LinkedList<Edge> adj[]; // Adjacency Lists
	int Cost[];
	Node[] nodes;
	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		Cost = new int[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Edge>();
		}
		nodes=new Node [v];
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w, int c) {
		adj[v].add(new Edge(v,w, c));
	}
}

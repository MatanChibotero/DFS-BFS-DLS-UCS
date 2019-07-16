package ass1_2;

import java.util.LinkedList;
public class Graph {
	int V; // No. of vertices
	LinkedList<Edge> adj[]; // Adjacency Lists
	int p[];
	int Cost[];

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		p = new int[v];
		Cost = new int[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Edge>();
		}
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w, int c) {
		adj[v].add(new Edge(v, w, c));
		if (Cost[w] == 0 || Cost[v] + c < Cost[w]) {
			Cost[w] = Cost[v] + c;
			p[w] = v;
		}
	}
}

package search;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BFS implements algorithm{

	@Override
	public void runAlgo(Graph g) {
		Node Index = null;
		LinkedList<Node> closed=new LinkedList<Node>();
		LinkedList<Node> frontier = new LinkedList<Node>();
		g.nodes[0]=new Node(0, 0);
		frontier.add(g.nodes[0]);
		System.out.println("Search route:");
		while(frontier.size()!=0) {
			Index=frontier.poll();
			if(Index.index==6) {
				System.out.println("-->6");
				break;
			}
			System.out.print("-->"+Index.index);
			for(int i=0; i<g.adj[Index.index].size();i++) {
				if(!closed.contains(g.nodes[g.adj[Index.index].get(i).dst])&&!frontier.contains(g.nodes[g.adj[Index.index].get(i).dst])) {
						g.nodes[g.adj[Index.index].get(i).dst]=new Node(g.adj[Index.index].get(i).dst, Index.cost+g.adj[Index.index].get(i).cost);
						g.nodes[g.adj[Index.index].get(i).dst].p=Index;
						frontier.add(g.nodes[g.adj[Index.index].get(i).dst]);
				}
			}
			closed.add(Index);	
		}
		System.out.println("Solution route:");
		System.out.print("6");
		Index=Index.p;
		while(Index.index!=0) {
			System.out.print("<--"+Index.index);
			Index=Index.p;
		}
		System.out.println("<--0");
	}
}

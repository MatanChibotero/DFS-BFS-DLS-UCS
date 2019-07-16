package ass1_2;

import java.util.LinkedList;

public class BFS implements algorithm{

	@Override
	public void runAlgo(Graph g) {
			LinkedList<Integer>  print[] =new LinkedList[g.V];
			for (int i = 0; i < print.length; i++) {
				print[i]=new LinkedList<Integer>();
			}
		    boolean visited[] = new boolean[g.V]; 
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 
	        int parent[]=new int[g.V];
	        visited[0]=true; 
	        queue.add(0);
	        print[0].add(0);
	        int s=0;
	        parent[0]=-1;
	        while (queue.size() != 0) 
	        { 
	            s = queue.poll(); 
	           
	            if(s!=0) {
	            	for(int i=0;i<print[parent[s]].size();i++) {
	            		print[s].add(print[parent[s]].get(i));
	            	}
	            	print[s].add(s);
	            }
	            if(s==5) {
	            	Print(print[s]);
	            	return;
	            } 
	            for(int i=0;i<g.adj[s].size();i++) {
	                if (!visited[g.adj[s].get(i).dst]) 
	                { 
	                	parent[g.adj[s].get(i).dst]=s;
	                    visited[g.adj[s].get(i).dst] = true; 
	                    queue.add(g.adj[s].get(i).dst); 
	                } 
	             }
	            } 
	}

	private void Print(LinkedList<Integer> p) {
		for(int i=0;i<p.size()-1;i++)	{
			System.out.print((char) (65 + p.get(i)) + "-->");
		}
		System.out.println("F");
	}
}

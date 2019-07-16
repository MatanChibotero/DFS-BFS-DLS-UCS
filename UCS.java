package ass1_2;

import java.util.LinkedList;

public class UCS implements algorithm {



static Node min(LinkedList<Node> list) {
	Node min=list.get(0);
	for(int i=1;i<list.size();i++) {
		if(list.get(i).cost<min.cost) {
			min=list.get(i);
		}
	}
	return min;
}
private static void Print(LinkedList<Integer> p) {
	for(int i=0;i<p.size()-1;i++)	{
		System.out.print((char) (65 + p.get(i)) + "-->");
	}
	System.out.println("F");
}
	@Override
	public void runAlgo(Graph g) {
		LinkedList<Integer>  print[] =new LinkedList[g.V];
		for (int i = 0; i < print.length; i++) {
			print[i]=new LinkedList<Integer>();
		}
		print[0].add(0);
		boolean visited[] = new boolean[g.V]; 
		LinkedList<Node> list=new LinkedList<Node>();
	    visited[0]=true; 
	    list.add(new Node(0,0));
	    Node s;
	    while (list.size() != 0) 
	    { 
	        s = min(list);
	        if(s.index!=0) {
	        	for(int i=0;i<print[g.p[s.index]].size();i++) {
	        		print[s.index].add(print[g.p[s.index]].get(i));
	        	}
	        	print[s.index].add(s.index);
	        }
	        	if (s.index == 5) {
	    			Print(print[s.index]);
	    			return;
	    		}
	        list.remove(s);
	        for(int i=0;i<g.adj[s.index].size();i++) {
	            if (!visited[g.adj[s.index].get(i).dst]) 
	            { 
	                visited[g.adj[s.index].get(i).dst] = true; 
	                list.add(new Node(g.adj[s.index].get(i).dst,g.Cost[g.adj[s.index].get(i).dst])); 
	            } 
	         }
	        } 		
	}
	}



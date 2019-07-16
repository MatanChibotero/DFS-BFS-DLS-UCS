package ass1_2;

import java.util.LinkedList;

public class DFS implements algorithm {

	@Override
	public void runAlgo(Graph g) {
		LinkedList<Integer>  print[] =new LinkedList[g.V];
		for (int i = 0; i < print.length; i++) {
			print[i]=new LinkedList<Integer>();
		}
		boolean visited[] = new boolean[g.V];
		boolean finish[] =new boolean[1];
		print[0].add(0);
		DFSUtil(g, visited, 0,print,-1,finish);
	}

	private static void Print(LinkedList<Integer> p) {
		for(int i=0;i<p.size()-1;i++)	{
			System.out.print((char) (65 + p.get(i)) + "-->");
		}
		System.out.println("F");
	}

	static void DFSUtil(Graph g, boolean visited[], int s,LinkedList<Integer> print[],int parent,boolean finish[]) {
		if(finish[0])
			return;
		if(s!=0) {
        	for(int i=0;i<print[parent].size();i++) {
        		print[s].add(print[parent].get(i));
        	}
        	print[s].add(s);
        }
		if (s == 5) {
			finish[0]=true;
			Print(print[s]);
			return;
		}
		visited[s] = true;
		for (int i = 0; i < g.adj[s].size(); i++) {
			if (!visited[g.adj[s].get(i).dst])
				DFSUtil(g, visited, g.adj[s].get(i).dst,print,s,finish);
		}
	}
}

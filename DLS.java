package ass1_2;

import java.util.LinkedList;
import java.util.Scanner;

public class DLS implements algorithm{

	@Override
	public void runAlgo(Graph g) {
		LinkedList<Integer>  print[] =new LinkedList[g.V];
		for (int i = 0; i < print.length; i++) {
			print[i]=new LinkedList<Integer>();
		}
		print[0].add(0);
		boolean visited[] = new boolean[g.V]; 
		System.out.println("Enter limit:");
		Scanner s=new Scanner(System.in);
		int Limit=s.nextInt();
		boolean finish[] =new boolean[1];
	    DLSUtil( g, visited,0,Limit+1,print,-1,finish); 
	    if(!finish[0]) 
	      System.out.println("Error!!!");
	    s.close();
	}
	private static void Print(LinkedList<Integer> p) {
		for(int i=0;i<p.size()-1;i++)	{
			System.out.print((char) (65 + p.get(i)) + "-->");
		}
		System.out.println("F");
	}
static void DLSUtil(Graph g,boolean visited[],int s,int Limit,LinkedList<Integer> print[],int parent,boolean finish[]) 
{ 
	if (finish[0])
		return;
	if(Limit<=0) {
		return;
	}
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
	Limit--;
    visited[s] = true;
    for(int i=0;i<g.adj[s].size();i++) {
        if (!visited[g.adj[s].get(i).dst]) 
            DLSUtil(g, visited,g.adj[s].get(i).dst,Limit,print,s,finish); 
    } 
}
}


import java.io.*;
import java.util.*;
class Graph
{
	private LinkedList<Integer> adj[];
	Graph(int v)
	{
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
           adj[i]=new LinkedList<Integer>();
	}
	public void addEdge(int u,int v)
	{
		adj[v].add(u);
		adj[u].add(v);
	}

  //using stack checking whether path exists between two given vertex
	public boolean dfsCheckPath(int source,int destination)
	{
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(source);
		boolean visited[]=new boolean[adj.length];
        visited[source]=true;
        while(stack.size()>0)
        {
        	int curr=stack.pop();
        	if(curr==destination)
                  return true;
        	
        		for(int neighbours :adj[curr])
        		{
        			if(visited[neighbours]!=true)
        			{
        				visited[neighbours]=true;
        			    stack.push(neighbours);
        		    }
        		}
        	
        }
        return false;
	}

	//recursive approach
	public boolean dfsRecursive(int source,int destination)
	{
		boolean visited[]=new boolean[adj.length];
		visited[source]=true;
		return dfsRecursive(source,destination,visited);
	}
	public boolean dfsRecursive(int source,int destination,boolean visited[])
	{
		if(source==destination)
			return true;
		
			
		  for(int neighbours : adj[source])
		   {
		   	 if(visited[neighbours]!=true)
		   	 {
		   		visited[neighbours]=true;
			    return dfsRecursive(neighbours,destination,visited);
		     }
		   }
	    
	    return false;
	}
}

public class DFSTree
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of vertex and edges");

		String ve[]=br.readLine().split(" ");
        int v=Integer.parseInt(ve[0]);
        int e=Integer.parseInt(ve[1]);
        Graph graph=new Graph(v);
        System.out.println("Enter "+e+" number of edges");
        for(int i=0;i<e;i++)
        {
           String ss[]=br.readLine().split(" ");
           int v1=Integer.parseInt(ss[0]);
           int v2=Integer.parseInt(ss[1]);
           graph.addEdge(v1,v2);
         }
          System.out.println("Enter source and destination vertex ");
          String sss[]=br.readLine().split(" ");
          int source=Integer.parseInt(sss[0]);
          int destination=Integer.parseInt(sss[1]);
          System.out.println("Path exist"+graph.dfsCheckPath(source,destination));
          System.out.println("Path exist"+graph.dfsRecursive(source,destination));
	}

}


========================================================================================================================
----------------------------OUTPUT FORMAT---------------------------------

C:\Users\hp\Desktop\javas>java DFSTree
Enter number of vertex and edges
5 6
Enter 6 number of edges
1 2
1 4
2 3
0 4
0 3
3 4
Enter source and destination vertex
0 4
Path existtrue

C:\Users\hp\Desktop\javas>java DFSTree
Enter number of vertex and edges
6 6
Enter 6 number of edges
1 2
1 4
2 3
0 4
0 3
3 4
Enter source and destination vertex
0 6
Path existfalse

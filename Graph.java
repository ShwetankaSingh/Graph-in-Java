import java.io.*;
import java.util.*;
public class Graph
{
	private LinkedList<Integer> adj[];

	public Graph(int v)
	{
		adj=new LinkedList[v];
		for(int i=0;i<v;i++){
          adj[i]=new LinkedList<Integer>();
		}
	}

	public void addEdge(int source,int destination){
       adj[source].add(destination);
       adj[destination].add(source);
	}

	public int bfs(int source,int destination)
	{
		boolean vis[]=new boolean[adj.length];
		int parent[]=new int[adj.length];
		Queue<Integer> q=new LinkedList<>();
		q.add(source);
		parent[source]=-1;
		vis[source]=true;
		while(!q.isEmpty())
		{
			int cur=q.poll();
			if(cur==destination)
				break;
			for(int neighbour:adj[cur])
			{
				if(!vis[neighbour])
				{
					vis[neighbour]=true;
					q.add(neighbour);
					parent[neighbour]=cur;
				}
			}
		}
		int cur=destination;
		int distance=0;
		while(parent[cur]!=-1)
        {
             System.out.print(cur+"-->");
             cur=parent[cur];
             distance++;
		}
		return distance;
	}


  public static void main(String agrs[])throws IOException 
  {
  	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  	System.out.println("Enter the number of vertices and edges");
  	int v=Integer.parseInt(br.readLine());
  	int e=Integer.parseInt(br.readLine());
  	Graph graph=new Graph(v);
  	System.out.println("Enter"+e+"edges");
  	for(int i=0;i<e;i++)
  	{
  		String sd[]=br.readLine().split(" ");
  		int source=Integer.parseInt(sd[0]);
  		int destination=Integer.parseInt(sd[1]);
  		graph.addEdge(source,destination);
  	}
  	System.out.println("Enter source and destination");
  	String s[]=br.readLine().split(" ");
  	int ss=Integer.parseInt(s[0]);
  	int dd=Integer.parseInt(s[1]);
  	System.out.println("Minimum distance is"+graph.bfs(ss,dd));
  }

}



/*       ============================================== OUTPUT==============

C:\Users\hp\Desktop\javas>java Graph
Enter the number of vertices and edges
5
6
Enter6edges
0 1
1 2
2 3
3 4
0 4
2 4
Enter source and destination
0 3
3-->4-->Minimum distance is2



*/

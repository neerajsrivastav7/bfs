import java.io.*;
import java.util.*; 
public class bfsInJava
{
    private int V;
    private LinkedList<Integer> adj[];
    bfsInJava(int v)
      {
         V=v;
         adj=new LinkedList[v];
         for(int i=0;i<v;i++)
            {
               adj[i]=new LinkedList();
            }
      }
    void addEdge(int v,int w)
     {
        adj[v].add(w);
     }
    void bfs(int s)
     {
        boolean visited[]=new boolean[V];//by default this arr have false value
        LinkedList<Integer> queue=new LinkedList();
        queue.add(s);
        while(queue.size()!=0)
           {
               s=queue.poll();
               System.out.print(s+" ");
               Iterator<Integer> i = adj[s].listIterator(); 
               while(i.hasNext())
                {
                   int n=i.next();
                   if(!visited[n])
                     {
                        visited[n]=true;
                        queue.add(n);
                     }
                }
           } 
     } 
   public static void main(String[] args)
     {
         bfsInJava g = new bfsInJava(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 0)"); 
        g.bfs(0); 
     }
}

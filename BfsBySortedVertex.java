import java.io.*;
import java.util.*; 
public class Specialpath
{
    private int V;
    private int b,c,s;
    public int c1=0;
    int arr[];
    private LinkedList<Integer> adj[];
    Specialpath(int v)
      {
         this.V=v+10;
         adj=new LinkedList[V];
         arr=new int[V];
         for(int i=0;i<V;i++)
            {
               adj[i]=new LinkedList();
            }
      }
    void getresult(int s1,int d)
      {
        int val=d,i=0;
        int a1[]=new int[V];
        val=d;
        while(val!=-1)
         {
            a1[i++]=val;
            val=arr[val];
         }
      System.out.println(i);
      for(int j=i-1;j>=0;j--)
      System.out.print(a1[j]+" ");
      }
    void addEdge(int v1,int w)
     {
        adj[v1].add(w);
     }
    void bfs(int s2,int d1)
     {
        int f=0;
        boolean visited[]=new boolean[V];//by default this arr have false value
        LinkedList<Integer> queue=new LinkedList();
        queue.add(s2);
        visited[s2]=true;
        arr[s2]=-1;
        while(queue.size()!=0)
           {
               s2=queue.poll();
               //System.out.print(s2+" ");
               c1++;
               Iterator<Integer> i = adj[s2].listIterator(); 
               Collections.sort(adj[s2]);
               //System.out.println(adj[s2]);
               while(i.hasNext())
                {
                   int n=i.next();   
                   if(!visited[n])
                     {
                        arr[n]=s2;
                        visited[n]=true;
                        queue.add(n);
                     }
                     if(n==d1)
                     {
                       f=1;
                       break;
                     }
                   if(f==1)
                   break;
                }
           } 
     } 
   public static void main(String[] args)
     {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int s=sc.nextInt();
        Specialpath g = new Specialpath(a); 
        for(int i=0;i<b;i++)
          {
             int u=sc.nextInt();
             int v=sc.nextInt();
             g.addEdge(u,v);
             g.addEdge(v,u);
          } 
        int s1=sc.nextInt();
        int d=sc.nextInt();
        g.bfs(s1,d); 
        g.getresult(s1,d);
     }
}

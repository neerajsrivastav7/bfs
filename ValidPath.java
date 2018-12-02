import java.io.*;
import java.util.*; 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
public class ValidPath
{
     private int V=200005;
    private LinkedList<Integer> adj[];
    int arr[];
    int i=0;
    int j=1;
    int n1;
    boolean visited[];
    ValidPath(int v)
      {
          this.n1=v;
         arr=new int[V];
         visited=new boolean[V];
         adj=new LinkedList[V];
         for(int i=1;i<=v;i++)
            {
               adj[i]=new LinkedList();
            }
      }
 static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
  }
    void setval(int value)
     {
        arr[i++]=value;
     }
    int getIndex()
     {
        return arr[0];
     }
    void addEdge(int v,int w)
     {
        adj[v].add(w);
     }
    int bfs(int s)
     {
        //by default this arr have false value
        LinkedList<Integer> queue=new LinkedList();
        queue.add(s);
        int f=1;
        visited[s]=true;
        if(s!=1)
        return 0;
        while(queue.size()!=0)
           {
               s=queue.poll();
               int value=(adj[s].size());
               while(value!=0&&j<n1)
                {
                   if((j<n1)&&adj[s].contains(arr[j]))
                      {
                       // System.out.println(arr[j]);
                        if(visited[arr[j]]==false){
                         visited[arr[j]]=true;
                         queue.add(arr[j]);
                         j++;  
                      } }
                 value=value-1;
                }
           } 
       if(j<n1)
       f=0;
       return f;
     } 
   public static void main(String[] args)
     {
          FastReader sc=new FastReader();
          int n=sc.nextInt();
          ValidPath g=new ValidPath(n);
          for(int i=0;i<n-1;i++)
             {
                int x=sc.nextInt();
                int y=sc.nextInt();  
                g.addEdge(x,y);
                g.addEdge(y,x);        
             }
        for(int i=0;i<n;i++)
          {
             int val=sc.nextInt();
             g.setval(val);  
          }
       int f=g.bfs(1);
       if(f==0)
       System.out.print("No");
       else 
        {
          System.out.print("Yes");
        }      
     }
}

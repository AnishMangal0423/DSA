import java.util.*;
/*
 Qn- Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
 Example 1:
 Input:
 Output: 1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.

Example 2:
Input:
Output:1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0.


Problem Statement- Given a Directed Acyclic Graph(DAG) and we have to find Topological sort or linear orrdering in it .. 
Linear Ordering - if u --> v then u should come before v and that is it.. 

Approch-1 : DFS Approch-
Intution- So we have to print first those nodes which have no outgoing edge or where my dfs willl end so first will do dfs and on returning time will store nodes in stack...

TC - O(V+E)
SC- O(V)
Code- 

*/

       
class Solution
{
    // Function to return list containing vertices in Topological order. 
    
    void dfs(boolean[]visited,  ArrayList<ArrayList<Integer>> adj, Stack<Integer>s, int vertex){
        
      visited[vertex]=true;
      
      ArrayList<Integer>childArray=adj.get(vertex);
      
      for(int childs : childArray){
          
          if(visited[childs]==false){
              
              dfs(visited, adj, s, childs);
            
          }
      }
      
      
      s.push(vertex);
        return;
    
    }
    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       
      boolean[]visited=new boolean[V];
      Stack<Integer>s=new Stack<>();
      int[]ans=new int[V];
       
       
      for(int i=0; i<V; i++){
           
          if(visited[i]==false){
               
              dfs(visited, adj , s, i);
          }
      }
       
      int k=0;
      while(!s.isEmpty()){
           
          int a=s.pop();
          ans[k]=a;
        //   System.out.print(a+" ,");
        k++;
           
      }
      return ans;
    
    
 
    }
}



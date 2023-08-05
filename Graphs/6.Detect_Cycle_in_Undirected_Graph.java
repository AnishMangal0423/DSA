import java.util.*;
/*
Q6. Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. Graph is in the form of        a   djacency list where adj[i] contains all the nodes ith node is having edge with.

 Input-  V = 5, E = 5
         adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
         Output: 1
         Explanation: 

         1->2->3->4->1 is a cycle.
https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

------------------------------------------------------------------------------------------------------------------------------------

Approch-1 : Approch of Parent-
     Intution- Main problem is that when we will call dfs and will call dfs to those who are not visited .
               then we will say that if we find any element that is visited and will return true that is wrong because A-B can be
               produce it also so we have to maintain one check also of Parent that basically changes if any node will make loop
               so parent will help us-
                

            TC- O(V+E)
            SC- O(V)

 Code-           
 */

class Solution {
    // Function to detect cycle in an undirected graph.
    boolean ans1=false;
    public boolean dfs(boolean[]visited ,ArrayList<ArrayList<Integer>> adj, int start_index, int parent){
        
         visited[start_index]=true;
        
        
        ArrayList<Integer>samp=adj.get(start_index);
        
        for(int j=0; j<samp.size(); j++){
        
        int child=samp.get(j);
        
        if(visited[child]==true && parent!=child){
            return true;
        }
        
        if(visited[child]==false){
          ans1=ans1 || dfs(visited , adj , child, start_index);
        }
        
        } 
        
        return ans1;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
      
      boolean ans=false;
        boolean[]visited=new boolean[V];
   
       for(int i=0; i<V; i++){
           
           if(visited[i]==false){
               
              ans=ans || dfs(visited , adj , i , -1);
           }
       }        
        
        return ans;
      
    }
}
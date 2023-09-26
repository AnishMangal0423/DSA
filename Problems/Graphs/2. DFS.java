package Graphs;
import java.util.*;

/* 
Q2. DFS-
Soln-

  Intitution- DFS Means Depth First Search , we are going in a depth and maintaining a visited array for not having infinite Loop problem
            and calling for every nth child starting from source vertex.

    
    Code-
*/ 
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
    void dfs(int node , ArrayList<ArrayList<Integer>> adj, ArrayList<Integer>ans , boolean[]visited){
        
        visited[node]=true;
        ans.add(node);
        
        
        ArrayList<Integer>childs=adj.get(node);
        int n=childs.size();
        
        for(int i=0; i<n; i++){
            
            if(!visited[childs.get(i)]){
                visited[childs.get(i)]=true;
                
                dfs(childs.get(i), adj, ans , visited);
            }
        }
    }
    
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        
        ArrayList<Integer>ans=new ArrayList<>();
    
        boolean [] visited=new boolean[V];
        
         dfs(0 , adj , ans , visited);
        
        return ans;
    }
}
/*
 *  Time Complexity - O(V+E) --> O(V) for going to every vertex and O(E) for every edge coming out of it.
 *   Space Complexity- O(V)

 */
/* 
-------------------------------------------------------------------------------------------------------------------------------------------

*/
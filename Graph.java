import java.util.*;
/* Q1..  Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.

Soln-
 
 Intitution- Main Approch is that here we have to set(arrange) the pairs not the vertices because all type of graphs can be possible
             like strongly connected , connected components, and like this.
             Eg- Let vertex A, B, C here three pairs can be formed A-B , B-C , A-C
                 Now consider these three as I1 , I2 , I3 and arrange them then we will get all graphs.

             Ans- 2^(nC2).

```
KeyFactor - Work on Pair rather then vertex.

```


--------------------------------------------------------------------------------------------------------------------------------------------

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



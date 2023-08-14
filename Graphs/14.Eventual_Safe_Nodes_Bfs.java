import java.util.*;
/*
 Qn-
A directed graph of V vertices and E edges is given in the form of an adjacency list adj. Each node of the graph is labelled with a distinct integer in the range 0 to V - 1.
A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node.
You have to return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Example 1:
Input: Graph
Output:
2 4 5 6
Explanation:
The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no 
outgoing edges from either of them. 
Every path starting at nodes 2, 4, 5, and 6 all 
lead to either node 5 or 6.

Example 2:
Input:
Output:
3
Explanation:
Only node 3 is a terminal node, and every path 
starting at node 3 leads to node 3.

Qn Link- https://practice.geeksforgeeks.org/problems/eventual-safe-states/1

Problem Statement- In this problem it is given that we have graph and some terminal nodes -- which do not have outgoing edges .. now we have to find the nodes from which all paths are connected to the terminal node at last .. 


Approch - Topological Kahn's (BFS)-
Intution- we can just reverse the graph by reversing adj matrix and do topo and will get all safe nodes..

TC- O(vlogv)
SC- O(V)

Code-
 */

 
// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

       List<Integer>ans=new ArrayList<>();
       
       
       List<List<Integer>>adjRev=new ArrayList<>();
       
       for(int i=0; i<V; i++){
           
           adjRev.add(new ArrayList<>());
       }
       
       int[]InDegree=new int[V];
       
       for(int i=0; i<V; i++){
           
           for(int childs : adj.get(i)){
               
               adjRev.get(childs).add(i);
               
               InDegree[i]++;
           }
       }
       
       
       Queue<Integer>q=new LinkedList<>();
       
       for(int i=0; i<V; i++){
           
           if(InDegree[i]==0){
               
               q.add(i);
           }
       }
       
       
       while(!q.isEmpty()){
           
           int front=q.remove();
           ans.add(front);
           
           for(int childs : adjRev.get(front)){
               
               InDegree[childs]--;
               
               if(InDegree[childs]==0){
                   
                   q.add(childs);
               }
           }
           
           
       }
       
       
       Collections.sort(ans);
       
    //   System.out.println(adj);
       
       return ans;
    }
}

/*
  Important Note- 
      1. whenever safe state or terminal nodes are discussed .. we can go for topological or reverse graph and can find safe sattes and paths..

      Errors-
       1. No Error
 */


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

Approch - Kahn's Algorithm (BFS)-
Intution- Basically we have to keep first those nodes which do not have incoming edge and we do  repreatdly by indegree array..

code-
*/


class Solution
{

    int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
       
 
   // By BFS Kahn's Algorithm-
    
    int[]InDegree=new int[V];
    int[]ans=new int[V];
    

     for(int i=0; i<V; i++){
         
         for(int child : adj.get(i)){
             
             InDegree[child]+=1;
         }
     }    
       
     
     Queue<Integer>q=new LinkedList<>();
     
     for(int i=0; i<V; i++){
         
         if(InDegree[i]==0){
             
             q.add(i);
         }
     }
       
       
       int k=0;
     while(!q.isEmpty()){
         
         int front=q.remove();
         ans[k]=front;
         k++;
         
         ArrayList<Integer>childArray=adj.get(front);
         
         for(int childs : childArray){
             
             InDegree[childs]-=1;
             
             if(InDegree[childs]==0){
                 
                 q.add(childs);
             }
         }
         
     }  
       
       return ans;

    }
}

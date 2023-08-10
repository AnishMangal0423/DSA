import java.util.*;
/*
 
Q. 
Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
 

Example 1:
Input: 
Output: 1
Explanation: The given graph can be colored 
in two colors so, it is a bipartite graph.

Example 2:
Input:
Output: 0
Explanation: The given graph cannot be colored 
in two colors such that color of adjacent 
vertices differs. 

Problem Statement- Same as flowers problem , difference is that here we have only 2 colours-
refer flower problem in arsh goyal folder-

Intersting - Some Errors i have made .. made my life complex in errors 🔥
Code-
 */

 class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
    
    
    int[]colour=new int[V];
    Queue<Integer>q=new LinkedList<>();
    
    for(int i=0; i<V; i++){
        
        if(colour[i]==0){
            
            colour[i]=1;
            q.add(i);
        
        
        
        while(!q.isEmpty()){
            
            int parentNode=q.remove();
            
            ArrayList<Integer>childArray=adj.get(parentNode);
            
            for(int child : childArray){
                
                if(colour[child]==0){
                    
                    colour[child]=colour[parentNode]+1;
                   
                    q.add(child);
                }
                
                if(colour[child] > 2){
                    
                    colour[child]%=2;
                }

                 else if(colour[child]==colour[parentNode]){
                    
                    return false;
                }
                
               
                
            }
        }
        }
        
    }
    
    return true;
    }
}


/*
 Note- 
   1. Logic of Flower Question is Important.
  
  Errors-
    1. Fucked Mistake that i have made was i was using a bad loop for()  
        

           Queue<Integer>q=new LinkedList<>();
    
    for(int parent : colour){
        if(colour[i]==0){

      this will oviously give errors becuase we have to go to nodes .. rather then their changing values..

      use -

      for(int i=0; i<V; i++){

        ..... code
      }

 */

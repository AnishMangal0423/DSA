package Graphs;
import java.util.*;

/*
 
Q5. Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
     0 : Empty cell
     1 : Cells have fresh oranges 
     2 : Cells have rotten oranges

     We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 

     Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
     Output: 1
     Explanation: The grid is-
       0 1 2
       0 1 2
       2 1 1
     Oranges at positions (0,2), (1,2), (2,0)
     will rot oranges at (0,1), (1,1), (2,2) and 
     (2,1) in unit time.


---------------------------------------------------------------------------------------------------------------------------------------
 Soln-

    Approch-1 : Brute Force-
        Intution- Whatever question is saying we can make all oranges to roat and use the loop for maximum Math.max(m, n) times if any orange will remain fresh then it will be -1 else total time should be ans.

        TC- O(M*N*M) or O(N*N*M) == O(N*3) Not so Good. because we are checking grid for m or n iterations.
        SC- O(N*M)
      
--------------------------------------------------------------------------------------------------------------------------------------       
   Approch-2 : BFS Approch-
    Intution- Graph comes in mind by 2 ways - first if we have to make change after some time on every level or second is if we want to commulate changes to a group and then another group out of many numbers. so bfs came in picture because it will make less time to roat then dfs.

   Code-

 */

 
class pair{
    
    int i,j;
    
    pair(int i , int j){
        this.i=i;
        this.j=j;
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    
    
    public int orangesRotting(int[][] grid)
    {
        int m= grid.length;
        int n= grid[0].length;
        
        boolean[][]visited=new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j]==0){
                    visited[i][j]=true;
                }
            }
        }
        
        
        
        Queue<pair> q = new LinkedList<>();
        
        for(int i=0; i<m; i++){
            
            for(int j=0; j<n; j++){
                
                if(grid[i][j]==2 && visited[i][j]==false){
                    
                    q.add(new pair(i , j));
                    visited[i][j]=true;
                }
            }
        }
       
       
       int count=0;
       int length=q.size()+1;
       
       while(q.size()!=0){
           
           pair front = q.remove();
           length--;
           
           if(length ==0){
            //   System.out.println(count+" "+front.i+" "+front.j);
               count++;
               length=q.size()+1;
           }
           
           
           int a= front.i;
           int b=front.j;
           
           // case 1- Left
           
           if(b-1 >=0 && visited[a][b-1]==false && grid[a][b-1]==1){
               visited[a][b-1]=true;
               q.add(new pair(a , b-1));
               grid[a][b-1]=2;
               
           }
           
           
           // case 2- right
           
                      
           if(b+1 <n && visited[a][b+1]==false && grid[a][b+1]==1){
               visited[a][b+1]=true;
               q.add(new pair(a , b+1));
                grid[a][b+1]=2;
               
           }
           
           // case 3- upper-
                      
           if(a-1 >=0 && visited[a-1][b]==false && grid[a-1][b]==1){
               visited[a-1][b]=true;
               q.add(new pair(a-1 , b));
                grid[a-1][b]=2;
           }
           
           // case4 - lower
           
                      
           if(a+1 < m && visited[a+1][b]==false && grid[a+1][b]==1){
               visited[a+1][b]=true;
               q.add(new pair(a+1 , b));
                grid[a+1][b]=2;
           }
           
           
           
       }
       
       
       for(int i=0; i<m; i++){
           
           for(int j=0; j<n; j++){
               
              if(grid[i][j]==1){
                   
                  return -1;
              }
            
            // System.out.print(grid[i][j]+", ");
           }
        //   System.out.println(" ");
       }
       
       return count;
    }
}

/*

```
  Note-
 *    1. See how to make pair class and use it.
 *    2. Use of Bfs is done whenver we have to make changes on levels.
 *    3. Use of DFS when we have to make changes to a cluster/group of many/ depth , out of many eleemnts.
 
 ```
 */
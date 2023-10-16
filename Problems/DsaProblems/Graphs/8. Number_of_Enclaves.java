/*
   
Q. You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

   A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

   Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

   Example 1:

   Input:
   grid[][] = {{0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}}
    Output:
     3
   Explanation:
  0 0 0 0
  1 0 1 0
  0 1 1 0
  0 0 0 0
The highlighted cells represents the land cells.

  Problem Statement- Basically question is saying that if any land is present on boundary then that island land is ok otherwise we have to make answers of all remaining 1's-

  Intution- USE DFS to go for every island-

  Code-

 */

 
// User function Template for Java

class Solution {

    void dfs(boolean[][]visited , int[][]grid, int i , int j , int rows, int cols){
        
        visited[i][j]=true;
     
        int[][]cord={{0 , -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        for(int[]pos : cord){
            
            int row=i+pos[0];
            int col=j+pos[1];
            
            if(row >=0 && row <rows && col >=0 && col < cols && visited[row][col]==false && grid[row][col]==1){
                     dfs(visited , grid , row, col , rows , cols);
            }
            
        }
        
       
    }

    int numberOfEnclaves(int[][] grid) {

    int m=grid.length;
    int n=grid[0].length;
    
    boolean[][]visited=new boolean[m][n];
    
   for(int j=0; j<n; j++){
       
       if(visited[0][j]==false && grid[0][j]==1){
           
           dfs(visited , grid ,0 , j, m , n);
        
       }
       
       if(visited[m-1][j]==false && grid[m-1][j]==1){
              dfs(visited , grid ,m-1 , j , m , n);
       }
   }
   
   for(int j=1; j<m-1; j++){
       
       if(visited[j][0]==false && grid[j][0]==1){
           
           dfs(visited , grid , j , 0 , m, n);
       }
       
       if(visited[j][n-1]==false && grid[j][n-1]==1){
           
              dfs(visited , grid ,j, n-1 , m , n);
       }
      
   }
   int count=0;
   
   for(int i=0; i<m; i++){
       
       for(int j=0; j<n; j++){
           
           if(visited[i][j]==false && grid[i][j]==1){
               
               count++;
           }
       }
   }
   return count;
    }
}
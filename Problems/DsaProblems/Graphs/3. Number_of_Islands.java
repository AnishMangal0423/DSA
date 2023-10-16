// package Graphs;
// import java.util.*;

/*
Q3. Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's  (Land). Find the number of islands.

    Note: An island is either surrounded by water or boundary of grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

--------------------------------------------------------------------------------------------------------------------------------------

Soln-
   Approch-1 : DFS-
 
 Code-

 */

 class Solution {
    // Function to find the number of islands.
    
    int count=0;
      
    public void dfs(char[][] grid , boolean[][]visited , int i , int j, int m , int n){
        
        visited[i][j]=true;
        
        // Now Calling recursion in all 8 Directions-
        
        // Right-
        
        if(j+1 < n && visited[i][j+1]==false && grid[i][j+1]=='1'){
        
            dfs(grid , visited , i , j+1 , m ,n);
        }
        
        // left-
          
        if(j-1 >=0 && visited[i][j-1]==false && grid[i][j-1]=='1'){
        
            dfs(grid , visited , i , j-1 , m ,n);
        }
        
        // upper-
        
          
        if(i-1 >=0 && visited[i-1][j]==false && grid[i-1][j]=='1'){
        
            dfs(grid , visited , i-1 , j , m ,n);
        }
        
        // lower-
          
        if(i+1 < m  && visited[i+1][j]==false && grid[i+1][j]=='1'){
        
            dfs(grid , visited , i+1 , j , m ,n);
        }
        
        // left-diag-
        
          
        if(i-1 >=0 && j-1>=0 && visited[i-1][j-1]==false && grid[i-1][j-1]=='1'){
        
            dfs(grid , visited , i-1 , j-1 , m ,n);
        }
        
        // right-diag-
        
          
        if(i-1>=0 && j+1 <n && visited[i-1][j+1]==false && grid[i-1][j+1]=='1'){
        
            dfs(grid , visited , i-1 , j+1 , m ,n);
        }
        
        // left-diag-lower
          
        if(i+1<m && j-1 >=0  && visited[i+1][j-1]==false && grid[i+1][j-1]=='1'){
        
            dfs(grid , visited , i+1 , j-1 , m ,n);
        }
        
        // right diag-lower-
        
          
        if(i+1<m && j+1 <n && visited[i+1][j+1]==false && grid[i+1][j+1]=='1'){
        
            dfs(grid , visited , i+1 , j+1 , m ,n);
        }
    } 
    
    public int numIslands(char[][] grid) {
        // DFS Approch-
        
        int m=grid.length;
        int n= grid[0].length;
        
        boolean[][]visited=new boolean[m][n];
        
        for(int i=0; i<m; i++){
            
            for(int j=0; j<n; j++){
                
                
                if(visited[i][j]==false && grid[i][j]=='1'){
                    
                    count++;
                    
                    dfs(grid , visited , i , j,m,n);
                }
            }
        }
        return count;
    }
}

/*
 
I Know that there can be more Effeciency also for that Redunandancy will make it on another day-

```
Note-
    1. Always whenever we have to find certain groups/clusters in a matrix/or in garbages we have to think about DFS- DEPTH.

 */





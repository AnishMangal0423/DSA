import java.util.*;
/*
 
Q-
    Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
     The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1. There should be atleast one 1 in the grid.

     Input: grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}}
     Output: {{1,0,0,1},{0,0,1,1},{1,1,0,0}}
     Explanation: The grid is-
      0 1 1 0 
      1 1 0 0 
      0 0 1 1 
      0's at (0,0), (0,3), (1,2), (1,3), (2,0) and
      (2,1) are at a distance of 1 from 1's at (0,1),
      (0,2), (0,2), (2,3), (1,0) and (1,1)

Soln-  Problem Statement- Basically we have to calculate the distance of every 0 grid from nearst 1 cell and store those all results 
                           in grid so these is like a rotten orange problem.
                           
  Approch-1 : BFS-
     Intution- Because to find minimum we will go level wise , why to go every 1 and do depth search so , we will                    
                 first will aways first store the targeted element like - fresh oranges to make rotten then rotten elements are target so here 1 will be target because it is rooten/1 it will rott others as well .... 

               will first make ans matrix with -1 and increse as level incerases-
     CODE-

 */

class Pair{
    int a;
    int b;
    int c;
    
    Pair(int a, int b, int level){
        
        this.a=a;
        this.b=b;
        c=level;
        
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    
    public void bfs(boolean[][]visited , int[][]grid ,Queue<Pair>help,int i , int j , int m , int n, int level){
        
        int[][] pos={{0 , -1}, {-1, 0}, {0 ,1 }, {1, 0}};
        
        for(int[]cor: pos){
            
            int row=i+cor[0];
            int col=j+cor[1];
            
            if(row>=0 && row<m && col>=0 && col<n && visited[row][col]==false){
                
                help.add(new Pair(row , col, level+1));
                
                visited[row][col]=true;
                
                grid[row][col]=1;
            }
            
        }
        
    }
    
    public int[][] nearest(int[][] grid)
    {
        
        // Can be done in BFS and DFS Both , doing By bfs because of level order and minumum distance-
        
        int m=grid.length;
        int n=grid[0].length;
        
        boolean[][]visited=new boolean[m][n];
        
        int[][]ans=new int[m][n];

        Queue<Pair>help=new LinkedList<>();
        
        for(int i=0; i<m; i++){
    
           Arrays.fill(ans[i], -1);
           
            for(int j=0; j<n; j++){
                
                if(visited[i][j]==false && grid[i][j]==1){
                    
                    help.add(new Pair(i , j, 0));
                    
                    visited[i][j]=true;
                }
            }
        }
        
        
        
        while(!help.isEmpty()){
            
            Pair front= help.remove();
            
            int x = front.a;
            int y= front.b;
            int level= front.c;
            
            ans[x][y]+=level+1;
           
            
            bfs(visited , grid ,help, x , y , m , n, level);
        }
        
        return ans;
    }
}

/*
   Important Note-
 *       1. Always Remember whenever we have to find nearst distance of elemnets from some target in a grid then bfs works. or level   work.
 */
import java.util.*;
/*

Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
Example 1:
Input:
grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}
Output:
1
Explanation:
grid[][] = {{1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {0, 0, 0, 1, 1}, 
            {0, 0, 0, 1, 1}}
Same colored islands are equal.
We have 2 equal islands, so we 
have only 1 distinct island.
Example 2:
Input:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Output:
3
Explanation:
grid[][] = {{1, 1, 0, 1, 1}, 
            {1, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 1}, 
            {1, 1, 0, 1, 1}}
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.
 
Soln- 

Problem Statement-
            We have many Islands in a sea we have to tell that count of distinct islands.

  
 Approch-1 : DFS-
    Inutition - Will go to evey island and change it to normal coordinate form and store in Hashset to give distinct islands-
    
    TC- O(N*M)
    SC- O(N*M)+o(N+M)

   Code-   
*/


class Pair{
    
    int x;
    int y;
    
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    int a, b;
    
    
 String toString(int a , int b){
     
     return "("+a+b+")";
 }

    
    void dfs(int[][]grid, boolean[][]visited, int i, int j, int i0, int j0, ArrayList<String>islands){
        
        visited[i][j]=true;
        islands.add(toString(i-i0, j-j0));
        
        // System.out.println(i+" , "+j);
        
    //       for(Pair b : islands){
           
    //       System.out.print("x "+b.x+" y "+b.y+" ,, ");
    //   }
    //      System.out.println(" ");
        
        int [][]pos={{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        for(int[]cor: pos){
            
            int row=i+cor[0];
            int col=j+cor[1];
            
            if(row >=0 && row<a && col>=0 && col<b && visited[row][col]==false && grid[row][col]==1){
            dfs(grid, visited, row, col, i0, j0, islands);
            }
            
        }
    }
    

    int countDistinctIslands(int[][] grid) {
       
          a=grid.length;
          b= grid[0].length;
        Set<ArrayList<String>>ans=new HashSet<>();
        //  System.out.println(grid[0][0]);
        
        
        boolean[][]visited=new boolean[a][b];
        
        for(int i=0; i<a; i++){
            
            for(int j=0; j<b; j++){
                
                
                if(visited[i][j]==false && grid[i][j]==1){
                    //  System.out.println(" hii");
                    
                    ArrayList<String>islands =new ArrayList<>();
                      
                    dfs(grid , visited , i , j,i, j, islands);
                    
                    
                    ans.add(islands);
                }
            }
        }
        
        // for(int i=0; i<a; i++){
        //     for(int j=0; j<b;j++){
                
        //         System.out.print(visited[i][j]+" ,");
        //     }
        //     System.out.println(" ");
//         // }
        
//   for(ArrayList<Pair>a : ans){
       
//       for(Pair b : a){
           
//           System.out.print("x "+b.x+" y "+b.y+" ,, ");
//       }
       
//              System.out.println(" ");
//   }
      
        // System.out.println(ans); 
       return ans.size();
    }
}


/*
  Note-
    
    1. Logic is Simple.
    
    Errors-
      1. Hashset will  not be able to compare arraylist which have pairs .. so we have to convert those pairs in strings with inbuilt function toString and then put those arraylist in set.
 */
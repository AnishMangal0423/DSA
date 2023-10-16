import java.util.*;
/*
 Qn- 
 Given an m x n matrix, return all elements of the matrix in spiral order.

 Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 
Problem Statement- Statement is clear we have to find the spiral order traversal for the given matrixes-

 Approch-1 : Using DFS-
  Error- It will not work because it will not be spiral.

  Approch-2 : Using 4 loops and make code very edge casy and Redundant-
  Error- Very Bad Approch.

  Approch-3: Direction Array & Visited concept-
  Intution- AS we will make direction array and first will move from 0,0 and give dirn to it and whenever pointer will go beyond boundry then update dirn and when it go to visited grid then also change dirn.
  it will be good for saving us from Redundancy and clean code also--

    TC- O(M*N)
    SC- O(1)

CODE-
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
    int i=0, j=0, rows=matrix.length, cols=matrix[0].length, dir=0;
    int[][]coordinates={{0, 1}, {1, 0}, {0 , -1}, {-1 , 0}};
    List<Integer>ans=new ArrayList<>();

    while(ans.size()< rows*cols){

        ans.add(matrix[i][j]);
        matrix[i][j]=1000;

        int xDash=i+coordinates[dir][0];
        int yDash=j+coordinates[dir][1];

        if(xDash >=0 && xDash<rows && yDash>=0 && yDash<cols && matrix[xDash][yDash]!=1000){

            i=xDash;
            j=yDash;
        }

        else{

            dir=(dir+1)%4;
               xDash=i+coordinates[dir][0];
               yDash=j+coordinates[dir][1];   
                  i=xDash;
                  j=yDash;

        }

    }

return ans;
    }
}

/* cAN ALSO MAKE IT GOOD BY REMOVING ABOVE REDUNDANCY */
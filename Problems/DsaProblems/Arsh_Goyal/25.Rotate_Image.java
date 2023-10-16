/*
 Qn-
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 
Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

Problem Statement- We Have given a Image and we have to rotate it by 90 degree.


Approch-1 : Brute Force-
Intution- Here we will make a seprate matrix and store the result f every matrix ..

Approch-2 : Spiral Matrix Approch-
Intutuion- The Intution of this Approch is that we will use a pointer that will move via direction matrix and follow spiral path as we have done in our spiral qn and store all values in queue and then we will dequeue the elements and store in 90 degree rotated fashion.

To Decrese the visited array storay in first spiral traversal we will make visited elements to be 1000 and in 2nd traversal we will store the values and 1000 will help us to move the pointer in right direction.
------------------------------------------------------------------------------------------------------------------------------------------------

Approch-3 : Transpose Approch-
Intution - Basically there is not any particular intuion of doing these questions only method of these approches is pattern matching u have to write coordinates and map them to find approch-
always remeber that transpose can also help in these situations.

TC- O(N^2)
SC-O(1)

Code-
*/

class Solution {


   public void Swap1(int[][]matrix , int i, int j){
       int a=matrix[i][j];
       matrix[i][j]=matrix[j][i];
       matrix[j][i]=a;
   }

   public void Swap2(int[][]matrix , int i, int j){
        int n=matrix.length;
       int a=matrix[i][j];
       matrix[i][j]=matrix[i][n-j-1];
       matrix[i][n-j-1]=a;
   }

    public void Transpose(int[][]matrix){

        int n=matrix.length;

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){

                Swap1(matrix, i, j);
            }
        }
    }

    public void Reverse(int[][]matrix){
   
        int n=matrix.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){

         Swap2(matrix, i, j);
        }

    }
}
    public void rotate(int[][] matrix) {
      
       Transpose(matrix);
       Reverse(matrix);
 
    }
}
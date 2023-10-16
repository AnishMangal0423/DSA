// import java.util.*;
package POTD_LeetCode;

import java.util.*;
/*
 Qn-
   Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
   In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]
 

Constraints:
0 <= rowIndex <= 33
 
Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?


Problem Statement- We have given an Pascal Traingle and summary is that we have to return an arrayList corrosponding to rowIndex.
 
Approch-1 : Brute Force-
   We will go every row store it's value and calculate the next value and point to another row-

   Tc- O(N^2)
   SC-O(N)


Approch-2 : Combiantion Approch-
Intution - As we can see that every row in pascal triangle is just bionomial cofficient and we can calculate it 
     
                      0C0
                    1C0  1C1
                 2C0   2C1  2C2
               3C0  3C1  3C2  3C3
               
               so we can Calulate it .. now the intersting point is to calculate combination of a number as (nCr)

               TC-o(N^2)
               SC-O(N)


            Code-  

 */

  class Solution {

    public long Combination(int n, int r){

        // Calculating nCr By Smart Formula ..
        long result=1;

        for(int i=0; i< r; i++) result=result*(n-i)/(i+1);

        return result;
        
    }
    public List<Integer> getRow(int rowIndex) {
        
        // Approch -1 : Space Optimized Approch- TC- O(N^2) and SC-O(N)


//         ArrayList<Integer>prev=new ArrayList<>();
//         prev.add(1);

//         for(int i=1; i<=rowIndex; i++){

//         ArrayList<Integer>current=new ArrayList<>();
//         current.add(1);
//             for(int j=0; j<prev.size()-1; j++){

//                 current.add(prev.get(j)+prev.get(j+1));

//             }

//             current.add(1);
//             prev=current;
//         }
// return prev;


    // Approch-2 : Time and Space Optimized Approch - TC-O(N) and SC-O(N)
     ArrayList<Integer>ans=new ArrayList<>();
     
     for(int i=0; i<=rowIndex; i++) ans.add((int)Combination(rowIndex,i));
     
     return ans;

    }
}


/*
 * Main Use -
 *     1. To Laern How to Calculate nCr in O(N) time-
 *     2. It is used to calculate Bionomial cofficients.
 *     3. Used in computers area 
 *
 */

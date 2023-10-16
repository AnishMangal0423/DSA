/*
 Qn-
You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.

Example 1:
Input: n = 12, k = 3
Output: 3
Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.

Example 2:
Input: n = 7, k = 2
Output: 7
Explanation: Factors list is [1, 7], the 2nd factor is 7.

Example 3:
Input: n = 4, k = 4
Output: -1
Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
 
Constraints:
1 <= k <= n <= 1000
 
Follow up:
Could you solve this problem in less than O(n) complexity?

Problem Statement- We have given a number and kth position of factor .. if we will be able to find kth factor then ok else -1 will be our ans.

Approch-1 : Better Soln-
  Tc-O(N/2)
  Sc-o(1)
------------------------------------------------------------------------------------------------------------------------------------------------


Approch-2 : Square Root(Optimized)
Intution - Main Intution behind this approch is that factors of a number is always made up of two numbers (i, n/i) as pairs so after root n there is no need to check just do twice 

Edge Case-
but always check for perfect square because it will make i== n/i and will count twice so i handled it in a very good manner see it.. 

In first turen i go to tat number-1 and in next turn i add it.

TC - O(2 root N)
SC - O(1)

*/

class Solution {
    public int kthFactor(int n, int k) {
        
 // Going Loop       
    for(int i=1; i< Math.sqrt(n); i++){

        if(n%i==0){
           if(k==1) return i;
               k--; 
        }
    }

// Back Loop
   for(int i=(int)Math.sqrt(n); i>=1; i--){

       if(n%(n/i)==0){
           if(k==1) return n/i;
               k--;
       }
    }

return -1;

    }
}



/*
 * 
 * Lessons-
 *    1. if n is not perfect square then no of factors is 2 Root n
 *    2. If n is perfect Square then no of factors is 2 Root n -1 
 */
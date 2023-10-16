import java.util.*;
/*
 Qn-
 You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

Example 1:
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

Example 2:
Input: nums = [5,6,7,8,9], x = 4
Output: -1

Example 3:
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 
Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109

------------------------------------------------------------------------------------------------------------------------------------------

Problem Statement- we have given an array of numbers and we have to calcuate the minimum numbers to intergers we remove from array such that on subtracting it from number x will turn to 0


Approch-1 : Brute force ( Dp solution )-
Observation-  1. when we have given an array then we will try to use dfferent ways to remove last or first element but that will give 2^n or o(n^2) solution but here space will get overflow..
Not a good approch for this 👎

------------------------------------------------------------------------------------------------------------------------------------------


Approch-2: Smart Approch (Optimized Solution )-
Observation-
          1. what about we find the longest subarray whose sum is totalsum-x .. think about it ..... 
          2. This question is just the variation of subarray max .. and aaded some elements at the beginneing and end and framed the quesion to just remove them..


          TC-O(N)
          SC-O(N)

          Code-
*/

class Solution {
    public int minOperations(int[] nums, int x) {
 
     int n=nums.length;
     int[]prefixArray=new int[n]; 
     HashMap<Integer, Integer>map=new HashMap<>();

      prefixArray[0]=nums[0];
     for(int i=1; i<n; i++){
         prefixArray[i]=prefixArray[i-1]+nums[i];
     }

     int target=prefixArray[n-1]-x;
     int maxi=0;

     if(target < 0) return -1;

     else if(target == 0 ) return n;

     else{

         for(int i=0; i<n; i++){

            if(prefixArray[i]==target){
              maxi=Math.max(maxi, i+1);
            } 

            else{
             if(map.containsKey(prefixArray[i]-target)==true){
                 maxi=Math.max(maxi, i-map.get(prefixArray[i]-target));
             }
            }

             map.put(prefixArray[i], i);
         }
     }
     
     return maxi==0 ? -1 : n-maxi;
    }
}


/*
Learnings-
      1. Whenever there is any removing of elements from start or end like a circular array /        not direct to middle of array then we can use the concept of subarray .. 

      2. using Hashmap and prefix sum is good approch..

*/
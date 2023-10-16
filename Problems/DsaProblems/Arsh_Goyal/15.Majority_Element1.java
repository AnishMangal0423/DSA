/*
 Qn-
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 
Follow-up: Could you solve the problem in linear time and in O(1) space?

Problem Statement- Question is pretty forward and straight we have given an array and we have to find an element that occures more than n/2 times .. it can also be n/k time as of qn next..

Another Brute force is ok-


Approch - Optimized-(Moore votting Algrithm)-
Intution - The main Intution of Moore Algorithm is just Balancing the numbers with another -and if any number will exceed then there can be chances that it can be ans or check it by one complete traversal.

Explanation- 

   Step-1 ::   Try to understand this problem with the help of graphical scenario.. that all things get balanced and in last one number will        increase it count and will say i am more then we will check it by traversing an array again

   Step-2 :: so we can use the counter for balancings-
   Step-3 :: if those are for more like k>=2 then we will make counters according to it.

   Code-

*/

class Solution {
    public int majorityElement(int[] nums) {
        

      int count=0;
      int element=Integer.MAX_VALUE;

      for(int i=0; i<nums.length; i++){

          if(count==0){
              count=1;
              element=nums[i];
          }

         else if(element!=nums[i]){
              count--;
         }

         else{

             count++;
         }
      }

  return element;


    }
}
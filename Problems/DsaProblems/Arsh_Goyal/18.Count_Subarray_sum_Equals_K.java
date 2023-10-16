import java.util.*;
/*
Qn-
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 
Constraints:
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

Problem Statement- Problem is straight forward we have given an array which contains both positive and negative number..and we have to calculate the number of subarrays whose sum is equal to k.

Approch-1 : Brute force(All Subarrays)
Approch-2: Prefix Sum-
Intution - 
   Step-1: Since Number is given as positive and Negative Both we cannot go for Sliding window , two pointers approch , we have to use prefix sum     technique.

   Logic Part-
     1. first of all we take a strip of sum x then we will check if x-k exist in hashmap with certain values of count then that number of subarrays will define our answer..

     TC- O(N)
     SC- O(N)

 Code-    
*/

class Solution {
    public int subarraySum(int[] nums, int k) {

  // Using the Approch of Prefix Sum-
     
     int prefix_sum=0;
     int count=0;

    HashMap<Integer , Integer>map=new HashMap<>();
    map.put(0, 1);
   
    for(int i=0; i<nums.length; i++){
  
     prefix_sum+=nums[i];
     int val=map.getOrDefault(prefix_sum , 0);

     if(map.containsKey(prefix_sum-k)){

         count+=map.get(prefix_sum-k);
     }  

      map.put(prefix_sum , val+1);

    }

    return count;
    }
}


/*
 Lesson-
    1. Whenever we have to find subarray to sum k for negative and positive numbers we will use hashMap .
    2. If only positive number is there only then we can use two-pointer sliding window.
 */
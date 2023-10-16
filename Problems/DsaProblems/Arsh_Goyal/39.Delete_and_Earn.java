import java.util.*;
/*
Qn- 
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

Example 1:
Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.

Example 2:
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
 
Constraints:
1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 10^4


Problem Statement- We have given some elements in an array and when we delete any element from array then we got the arr[i] number of points and we have to maximize the points .. so now we will try to delete all the elements but in real .. there is a condition that on deleting arr[i] , arr[i]-1,arr[i]+1 will automatically deleted and you will not got their points..

------------------------------------------------------------------------------------------------------------------------------------------

Approch-1 : Dp solution( optimized )-
Observation-
           1. there is one hack that we calculate for every index and maximum point will be our ans.
           2. So insted of seeing to all the numbers and their maximums .. just only focus on 1 element how you will calculate then it will be easy to calculate for others.
           3. so for eg -[1,2,3,3,4] taking in the form of index was challenging just do for 1st index and make it generalize for i indexes then ..

        TC-O(N)
        SC-O(N)

           Code-

 */

 class Solution {

    public int Delete(int[]nums, int index,int[]dp){

       if(index >= nums.length){
           return 0;
       }
          
          if(dp[index]!=-1){
              return dp[index];
          }

       int i=index+1;
       int currsum=nums[index];


       // if duplicates of itself-
       while(i<nums.length && nums[i]==nums[i-1]){

           currsum+=nums[i];
           i++;
       }

       // arr+1 removals-
       while(i<nums.length && nums[i]==nums[index]+1){
           i++;
       }

        return dp[index]=Math.max(currsum + Delete(nums, i,dp) , Delete(nums, index+1,dp));
    }

    public int deleteAndEarn(int[] nums) {
        
        Arrays.sort(nums);
        int[]dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return Delete(nums, 0,dp);        
    }
}
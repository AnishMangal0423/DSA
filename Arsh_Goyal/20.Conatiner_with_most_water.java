/*
Qn-
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 
Constraints:
n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4

Problem Statement- We have given a Sample or Apparatus which contains some pillars and in those pillars .. and those pillars with other pillars forms a containers that contains water trapped in it .. so we have to find the maximum amount of water that can be trapped in ihe container..

Approch-1 : Brute Force-
         TC-O(N^2)
         SC-O(1)

Approch-2 : Two Pointers Approch-
Intution- Main Intution behind using two pointers is that we are basically working on subarrays and their first and last element comparision so we can go for two pointers approch to reeject some subarrays directly.

 Main Hack - 
      if there is any pillar which has smaller height on left or right we will increase its pointer because at that time it is the maximum area that it can make otherwise  water will split off and index factor will also decrese.

     TC-O(N)
     SC-O(1)

  Code-   
*/

class Solution {
    public int maxArea(int[] height) {
    
       int N=height.length;
       int left=0;
       int right=N-1;

       int maxi=0;
       while(left < right){

         int area=Math.min(height[left] , height[right])*(right-left);
          maxi=Math.max(maxi ,area);
        if(height[left] <= height[right]){
             left++;
        }
        else{
            right--;
        }

       }
return maxi;
    }
}


/*
 Note-
   1. if we have subarray type of question .. we can go for 2 pointers approch.
   2. In Greedy Question we can go for 2 pointers as well..
 */
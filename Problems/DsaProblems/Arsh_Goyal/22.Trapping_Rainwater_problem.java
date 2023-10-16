/*
 Qn-
  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

Ans-

Problem Statement- Problem is quite clear we have to find the trapped water between the buildings or blocks.and its area.

Approch-1 : Brute Force-
Intution-  

    1. Basically the main ideology to solve this problem is that we will find the water that can be stored by each building.then we will add up   and get the total water.
 
    2. Now for a building to store some water it is required that it has left and right building that is of height greater then this i th building to store water on it.

    3. Now the point is that left height can be more then right it will also matter .. when u will iterate threw it u will feel good.


  Logic of Brute Force-
    1. We will maintain leftmax and rightmax always initially as 0 and then calulate water for every building and will do total of it.
    
Code-
*/
class Solution {
    public int trap(int[] height) {
        int totalTrappedWater = 0;

        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;

            // Find maximum height to the left of the current bar
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find maximum height to the right of the current bar
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int trappedWaterHeight = Math.min(leftMax, rightMax) - height[i];
            if (trappedWaterHeight > 0) {
                totalTrappedWater += trappedWaterHeight;
            }
        }

        return totalTrappedWater;
    }
}


/*

----------------------------------------------------------------------------------------------------------------------------------------------
Approch-2 : Better Approch(Prefix and Suffix Max)-
Intution- Now to avoid for finding the next greater height we will maintain prefix and suffix max arrays to handle the left and right max and calculate the areas according to it.

  Eg- [0,1,0,2,1,0,1,3,2,1,2,1]
  Prefixmaxes-[0, 1, 1, 2, 2, 2, 2,2,3,3,3,3,3]
  SuffixMaxes-[3,3,3,3,3,3,3,3,3,2,2,2,1]

  now for every index we have leftmax and rightmax then we can calculate the water trapped by it.

  Tc-o(N)
  sc-o(N)
  ----------------------------------------------------------------------------------------------------------------------------------------------

Approch-3 : Two Pointers Approch(Optimized)
Intution- Now the problem is that we are getting because of getting left and rightmax and traversing the array .. now in this approch also we have to traverse the array but for left max and rightmax we are saying that rightmax exists and will be greater then leftmax so water trapped on that building will be directly leftmax-a[i] and same for right also ..
Because in first case we are saying that l<=r and l++ now it depends on it that it will trap water or update the leftmax (think 1, 0, 2) or(1,2)
same for right- 

so we are decresing the complexity and storing water on the basis of one maxside assuming that opp will always be larger..

Tc-O(N)
SC-O(1)

Code-
 */

 class monkey{
    public int trap(int[] height) {
        
       
         int n= height.length;
         int left=0;
         int right=n-1;
         int leftmax=0;
         int rightmax=0;
         int water=0;
         
     while(left <= right){
   
           if(height[left] <= height[right]){

               if(height[left] >= leftmax) leftmax= height[left];

               else water+=leftmax-height[left];

               left++;
           }

           else{

               if(height[right] >= rightmax) rightmax=height[right];

               else water+=rightmax-height[right];

               right--;
           }
        }

          return water;
    }
}
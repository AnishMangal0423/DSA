import java.util.*;
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


Problem Statement- Same as previous majority element .. change is that now we have to calculate it for k==3

Approch- Optimized (Moore Vooting Algorithm)-
Intution-
   1. Moore main principle is to Balancing the elements.
   2. In k==3 we can say that at max we can find two elements as our answer.so we will use two counters.
   3. At Last it is very neccesary that we check for counter1 and counter2 elemnts to traverse array again .. Think in Graphical manner to feel it.-

TC -O(2N)
SC- O(1)

Code-
 */

 class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer>ans=new ArrayList<>();

        int len= nums.length;
        int count1=0;
        int element1=Integer.MAX_VALUE;
        int count2=0;
        int element2=Integer.MAX_VALUE;

        for(int i=0; i<len; i++){

             if(count1==0 && nums[i]!=element2){

                 count1=1;
                 element1=nums[i];
             }

            else if(count2==0 && nums[i]!=element1){

                count2=1;
                element2=nums[i];
            }

            else if(nums[i]==element1) count1++;
            else if(nums[i]==element2) count2++;

            else{

                count1--;
                count2--;
            }
        }

       int cnt1=0, cnt2=0;
    for(int i=0; i<len; i++){

        if(nums[i]==element1) cnt1++;
        else if(nums[i]==element2) cnt2++;
    }

   if(cnt1 > len/3) ans.add(element1);
   if(cnt2 > len/3) ans.add(element2);

   return ans;

    }
}


/*
 Important -
       
    Edge Cases-
       1. check if we are not using any counter value of one counter to another because it will perform clashes- as you can see in code.
 */
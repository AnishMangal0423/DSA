/*
 Qn-

 A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.

 
Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100

Problem Statement- we have given an array and we have to find the next permutation in it .. an array can have N! ways to Rearrange       elements and we have to give the next permutation to it..

Intution - Can we write all Permutation after sorting of array because it will give correct lexographically ordered and check if anyone matching then permutation at index+1 will be our answer..

Approch-1 : Brute Force-
Intution- 
    1. I will write all the permutations and next will be our answer..
    2. Use a visited array and Inclusive and Exclusive Stack . 
    3. Only Call for those iterations that are not visited. in that array...

    Pros- 
       1. We are writing all fundamentals permutations that will solve 100's of Questions.

    Cons-
       1. Space Utilization is very much because in every N! iterations we are taking N length visited array .(In this No inclusion-ex can be done)
       2. Time Complexity will be N!*N .. Not Good. 👎
       
       
       TC- O(N* N!)
       SC- O(N* N!)
   
*/

/*
 Approch-2 : Graphical Analysis(Optimized)
   
   Observation-
        1. we want the next permutation not maximum or higher.
        2. So we want prefix as much as same .
        3. so from end if maximum number is not made we will make till then prefix will be same 
        4. In another terms we say it a dip in array..
            Now Go to Intution-


    Intution -

        Find Dip-
        1. From end we will iterate the array if we find a dip then we observed that from that digit to last we can a nexxt small number instead.
          Eg- 3 2 1 10 9 7 0  --> 10, 9, 7, 0 is already maximum but 1,10,9,7,0 is not maximum we make next element from it.

           
       Swap Next Greater-
        1. Now we want next permutation not maximum then we traverse from last and find next greater from that peak element.
        
       Reverse Remaining Array-
       1. Now after swap to make array next permute basically it will reverse of remaing array becuase it was increasing from end.


      Edge Cases-
        1. 10, 9, 8, 1  --> Here you will not find dip so reverse array will be ans.
        

     TC- O(N)
     SC- O(1)    🥇👍

     Code-
 */
class Solution {

   public void swap(int nums[], int i , int j){

       int store=nums[j];
       nums[j]=nums[i];
       nums[i]=store;
   }

   public void Reverse(int[]nums , int i, int j){
        
         int n=nums.length;
         int mid=(i+n-1)/2;
       for(int k=i; k<=mid; k++){

         swap(nums, k, j);
         j--;
       }
   }

    public void nextPermutation(int[] nums) {
        
       int n=nums.length;
       int ind=-1;

       for(int i=n-2; i>=0; i--){

           if(nums[i] < nums[i+1]){
                ind=i;
                break;
           }
       }

       if(ind == -1) Reverse(nums, 0,n-1);

       else{

           for(int j=n-1; j>ind; j--){

               if(nums[j] > nums[ind]){

                   swap(nums, j , ind);
                   break;
               }
           }

             Reverse(nums , ind+1,n-1);
       }

    }
}
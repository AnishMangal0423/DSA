/*
 Qn-

 Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.


Problem Statement- We have given a set of numbers in an array and we have to make all the subsets-
Subsets- Subsets is like Subsequence which forms on deletion of some elements in an array.

General Intution- in first Click we try to Go for the itrations by Recursion(Rough Recursion) 

Remember: We will start the iteraions from 0 --> N-1 because if we will add from behind then all pairs will be added in reverse order in arrayLists...

Approch-1 : Brute Force ( Rough Recursion )-
Intution- we go to every iteration and add elements to it and when we reach to last index+1 then we will add it to ans array 🥉
    Cons-
       1. First of all wastage is more because we are using memory in every iteration of some arrayList length of max 2^N
       2. Manupulation Part is also somhow tough..

       TC - O(2^N * N)
       SC - O(2^N * N)

    Code-   
*/

// Method-1
// class Solution {

//     public List<List<Integer>> Subsets_rec(int[]nums, int index){

//         List<List<Integer>>ans=new ArrayList<>();

//         if(index < 0){
//             ans.add(new ArrayList<>());
//             return ans;
//         }
//      List<List<Integer>> take=Subsets_rec(nums , index-1);

//         for(List<Integer> child : take){
    
//             ArrayList<Integer>num=new ArrayList<>(child);
//             num.add(nums[index]);
//           ans.add(num);
//         }

//       List<List<Integer>> not_take=Subsets_rec(nums , index-1);

//        ans.addAll(not_take);

//        return ans;

//     }

//     public List<List<Integer>> subsets(int[] nums) {

//           int n=nums.length;
//           return Subsets_rec(nums,n-1);
        
//     }
// }

/*
 -----------------------------------------------------------------------------------------------------------------------------------------

Approch-2 : Bit Manupulation( Memory Efficient)-
Intution- 
      1. Input is less then <64
      2. Take & Non-take is discussed so we devlop all possibilities/mask.
      3. on iteration of all possibilities/mask 1 bits items will be added to bucket. 🥈

      Pros- 
         1. Memory Efficient because we have to not make all arrayLists again-again .

      Cons-   
         1. Same Time complecxity because total masks are 2^N and in every we have to iterate N bit long mask so 
             TC- O(2^N * N)
             SC- O(1)

Code-
 */
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
        
//          int n=nums.length;
//          List<List<Integer>> ans=new ArrayList<>();
//          int total_subsets=(1<<n);

//          for(int mask=0; mask<total_subsets; mask++){

//           List<Integer>subset=new ArrayList<>();
//              for(int i=0; i<n; i++){

//                  if((mask & (1 << i)) !=0){

//                      subset.add(0, nums[i]);
//                  }
//              }

//              ans.add(subset);
//          }

// return ans;
//     }
// }


/*
Approch-3 : Inclusion-Exclusion Recursion ( Optimized )

Intution - In first solution we saw that that we are providing every iteration an arrayList and increasing the space why not make a single arraylist and do inclusion-exclusion depending on index we have reached .... ok 🥇

    Pros- 
        1. We even do not have to iterate over the array because on overflowing it is automatically adding.
        2. Tc improved 
        3. SC Improved

   TC- O(2^N)
   SC- O(N)

  Code- 
 */

 // Method-2
// class Solution {

//      void DFS( List<List<Integer>>ans, ArrayList<Integer>helper, int[]nums, int index){

//            if(index == nums.length){
//                ans.add(new ArrayList<>(helper));
//                return;
//            }

//           helper.add(nums[index]);
//           DFS(ans, helper, nums, index+1);

//           helper.remove(helper.size()-1);
//           DFS(ans, helper, nums, index+1);

//      }

//     public List<List<Integer>> subsets(int[] nums) {
        
//         List<List<Integer>> ans=new ArrayList<>();
//         ArrayList<Integer> helper=new ArrayList<>();

//           DFS(ans , helper, nums, 0);

//          return ans;

//     }
// }
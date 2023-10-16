import java.util.*;
/*
 Qn-
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 
Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 
Constraints:
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40


Problem Statement- we have given a array and a target element and we have to find the all combinations -- 

Identity -> whenever we have given a keyword "All Possible combinations"  ---> Always Go for Backtracking or Recursion. and "minimum/maximum combination" then Go for dp solution.

Approch-1 : BackTrack(Inclusion-Exclusion)
Intution-
      1. We have given a unbounded Knapsnack problem.
      2. But the main cringe is that we have to print the sequences so using dp is not good idea .
      3. backtracking will help . to come up all possible cases.

    TC- O(2^ target)  ->>> in unbounded knapsack problem tc- 2^t because we have target and t places rather then n places and 2 choiches for each.

    Sc- o(k*x) --> K number of subarrays or average length x. 

Code-
*/

class Solution {
    
    List<List<Integer>>ans=new ArrayList<>();

     public void Make_Lists(int[]candidates,ArrayList<Integer>temp, int ind, int target){

         if(target==0){

         ArrayList<Integer>a=new ArrayList<>(temp);
          ans.add(a);  
          return;
         }

         if(ind>=candidates.length) return;

        if(target-candidates[ind]>=0){
            
            temp.add(candidates[ind]);
            Make_Lists(candidates, temp, ind,target-candidates[ind]);
            temp.remove(temp.size()-1);
        }

          Make_Lists(candidates, temp, ind+1, target);
     }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
  
             ArrayList<Integer>temp=new ArrayList<>();
             Make_Lists(candidates, temp, 0 ,target);
               
               return ans;
    }
}


/*
 Notice -->
     1. Always remember that i am passing an temp array in recursion and it is always passing by the refernce so exclusion will also be there.
     2. In variables of number or something like that there is no-refernce so they makes seperate memory.
 */


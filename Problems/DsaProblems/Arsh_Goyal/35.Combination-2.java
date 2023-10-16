/*
 Qn-
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 
Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30


Problem Statement- we have given a duplicates array and we have to do basically bounded knapsack .

Obseravation-
           1. I know that it is bounded Knapsack so i can do code for it..
           2. Main glitch here is that we have given duplicates eg- [2,3,2,5] and target=5 ,, now [2,3] and [3,2],[5] both are making 5 but we have to take only one bcz dup.pairs are not allowed .
           2. Now you will say i will sort it and becomes atlesst of same pairs then it will be become - [2,3],[2,3],[5] now you will say that we will use hashset .. but we will not because it will give tle if we have 100's of input=1 and target=40 beacuse it will be largest tree.

           3. So we have to something now-
               a. hashset.
               b. Brain

               Brain --> After sorting of array it will become --> [2,2,3,5] now we know that only we want to make array with first 2 not with second so we will run the loop after 


*/



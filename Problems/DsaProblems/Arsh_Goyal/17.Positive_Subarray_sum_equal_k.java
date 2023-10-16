import java.util.*;
/*
 Qn-
 Given an unsorted array A of size N that contains only positive integers, find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.
 In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
 Note:- You have to return an ArrayList consisting of two elements left and right. In case no such subarray exists return an array consisting of element -1.

 Example 1:
Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4

Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.

Example 2:
Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= Ai <= 109
0<= S <= 109

Problem Statement- An array of Numbers is Given and we have to calculate the first subarray whose sum is equal to k .

Approch-1 : o(N2) Brute Force.
Approch-2 : Prefix Sum approch.

Approch-3: Two pointer sliding window approch.
Intution- 
    step-1 : sliding window will basically makes the cases according to the subaaray sum comaprision to k .. those which can satify will comes else no .. 

    Logic-
       1. we will keep always left on the element which we can substract in nearfuture .
       2. we will keep second pointer on the elemnet which we will use as to add if sum is less and move it to forward.
       3. will handle the situation of 0 in beggining and in last while loop as well we can also take once.
    
Code-
  */

  class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> ar = new ArrayList<>();
        if(s == 0){
            ar.add(-1);
            return ar;
        }
        int i = 0,j = 1;
        int sum = arr[0];
        while(j < n){
            
            while(j<n && sum < s){
                sum += arr[j];
                j++;
            }
            
            while(i<j && sum > s){
                sum -= arr[i];
                i++;
            }
            
            if(sum == s && i!= j){
                ar.add(i+1);
                ar.add(j);
                break;
            }
        }
        
        if(ar.size() == 0){
            ar.add(-1);
        }
        return ar;
        
    }
}


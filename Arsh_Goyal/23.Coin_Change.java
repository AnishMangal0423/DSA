/*
 Qn-
 You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0
 
Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

Problem Statement- Problem is quite Clear we have a series of coins and a target if we are able to change this target to coins then ok give the minimum number of coins , otherwise give the ans as -1 if not able to change.


Approch-1 : Recursion(2^N)
Approch-2 : Tabulation- 

  TC- O(N*N)
  SC-O(N*N)

Intution - Simple just (concept of take and not take unbounded times and handling of edge cases was just tricky) 

Code-
*/

class Solution {


    public int coinChange(int[] coins, int amount) {

        int n=coins.length;
     int[][]dp=new int[n][amount+1];
   
     for(int i=0; i<=amount; i++){

         if(i % coins[0]==0){
         dp[0][i]=(i/coins[0]);
         }
      else{

          dp[0][i]=Integer.MAX_VALUE;
      }     
     }


     for(int i=1; i<n; i++){

         for(int j=1; j<=amount; j++){

             int not_take=dp[i-1][j];

             int take=Integer.MAX_VALUE;
            if(j-coins[i] >=0){
                if(dp[i][j-coins[i]] != Integer.MAX_VALUE)
                take=1+dp[i][j-coins[i]];
            }

            dp[i][j]=Math.min(not_take , take);

         }
     }

return (dp[n-1][amount] > amount) ? -1 : dp[n-1][amount];
    }
    
}

/*
 Note-
   Errors-
      1. Handling the  edge cases was little tricky because of remaining of value as -1 and we are using the term integer.max  so in returning condition always handle it.
      
      2. in last edge case we have to take that if we are able to change it in coin will return the no of coins .. else will block that branch by max

      3. in checking i was making 1+ Integer.max and it is -Integer.max and giving the wrong ans.. so also handled it..
      
 */
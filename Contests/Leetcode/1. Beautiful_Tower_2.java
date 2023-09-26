package Contests.Leetcode;
import java.util.*;

/*
 Qn-
You are given a 0-indexed array maxHeights of n integers. You are tasked with building n towers in the coordinate line. The ith tower is built at coordinate i and has a height of heights[i]. A configuration of towers is beautiful if the following conditions hold: 1 <= heights[i] <= maxHeights[i] heights is a mountain array. Array heights is a mountain if there exists an index i such that:

For all 0 < j <= i, heights[j - 1] <= heights[j]
For all i <= k < n - 1, heights[k + 1] <= heights[k]
Return the maximum possible sum of heights of a beautiful configuration of towers.

Example 1:
Input: maxHeights = [5,3,4,1,1]
Output: 13
Explanation: One beautiful configuration with a maximum sum is heights = [5,3,3,1,1]. This configuration is beautiful since:
- 1 <= heights[i] <= maxHeights[i]  
- heights is a mountain of peak i = 0.
It can be shown that there exists no other beautiful configuration with a sum of heights greater than 13.

Example 2:
Input: maxHeights = [6,5,3,9,2,7]
Output: 22
Explanation: One beautiful configuration with a maximum sum is heights = [3,3,3,9,2,2]. This configuration is beautiful since:
- 1 <= heights[i] <= maxHeights[i]
- heights is a mountain of peak i = 3.
It can be shown that there exists no other beautiful configuration with a sum of heights greater than 22.

Example 3:
Input: maxHeights = [3,2,5,5,2,3]
Output: 18
Explanation: One beautiful configuration with a maximum sum is heights = [2,2,5,5,2,2]. This configuration is beautiful since:
- 1 <= heights[i] <= maxHeights[i]
- heights is a mountain of peak i = 2. 
Note that, for this configuration, i = 3 can also be considered a peak.
It can be shown that there exists no other beautiful configuration with a sum of heights greater than 18.
 
Constraints:
1 <= n == maxHeights <= 10^5
1 <= maxHeights[i] <= 10^9


Problem Statement- we have given an Array and our main goal is that we have to make mountain out of it we can basically reduce the length of towers according to it as well equality cases are allowed in a array eg- 5,5,5,5 is also a mountain array. and we have to claculate the total sum of elements out of it . and return maximum.


Approch-1 : (Brute Force)-
Its Simple approch we will go to every index and in make of mountain we will calculate the sum of elements according to it. and find maximum..

Tc- o(N^2)
Sc- o(1)


Approch-2 : (Stack Approch)-
Observations-
           1. Our problem is that we have to calculate the sum according to elements in an array and store it and in another traversal we will find maximum sum accordings.

           2. so by stack we calculated it .
           3. Idea behind was that we have to calculate the next smaller element till then same peak element will be created and from onwards smaller elemnent sum will help us.

             eg- [1,2,3,9,6,4]
             now - 9,6,4 will become 4 and then from 3 previous calculated result will be added so we use indexes -1 and n that not exist to calculate lengths and calculate left and right smallers.....
           4. Monotonic stack and basic Question requirement was the funda.

           Tc-O(N)
           SC-O(N)

           CODE-
 */

 class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        
     // Method of O(N) Time and 4 O(N) space complexity.

     int n=maxHeights.size();
     int[]leftNextSmaller=new int[n];       
     int[]rightNextSmaller=new int[n];
     long[]leftSum=new long[n];
     long[]rightSum=new long[n];


    Arrays.fill(leftNextSmaller, -1);
    Arrays.fill(rightNextSmaller, n);

     // Calculating Left-next-smaller

     Stack<Integer>stk=new Stack<>();
     

     for(int i=0; i<n; i++){

      while(!stk.isEmpty() && maxHeights.get(stk.peek()) >= maxHeights.get(i)){

          stk.pop();
      }

      if(!stk.isEmpty()){
          leftNextSmaller[i]=stk.peek();
      }

      stk.push(i);
     }
    

Stack<Integer>stk2=new Stack<>();

     // calculating Right-Next-smaller
  
     for(int i=n-1; i>=0; i--){

      while(!stk2.isEmpty() && maxHeights.get(stk2.peek()) >= maxHeights.get(i)){

          stk2.pop();
      }

      if(!stk2.isEmpty()){
          rightNextSmaller[i]=stk2.peek();
      }

      stk2.push(i);
     }
    
  

 // calculating Left Sum-
   
   leftSum[0]=maxHeights.get(0);
   for(int i=1; i<n; i++){
  
        if(leftNextSmaller[i]==-1){
              leftSum[i]=(long)maxHeights.get(i)*((i+1));
        }

        else{
            int smallindex=leftNextSmaller[i];
            leftSum[i]=(long)maxHeights.get(i)*((i-smallindex));
            leftSum[i]+=leftSum[smallindex];
        }
     
   }



// Calculating right sum-

rightSum[n-1]=maxHeights.get(n-1);
for(int i=n-2; i>=0; i--){
  
        if(rightNextSmaller[i]==n){
              rightSum[i]=(long)maxHeights.get(i)*((n-i));
        }

        else{
            int smallindex=rightNextSmaller[i];
            rightSum[i]=(long)maxHeights.get(i)*((smallindex-i));
            rightSum[i]+=rightSum[smallindex];
        }
     
   }



  long maxi=0;

  for(int i=0; i<n; i++){

      maxi=Math.max(maxi, leftSum[i]+rightSum[i]-maxHeights.get(i));
  }



//  System.out.println("leftNextSmaller: " + Arrays.toString(leftNextSmaller));
//         System.out.println("rightNextSmaller: " + Arrays.toString(rightNextSmaller));
//         System.out.println("leftSum: " + Arrays.toString(leftSum));
//         System.out.println("rightSum: " + Arrays.toString(rightSum));


// System.out.println(result1);

return maxi;
}
}



/*
 * Some More Learnings-
 *                  1. Whenever there is anything of 10^9 Go for long and use long*long rather then long*int for good Robust Results.
 *                  2. Increasing and Decresing arrays can also be Manupulated threw Monotonus Stack as well.
 *                  3. Use of Indexings(Rather then Concerete Value) and calculating smaller in terms of indexes make qn more good.
 * 
 */


 /*
 * Real Life Examples of This Problem - 
 *    1. Memory Allocation -> Let's Suppose we represent this array as of many resources and have some capacity for every resource, so we have to maintain a memory usage of every process/resource till it's capacity so that overall memory management can be make good.
 * 
 *    2. Load Balancing in Distributed Systems: In distributed systems, load balancing involves distributing tasks or requests across multiple nodes or servers. Tower heights could represent the capacity of each node, and the goal is to balance the load in such a way that no node exceeds its capacity while maximizing overall system throughput.
 * 
 *   3. Supply Chain Management: In supply chain management, optimizing the distribution of goods or products across various distribution centers or warehouses is essential. Tower heights could represent the capacity of each distribution center, and solving this problem relates to finding an optimal distribution strategy that maximizes the utilization of distribution centers without exceeding their capacities.
 * 
 *   4. Resource Allocation in Multi-core Processors: In the design of multi-core processors, allocating tasks to cores with varying processing capacities is important for optimizing performance and power consumption. Solving this problem can resemble allocating tasks to processor cores to maximize parallelism while staying within power and thermal constraints.
 * 
 */ 
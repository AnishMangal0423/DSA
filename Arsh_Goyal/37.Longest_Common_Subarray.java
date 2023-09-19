/*
Qn-
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

Example 1:
Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].

Example 2:
Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
 
Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100

------------------------------------------------------------------------------------------------------------------------------------------
Problem Statement- We have given two arrays num1 and num2 and we have to calculate the common subarray of maximum length-

Intution - Claculate all subarrays of both arrays and find maximum by O(m^2 * n^2 * n) it is o(n^5)


Approch-1 : Loop Approch( Better Solution )-
Intution- This method is valid for only subarrays findings not for subsequences because a regular sequence is needed to work.
          
          1. First we iterate to every element of second array and ans will be coressponding to maximum element subarray.
          2. In course we have to traverse the first array until both elements matched.
          3. Whenever any element is not matched then we have to come back in array 1 again to the starting+1 of len>1 element and in array 2 to the same initial index it may be possible that we find it later.
          
          To understand these cases properly take the good example -
          a1=[65,77,21,88,67,67,99,100]
          a2=[67,99,21,1,2,2,3,4]

          ans should be 2 -->[67,99]

          so we have to come back agian in both arrays .. so in worst case-

          TC-O(N^3)
          SC-O(1)


          Code-
*/

class Solution {

    public int findLength(int[] nums1, int[] nums2) {
        
        // Better Solution of O(N^3)
     int maxi=0;
     int l1=nums1.length;
     int l2=nums2.length;

     for(int i=0; i<nums2.length; i++){
        
         int k=i,j=0,len=0,flag=-1; // This flag is for 1st array again come back signal.
         while(j<l1 && k<l2){
            if(nums1[j]==nums2[k]){
                len++;
                j++; k++; 
            }

            else if(len>0 && nums1[j]!=nums2[k] && flag!=-1){

               len=0;
               j=flag+1;
               k=i;
            }

            else{
                len=0;
                j++;
                k=i;
            }

            if(len==1) flag=j-1;

            maxi=Math.max(len , maxi);
         }
     }
return maxi;
    }
}
/*
 -----------------------------------------------------------------------------------------------------------------------------------------

Approch-3 : DP( Optimized )-

Observation-
    1. we have to calculate the longest common subarray.
    2. we will use the coomon suffix of defferent prefixes so we will check 1 prefix with other prefix's suffix that they are matching or not 
    
     Eg- "pqabcxy" s2="xyzabcp"
     then all preifixes of both are 

         p              x
         pq             xy
         pqa            xyz
         pqab           xyza
         pqabc          xyzab
         pqabcx         xyzabc
         pqabcxy        xyzabcp


    so for every prefix we will compare the suffix-

    For good feel you can watch- https://www.youtube.com/watch?v=NvmJBCn4eQI&t=1229s&ab_channel=Pepcoding

    TC-O(M*N)
    SC-O(M*N)
Code-
 */

 class Sol {

    public int findLength(int[] nums1, int[] nums2) {
        
        // Better Solution of O(N^3)
     int maxi=0;
     int l1=nums1.length;
     int l2=nums2.length;

     
     // Optimal Solution of dp-

     int[][]dp=new int[l1+1][l2+1];
    

    for(int i=1; i<=l1; i++){
        for(int j=1; j<=l2; j++){

            if(nums1[i-1]==nums2[j-1]){
                dp[i][j]=1+dp[i-1][j-1];
                maxi=Math.max(maxi, dp[i][j]);
            }
        }
    }
return maxi;

  
    }
}


/*
 Note-
    1. So from now if we have two strings and we have to find some commons of substring we can think of prefixs and matching suffixes in it.
 */
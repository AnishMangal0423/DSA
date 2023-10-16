import java.util.*;
/*
 Qn- Hard
Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:
Input: nums = [-1]
Output: [0]

Example 3:
Input: nums = [-1,-1]
Output: [0,0]
 
Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104

Problem Statement- We have given an array of elements and we have to find that how many number of elements are smaller then our current element after the current element.

Approch-1 : Brute Force
- Simple Loop Iiteration for every Element -
  TC- O(N^2)
  SC- O(1)
-----------------------------------------------------------------------------------------------------------------------------------------

Approch-2 : Merge Sort(Inversion Count Approch)-
Intution - Basically we can every elements on doing Merge Function .. u can think about it..
   Problems-
      1. We do not have to count the total Number of pairs that  is following the pair .. we have to give the count of specific numbers.
      2. Lts suppose we have arr1=[9,11,15] and arr2=[1,2,3] then if pointers are at initials then comparisions for every element will give Again O(N^2) Solution .   ----> **** CRINGE ****

    Solutions -
      1. We cannot deal with our initial number array because first of all it will change(become sorted) and second we want pair array of indexes.
      2. For Avoiding the o(N^2) we will take the numElemsRightArrayLessThanLeftArray variable that will maintain count for other variables and whenever there turn will come to go for temp array we will add with them. so all pairs  will be handled by this.  ******* CRINGE ******** 


      TC- O(Nlogn)
      SC- O(N)

      Code-
*/
class Pair{

    int val;
    int index;

    Pair(int v, int i){
        val=v;
        index=i;
    }
}

class Solution {
    void Merge(Pair pair_array[],int[]result, int l, int m, int r){
         
         Pair[] temp= new Pair[r-l+1];
         int numElemsRightArrayLessThanLeftArray=0;

         int i=0;
         int n1=l;
         int n2=m+1;
         while(n1<=m && n2<=r)
         {
             if(pair_array[n1].val <= pair_array[n2].val)
             {
                 result[pair_array[n1].index]+=numElemsRightArrayLessThanLeftArray;
                 temp[i++]=pair_array[n1];
                 n1++;
             }
             else
             {
                 numElemsRightArrayLessThanLeftArray++;
                 temp[i++]=pair_array[n2];
                 n2++;
             }
         }
         while(n1<=m)
         {
            result[pair_array[n1].index]+=numElemsRightArrayLessThanLeftArray;
             temp[i++]=pair_array[n1];
             n1++;
         }
         while(n2<=r)
         {
             temp[i++]=pair_array[n2];
             n2++;
         }
         for(int j=l;j<=r;j++)
         {
             pair_array[j]=temp[j-l];
         }
         
    }

    public void MergeSort(Pair[]pair_array, int[]result , int s, int e){

       if(s >=e) return;

     int mid=(s+e)/2;

       MergeSort(pair_array,result, s, mid);
       MergeSort(pair_array,result, mid+1, e);
       Merge(pair_array,result, s, mid, e);
    }

  public List<Integer> countSmaller(int[] nums) {

     int n=nums.length;

    int result[]=new int[n];
    Pair[]pair_array=new Pair[n];

    for(int i=0; i<n; i++){
        pair_array[i]=new Pair(nums[i], i);
    }
       MergeSort(pair_array,result, 0, n-1);
        
       ArrayList<Integer>ans=new ArrayList<>();

       for(int i : result){
           ans.add(i);
       }
       return ans;
    }
}


/*
 * 
 * Lessons-
 *    1. How Smotthly we performed o(N^2) Solution to O(N) solution. "CRINGE PART"
 *    2. Concept of Count Inversion.
 */
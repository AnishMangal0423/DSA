/*
 Qn-
  Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 
Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

Problem Statement- we have given an array sorted and we have to tell the starting and ending index of certain number.target.

Aprroch- Binary Search(Optimized)-
Inution - Since Binary Search is used to search a eleemnt in logN time so it can also search its neighour duplicates also so means it can also manage their indexes as well. so we can go for binary search ..

Code-
*/
class Solution {
      int i=-1;
        int j=-1;

    void BinarySearch(int[]arr, int target, int si, int ei){
        
        if(si > ei){
            
            return ;
        }
        
        int mid=(si+ei)/2;
        int middle=arr[mid];
        
        if(middle ==target){

            if(i==-1 && j==-1){
                i=mid;
                j=mid;
            }

          else if(i > mid){
            i=mid;
        }         

        else  if(j < mid){
            j=mid;
          } 
  
          BinarySearch(arr , target , mid+1, ei); 
           BinarySearch(arr , target , si , mid-1);
        }
        
        else if(middle < target){
            
         BinarySearch(arr , target, mid+1, ei);
        }
        
        else{
            
          BinarySearch(arr , target , si , mid-1);
        }
        
    }

    public int[] searchRange(int[] arr, int target) {

     int n=arr.length;
        int[]ans=new int[2];
      
       BinarySearch(arr , target, 0 , n-1);
       ans[0]=i;
       ans[1]=j;
        
        return ans;
   
    }
}

/*
 Lessons-
    1. Whenever array is given sorted and we have to search a element or some target and their duplicates ... go for binary search.
 */
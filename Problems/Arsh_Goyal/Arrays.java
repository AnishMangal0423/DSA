package Problems.Arsh_Goyal;
/* 
Question- Find Union and Intersection of Arrays-
Soln-  
     Union- 
   Approch-1 : TC- O(N^M)
               SC- O(1) 

   Approch-2 : HashSet
               TC-O(M+N)
               SC-O(M+N)             


     Intersection-
     Approch-1 : TC-O(MN)
     Approch-2 : HashSet(using contains function)


---------------------------------------------------------------------------------------------------------------------------------------------

Ques- Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array. Return the answer in ascending order.
Note: The extra space is only for the array to be returned.Try and perform all operations within the provided array. 


Ans- Intitution:- Main Thing is that when we read this question Carefully we find that every element in this array is ranging from 0 to    n-1 , this is the meaning. 

Approch-1 : Using Hashset 
Intitution- whenever we talk about occurances or duplicates when can go for hashset approches.
            TC- O(N) 
            SC- O(N) --> Because of hashset 


Approch-2 : Count sort Approch-
Intitution:- Basically Count Sort as usual Deals with the elements ranging from 0 to n-1 so .. count sort can come to mind
Implimentation:- we first traverse a array and increased every index by n and used % for every index to go their increments.
           TC-O(N)
           SC-O(1)

---------------------------------------------------------------------------------------------------------------------------------------------

Ques- Count Inversion-
     Given an array of integers. Find the Inversion Count in the array. 
     Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
     Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
     Input: N = 5, arr[] = {2, 4, 1, 3, 5}
     Output: 3
     Explanation: The sequence 2, 4, 1, 3, 5 
     has three inversions (2, 1), (4, 1), (4, 3).
   
Soln- 
Approch-1: Making Pairs(Brute Force Approch)
           Simply we have to find the pairs in which first element is greater then second one so comparision using loop and this question is
           same as how many steps array is far away t be sorted .
           TC-O(N*N)
           SC-O(1)
     

Approch-2: Divide and Conquor(Merge Sort comparisions)
Intitution- Always Remember whenever we have given a array and we have to make pairs and do comparisions or swappings to make things sorted 
            we can think about Divide and Conquour for NlogN solutions-

           TC-O(NlogN)
           SC-O(N)
Code-           
*/
class Solution
{
     long count=0;
     
     
     
   void Merge(long arr[] , int s, int mid , int e){
       
       int n1=mid-s+1;
       int n2=e-mid;
       int i=s;
       int j=mid+1;
       int k=0;
       
       long []temp=new long[n1+n2];
       
      while(i<=mid && j<=e){
          
         if(arr[i] <= arr[j]){
          temp[k]=arr[i];
         i++;
         k++;
      }
      
      
      else{
          
          count+=(mid-i+1);
          temp[k]=arr[j];
          j++;
          k++;
      }
      
      
   }     
   
   
   while(i <= mid){
       
       temp[k]=arr[i];
       i++;
       k++;
   }
   
   while(j<=e){
       
       temp[k]=arr[j];
       j++;
       k++;
   }
   
   
   int h=0;
   
   for(int a=s; a<=e; a++){
       
       arr[a]=temp[h];
       h++;
   }
   
   return;
   
     
   }
     
   void MergeSort(long []arr , int s, int e){
       
       int mid =(s+e)/2;
       
       if(s < e){
           
           MergeSort(arr , s, mid);
           MergeSort(arr , mid+1 , e);
           Merge(arr , s, mid , e);
           
       }
       
       return;
   }
     
     
   long inversionCount(long arr[], long N)
    {
        
     MergeSort(arr , 0 , (int)N-1);
     
     return count;
        
    }
}






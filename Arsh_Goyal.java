/*
  Q1. You are given two 0-indexed arrays nums and cost consisting each of n positive integers.
    You can do the following operation any number of times:
    Increase or decrease any element of the array nums by 1.
    The cost of doing one operation on the ith element is cost[i].

    Return the minimum total cost such that all the elements of the array nums become equal.

  Input: nums = [1,3,5,2], cost = [2,3,1,14]
  Output: 8


 Soln- 
   Intution- Instead of making the number same in whole array to be equal another number it will be optimal to make same as number is present in array  as you can understand from above question , now to find the median in these weighted median question
   
   Method-1 : Brute Force
   Intution- Instead of Finding median we are making target to every element and finding result to be minimum corresponding to it.
             and taking the minimum-

    Code-
         
    public long minCost(int[] nums, int[] cost) {
        int n1=nums.length;
        int n2=cost.length;
        long Minimum=Long.MAX_VALUE;     *** Mistake - I was taking it as INTEGER.MAX_VALUE
         for(int i=0; i<n1; i++){
              int target=nums[i];
              long Mini=0;
              for(int j=0; j<n1; j++){

                  Mini+=Math.abs((long)nums[j]-(long)target)*(long)cost[j];
              }
            Minimum=Math.min(Mini , Minimum);
            System.out.println(Minimum);
         }
     }         

     TC- O(N2)
     SC- O(1)

   Method-2 : Method of Median-
   Intution- As we have done above question we understand that if we take/Make  every elemnets costs to be equal to 1 then we can calculate the median and in O(N) time we will reach the result by sorting in O(NlogN) time.
   Now we will change every elements costs as 1 by adding elements in num to be equal to cost so if they change to some number cost can be obtained , so we first took sum of all elements/costs and find median index by sc/2 , now , by prefix sum we calculated the range and median value and returned and calculated the difference/oprn in it.


   lass Solution {
   public long weightedMedian(long[][]sample , long pos){
     int n1=sample.length;
       Arrays.sort(sample , (a, b)->Long.compare(a[0],b[0]));
    long store=0;
       for(int i=0; i<n1; i++){
        sample[i][1]+=store;
        store=sample[i][1];
        if(pos <= sample[i][1]){

            return sample[i][0];
        }

       }

       return 0;
   }

    public long minCost(int[] nums, int[] cost) {
        int n1=nums.length;
        int n2=cost.length;
              long Mini=0;
       
   long[][]sample=new long[n1][2];  --> *** Mistake2 - It is Mandatory to make sample array to be long int cant ne used it will give wrong .

   for(int i=0; i<n1; i++){
       for(int j=0; j<2; j++){

           if(j==0){
               sample[i][j]=(long)nums[i];
           }
           else{
               sample[i][j]=(long)cost[i];
           }
       }
   }

sum of costs-
long sc=0;
   for(int i=0; i<n1; i++){
    sc+=(long)cost[i];
   }

   long pos=(sc+1)/2;   --> *** Mistake1 - if we will write sc then it not comapre to odd cases but can run for some cases because there range is large

   long median=weightedMedian(sample , pos);


 for(int i=0; i<n1; i++){

       Mini+=Math.abs((long)nums[i]-median)*(long)cost[i];  --> TypeCasting is Important
    
 }
return Mini;
    }
}


```

Note- 1. Whenever we have to convert All array elemnets to some value remember the concept of median.
      2. If Cost is Given remember frequency median concept.
      3. whenever even/odd elements are issue check for ind , indx+1 for errors.
      4. Use Long.Max_Value if Long is in useCase.  

```
   
 */
package Contests.CodeForces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B {
 
   
    public static long BinarySearch(long s, long e,long w,  long[]arr, long mainans){


          if(s > e){
            return mainans;
          }
           long mid=(s+e)/2;

           int i=0;
           long smallwater=0;
           while(arr[i] < mid){

             smallwater+=mid-arr[i];
             i++;
           }
             
           if(smallwater <= w){
             mainans=Math.max(mainans, mid);
             return BinarySearch(mid+1, e, w , arr, mainans);
           }

           else if(smallwater > w){
               return BinarySearch(s, mid+1 , w, arr, mainans);
           }

  return 2;
    }
    public static void main(String []args){

    System.out.print("Enter the tcs :");
     Scanner scanner = new Scanner(System.in);
     ArrayList<Long>ans=new ArrayList<>();

      int tc=scanner.nextInt();

      while(tc > 0){

          int n=scanner.nextInt();
          long w=scanner.nextInt();

           long mini=Long.MAX_VALUE;
          long[]arr=new long[n];

          for(int i=0; i<n; i++){
             arr[i]=scanner.nextInt();
             mini=Math.min(mini, arr[i]);
          }

          // Bianary search on 1 --> mini+w

          Arrays.sort(arr);
          long h=BinarySearch(1,mini+w, w, arr , 1);
          
          ans.add(h);
        tc--;
      }


      for(long val : ans){
        System.out.println(val);
      }

      scanner.close();
    }

}

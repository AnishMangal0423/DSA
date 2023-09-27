// package Contests.CodeForces;

import java.util.ArrayList;
import java.util.Scanner;

public class Money_Tree {
    
    public static void main(String []args){

        System.out.print("Enter the tcs :");
         Scanner scanner = new Scanner(System.in);
         ArrayList<Long>ans=new ArrayList<>();
    
          int tc=scanner.nextInt();
    
          while(tc > 0){
    
              int n=scanner.nextInt();
              long Total_fruits=scanner.nextInt();

              long[]fruits=new long[n];
              long[]heights=new long[n];

              for(int i=0; i<n; i++){
                fruits[i]=scanner.nextInt();
              }

              for(int i=0; i<n; i++){
                heights[i]=scanner.nextInt();
              }

             
             int l=0;
             int r=0;
             long maxi=0;
             long subarrayTotalFruits=0;
             
             while( r < n){

                subarrayTotalFruits+=fruits[r];

                if(l==r && fruits[l] <= Total_fruits){
                    maxi=Math.max(maxi , r-l+1);
                    r++;
                }

                else if(subarrayTotalFruits <= Total_fruits && heights[r-1] % heights[r]==0){
                    maxi=Math.max(maxi, r-l+1);
                    r++;
                }

                else{

                    l=r;
                    subarrayTotalFruits=fruits[r];
                }
             }

               ans.add(maxi);

              tc--;

          }


          for(long max : ans){
            System.out.println(max);
          }

          scanner.close();
        }
}

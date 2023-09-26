package POTD_LeetCode;

import java.util.*;

/*
 Q1. Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.


Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"
 
Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.

Problem Statement- We have Given an string that can contain Duplicate Elements ok .. and now wewant to use  all unique elements once order as the subsequence of minimum length. and laxicographically smallest.

Analyze Problem - 
    Eg-  s= "bcabc" we can delete any 'b' ok but we will delete in a way that it will give smallest.

 Approch -1 : Monotonic  stack 👍
    Now we can see that once 'b' is dependent on another that another 'b' will be taken or not.. means one characetr of string is dependent on another so stack can be helpful.. but we want laxicographical smallest so will try to maintain a increasing sequence is able to maintain with the help of count and monotonic stack.
    

    Observation-

   1. For maintaining the one count we will use visited concept.
   2. for maintaining laxiographical order will maintain monotonic stack with count hashmap.

     if cb is made and bc is also possible then obiously we will take bc and if cb is made and c will never come back if i will remove it fom here. so count will help us.

   TC- O(N)
   SC- O(N)

   Overall Question --> Good, Learning Based.


   Code-
*/

class Solution {
    public String smallestSubsequence(String s) {

       Stack<Character>stk=new Stack<>();
        boolean visited[]=new boolean[26];
        HashMap<Character, Integer>map=new HashMap<>();
        int n= s.length();

        for(int i=0; i<n; i++){

            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<n; i++){


       if(visited[s.charAt(i)-'a'] == false){
          while(!stk.isEmpty() && stk.peek() - s.charAt(i) > 0 && map.get(stk.peek()) > 0){

              visited[stk.peek() - 'a']=false;
              stk.pop();
          }

            stk.push(s.charAt(i));
            map.put(s.charAt(i), map.get(s.charAt(i))-1);
            visited[s.charAt(i) - 'a']=true;
        }

       else{
             map.put(s.charAt(i), map.get(s.charAt(i))-1);
       }
        }

        StringBuilder sb=new StringBuilder("");


        while(!stk.isEmpty()){

          sb.insert(0, stk.pop());

        }
        return sb.toString();
   
    }
}
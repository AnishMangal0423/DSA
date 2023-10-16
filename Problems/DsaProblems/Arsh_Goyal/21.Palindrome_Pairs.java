import java.util.*;
/*
 Qn-

 You are given a 0-indexed array of unique strings words.
 A palindrome pair is a pair of integers (i, j) such that:
0 <= i, j < words.length,
i != j, and
words[i] + words[j] (the concatenation of the two strings) is a 
palindrome
.
Return an array of all the palindrome pairs of words.
You must write an algorithm with O(sum of words[i].length) runtime complexity.

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]

Input: words = ["a",""]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["a","a"]


Soln-
Problem Statement- Problem Is quite understandable and direct we have given an array that contains some strings those strings can be empty, palindrome, or normal ..and we have to find the pairs so that adding them can help us to make a concetatinate string  palindrome.

Approch-1 : Brute Force(Loops)-
Intution- basically we can traverse for every string and its components to add before or after to make string palindrome .
   TC- O(N^2)
   SC-O(1)


Approch-2 : HashMap(Optimized)-
Intution -  
    1. Note down that every Palindromic strinng is made up of three components .. Left + Mid + Right 
    2. In every Palindromic String Mid part is always Palindromic.
    3. so to make a pair cancetatnte as palindrome we will find some pairs when we will find reverse of strings and adding will give results.
    4. case-1 : 
           String can be Left +Mid(Palindromic) 
             then we found reverse of left in hashmap then got a pair.

    5. Case-2 : 
           String can be Mid(Palindromic)+Right
             then we found reverse of right in hashmap then got a pair or ans .
             
    6. Edge cases is having "" strings (as mentioned in qn that strings are unique) so we will found "" once. 
    7. "" will form Palindrome with only Palindromic string
       case-1 : if we have to add both pairs ""+ Palindrome =Palindrome
                                        and Palindrome + "" = Palindrome
                                        
    8. But Remember that a Palindrome + Palindrome = Palindrome or ! Palindrome , so we are taking this also in cases.                                    

 TC-o(N*k*k*k)
 SC-O(N)   

Code-
 */

 class Solution {

   boolean isPalindrome(String s, int i, int j){

       while(i < j){
           if(s.charAt(i)!= s.charAt(j))  return false;

           i++;
           j--;
       }

       return true;
   }


    public List<List<Integer>> palindromePairs(String[] words) {

        HashMap<String , Integer>map=new HashMap<>();
       List<List<Integer>>ans=new ArrayList<>();

     for(int i=0; i<words.length; i++){
      if(words[i].equals("")){
          continue;
      }

         map.put(words[i], i);
     }


for (int i = 0; i < words.length; i++) {
    if (words[i].equals("")) {
        for (int j = 0; j < words.length; j++) {
            if (i != j && isPalindrome(words[j], 0, words[j].length() - 1)) {
                ans.add(Arrays.asList(i, j));
                ans.add(Arrays.asList(j, i));  // Add both orders of pairs
            }
        }
    }
}
     for(int i=0; i<words.length; i++){

         for(int cut=0; cut<words[i].length(); cut++){

  // Case-1 : Left+Mid + "reverseofleft"
        if(isPalindrome(words[i],cut, words[i].length()-1)){

            String right=words[i].substring(0 , cut); 
      StringBuilder str = new StringBuilder(right);
            str.reverse();
            String revright=str.toString();
         
         if(map.containsKey(revright) && map.get(revright)!=i){


         List<Integer>a=new ArrayList<>();
a.add(i);
a.add(map.get(revright));

     ans.add(a);
           
         }

        }

// Case2 : "ReverseofRight"+Mid+Right
      if(isPalindrome(words[i], 0 , cut-1)){

            String left=words[i].substring(cut); 
      StringBuilder str = new StringBuilder(left);
            str.reverse();
            String revleft=str.toString();
         
         if(map.containsKey(revleft) && map.get(revleft)!=i){

             
         List<Integer>a=new ArrayList<>();
         a.add(map.get(revleft));
     a.add(i);

     ans.add(a);
         }

        }

         }
     }

       return ans;
    }
}   


/*
 Utils -
   1. Arrays.asList(i, j)  ->> If we want to store a arraylist of making two integers we can add a direct arraylist as Arrays.asList(i , j, k )
   2. In strings always use equals function .. dont try to use == because equals function deals  with object referencing matchings while equls deals with content matching.
 */
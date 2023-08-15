import java.util.*;
/*
 Qn- 
 Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Problem Statement- Basically a list of strings is given and we have to put the arrangments of strings together 
Anagram string --> A string is called a  anagram if it is formed by the arrangment of a string.

Approch-1 : Wrong Approch:
i was thinking of making map of every string and compare to every map that is a bad approch- because it will give Tle-

Approch-2 : Sort Approch-
Intution- Here we will convert every string to its raw form and then will add to hashmap according to it  -

TC- O(N*K*logK)
SC- O(N)

Code-
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
    HashMap<String , List<String>>map=new HashMap<>();
       for(String s : strs){

       char[]temparray=s.toCharArray();
       Arrays.sort(temparray);
         String raw=new String(temparray);
         
         if(!map.containsKey(raw)){
             ArrayList<String>a=new ArrayList<>();
             a.add(s);
         map.put(raw, a);

         }

         else{
           List<String>val=map.get(raw);
           val.add(s);
             map.put(raw ,val );
         }
       }


   List<List<String>>ans=new ArrayList<>();

    for(List<String>val : map.values()){

        ans.add(val);
    }
return ans;
    }
}

/*
 Important - 
    1. Whenever we want to check the frequency of bunch of strings , we can sort them and use them (raw form is also used)
       if have 2 strings then making of both strings can help.

   2. Add function on Arraylist gives boolean result.
    
   Utils -
   
     1. Sorting of String -->
                We cannot directly convert sorting of string by sort method .. we have to go via approch of stringBuilder or toCharArray approch-

                char[]carray=str.toCharArray()
                 Arrays.sort(carray);
                 String s=new String(carray)

      2. Traversal of HashMap- 
         we learnt traversal of Hashmap in 3 different ways-
         a. for(Map.Entry<a, b>entry=map.entrySet()){

            key=entry.getKey()
            val=entry.getValue()
         }            

         b. // by key-
            for(List<a>obj : map.keySet()){

            }

         c. // by value-
         
           for(List<a>val : map.values()){

            
           }
 */
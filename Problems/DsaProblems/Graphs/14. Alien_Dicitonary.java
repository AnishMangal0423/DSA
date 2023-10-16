import java.util.*;
/*
  Qn- 
   Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 
Example 1:
Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output: 1

Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.

Example 2:
Input: 
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output: 1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.


Soln- 
  Problem Statement - Here some words are written like a dictionary in a sorted and we have to return a order of alphabets of that planet--

  Approch-1 : Topological(BFS)-
  Intution - we have some characters and have condition that that character should come before that character and something like that dependencies that also matches the logic of topo sort .. so comes an idea of topo sort-

  TC- O(V+E)
  SC- O(V)

  Code-

 */

 
//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
    
    List<List<Integer>>adj=new ArrayList<>();
    for(int i=0; i<K; i++){
        
        adj.add(new ArrayList<>());
    }
    
    
    for(int i=0; i<N-1; i++){
        
        String s1=dict[i]; int l1=s1.length();
        String s2=dict[i+1]; int l2= s2.length();
        
        int ind=0;
        while(ind < l1 && ind < l2){
            char first=s1.charAt(ind);
            char second=s2.charAt(ind);
            
          if(first!=second){
              int fir=first-'a';
              int sec=second-'a';
              
              adj.get(fir).add(sec);
              break;
          }
          
          else{
              
              ind++;
          }
        }
        }
       
       // APPLTING tOPOLOGICAL SORT NOW -
       
       int[]InDegree=new int[K];
       
       for(int i=0; i<K; i++){
           
           for(int child : adj.get(i)){
               
               InDegree[child]++;
           }
       }
       
       // making queue now-
       
       Queue<Integer>q=new LinkedList<>();
       
       for(int i=0; i<K; i++){
           
           if(InDegree[i]==0){
               
               q.add(i);
           }
       }
       
       StringBuilder s=new StringBuilder("");
       while(!q.isEmpty()){
           
           int front=q.remove();
           s.append((char)(front+'a'));
           
           for(int child : adj.get(front)){
               
               InDegree[child]--;
               
               if(InDegree[child]==0){
                   
                   q.add(child);
               }
           }
       }
       
      return s.toString();
    }
}

/*
   Important Note -

     1. Whenever we have dependencies like this node should should come before or after then we can think of Topo Sort..
        These Nodes can be anything like number / alphabets..

 */

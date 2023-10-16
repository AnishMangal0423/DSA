/*
 Q-

 Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""

   Problem Statement- we have to make or return a string that does not have anjacent characters same.. 

   Intutution-
       Basically we can make a hashmap that store the counts of every character and we can store it in decending order via priority Queue and then adding strings characters adjacent to it by loopings.


  TC- O(N)
  TC- O(2N)

  Dirty Code-

 */

//  class CustomPair implements Comparable<CustomPair> {
//     char key;
//     int value;

//     public CustomPair(char key, int value) {
//         this.key = key;
//         this.value = value;
//     }

//     @Override
//     public int compareTo(CustomPair other) {
//         // Compare based on the second value (value)
//         return Integer.compare(other.value, this.value);
//     }
// }

// class Solution {
//     public String reorganizeString(String s) {
        
//       String ans="";  
//      int len=s.length();
//   HashMap<Character , Integer>map=new HashMap<>();

//      for(int i=0;i<len; i++){

//        char element=s.charAt(i);
//          if(!map.containsKey(element)){

//              map.put(element , 1);
//          }

//          else{

//              int val=map.get(element);
//              val++;
//              map.put(element , val);
//          }
//      }

//     //  System.out.println(map);
  

//      PriorityQueue<CustomPair>queue=new PriorityQueue<>();

//         for(Map.Entry<Character,Integer> mapElement : map.entrySet()) {

//                   queue.add(new CustomPair(mapElement.getKey(), mapElement.getValue()));
//     }

    

//      CustomPair p=queue.poll();
//       char key= p.key;
//       int val=p.value;
    
//     if(val > (len+1)/2){
//         return "";
//     }

//     //   System.out.println("key "+key+" val "+val);

//     for(int i=0; i<val; i++){
//         ans+=String.valueOf(key);

//     }
// //    System.out.println(ans);

//      int length=queue.size();
//      int first=1;
//      int last=2*(ans.length())-1;

//      while(length!=0){
   
//       p=queue.poll();
//       key= p.key;
//       val=p.value;
      
//     //   System.out.println("key "+key+" val "+val);
     
//      while(first <= last && val>0){

//         ans= ans.substring(0 , first)+ key+ans.substring(first);
//         first+=2;
//         val--;

//     // System.out.println(ans);
//      }

//      if(first > last){
//          first=1;
//          last=2*(ans.length())-1;
//      }

//      while(val > 0){
//      ans= ans.substring(0 , first)+ key+ans.substring(first);
//         first+=2;
//         val--;

//      }

//          length--;
//      }

//     // System.out.println(ans);
//        return ans;

//     }
// }



/* 
 * 
 * Good Code-
 */

//  class CustomPair implements Comparable<CustomPair> {
//     char key;
//     int value;

//     public CustomPair(char key, int value) {
//         this.key = key;
//         this.value = value;
//     }

//     @Override
//     public int compareTo(CustomPair other) {
//         // Compare based on the second value (value)
//         return Integer.compare(other.value, this.value);
//     }
// }

// class Solution {
//     public String reorganizeString(String s) {
//         StringBuilder ans = new StringBuilder();
//         int len = s.length();
//         HashMap<Character, Integer> map = new HashMap<>();

//         for (int i = 0; i < len; i++) {
//             char element = s.charAt(i);
//             map.put(element, map.getOrDefault(element, 0) + 1);
//         }

//         PriorityQueue<CustomPair> queue = new PriorityQueue<>();

//         for (Map.Entry<Character, Integer> mapElement : map.entrySet()) {
//             queue.add(new CustomPair(mapElement.getKey(), mapElement.getValue()));
//         }

//         CustomPair p = queue.poll();
//         char key = p.key;
//         int val = p.value;

//         if (val > (len + 1) / 2) {
//             return "";
//         }

//         // Append the first character to the StringBuilder
//         for (int i = 0; i < val; i++) {
//             ans.append(key);
//         }

//         int length = queue.size();
//         int first = 1;
//         int last = 2 * ans.length() - 1;

//         while (length != 0) {
//             p = queue.poll();
//             key = p.key;
//             val = p.value;

//             while (first <= last && val > 0) {
//                 ans.insert(first, key);
//                 first += 2;
//                 val--;
//             }

//             if (first > last) {
//                 first = 1;
//                 last = 2 * ans.length() - 1;
//             }

//          while(val > 0){
//      ans.insert(first, key);
//         first+=2;
//         val--;

//      }


//             length--;
//         }

//         return ans.toString();
//     }
// }
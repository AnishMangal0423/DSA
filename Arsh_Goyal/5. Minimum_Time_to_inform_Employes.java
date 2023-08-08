/*
 Q-Link - https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
   A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
   Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
   The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

   The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

   Return the number of minutes needed to inform all the employees about the urgent news.

  
   Example 1:

   Input: n = 1, headID = 0, manager = [-1], informTime = [0]
   Output: 0
   Explanation: The head of the company is the only employee in the company.
   
   Example 2:
   Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
   Output: 1
   Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
   The tree structure of the employees in the company is shown.

   Approch-1 : Approch of BFS-
    
     TC- O(N)
     sc- O(2n)

     iNTUTION- After Carefully Reading the problem we observed that we have to deal like a tree like data structure , now bfs came in mind to traverse for all branches .. and we kept childrens in hashmap for various managers and used queue to update the time taken and update maximum time also 

--------------------------------------------------------------------------------------------------------------------------------------
CODE-  
 */

//  class Pair{

//     int id;
//     int time;

//     Pair(int i , int t){
//         id=i;
//         time=t;
//     }
// }
// class Solution {
//     public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
//     int max_Time=0;

//      HashMap<Integer , ArrayList<Integer>>map= new HashMap<>();

//      for(int i=0; i<n; i++){

//       int emp=manager[i];
//          if(emp!=-1){

//               if(!map.containsKey(emp)){
//                   ArrayList<Integer>a=new ArrayList<>();
//                   a.add(i);
//                   map.put(emp , a);
//               }

//               else{
//                 ArrayList<Integer>b= map.get(emp);
//                 b.add(i);
//                 map.put(emp, b);
//               }
//          }
//      }

// //      System.out.println(map);

//     Queue<Pair>queue=new LinkedList<>();

//     queue.add(new Pair(headID , 0));
       
//     while(queue.size()!=0){

//         Pair front = queue.remove();
//         int e_id= front.id;
//         int i_time=front.time;

//        max_Time=Math.max(max_Time , i_time);

//         ArrayList<Integer>childs= map.get(e_id);
//         if(childs!=null){
//        int size=childs.size();
//         for(int i=0; i<size; i++){

//             queue.add(new Pair(childs.get(i), i_time+informTime[e_id]));
//         }

//         }
//     }

// return max_Time;
//     }
// }

/*
  Important Note-

   1. It is not Necassary that bfs can only be applied to tree and graphs , it can also be imagined and applied to arrays as well.
   2. if we want to store the childrens of some nodes.. always think of arrayList in HashMap.
 */
/*
 Q. You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional path between garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.
 All gardens have at most 3 paths coming into or leaving it.
 Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

 Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden. The flower types are denoted 1, 2, 3, or 4. It is guaranteed an answer exists.

 

Example 1:

Input: n = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]
Explanation:
Gardens 1 and 2 have different types.
Gardens 2 and 3 have different types.
Gardens 3 and 1 have different types.
Hence, [1,2,3] is a valid answer. Other valid answers include [1,2,4], [1,4,2], and [3,2,1].
Example 2:

Input: n = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
Example 3:

Input: n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]

Problem Statement-
           We have to plant some flowers but keep always one thing in mind that connected fields cannnot have same type of flowers..

   
 Approch-1 : Wrong Large BFS-
      one of the intersting case in this problem is that it is possible that same level fields will be assigned same type of flowers
      according to this logic that is wrong .. and we are also dealing bfs and assigning every field(parent) as visited of flowers and fields both that not good ...and answer was also coming wrong y that method-
--------------------------------------------------------------------------------------------------------------------------------------

Approch-2 : Modified Non-Visited BFS-

Intution- Basically to solve this same level problem we will go for bfs to that same level element if its neighour has different flower then ok otherwise we will increse it's count- 

Note - We have to increase the count of always child imagine that we want to keep only those field on same level which are not   connected otherwise connected will be level incresed so that vacancy can be created and child decrese will help bcz if parent dec then if its child may decrese due to its further child then they will again on same level.


Code-
 */


 import java.util.*;

// class Pair{

//     int data;
//     int flower_type;

//     Pair(int d ,int f){

//         this.data=d;
//         this.flower_type=f;
//     }
// }

class Solution {

    public int[] gardenNoAdj(int n, int[][] paths) {

//          int[]flowers={1, 2, 3, 4};    
//         int[]ans=new int[n];
        int m=paths.length;
      HashMap<Integer , ArrayList<Integer>>map=new HashMap<>();
  
        for(int i=1; i<=n; i++){

            map.put(i , new ArrayList<>());
        }


       for(int i=0; i<m; i++){

        int src= paths[i][0];
        int des= paths[i][1];

       ArrayList<Integer>a=map.get(src);
       a.add(des);

       
       ArrayList<Integer>b=map.get(des);
       b.add(src);

          
        map.put(src , a);
        map.put(des ,b);

       }

// System.out.println(map);
//     Queue<Pair>queue=new LinkedList<>();

       

//   int k=0;

// boolean[]visit=new boolean[n+1];

// for(int j=1; j<=n; j++){
   
//       if(visit[j]==false){
//       queue.add(new Pair(j, 1));
//       visit[j]=true;
//       }

//    while(!queue.isEmpty()){

//        Pair front= queue.remove();
//        int data=front.data;
//        int flowerType=front.flower_type;
    
//     System.out.println("d "+data+" ft "+flowerType);
//        ans[data-1]=flowerType;
//     //    System.out.println(k);
//        k++;
//         boolean[]visited=new boolean[5];
//         visited[flowerType]=true;
//         ArrayList<Integer>childs=map.get(data);

//         for(int i=0; i<childs.size(); i++){

//             for(int p=1; p<5; p++){

//                   if(visited[p]==false &&  visit[childs.get(i)]==false){

                   
//                       queue.add(new Pair(childs.get(i) , p));
//                       visit[childs.get(i)]=true;                        
//                     visited[p]=true;
//                       break;
//                   }
//             }
//         }
        

//    }
//    }

// return ans;




int[]field_Array= new int[n];
Arrays.fill(field_Array, 0);

Queue<Integer>q=new LinkedList<>();

for(int i=0; i<n; i++){

if(field_Array[i]==0){
     
     field_Array[i]=1;
    q.add(i+1);
}

while(!q.isEmpty()){

    int field= q.remove();

    ArrayList<Integer>childs=map.get(field);

    for(int child : childs){

  
          if(field_Array[child-1]==0  || field_Array[field-1]== field_Array[child-1]){

              field_Array[child-1]=field_Array[child-1]+1;
              q.add(child);
          }

          if(field_Array[child-1] > 4){
              field_Array[child-1]%=4;
          }
    }
}

}

return field_Array;
    }
}


/*
 
   Note-
     1. This Approch is beneficial when u are using bfs and have ceratin condition like neighours dont have same toys/flowers .. etc
     

 */
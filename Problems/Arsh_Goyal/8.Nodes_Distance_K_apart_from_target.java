/*
Q. Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:
Input: root = [1], target = 1, k = 3
Output: []
 
Constraints:
The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000 

 Problem Statement- In this Problem basically we have to tell all the nodes that are k distance apart from our targeted node-

  Intution-
      so To keep the distance in all radial directions we have to keep the record of hashmap for record of parent of all nodes in one traversal and finding targeted node also and then traverse all nodes again by bfs to get ans with required distance and keep visited array to avoid making unneccasry looping conditions-

      . Whenever we have to go back to tree parent node is a concept with hashmap and visited to loop complete bfs.

   Code-
     TC-O(n) 
     SC-O(n)   
 
     Code-
 */

//   class Pair{

//      TreeNode node;
//      int level;

//      Pair(TreeNode n, int l){
//          node=n;
//          level=l;
//      }
//  }
// class Solution {
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//          List<Integer>ans=new ArrayList<Integer>();
//     // step-1 : Will make HashMap that will contain Parents with the help of BFS Traversal-

//        HashMap<TreeNode, TreeNode>map=new HashMap<>();
//        Queue<TreeNode>q=new LinkedList<>();
//          TreeNode NewRoot=null;
          
//           q.add(root);
//           map.put(root , null);

//           while(!q.isEmpty()){

//            TreeNode front=q.remove();

//            if(front.val == target.val){
//               NewRoot=front;
//            }

//            if(front.left!=null){
//                q.add(front.left);
//                map.put(front.left , front);
//            }
           
//            if(front.right!=null){
//                q.add(front.right);
//                map.put(front.right , front);
//            }
//           }

// // System.out.println(NewRoot.val);


//   //Step-2 : We will Apply Bfs like a graph with the help of visited array-

//       ArrayList<TreeNode>visited=new ArrayList<>();
//       Queue<Pair>queue=new LinkedList<>();
 
//       queue.add(new Pair(NewRoot, 0));
//       visited.add(NewRoot);

//       while(!queue.isEmpty()){

//           Pair front= queue.remove();
//           TreeNode parent=front.node;
//           int level= front.level;

//     //   System.out.println("node "+parent.val+"l "+level);
// //       for(TreeNode l: visited){
// //           System.out.print(" visited "+ l.val);
// //       }
// // System.out.println(" ");
//           if(level==k){
//               ans.add(parent.val);
//           }
  
//        if(parent.left!=null && visited.contains(parent.left)==false){

//            queue.add(new Pair(parent.left, level+1));
//       visited.add(parent.left);
//        }

//         if(parent.right!=null && visited.contains(parent.right)==false){
  
//         queue.add(new Pair(parent.right, level+1));
//       visited.add(parent.right);
//         }

//     TreeNode grandFather=map.get(parent);
//         if(grandFather!=null && visited.contains(grandFather)==false){

//              queue.add(new Pair(grandFather, level+1));
//       visited.add(grandFather);

//         }   
//        }
      
// return ans;

//     }
// }

/*
 Note -
    1. When we have to traverse the node again back then we uses the concept of parent node.

  Errors-
    1. First on making hashmap i added wrong nodes (to add front , added root again and again).
    2. Added no condition for visited array for left and right .. that is also required when u call for grandfather then on left it can also come to father again.
      
 */
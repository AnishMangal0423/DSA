/* 
 Qn-
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 
Constraints:
The number of nodes in the tree is in the range [2, 1000].
-2^31 <= Node.val <= 2^31 - 1
 
Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?


Problem Statement- we have basically given a skeleton of BST and eventually two nodes were swapped by mistake then how will identify and again do correct them is the fight-


Approch-1 : Brute Force( General Intution )-
Intution-
       1. Do a inorder traversal store all nodes someone (default inorder)
       2. then sort the nodes./array
       3. then again to tree and put the values.. not good approch..    👎

                      
       cons-
         1. time costly -TC-O(2N + NlogN)
         2. Space comp- SC- O(N)
     
------------------------------------------------------------------------------------------------------------------------------------------

Approch-2 : Graphical Approch-

Observation - 
     1. we want the array to be sorted this is our aim.
     2. array can be made sorted by a pair of nodes.
     3. first we find a dip because it is first element that is disarranging.
     4. Now its pair can be adjacent or distant sepends on if later dip is found or not.
     5. if later dip is found then we will swap outerwise nearset dip(adjacent element will be swapped)
     6. this pair can be adjacent [2,6,9,8,10] or can be distant [2,6,25,9,8,30].
     7. Imagine this statement 6 by graph for Good Understanding.  👍
      
     
    Intution-
        1. Find dip-1-
            first we will find dip-1 .. and it will gurantlly meet beacuse pair will find it is given.
            
        2. Find dip-2-
            then from end till > dip-1 we will find if element is find to small then dip-1 then we will swap it. and break    


       TC- O(N)
       SC- O(N)
       
       
---------------------------------------------------------------------------------------------------------------------------------------    
Approch-3 : Three Pointer-Graphical Approch(Optimized)

Intuion - same intution as above only changes is that instaed of array we will maintain prev as int_min and check first elemeent and nexts by it and first,middle,last as dips points ..

   TC-O(N)
   SC-O(1) or stackspace. 👍👍


  Code- 
 */

//  class Solution {
//     TreeNode prev=null;
//     TreeNode first=null;
//     TreeNode middle=null;
//     TreeNode last=null;

//     public void swap(TreeNode n1 , TreeNode n2){

//         int store=n2.val;
//         n2.val=n1.val;
//         n1.val=store;
//     }

//     public void Inorder(TreeNode root){

//           if(root==null) return;

//           Inorder(root.left);

 // Handling when dip is found-
//           if(prev!=null && root.val < prev.val){

//               if(first==null){
//                   first=prev;
//                   middle=root;
//               }

//               else last=root;
//           }

//           prev=root;

//           Inorder(root.right);

//           return;
//     }



//     public void recoverTree(TreeNode root) {

//         Inorder(root);

//         if(first!=null && last!=null) swap(first , last);

//         else swap(first , middle);
        
//     }
// }
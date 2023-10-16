// import java.util.*;
/*
 Qn- 

 Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 
Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104

Problem Statement- We have Given a tree s and t and we have to find the subtree t in our s if we find then true else false.

Approch-1/Error-1 : String Method-
   This method will fail for nodes who have children in s and not have t 
   Example- s=[3, 1, 2] t=[3]

----------------------------------------------------------------------------------------------------------------------------------

Approch-2 : Manual Traversal

Intution - we will go to every node check for same tree , if not find there then will go to left and at last right ..
           we will use same tree function seperate because of Cleanliness and if lets suppose they found different the atleast we ca again come back and tour initial postions and will call for left and right otherwise your test case 177/182 will fail eg- s=[3,4,5,1,null,2], t=[3,1,2]

     TC- o(N)
     SC-O(1)
     
  Code-
*/

// class Solution {

//      public boolean sameTree(TreeNode root, TreeNode subRoot){
//      if(root==null && subRoot==null) return true;
//      if(root==null || subRoot==null) return false;

//       if(root.val == subRoot.val){

//       return  sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
//       }

//    else{
//       return false;
//    }
//      }
 
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
   
//      if(root==null && subRoot==null) return true;
//      if(root==null || subRoot==null) return false;
  
//       return sameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

//     }
// }

/*
   Important Note- 
      Erors- 1. Using String is an Bad Approch.
             2. We have to make same tree function seperate to deal with the redundant pointers comparision. eq- above in intution.
             3. when two trees are traversing in recursion then dont worry here logic will return both.
 */
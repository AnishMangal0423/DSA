
/*
Q4. Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3
    Explanation: The LCA of nodes 5 and 1 is 3.  

  
Soln-
  
Approch-1 : Brute Force-
    Intution- we will make list of node 1 and list of path of node 2 then will find first common from last-
         Tc- o(2n)
         Sc- o(2n)
 
-------------------------------------------------------------------------------------------------------------------------------------- 

Approch-2 : Targen's Algorithm-
  
    Tc- o(<N)
    sc - o(1)

  code-  
*/

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
//    // Three case problem just-

//    if(root==null){
//        return null;
//    }

//    if(root==p || root==q){
//        return root;
//    }

//    TreeNode left=lowestCommonAncestor(root.left , p , q);
//    TreeNode right=lowestCommonAncestor(root.right ,p,q);

//    if(left==null && right==null) return null;
//    else if(left==null) return right;
//    else if(right==null) return left;
//    else return root;

//     }
// }


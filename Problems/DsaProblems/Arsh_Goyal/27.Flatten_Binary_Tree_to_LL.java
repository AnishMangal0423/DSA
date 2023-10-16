/*
 Qn-
Given the root of a binary tree, flatten the tree into a "linked list":
The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 
Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

Ans- 
Problem Statement- We have Given a Binary Tree and we have to flatten it it to Linked List as right pointers of nodes as the next pointer and leftpointer to be null-


Main Intution - Main Intution of this problem is that we have to attach the bottom-most right node to the root.right node ..


Approch-1 : Bottom-Up
Intution - Here  main funda is that we have to maintain a prev pointer and have to start from right -
       Right --> Left --> Root
Imagine that we are traversing over left part and then store left.right to stored pointer(prev) then this approch will work-

TC- O(N)
SC-O(N) --> Recursive Stack.

Code-
*/
//  TreeNode prev=null;
//     public void flatten(TreeNode root) {

     // Method-1 : Solution of Recursion-
        // Tc-o(N)
        // Sc-o(N)

    // if(root==null){
    //    return;
    // }

    //   flatten(root.right);
    //   flatten(root.left);

    //   root.right=prev;
    //   root.left=null;

    //   prev=root;


// ---------------------------------------------------------------------------------------------------------------------------------------------
/*
Approch-2 : Top-Bottom(Morris Traversal)-

Intution - Here funda is same only difference is this soloution is iterative and uses the same Logic as what i have told u to the Main -Intution
            It Seems that it is O(N*H) but on traversing you will find it is a O(N+x) algorithm-

      TC-O(N)
      SC-O(1)
      
  Code-    
*/



// class Solution{

//     public void flatten(TreeNode root) {

//     TreeNode curr=root;

//   while(curr!=null){
//     if(curr.left!=null){
   
//         TreeNode prev=curr.left;

//         while(prev.right!=null){
//           prev=prev.right;
//        }

//        prev.right=curr.right;
//        curr.right=curr.left;
//        curr.left=null;

//       }

//     curr=curr.right;

//  }

//  }

// }


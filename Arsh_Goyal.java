/* 
Q2. Construct Binary Search Tree from Preorder Traversal.
    Input: preorder = [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]

Soln- 
    Intution- we have to make bst basically by using some nodes .. so it takes o(n^2) time , becuase we have to go in depth and add that node so adding n numbers will go for o(n^2) time.

    Approch-1 : Brute Force-
          TC- O(N^2)
          SC- O(1)

    Approch-2 : Approch of Range (Optimized)-
        Intution- Always Remember whenever we are dealing with bst then range is important because it automatically maintains range and we can directly add using this range using low , high range ,, otherwise we have to tranverse the whole tree again-
        
        TC-O(N)
        SC-O(1)


    Code-
    
    class Solution {

int index=1;

public void MakeTree(int pre[] ,int s_range , int l_range , TreeNode tree){
    
    if(index >= pre.length){
        return;
    }
              
        if(pre[index] < tree.val && pre[index] > s_range){
           TreeNode node= new TreeNode(pre[index]);
            tree.left=node;
         index++;
            
            MakeTree(pre , s_range , tree.val , node);
        }
      
        
        if(index < pre.length && pre[index] > tree.val && pre[index] < l_range){
                TreeNode node= new TreeNode(pre[index]);
            // System.out.println("data"+node.val+" index "+index+" lvalue "+s_range);
             tree.right=node;
             index++;
             MakeTree(pre , tree.val , l_range , node);
        }
        
      
    return;
    
}
    public TreeNode bstFromPreorder(int[] pre) {
        
         TreeNode Tree=new TreeNode(pre[0]);
    MakeTree(pre , Integer.MIN_VALUE , Integer.MAX_VALUE , Tree);
      
    return Tree;
    }
}
    
 */
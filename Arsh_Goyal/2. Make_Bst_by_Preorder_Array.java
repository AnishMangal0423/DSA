/*
 
Q2. Construct Binary Search Tree from Preorder Traversal. 
                 or
    Given an array arr[] of N nodes representing preorder traversal of some BST. You have to build the exact PostOrder from it's given preorder traversal. In Pre-Order traversal, the root node is visited before the left child and right child nodes.             
    Input: preorder = [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]



Soln- 
    Intution- we have to make bst basically by using some nodes .. so it takes o(n^2) time , becuase we have to go in depth and add that node so adding n numbers will go for o(n^2) time.

-------------------------------------------------------------------------------------------------------------------------------------
    Approch-1 : Brute Force-
          TC- O(N^2)
          SC- O(1)

--------------------------------------------------------------------------------------------------------------------------------------
    Approch-2 : Approch of Range (Optimized)-
        Intution- Always Remember whenever we are dealing with bst then range is important because it automatically maintains range and we can directly add using this range using low , high range ,, otherwise we have to tranverse the whole tree again-
    

    Code-
 
  static int index=1;

public static  void MakeTree(int pre[] ,int s_range , int l_range , Node tree){
    
        if(index >= pre.length){
        return;                               --> *** Mistake - Base Case Condition Important-
    }
              
        if(pre[index] < tree.data && pre[index] > s_range){
           Node node= new Node(pre[index]);
            tree.left=node;
              index++;
            
            MakeTree(pre , s_range , tree.data , node);
        }
      
        
        if(index < pre.length && pre[index] > tree.data && pre[index] < l_range){
                Node node= new Node(pre[index]);
            // System.out.println("data"+node.val+" index "+index+" lvalue "+s_range);
             tree.right=node;
             index++;
             MakeTree(pre , tree.data , l_range , node);
        }
        
      
    return;
    
}

public static Node post_order(int pre[], int size) 
{
    index = 1;
    Node Tree=new Node(pre[0]);
    MakeTree(pre , Integer.MIN_VALUE , Integer.MAX_VALUE , Tree);

    return Tree;
    
} 
   
        TC-O(N)
        SC-O(1)


=======================================================================================================================================

```

Note-
    1. Always Remember the inutition of Ranges in bst because it reduces TC.
    2. Always Handle Left and Right cases with condition seperatly.
    3. Always Traverse your code for Base Case Condition.
   *4. There was some fault for static functions and we were not able to go for every test case for global variables so 
       we again starting that index from 1 for every test case. 

```


 */
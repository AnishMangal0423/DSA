/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
 
Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

Approch-1 : Brute Force-
Intution - By  merging every lists by its previous lists we can also merge-

    TC -O(N*K)
    SC-O(1)

Code-
*/
// class Solution {
  
//    public ListNode Merge(ListNode head1 , ListNode head2){

//        if(head1==null && head2==null) return null;
//        if(head1==null) return head2;
//        if(head2==null) return head1; 

//     // System.out.println(head1.val +" "+head2.val);
//        ListNode temp1=head1;
//         ListNode temp2=head2;
//         ListNode temp3=null;
//         ListNode head3=null;

//     while(temp1!=null && temp2!=null){

//         if(temp1.val <= temp2.val){

//             if(head3==null){
//                 head3=temp1;
//                 temp3=temp1;
//             }

//               else{
//               temp3.next=temp1;
//               temp3=temp3.next;
//           }

//             temp1=temp1.next;

//         }

//        else if(temp2.val < temp1.val){
 
//            if(head3==null){
//                 head3=temp2;
//                 temp3=temp2;
//             }
//           else{
//               temp3.next=temp2;
//               temp3=temp3.next;
//           }
//           temp2=temp2.next;
//        }
//     }

//     if(temp1!=null){

//         temp3.next=temp1;
//     }

//     if(temp2!=null){

//       temp3.next=temp2;
//    }
// //   System.out.println(head3.val);
// return head3;
//    }

//     public ListNode mergeKLists(ListNode[] lists) {
        
//         ListNode ans=null;

//         for(int i=0; i<lists.length; i++){

//             ans=Merge(ans, lists[i]);

//             // System.out.println(ans.val);
//         }

//         return ans;
//     }
// }

/*
 Approch-2 : Priority Queue-
 Intution- Priority Queue came in my mind because whenever we required a maxi,um or minimum element we can go to priority queue and to insert a element in n element priority queue time complexity is O(logN) so first of we will add k numbers and then we will add by increasing them so tc will become nlogK

 TC-O(NlogK)
 SC-O(k)
 */


// class pair<ListNode>{

//     int li;
//     ListNode node;

//     pair(int l , ListNode n ){

//         li=l;
//         node=n;
//     }

// }

// class Solution<ListNode> {
//     public ListNode mergeKLists(ListNode[] lists) {
        
//      // Solving By the approch of Priority Queue Now-

//      ListNode dummy=new ListNode(-1000);
//      ListNode temp=dummy;

//      PriorityQueue<pair>pq=new PriorityQueue<>((a , b)-> a.node.val-b.node.val);

//      for(int i=0; i<lists.length; i++){

//         if(lists[i]!=null)  pq.add(new pair(i, lists[i]));
//      }


//      while(!pq.isEmpty()){

//          pair front=pq.poll();
//          int index=front.li;
//          ListNode target=front.node;

//       if(target!=null){

//           temp.next=target;
//           temp=temp.next;

//           if(target.next!=null)   pq.add(new pair(index , target.next));
//       }
//      }

// return dummy.next;
//     }
// }



/*
 Important-
    1. Concept of pq.
    2. Concept of comparable interface and compareTo function.
    3. Concept of Dummy Node.
 */

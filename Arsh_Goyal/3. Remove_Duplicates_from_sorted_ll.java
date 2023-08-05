/*
   Q3. Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
   
      Input: head = [1,1,1,2,3,5,5]
      Output: [2,3]
-------------------------------------------------------------------------------------------------------------------------------------

  Problem Statement- Basically in this problem head is not fixed because we even can't hold a single duplicate element also so , 
                     but in normal problems head will be constant they allow atleast single copy. so it's more Good qn-

  Approch-1 : Brute Force(HashMap)-
     Intution- Basically to fix this head and moving the pointers ahead , we first of all count the occurances and first fix the head      using ocuurances and check .. but this method is not good because it will have more edge cases and error chances
     
      TC-  O(2N)
      SC-  O(N)
   
code-

         
      Map<Integer, Integer>map=new LinkedHashMap<>();

      ListNode temp=head;

      while(temp!=null){

          if(!map.containsKey(temp.val)){

              map.put(temp.val , 1);
          }

          else{

              int v= map.get(temp.val);
              v=v+1;
              map.put(temp.val , v);
          }

          temp=temp.next;
      }


      ListNode prev= null;
      ListNode temp1=head;
      boolean check=false;

        Iterator hmIterator = map.entrySet().iterator();
         while (hmIterator.hasNext()) {
 
            Map.Entry mapElement
                = (Map.Entry)hmIterator.next();
           
        

            if(check==false && (int)mapElement.getValue()!=1){

             int a = (int)mapElement.getValue();

               while(a!=0){
                    head=head.next;
                    if(temp1!=null){
                temp1=temp1.next;
                    }
                   a--;
               }
               
            }

            if(check==false && (int)mapElement.getValue()==1){
                   check=true;
                   prev=head;
                

            }

           if(check==true && (int)mapElement.getValue()==1){
               
                    prev=temp1;
                    if(temp1!=null){
                    temp1=temp1.next;
                    }
           }

            if(check==true && (int)mapElement.getValue()!=1){

               int a = (int)mapElement.getValue();

               while(a!=0){
                    if(temp1!=null){
            //   System.out.println("temp "+temp1.val);

                   temp1=temp1.next;
                    }
                   a--;
               }
               if(prev!=null){

                        //  System.out.println(prev.val);
                  
               prev.next=temp1;
               }
           }
             

        }
        if(prev!=null){
      prev.next=null;
        }

    //   System.out.println(map);

      return head;

-----------------------------------------------------------------------------------------------------------------------------------\
   Approch-2 : Dummy Node Approch-
      Intution- So why not we make head fix using dummy node and when we will fix will return dummy.next-
  
       Tc-o(N)
       sc-o(1)

    code-   
 */

//  class Solution {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

    // public ListNode deleteDuplicates(ListNode head) {
    
    //   ListNode dummy=new ListNode(-10 , head);
    //   ListNode curr= head;
    //   ListNode prev=dummy;

    //   while(curr!=null){

        //   if(curr.next!=null && curr.val==curr.next.val){

            //   while(curr.next!=null && curr.val==curr.next.val){
                // curr=curr.next;
            //   }

            //   curr=curr.next;
            //   prev.next=curr;
            

        //   }

        //   else{
            //   prev=curr;
            //   curr=curr.next;
              
        //   }
    //   }
// return dummy.next;
//     }
// }

//------------------------------------------------------------------------------------------------------------------------



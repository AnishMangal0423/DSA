import java.util.*;
/*
 Qn-
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:
StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 
Example 1:
Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output : [null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6



Problem Statement- Here we have given an object of this stock spanner class that contains a list of some elemnts that are price of stocks on previous days and we have to tell the number of days with this previous day for which stock price is less or equal if it is more then ans will be 1 --

Approch -1 : Brute Force-
Intution - We will go to every element and check for every previous element until we find greater element or index 0 will count and store in    array and return it.

TC - O(N^2)
SC- O(1)

================================================================================================================================================
Approch-2 : Previous Index Result-
Intution- Now I will tell you , how i think about previous index result basically if we have some elements written then we will use their result to get others result and the number ca also be larger then if we jump until index >0 then go to its jump and can be worst scaniorio as well
TC-O(N^2)
SC-O(1)

================================================================================================================================================

Approch-3 : Monotonic Stack-
Intution- Now u can think that element that are in between of jumps are of no use and can be removed because there updated highest result is got updated with new value so at the end of day it will be monotonic decreasing stack and a good o(N) because every element is added once and removed when condition allows-

TC- O(N)
SC- O(N)

Code-
 */

 class StockSpanner {

   Stack<int[]> s;

    public StockSpanner() {
        
        s=new Stack<>();
    }
    
    public int next(int price) {
        
         int span=1;

         while(!this.s.isEmpty()  &&  price >= this.s.peek()[0]){
      
          span+=s.peek()[1];
          this.s.pop();

         }
      s.push(new int[]{price , span});

      return span;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price)
 */


 

 /*
  Learnings-
    1. Concept of Montonic Stacks/Stacks in Arrays
    2. How to do the Question of local stack for object.
  */
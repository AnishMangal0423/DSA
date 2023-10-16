import java.util.*;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 
Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

Problem Statement- Given a string and we have to check wether that string have correct/valid parenthesis order or not..

Approch-1 : Stack Approch-
Intution - Intution behind this is that we have dependency of some upcoming results on the previous results so we have to take stack and store the values-
  
Cases-
 We have basically three types of cases along with edge cases also-

 1. [[[[[[[  --> This type of case.when at end stack is not empty.
 2. [[[[]]]]  --> ActUAL vALID case stack has some elements .. but not get complete empty
 3. ]]]]]]] --> This type of case when stack is empty but ans is false so i have wwritten a stack soln but it is tough to handle all cases.

 TC - O(N)
 SC - O(N)

Code- 
*/
// class Solution {

//     public boolean check(Stack<Character>st , char c){
//         if(!st.isEmpty()==true && st.peek()==c){
//             st.pop();
//              return true;
//              }
//          return false;
//     }


//     public boolean isValid(String s) {
        
//         int len=s.length();
//         boolean ans=true;
//           Stack<Character>st=new Stack<>();
//       for(int i=0; i<len; i++){


//           if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
//               st.push(s.charAt(i));
//           }

         
//           else if(s.charAt(i)==')') ans=ans && check(st , '(');
//         else if(s.charAt(i)=='}')ans= ans && check(st, '{');
//         else ans=ans && check(st , '[');
//       }
//            return st.isEmpty() && ans;
//     }
// }


//----------------------------------------------------------------------------------------------------------------------------------------------

/*
 Approch-2 : Stack(Clean Code)-
Intution - Reverse Adding of Brackets and handeling all cases-

TC-O(N)
SC-O(N)

Code-
 */
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character>st=new Stack<>();

        for(char c : s.toCharArray()){

            if(c=='(') st.push(')');
          else if(c=='{') st.push('}');
          else if(c=='[') st.push(']');
          else if(st.isEmpty() || st.pop()!=c) return false;
        }
 return st.isEmpty();
    }
}

/*
 Lessosn- 
      1. Learn All the Cases/Edge Cases and keep this approch always in mind.
      2. Always do code clean.
 */
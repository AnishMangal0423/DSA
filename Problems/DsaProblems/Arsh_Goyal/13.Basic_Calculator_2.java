/*
 Qn -
 Given a string s which represents an expression, evaluate this expression and return its value. 
 The integer division should truncate toward zero.
 You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5
 
Constraints:
1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.


Problem Statement - Here we hhave given a string Expression and we have to calculate the value of that expression without using any extral eval  () function so .. also remember that precedence of * , / is more then +, - if * or / whoever will come first will be evaluated first.

Approch-1 : Stack Approch - 
Intutuion - Main Philosophy of this problem is that we will  push add only operation in the stack and do all substract and multiply , divide operation in way.. we will make a number with num variable because case of 321*2+3-2 can also be possible 321 will be made first..

Approch-2 : 3pointers Approch-
Intution - Same as above only change is that instead of adding to stack when comes "+" we will add directly to answer and will return at last-

TC- O(N)
SC- O(1)
Code-
*/


class Solution {
    public int calculate(String s) {
        int currentNumber = 0;  // To build the current number
        int previousNumber = 0; // Previous number encountered
        int result = 0;         // To store the final result
        char currentOperator = '+';  // Initialize the current operator as '+'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (currentOperator == '+') {
                      result += previousNumber;
                    previousNumber = currentNumber;
                } else if (currentOperator == '-') {
                       result += previousNumber;
                    previousNumber -= currentNumber;
                } else if (currentOperator == '*') {
                     previousNumber *= currentNumber;
                } else if (currentOperator == '/') {
                     previousNumber /= currentNumber;
                }

                currentOperator = c;
                currentNumber = 0;
            }
        }

        return result + previousNumber;
    }
}

/*
 Lessons-
   1. whenever we have to find/evaluate expression use stack and can use some pointers approch like it.

   Utils-
       1. to convert number characters to number we can use (char - '0') because ascii value of '0' is 48
       2. to check character is Digit or not  use Character.isDigit(char)

 */
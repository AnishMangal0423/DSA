/*
 Qn- 
   A message containing letters from A-Z can be encoded into numbers using the following mapping:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
Given a string s containing only digits, return the number of ways to decode it.
The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 
Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).

Problem Statement- Basically we have given a string we can collect a word of 2digit together or can remain distinct so that we form differnt ways to see it and store many results.. so we have to count them .. and have some conditions as well ..

Approch-1: (Wrong)2d Index Dp-
My approch was to store evrey indexed string rather then formation of 2digit number as collective.. basically we have to work on 2digit number as collective using previous results--
Ans - wrong(but working on non-zero numbers )
================================================================================================================================================

Approch-2 : 1D- Dp :
Intution- Here we can store the previous results and the 4 cases of 0's -

Tc- O(N)
SC- O(N)

Code-
*/




//     int[]dp=new int[s.length()];
//    if(s.charAt(0)=='0'){
//        return 0;
//    }

//    else{
//         dp[0]=1;

     
//       for(int i=1; i<dp.length; i++){

//           char prev=s.charAt(i-1);
//           char curr=s.charAt(i);

//        if(prev=='0' && curr=='0') dp[i]=0;

//        else if(prev=='0' && curr!='0') dp[i]=dp[i-1];

//        else if(prev!='0' && curr=='0'){

//            if(prev=='1' || prev=='2'){
//                dp[i]= i>=2 ? dp[i-2] : 1;
//            }
//            else{
//                dp[i]=0;
//            }
//        }

//        else{

//            dp[i]=dp[i-1];

//            if(Integer.parseInt(s.substring(i-1, i+1))<=26){
//                dp[i]+=(i>=2) ? dp[i-2] : 1;
//            }
//        }


//       }
//    }

//    return dp[s.length()-1];
    

/*
 * Important Note-
 *    1. Question of 1d array and manuplulation.
 * 
 */
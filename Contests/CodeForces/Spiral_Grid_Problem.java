/*
 Q1. A 10×10
 target is made out of five "rings" as shown. Each ring has a different point value: the outermost ring — 1 point, the next ring — 2 points, ..., the center ring — 5 points.


Vlad fired several arrows at the target. Help him determine how many points he got.

Input
The input consists of multiple test cases. The first line of the input contains a single integer t
 (1≤t≤1000
) — the number of test cases.

Each test case consists of 10 lines, each containing 10 characters. Each character in the grid is either X
 (representing an arrow) or .
 (representing no arrow).

Output
For each test case, output a single integer — the total number of points of the arrows.

Example
inputCopy
4

X.........
..........
.......X..
.....X....
......X...
..........
.........X
..X.......
..........
.........X

2 Test Cases More-

XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
XXXXXXXXXX
outputCopy
17
--
220
Note
In the first test case, there are three arrows on the outer ring worth 1 point each, two arrows on the ring worth 3 points each, and two arrows on the ring worth 4 points each. The total score is 3×1+2×3+2×4=17
.

In the second test case, there aren't any arrows, so the score is 0
.


Problem Statement- we have given an Matrix/ Basically made up of 5 Rings values from 1 -> 2 -> 3 -> 4 -> 5 to outwards
and every ring has some cost and whenever we found X we got some points corresponding to the Ring Value..to go afterwards .. now the point is that we want the points to be maximum and their Final Value.


Approch-1 : Spiral Traversal( Lengthy Approch) 👎-
Observation- 
          1. Whenever their is a ring like structure in matrix then spiral traversal is helpful..
          2. By spiral Matrix we can print the values but increases counter and all and then increasing points will be bit taugh to manupulate..
          
          TC-O(N^2)
       
          Cons-
            1. Lengthy Process.
            2. Taugh to Handle those counter increase conditions.
------------------------------------------------------------------------------------------------------------------------------            
 */
/* 
 
Approch-2 : Hard Code 👎 -
Observation-
           1. We can Basically Do HardCode the matrixes for our values like -
           {{1,1,1,1,1,1,1,1,1,1},
            {1,2,2,2,2,2,2,2,2,1}} 
            
           2. Something like that and can manupulate it correspondingly..

         TC- O(N^2)  

         Cons-
            1. Not a Robust Approch bcz specific for small Matrixes.
------------------------------------------------------------------------------------------------------------------------------             
*/

/*
 Approch-3 : Conditionals 👎 -
 Observation-
          1. we can basically use the sequencing of conditionals(In a Proper Order) that will help us to count the points.
          like-
             if(i==0 || i==9 || j==0 || j==9) then 1
             else if(i==1 || i==8 || j==1 || j==8) then 2 
               .. something like that..

               TC- O(N^2)

               Cons-
                  1. Not Robust Appproch because of Ok for small matrixes.

-------------------------------------------------------------------------------------------------------------------------------
                  */

 /*
Approch-4 : Min Value 👍 -
Observation-
           1. we can use a formula as Math.min(i+1, j+1, 10-i, 10-j)
           2. Whenever there is some buffer in matrix from all sides then we can use this minimum approch-

           TC-O(N^2)

           Pros-
           1. Robust.
           2. Time Saver.
           3. Smart Approch..

           Imagine that theif want the number to steal

           Code-
 */             

//  package Contests.CodeForces;
import java.util.*;

public class Spiral_Grid_Problem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of test cases (TC): ");
        int tc = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left in the buffer
        ArrayList<Integer> ann = new ArrayList<>();

        while (tc > 0) {

            String s = scanner.next();
            int n = s.length();
            int Number_A = 0;
            int points = 0;

            int min = Integer.MAX_VALUE;

            Stack<Character> st = new Stack<>();

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'A')
                    Number_A++;
            }

            if (s.charAt(0) == 'B' || s.charAt(n - 1) == 'B')
                ann.add(Number_A);

            else {
                for (int i = 0; i < n; i++) {

                    // System.out.println(st.size()+"ssss");
                    if (s.charAt(i) == 'A')
                        st.push('A');

                    else {

                        min = Math.min(min, st.size());
                        st.clear();
                    }
                }

                if (st.size() > 0)
                    min = Math.min(min, st.size());
                points = Number_A - min;
                ann.add(points);

            }

            tc--;
        }

        for (int ab : ann) {
            System.out.println(ab);
        }

        scanner.close();
    }
}




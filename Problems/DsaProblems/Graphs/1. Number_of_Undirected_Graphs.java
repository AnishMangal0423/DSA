/* Q1..  Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.

Soln-
 
 Intitution- Main Approch is that here we have to set(arrange) the pairs not the vertices because all type of graphs can be possible
             like strongly connected , connected components, and like this.
             Eg- Let vertex A, B, C here three pairs can be formed A-B , B-C , A-C
                 Now consider these three as I1 , I2 , I3 and arrange them then we will get all graphs.

             Ans- 2^(nC2).

======================================================================================================================================

```
KeyFactor - Work on Pair rather then vertex.

```
*/
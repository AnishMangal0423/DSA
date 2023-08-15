/*

1. StringBuilder --> StringBuilder has append function that can add any data type to it.. 
    eg- StringBuilder s=new StringBuilder();
        s.append('A');
        s.append(true);

        Ans- Atrue
    

  2.   Sorting of String -->
                We cannot directly convert sorting of string by sort method .. we have to go via approch of stringBuilder or toCharArray approch-
                
                char[]carray=str.toCharArray()
                 Arrays.sort(carray);
                 String s=new String(carray)      


  3.  Traversal of HashMap- 
         we learnt traversal of Hashmap in 3 different ways-
         a. for(Map.Entry<a, b>entry=map.entrySet()){

            key=entry.getKey()
            val=entry.getValue()
         }            

         b. // by key-
            for(List<a>obj : map.keySet()){

            }

         c. // by value-
         
           for(List<a>val : map.values()){

            
           }              
*/
 
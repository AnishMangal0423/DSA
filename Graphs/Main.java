// import java.util.*;

// public class Solution {
//     public int solution(List<Integer> A) {
//         int ans = 2;
//         int n = A.size();
//         if (n <= 2)
//             return n;
        
//         List<Integer> llap = new ArrayList<>(Collections.nCopies(n, 2));
//         Collections.sort(A);

//         for (int j = n - 2; j >= 0; j--) {
//             int i = j - 1;
//             int k = j + 1;
//             while (i >= 0 && k < n) {
//                 if (A.get(i) + A.get(k) == 2 * A.get(j)) {
//                     llap.set(j, Math.max(llap.get(k) + 1, llap.get(j)));
//                     ans = Math.max(ans, llap.get(j));
//                     i -= 1;
//                     k += 1;
//                 } else if (A.get(i) + A.get(k) < 2 * A.get(j))
//                     k++;
//                 else
//                     i -= 1;
//             }
//         }
//         return ans;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         List<Integer> A = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             A.add(sc.nextInt());
//         }
//         Solution solution = new Solution();
//         int result = solution.solution(A);
//         System.out.println(result);

//         sc.close();
//     }
// }


import java.util.*;

public class Main {

    public static int solve(int i, int j, List<Integer> arr, int sum) {
        if (j <= i)
            return 0;
        int result = 0;
        if (arr.get(i) + arr.get(i + 1) == sum)
        {
            result = solve(i + 2, j, arr, sum) + 1;
        }
        if (sum == arr.get(j) + arr.get(j - 1))
        {
            result = Math.max(result, solve(i, j - 2, arr, sum) + 1);
        }
        if (arr.get(j) + arr.get(i) == sum)
        {
            result = Math.max(result, solve(i + 1, j - 1, arr, sum) + 1);
        }
        return result;
    }

    public static int solution(List<Integer> arr) {
        int length = arr.size();
        
        if (length < 2)
            return 0;
            
        int result = solve(0, arr.size() - 1, arr, arr.get(0) + arr.get(1));
        
        result = Math.max(result, solve(0, arr.size() - 1, arr, arr.get(0) + arr.get(length - 1)));
        
        result = Math.max(result, solve(0, length - 1, arr, arr.get(length - 2) + a.get(length - 1)));
        
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 9, 1, 1, 1, 1, 1, 1, 8, 1));
        int result = solution(arr);
        System.out.println("Result: " + result);
    }
}
package CodeForces;
import java.util.*;

public class a {
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

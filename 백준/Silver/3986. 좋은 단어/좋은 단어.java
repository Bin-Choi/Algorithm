import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int n = 0; n < N; n++) {
            Deque<Character> stk = new LinkedList<Character>();
            String word = br.readLine();
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (stk.isEmpty() || c != stk.peekFirst()) {
                    stk.offerFirst(c);
                    continue;
                }

                if (c == stk.peekFirst()) {
                    stk.pollFirst();
                    continue;
                }
            }

            if (flag && stk.isEmpty()) {
                answer++;
            } 
        }
        System.out.println(answer);
    }
}
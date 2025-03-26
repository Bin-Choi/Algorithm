import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int n = 0; n < N; n++) {
            Deque<Character> stk = new LinkedList<Character>();
            String word = br.readLine();
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (c == '(' || c == '[') {
                    stk.offerFirst(c);
                    continue;
                }

                if (stk.isEmpty()) {
                    flag = false;
                    break;
                }

                if (c == ')') {
                    if (stk.peekFirst() == '(') {
                        stk.pollFirst();
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }

                if (c == ']') {
                    if (stk.peekFirst() == '[') {
                        stk.pollFirst();
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stk.isEmpty()) {
                sb.append("YES" + "\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
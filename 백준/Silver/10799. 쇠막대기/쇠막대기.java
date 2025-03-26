import java.util.*;
import java.io.*;

public class Main {
    static char pr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Deque<Character> stk = new LinkedList<Character>();
        int answer = 0;

        for (char c : line.toCharArray()) {
            if(stk.isEmpty() || c == '(') {
                stk.offerFirst(c);
                pr = c;
                continue;
            }

            if(c == ')') {
                if (pr == '(') {
                    // 레이저라면
                    stk.pollFirst();
                    answer += stk.size();
                    pr = c;
                } else {
                    stk.pollFirst();
                    answer++;
                    pr = c;
                }
            }
        }
        System.out.println(answer);
    }
}
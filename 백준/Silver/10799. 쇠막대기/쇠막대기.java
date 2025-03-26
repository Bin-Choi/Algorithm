import java.util.*;
import java.io.*;

public class Main {
    static boolean islazer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Deque<Character> stk = new LinkedList<Character>();
        int answer = 0;

        for (char c : line.toCharArray()) {
            if(stk.isEmpty() || c == '(') {
                stk.offerFirst(c);
                islazer = true;
                continue;
            }

            if (islazer) {
                // 레이저라면
                stk.pollFirst();
                answer += stk.size();
                islazer = false;
            } else {
                stk.pollFirst();
                answer++;
                islazer = false;
            }
        }
        System.out.println(answer);
    }
}
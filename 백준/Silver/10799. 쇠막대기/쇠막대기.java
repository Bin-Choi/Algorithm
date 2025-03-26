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

            // 문제에서 닫힘을 보장하므로.
            stk.pollFirst();
            if (islazer) {
                answer += stk.size();
            } else {
                answer++;
            }
            islazer = false;
        }
        System.out.println(answer);
    }
}
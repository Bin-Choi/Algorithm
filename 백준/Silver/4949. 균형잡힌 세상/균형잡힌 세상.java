import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while(true) {
            line = br.readLine();

            if (line.equals(".")) {
                break;
            }

            String answer = solve(line);
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    static String solve(String line) {

        Stack<Character> stk = new Stack<Character>();

        for (char c : line.toCharArray()) {
            if (c == '[' || c == '(') {
                stk.push(c);
                continue;
            }

            if (c == ']') {
                if (stk.isEmpty() || stk.peek() != '[') {
                    return "no";
                } else {
                    stk.pop();
                    continue;
                }
            }

            if (c==')') {
                if (stk.isEmpty() || stk.peek() != '(') {
                    return "no";
                } else {
                    stk.pop();
                    continue;
                }
            }
        }

        if(stk.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
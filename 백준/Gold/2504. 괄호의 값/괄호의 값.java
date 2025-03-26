import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Deque<Character> stk = new LinkedList<Character>();
        int answer = 0;
        int tem = 1;

        L1: for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            switch (c) {
                case '(':
                    tem *= 2;
                    stk.offerFirst(c);
                    break;
                
                case '[':
                    tem *= 3;
                    stk.offerFirst(c);
                    break;

                case ')':
                    if (stk.isEmpty() || stk.peekFirst() != '(') {
                        answer = 0;
                        break L1;
                    } else {
                        if (line.charAt(i-1) == '('){
                            answer += tem;
                        }
                        stk.pollFirst();
                        tem /= 2;
                    } break;
                
                case ']':
                    if (stk.isEmpty() || stk.peekFirst() != '[') {
                        answer = 0;
                        break L1;
                    } else {
                        if (line.charAt(i-1) == '['){
                            answer += tem;
                        }
                        stk.pollFirst();
                        tem /= 3;
                    } break;
            }
        }

        if (!stk.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);
    }
}
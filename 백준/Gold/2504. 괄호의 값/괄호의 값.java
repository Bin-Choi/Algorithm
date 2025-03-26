import java.util.*;
import java.io.*;

public class Main {
    static char pr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Deque<Character> stk = new LinkedList<Character>();
        int answer = 0;
        int tem = 1;

        L1: for (char c : line.toCharArray()) {
            switch (c) {
                case '(':
                    tem *= 2;
                    stk.offerFirst(c);
                    pr = c;
                    break;
                
                case '[':
                    tem *= 3;
                    stk.offerFirst(c);
                    pr = c;
                    break;

                case ')':
                    if (stk.isEmpty() || stk.peekFirst() != '(') {
                        answer = 0;
                        break L1;
                    } else {
                        if (pr == '('){
                            answer += tem;
                        }
                        stk.pollFirst();
                        tem /= 2;
                        pr = c;
                    } break;
                
                case ']':
                    if (stk.isEmpty() || stk.peekFirst() != '[') {
                        answer = 0;
                        break L1;
                    } else {
                        if (pr == '['){
                            answer += tem;
                        }
                        stk.pollFirst();
                        tem /= 3;
                        pr = c;
                    } break;
            }
        }

        if (!stk.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);
    }
}

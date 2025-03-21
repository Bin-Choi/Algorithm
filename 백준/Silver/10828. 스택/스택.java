import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<Integer>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    Integer t = Integer.parseInt(st.nextToken());
                    stk.push(t);
                    break;
                case "top":
                    if (stk.empty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stk.peek());
                    }
                    break;

                case "size":
                    System.out.println(stk.size());
                    break;

                case "empty":
                    if (stk.empty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;

                case "pop":
                    if (stk.empty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stk.pop());
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
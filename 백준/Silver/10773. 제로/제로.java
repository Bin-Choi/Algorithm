import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<Integer>();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());

            if (money == 0) {
                stk.pop();
            } else {
                stk.push(money);
            }
        }

        for (int m : stk) {
            answer += m;
        }

        System.out.println(answer);
    }
}
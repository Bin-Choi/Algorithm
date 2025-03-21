import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<Integer>();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int num = 1;

        while(cnt != N) {
            if (stk.isEmpty()) {
                stk.add(num);
                num++;
            

                if (num > N+1) {
                    break;
                }
                sb.append('+').append('\n');
                continue;
            }

            if (stk.peek() != arr[cnt]) {
                stk.add(num);
                num++;

                if (num > N+1) {
                    break;
                }

                sb.append('+').append('\n');
            }

            else {
                stk.pop();
                cnt++;
                sb.append('-').append('\n');
            }
        }

        if (cnt != N) {
            sb = new StringBuilder().append("NO").append('\n');
        }

        System.out.println(sb);
    }
}
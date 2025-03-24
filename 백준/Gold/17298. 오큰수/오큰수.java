import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());        
        Stack<Integer> stk = new Stack<>();
        int[] ngr = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = N-1; j >= 0; j--) {
            int a = arr[j];

            while(true) {
                if (stk.isEmpty()) {
                    ngr[j] = -1;
                    stk.push(a);
                    break;
                }

                int top = stk.peek();

                if (top > a) {
                    ngr[j] = top;
                    stk.push(a);
                    break;
                }

                stk.pop();
            }
        }

        for (int num : ngr) {
            sb.append(num + " ");
        }

        System.out.println(sb);
   }
}
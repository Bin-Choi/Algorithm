import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] cnt = new int[N+1];
        Deque<int[]> stk = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        stk.push(new int[] {N, arr[N]});
 
        for (int j = N-1; j > 0; j--) {
            int h = arr[j];

            while(!stk.isEmpty() && stk.peek()[1] < h) {
                int[] top = stk.pop();
                cnt[j] += cnt[top[0]] + 1;
            }
            
            stk.push(new int[] {j, h});
            answer += cnt[j];
        }
        System.out.println(answer);
   }
}
import java.util.*;
import java.io.*;


public class Main {

    public static int N;
    public static int S;
    public static int cnt = 0;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    
        dfs(0, 0);

        if (S == 0) {
            cnt--;
        }
        
        System.out.println(cnt);
    }


    public static void dfs(int depth, int sum) {

        if(depth == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        dfs(depth+1, sum);
        dfs(depth+1, sum+arr[depth]);
    }
}
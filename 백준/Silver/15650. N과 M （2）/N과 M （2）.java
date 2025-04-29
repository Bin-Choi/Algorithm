import java.util.*;
import java.io.*;


public class Main {

    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static int temp = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N+1];

        dfs(0, 1);
        System.out.println(sb);
    }


    public static void dfs(int cur, int start) {

        if(cur == M) {
            for (int v : arr) {
                sb.append(v).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[cur] = i;
            dfs(cur + 1, i + 1); 
        }
    }
}
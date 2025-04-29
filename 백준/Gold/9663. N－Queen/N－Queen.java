import java.util.*;
import java.io.*;


public class Main {

    public static int N;
    public static int cnt = 0;
    public static int[] v1;
    public static int[] v2;
    public static int[] v3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    
        v1 = new int[N];
        v2 = new int[N*2];
        v3 = new int[N*2];

        dfs(0);
        System.out.println(cnt);
    }


    public static void dfs(int cur) {

        if(cur == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v1[i] == 1 || v2[i+cur] == 1 || v3[cur-i + N-1] == 1) {
                continue;
            }

            v1[i] = 1;
            v2[i+cur] = 1;
            v3[cur-i+N-1] = 1;

            dfs(cur+1);

            v1[i] = 0;
            v2[i+cur] = 0;
            v3[cur-i+N-1] = 0;
        }
    }
}
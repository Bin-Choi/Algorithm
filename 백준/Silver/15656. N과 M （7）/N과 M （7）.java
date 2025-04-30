import java.util.*;
import java.io.*;


public class Main {

    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static int[] nums;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[M];
        visit = new boolean[N];
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0);
        System.out.println(sb);
    }


    public static void dfs(int depth) {

        if(depth == M) {
            for (int v : arr) {
                sb.append(v).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
                arr[depth] = nums[i];
                dfs(depth + 1);
        }
    }
}
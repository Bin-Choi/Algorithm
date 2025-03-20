import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
    

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());
        boolean[] cache = new boolean[X];

        int answer = 0;

        for (int a: arr) {
            if (a >= X) {
                continue;
            }

            if (cache[a]) {
                answer++;
            }

            else {
                cache[X-a] = true;
            }
        }
        System.out.println(answer);
    }
}

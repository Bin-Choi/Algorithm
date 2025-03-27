import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        int[] arr = new int[100001];
        int[] dx = new int[] {-1, 1, 2};

        Deque<Integer> que = new LinkedList<>();
        visited[n] = true;
        arr[n] = 0;
        que.offerLast(n);

        while (!que.isEmpty()) {
            int x = que.pollFirst();
            if (x == k) {
                System.out.println(arr[k]);
                return;
            }
            int nx;
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    nx = x * 2;        
                } else {
                    nx = x + dx[i];
                }

                if (0 <= nx && nx <= 100000) {
                    if (!visited[nx]) {
                        arr[nx] = arr[x] + 1;
                        visited[nx] = true;
                        que.offerLast(nx);
                    }
                }
            }
        }
    }
}
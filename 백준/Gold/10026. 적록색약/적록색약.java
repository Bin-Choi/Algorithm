import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt;
    static int n;
    static Deque<int[]> q;
    static boolean[][] visited;
    static char[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        cnt = 0;

        arr = new char[n][n];
        visited = new boolean[n][n];

        // 세팅
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.toCharArray()[j];
            }
        }

        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bfs(i, j, false);
            }
        }

        sb.append(cnt + " ");
        visited = new boolean[n][n];
        cnt = 0;

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bfs(i, j, true);
            }
        }

        sb.append(cnt+"\n");

        System.out.println(sb);
    }

    static void bfs(int si, int sj, boolean color) {
        if (visited[si][sj]) {
            return;
        }
        if (color && arr[si][sj] == 'G') {
            arr[si][sj] = 'R';
        }

        visited[si][sj] = true;
        cnt++;
        q.offerLast(new int[] {si, sj});

        while(!q.isEmpty()) {
            int[] point = q.pollFirst();
            int x = point[0];
            int y = point[1];
            char curC = arr[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 > nx || 0 > ny || nx >= n || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                char nexC = arr[nx][ny];
                // 색약이면
                if (color) {
                    if (nexC == 'G') {
                        arr[nx][ny] = 'R';
                        nexC = arr[nx][ny];
                    }
                } 

                if (curC == nexC) {
                    visited[nx][ny] = true;
                    q.offerLast(new int[] {nx, ny});
                }
            }
        }
    }
}
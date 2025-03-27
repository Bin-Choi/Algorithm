import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        // arr 세팅, 출발점 미리찾기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        bfs(0, 0);

        System.out.println(arr[N-1][M-1]);
    }

    
    static void bfs(int si, int sj) {
        
        visited[si][sj] = true;
        Deque<int[]> que = new LinkedList<>();
        que.offerLast(new int[] {si, sj});

        while(!que.isEmpty()) {
            int[] point  = que.pollFirst();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 밖
                if(0 > nx || nx >= N || 0 > ny || ny >= M) {
                    continue;
                }
                // 방문한 적이 있다면
                if(visited[nx][ny]) {
                    continue;
                }
                // 갈 수 없는 곳이라면
                if(arr[nx][ny] == 0) {
                    continue;
                }

                // 범위 안이고, 방문한 적 없고, 가야하는 곳
                visited[nx][ny] = true;
                arr[nx][ny] = arr[x][y]+1;
                que.offerLast(new int[] {nx, ny});
            }
        }
    }
}
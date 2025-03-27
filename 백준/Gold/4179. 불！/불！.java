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
        int J_i = 0;
        int J_j = 0;

        Deque<int[]> que = new LinkedList<>();
        // arr 세팅, 익은 토마토 세팅
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if (c == '#') {
                    arr[i][j] = -2;
                    continue;
                }
                if (c == 'F') {
                    // 불 위치 + BFS 먼저 돌리기
                    que.offerLast(new int[] {i, j});
                    visited[i][j] = true;
                    arr[i][j] = 1;
                    continue;
                }
                if (c == 'J') {
                    // 지훈 시작점
                    J_i = i;
                    J_j = j;
                    continue;
                }
            }
        }

        while(!que.isEmpty()) {
            int[] point = que.pollFirst();
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
                if(arr[nx][ny] == -2) {
                    continue;
                }

                // 범위 안이고, 방문한 적 없고, 가야하는 곳
                visited[nx][ny] = true;
                arr[nx][ny] = arr[x][y]+1;
                que.offerLast(new int[] {nx, ny});
            }
        }

        // 지훈이가 도망쳐야함
        int time = Integer.MAX_VALUE;
        // 방문 초기화
        visited = new boolean[N][M];
        que.offer(new int[] {J_i, J_j});
        arr[J_i][J_j] = 1;

        while(!que.isEmpty()) {
            int[] point = que.pollFirst();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 밖
                if(0 > nx || nx >= N || 0 > ny || ny >= M) {
                    time = Math.min(time, arr[x][y]);
                    break;
                }
                // 방문한 적이 있다면
                if(visited[nx][ny]) {
                    continue;
                }
                // 갈 수 없는 곳이라면(벽, 불시작점)
                if(arr[nx][ny] == -2) {
                    continue;
                }

                // 불이 번지는 곳이라면
                if(arr[nx][ny] != 0 && arr[nx][ny] <= arr[x][y]+1) {
                    continue;
                }

                // 범위 안이고, 방문한 적 없고, 가야하는 곳
                visited[nx][ny] = true;
                arr[nx][ny] = arr[x][y]+1;
                que.offerLast(new int[] {nx, ny});
            }
        }

        if (time == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(time);
        }
    }
}
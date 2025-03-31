import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static boolean[][] visit;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];

        int H = 1;
        int answer = 1;

        // arr 세팅 && 최대 높이 구하기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                H = Math.max(H, arr[i][j]);
            }
        }

        for (int h = 1; h <= H; h++) {
            int cnt = 0;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && arr[i][j] > h) {
                        cnt++;
                        bfs(i, j, h);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);

    }

    static void bfs(int si, int sj, int height) {

        Queue<Point> q = new LinkedList<>();
        visit[si][sj] = true;
        q.offer(new Point(si, sj));

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 범위 초과
                if (0 > nx ||  0 > ny || N <= nx || N <= ny ) {
                    continue;
                }

                // 방문한 적있음
                if (visit[nx][ny] == true) {
                    continue;
                }

                // 침수됨
                if (arr[nx][ny] <= height) {
                    continue;
                }
                visit[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }
}
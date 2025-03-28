import java.util.*;
import java.io.*;

class Point {
    int row;
    int col;
    int hgt;

    public Point(int x, int y, int z) {
        this.row = x;
        this.col = y;
        this.hgt = z;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dz = {0, 0, -1, 0, 0, 1};
        int[] dx = {-1, 0, 0, 1, 0, 0};
        int[] dy = {0, -1, 0, 0, 1, 0};

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];
        Deque<Point> q = new LinkedList<>();
        int cnt = 0;

        // 세팅
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    int value = Integer.parseInt(st.nextToken());
                    arr[h][n][m] = value;
                    if (value == 1) {
                        q.offerLast(new Point(n, m, h));
                        visited[h][n][m] = true;
                        continue;
                    }
                    if (value == 0) {
                        cnt++;
                    } 
                }
            }
        }

        // 덜익은 토마토가 없다면
        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()) {
            Point p = q.pollFirst();
            int x = p.row;
            int y = p.col;
            int z = p.hgt;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                // 범위 밖
                if (0 > nx || 0 > ny || 0 > nz || nz >= H || nx >= N || ny >= M) {
                    continue;
                }
                // 방문한적 && 벽
                if (visited[nz][nx][ny] || arr[nz][nx][ny] == -1) {
                    continue;
                }
                // 전파
                q.offerLast(new Point(nx, ny, nz));
                visited[nz][nx][ny] = true;
                arr[nz][nx][ny] = arr[z][x][y] + 1;
            }
        }

        int MAX = 0;

        for(int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    int value = arr[h][n][m];
                    if (value == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (value != -1) {
                        MAX = Math.max(MAX, value);
                    }
                }
            }
        }

        System.out.println(MAX-1);
    }
}
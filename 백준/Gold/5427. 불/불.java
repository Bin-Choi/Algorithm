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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            int[][] fire = new int[n][m];
            int[][] sg = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            Deque<Point> q = new LinkedList<>();
            Point SG = new Point(0, 0);
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    char c = line.toCharArray()[j];
                    if(c == '#') {
                        fire[i][j] = -1;
                        sg[i][j] = -1;
                        continue;
                    }
                    if(c=='.') {
                        fire[i][j] = 0;
                        sg[i][j] = 0;
                        continue;
                    }
                    if(c == '*') {
                        q.offer(new Point(i, j));
                        visited[i][j] = true;
                        fire[i][j] = 1;
                        continue;
                    }
                    if (c == '@') {
                        SG = new Point(i, j);
                        sg[i][j] = 1;
                    }
                }
            }
            // 불 한바퀴 돌리기
            while(!q.isEmpty()) {
                Point p = q.pollFirst();
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    // out of range
                    if (0 > nx || 0 > ny || nx >= n || ny >= m) {
                        continue;
                    }
                    // wall or visited
                    if (fire[nx][ny] == -1 || visited[nx][ny] == true) {
                        continue;
                    }
                    // 전파
                    visited[nx][ny] = true;
                    fire[nx][ny] = fire[p.x][p.y] + 1;
                    q.offerLast(new Point(nx, ny));
                }
            }
            // 방문 초기화 (상근이 버전)
            visited = new boolean[n][m];
            visited[SG.x][SG.y] = true;
            // q도 비어있음
            q.offerLast(SG);
            boolean flag = false;
            while(!q.isEmpty()) {
                Point p = q.pollFirst();
                // 탈출
                if (0 == p.x || 0 == p.y || p.x == n-1 || p.y == m-1) {
                    flag = true;
                    bw.write(sg[p.x][p.y] + "\n");
                    break;
                }

                for (int u = 0; u < 4; u++) {
                    int nx = p.x + dx[u];
                    int ny = p.y + dy[u];

                    if (0 > nx || 0 > ny || nx >= n || ny >= m) {
                        continue;
                    }
                    // wall or visited
                    if (sg[nx][ny] == -1 || visited[nx][ny] == true) {
                        continue;
                    }
                    // 불 있는곳
                    if (fire[nx][ny] != 0 && sg[p.x][p.y] + 1 >= fire[nx][ny]) {
                        continue;
                    }
                    // 전파
                    visited[nx][ny] = true;
                    sg[nx][ny] = sg[p.x][p.y] + 1;
                    q.offerLast(new Point(nx, ny));
                }
            }

            if (!flag) {
                bw.write("IMPOSSIBLE" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
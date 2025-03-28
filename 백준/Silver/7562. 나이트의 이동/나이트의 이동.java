import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int d;

    public Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
        int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            Deque<Point> q = new LinkedList<>();
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            q.offerLast(start);
            visited[start.x][start.y] = true;

            while(!q.isEmpty()) {
                Point p = q.pollFirst();
                int x = p.x;
                int y = p.y;

                if (x == end.x && y == end.y) {
                    // 도착
                    bw.write(p.d + "\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    // 범위 밖
                    if (0 > nx || 0 > ny || nx >= n || ny >= n) {
                        continue;
                    }
                    // 방문한 적있음
                    if (visited[nx][ny] == true) {
                        continue;
                    }
                    // push
                    visited[nx][ny] = true;
                    q.offerLast(new Point(nx, ny, p.d+1));
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
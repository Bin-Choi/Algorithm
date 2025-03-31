import java.util.*;
import java.io.*;

class Point {
    int x;
    int d;

    public Point(int x, int d) {
        this.x = x;
        this.d = d;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dx = {U, -D};

        boolean[] visit = new boolean[F+1];

        Queue<Point> q = new LinkedList<>();
        visit[S] = true;
        q.offer(new Point(S, 0));

        while(!q.isEmpty()) {
            Point p = q.poll();
            // 목적지에 도착 했다면
            if (p.x == G) {
                System.out.println(p.d);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx = p.x + dx[i];

                // 범위 초과
                if (0 >= nx || F < nx ) {
                    continue;
                }

                // 방문한 적있음
                if (visit[nx] == true) {
                    continue;
                }

                visit[nx] = true;
                q.offer(new Point(nx, p.d+1));
            }
        }

        // 목적지에 도착 못했다면
        System.out.println("use the stairs");
    }
}
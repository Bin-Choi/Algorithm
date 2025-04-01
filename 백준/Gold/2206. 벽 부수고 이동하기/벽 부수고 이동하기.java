import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int w;
    int cnt;


    public Point(int x, int y, int w, int cnt) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.cnt = cnt;
    }
}

public class Main {

    static int N;
    static int M;

    static boolean[][][] visit;
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); 

        if (N-1 == 0 && M-1 == 0) {
            System.out.println(1);
            return;
        }

        arr = new int[N][M];
        visit = new boolean[2][N][M];
        
        for (int n = 0; n < N; n++) {
            String line = sc.nextLine();
            for (int m = 0; m < M; m++) {
                int i = line.charAt(m) - '0';
                arr[n][m] = -i;
            }
        }

        Deque<Point> q = new LinkedList<>();
        q.offerLast(new Point(0, 0, 0, 1));
        visit[0][0][0] = true;
        boolean flag = false;
        
        while (!q.isEmpty()) {
            Point p = q.pollFirst();

            if (p.x == N-1 && p.y == M-1) {
                System.out.println(p.cnt);
                flag = true;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 > nx || 0 > ny || nx >= N || ny >= M) {
                    continue;
                }


                if (arr[nx][ny] == -1) {
                    if (p.w == 0 && !visit[1][nx][ny]) {
                        visit[1][nx][ny] = true;
                        q.offerLast(new Point(nx, ny, 1, p.cnt+1));
                    }
                    continue;
                }

                if (visit[p.w][nx][ny]) {
                    continue;
                }

                visit[p.w][nx][ny] = true;
                q.offer(new Point(nx, ny, p.w, p.cnt+1));
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }
}
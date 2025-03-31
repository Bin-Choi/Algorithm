import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean isGoal(Point p) {
        if (this.x == p.x && this.y == p.y && this.z == p.z) {
            return true;
        }
        return false;
    }
}

public class Main {

    static int N;
    static int M;
    static int H;

    static boolean[][][] visit;
    static int[][][] arr;
    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0 ,-1, 1};
    static Point goal;
    static Point start;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            H = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();

            if (H == 0) {
                break;
            }

            arr = new int[H][N][M];
            visit = new boolean[H][N][M];
       
            // arr 세팅 && 최대 높이 구하기
            for (int h = 0; h < H; h++) {
                for (int n = 0; n < N; n++) {
                    String line = sc.next();
                    for (int m = 0; m < M; m++) {
                        char c = line.charAt(m);

                        if (c == '#') {
                            arr[h][n][m] = -1;
                        } else if (c == 'S') {
                            start = new Point(n, m, h);
                            visit[h][n][m] = true;
                        } else if (c == 'E') {
                            goal = new Point(n, m, h);
                        }
                    }
                }
            }

            Deque<Point> q = new LinkedList<>();
            q.offerLast(start);
            boolean flag = false;
            while (!q.isEmpty()) {
                Point p = q.pollFirst();

                if (p.isGoal(goal)) {
                    bw.write("Escaped in " + arr[p.z][p.x][p.y] + " minute(s)." + "\n");
                    flag = true;
                    break;
                }

                for(int i = 0; i < 6; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    int nz = p.z + dz[i];

                    if (0 > nx || 0 > ny || 0 > nz || nx >= N || ny >= M || nz >= H) {
                        continue;
                    }

                    if (arr[nz][nx][ny] == -1) {
                        continue;
                    }

                    if (visit[nz][nx][ny] == true) {
                        continue;
                    }

                    visit[nz][nx][ny] = true;
                    arr[nz][nx][ny] = arr[p.z][p.x][p.y] + 1;
                    q.offer(new Point(nx, ny, nz));
                }
            }
            if (!flag) {
                bw.write("Trapped!" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}

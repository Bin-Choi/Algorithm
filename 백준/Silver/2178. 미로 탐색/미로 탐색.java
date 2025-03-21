import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visit;
   

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<int[]> que = new LinkedList<>();

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i< N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visit[0][0] = true;
        que.offer(new int[] {0, 0});
        
        while (!que.isEmpty()) {
            int[] temp = que.poll();

            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if(map[nx][ny] == 0 || visit[nx][ny]) {
                    continue;
                }

                visit[nx][ny] = true;
                que.offer(new int[] {nx, ny});

                map[nx][ny] = map[x][y]+1;
            }
        }

        System.out.println(map[N-1][M-1]);
    }
}
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<int[]> que = new LinkedList<>();

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 || visit[i][j]) {
                    continue;
                }

                cnt++;
                visit[i][j] = true;
                que.offer(new int[] {i, j});
                int area = 0;

                while(!que.isEmpty()) {
                    area++;
                    int[] temp = que.poll();
                    int x = temp[0];
                    int y = temp[1];

                    for(int d = 0; d < 4; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            continue;
                        }
                        if (visit[nx][ny] || map[nx][ny] != 1) {
                            continue;
                        }

                        visit[nx][ny] = true;
                        que.offer(new int[] {nx, ny});
                    }
                }

                max = Math.max(area, max);
            }
        }    
        bw.write(cnt + "\n");
        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }
}
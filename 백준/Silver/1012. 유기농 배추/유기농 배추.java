import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int time = Integer.parseInt(br.readLine());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int t = 0; t < time; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Deque<int[]> slist = new LinkedList<>();
            int[][] arr = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            int cnt = 0;

            // map 세팅, 출발지 미리 저장
            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken());
                int i = Integer.parseInt(st.nextToken());

                arr[i][j] = 1;
                slist.offer(new int[] {i, j});
            }

            while(!slist.isEmpty()) {
                int[] point = slist.poll();
                int x = point[0];
                int y = point[1];
                
                // 이미 bfs 돌린 배추밭이라면 Pass
                if(visited[x][y]) {
                    continue;
                }

                // 배추밭의 첫 시작점
                visited[x][y] = true;
                Deque<int[]> q = new LinkedList<>();
                q.offerLast(point);
                cnt++;
                while(!q.isEmpty()) {
                    point = q.pollFirst();
                    x = point[0];
                    y = point[1];

                    for(int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        // 맵 밖
                        if (0 > nx || 0 > ny || nx >= n || ny >= m) {
                            continue;
                        }
                        // 방문했거나 배추가 아니면
                        if (visited[nx][ny] || arr[nx][ny] == 0) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        q.offerLast(new int[] {nx, ny});
                    }
                }   
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
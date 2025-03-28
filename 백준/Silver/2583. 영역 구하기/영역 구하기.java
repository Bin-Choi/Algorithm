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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int sj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int ej = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());
            for (int i = si; i < ei; i++) {
                for (int j = sj; j < ej; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && visited[i][j] == false) {
                    int temp = 1;
                    visited[i][j] = true;

                    Deque<Point> q = new LinkedList<>();
                    q.offer(new Point(i,j));

                    while(!q.isEmpty()) {
                        Point p = q.pollFirst();

                        int x = p.x;
                        int y = p.y;

                        for (int di = 0; di < 4; di++) {
                            int nx = x + dx[di];
                            int ny = y + dy[di];

                            if (0 > nx || 0 > ny || nx >= n || ny >= m) {
                                continue;
                            }

                            if (visited[nx][ny]) {
                                continue;
                            }

                            if (arr[nx][ny] == 1) {
                                continue;
                            }
               
                            visited[nx][ny] = true;
                            temp++;
                            q.offerLast(new Point(nx, ny));
                        }
                    }
                    areas.add(temp);
                } 
            }
        }

        Collections.sort(areas);

        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append("\n");
        for (int i = 0; i < areas.size(); i++) {
            sb.append(areas.get(i));
            if (i != areas.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
import java.util.*;
import java.util.stream.Collector;
import java.io.*;


public class Main {
    static int N, M, R;
    static int[] result;
    static boolean[] visited;
    static int cnt = 1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

        result = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for(ArrayList<Integer> list : graph) {
            Collections.sort(list, Collections.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur) {
        visited[cur] = true;
        result[cur] = cnt++;

        for(int i: graph.get(cur)) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}
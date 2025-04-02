import java.util.*;
import java.util.stream.Collector;
import java.io.*;


public class Main {
    static int N, M, R;
    static int[] d;

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

        visited = new boolean[N+1];
        d = new int[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for(ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        visited = new boolean[N+1];
        d[R] = 0;
        dfs(R);

        for (int i = 1; i < N+1; i++) {
            bw.write(d[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    
    static void dfs(int cur) {
        visited[cur] = true;

        for(int i: graph.get(cur)) {
            if(!visited[i]) {
                d[i] = d[cur]+1;
                dfs(i);
            }
        }
    }
}
import java.util.*;
import java.util.stream.Collector;
import java.io.*;


public class Main {
    static int N, M, R;
    static List<Integer> b = new ArrayList<>();
    static List<Integer> d = new ArrayList<>();

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
            Collections.sort(list);
        }

        bfs(R);
        visited = new boolean[N+1];
        dfs(R);

        for (int i = 0; i < d.size(); i++) {
            bw.write(d.get(i) + (i == d.size() - 1 ? "\n" : " "));
        }

        for (int i = 0; i < b.size(); i++) {
            bw.write(b.get(i) + (i == b.size() - 1 ? "\n" : " "));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int cur) {
        Deque<Integer> q = new LinkedList<>();

        q.offerLast(cur);
        visited[cur] = true;
        b.add(cur);
        
        while(!q.isEmpty()) {
            int p = q.pollFirst();

            for(int i : graph.get(p)) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offerLast(i);
                    b.add(i);
                }
            }
        }
    }

    static void dfs(int cur) {
        visited[cur] = true;
        d.add(cur);

        for(int i: graph.get(cur)) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}
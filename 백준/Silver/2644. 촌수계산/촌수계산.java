import java.util.*;
import java.util.stream.Collector;
import java.io.*;


public class Main {
    static int N, M, S, E;

    static boolean[] visited;
    static int answer = -1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

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

        visited = new boolean[N+1];
        dfs(S, 0);

        System.out.println(answer);
    }

    
    static void dfs(int cur, int depth) {
        if (cur == E) {
            answer = depth;
            return;
        }
        visited[cur] = true;

        for(int i: graph.get(cur)) {
            if(!visited[i]) {
                dfs(i, depth+1);
            }
        }
    }
}
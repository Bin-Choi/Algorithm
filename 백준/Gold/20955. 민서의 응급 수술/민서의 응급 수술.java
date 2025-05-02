import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        parent = new int[N + 1];


        Arrays.fill(parent, -1);

        int count = 0;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = parseInt(st.nextToken());
            int v = parseInt(st.nextToken());

            int r1 = find(u);
            int r2 = find(v);

            if (r1 == r2) {
                count++;
                continue;
            }

            union(r1, r2);
        }

        int group = 0;
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] < 0)
                group++;
        }

        System.out.print(count + group - 1);
        br.close();
    }

    static void union(int r1, int r2) {
        if (parent[r1] < parent[r2]) {
            parent[r1] += parent[r2];
            parent[r2] = r1;

        } else {
            parent[r2] += parent[r1];
            parent[r1] = r2;
        }
    }

    static int find(int u) {
        if (parent[u] < 0) return u;

        return parent[u] = find(parent[u]);
    }
}
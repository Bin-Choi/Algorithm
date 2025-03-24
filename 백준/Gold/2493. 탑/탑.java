import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> stk = new LinkedList<>();
        int fh = Integer.parseInt(st.nextToken());
        sb.append("0 ");
        stk.add(new int[] {1, fh});
        
        for (int i = 2; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());
       
            while (true) {
                if (stk.isEmpty()) {
                    sb.append("0 ");
                    stk.add(new int[] {i, h});
                    break;
                }

                int[] t = stk.peekLast();

                if (t[1] > h) {
                    sb.append(t[0] + " ");
                    stk.add(new int[] {i, h});
                    break;
                } else {
                    stk.pollLast();
                }
            }
        }

        System.out.println(sb.toString() + "\n");
   }
}
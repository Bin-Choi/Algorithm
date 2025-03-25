import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> que = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            que.offerLast(i);
        }

        while(que.size() > 1) {
            que.pollFirst();
            if (que.size() == 1) {
                break;
            }
            que.offerLast(que.pollFirst());
        }
        System.out.println(que.poll());
   }
}
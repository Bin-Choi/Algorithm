import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deq = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int n = 1; n <= N; n++) {
            deq.offer(n);
        }

        for (int m = 0; m < M; m++){
            int target = Integer.parseInt(st.nextToken());

            while(deq.peekFirst() != target) {
                if (deq.indexOf(target) > deq.size()/2) {
                    deq.offerFirst(deq.peekLast());
                    deq.removeLast();
                
                } else {
                    deq.offerLast(deq.peekFirst());
                    deq.removeFirst();
                }
                answer++;
            }

            if (deq.peekFirst() == target) {
                deq.removeFirst();
            }
        }
        System.out.println(answer);
   }
}
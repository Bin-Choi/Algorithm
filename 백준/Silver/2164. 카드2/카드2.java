import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> que = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) {
            que.offerLast(i);
        }

        while(true) {
            if(que.size() > 1){
                que.pollFirst();
            }

            if(que.size() > 1){
                que.offerLast(que.pollFirst());
            }

            if(que.size() == 1) {
                break;
            }
            
        }
        System.out.println(que.poll());
   }
}
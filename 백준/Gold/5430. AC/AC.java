import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());

        for (int t = 0; t < time; t++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean isError = false;

            for (char c : command.toCharArray()) {
                if (c=='R') {
                    reverse = !reverse;
                    continue;
                } 
                
                if (deque.isEmpty()) {
                    sb.append("error" + "\n");
                    isError = true;
                    break;
                }

                if (reverse) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }

            if(!isError) {
                sb.append("[");
                if(reverse) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}
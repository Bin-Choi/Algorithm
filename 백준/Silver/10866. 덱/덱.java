import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");

            switch (line[0]) {
                case "push_back":
                    deq.offerLast(Integer.parseInt(line[1]));
                    break;

                case "push_front":
                    deq.offerFirst(Integer.parseInt(line[1]));
                    break;

                case "front":
                    if (deq.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deq.peekFirst() + "\n");
                    }
                    break;

                case "back":
                    if (deq.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deq.peekLast() + "\n");
                    }
                    break;

                case "size":
                    sb.append(deq.size()+  "\n");
                    break;

                case "empty":
                    if (deq.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;

                case "pop_front":
                    if (deq.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deq.pollFirst() + "\n");
                    }
                    break;

                case "pop_back":
                    if (deq.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deq.pollLast() + "\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
   }
}
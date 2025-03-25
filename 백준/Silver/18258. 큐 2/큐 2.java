import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> que = new LinkedList<>();
        

        for (int i = 0; i < N; i++) {
            String[] com = br.readLine().split(" ");

            switch (com[0]) {
                case "push":
                    que.addLast(Integer.parseInt(com[1]));
                    break;
                
                case "front":
                    if (que.isEmpty()) {
                        sb.append(-1 + "\n");
                        break;
                    }
                    sb.append(que.peekFirst() + "\n");
                    break;

                case "back":
                    if (que.isEmpty()) {
                        sb.append(-1 + "\n");
                        break;
                    }
                    sb.append(que.peekLast() + "\n");
                    break;
                
                case "size":
                    sb.append(que.size() + "\n");
                    break;
                case "empty":
                    if (que.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "pop":
                    if (que.isEmpty()) {
                        sb.append(-1 + "\n");
                        break;
                    }
                    sb.append(que.pollFirst() + "\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
   }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> que = new LinkedList<>();

        while(N-- >0) {
            String input = br.readLine();
            String spt[] = input.split(" ");

            switch (spt[0]) {
                case "push":
                    que.offer(Integer.parseInt(spt[1]));
                    break;
            
                case "front":
                    if(que.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(que.peek() + "\n");
                    }
                    break;

                case "back":
                    if(que.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(que.peekLast() + "\n");
                    }
                    break;
                
                case "size":
                    bw.write(que.size() + "\n");
                    break;

                case "empty":
                    if (que.isEmpty()) {
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
        
                case "pop":
                    if (que.isEmpty()) {
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(que.poll() + "\n");
                    }
                    break;
      
            }
        }

        bw.flush();
        bw.close();
    }
}
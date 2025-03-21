import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    stk.push(Integer.parseInt(st.nextToken()));
                    break;

                case "top":
                    bw.write(stk.isEmpty() ? "-1\n" : stk.peek() + "\n");
                    break;

                case "size":
                    bw.write(stk.size() + "\n");
                    break;

                case "empty":
                    bw.write(stk.isEmpty() ? "1\n" : "0\n");
                    break;

                case "pop":
                    bw.write(stk.isEmpty() ? "-1\n" : stk.pop() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
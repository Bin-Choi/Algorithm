import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int time = Integer.parseInt(br.readLine());
        Deque<Integer> stk = new LinkedList<>();
        int [] arr = new int[time];

        for(int i = 0; i < time; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int num = 1;


        while(cnt != time) {

            if (stk.isEmpty()) {
                stk.add(num);
                num++;

                if (num > time+1) {
                    break;
                }

                sb.append("+\n");
                continue;
            }
            
            if (stk.peekLast() != arr[cnt]) {
                stk.add(num);
                num++;

                if (num > time+1) {
                    break;
                }

                sb.append("+\n");
                
            }

            else {
                stk.pollLast();
                sb.append("-\n");
                cnt++;
            }
        }
            
        
        if (cnt != time) {
            System.out.println("NO");
        }
        else {
            System.out.print(sb);
        }
   }
}
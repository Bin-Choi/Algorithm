import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[201];
    

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken()) + 100;
            arr[x]++;
        }

        int X = Integer.parseInt(br.readLine())+100;

        int answer = arr[X];

        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] student = new int[2][7];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            student[gender][grade]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                int cnt = student[i][j];

                if (cnt > 0) {
                    if (cnt % M == 0) {
                        answer += (cnt / M);
                    } else {
                        answer += (cnt / M) + 1;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
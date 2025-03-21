import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) { // ✅ i 대신 t 사용하여 반복문 안정화
            String line = br.readLine();

            // ✅ 입력이 없을 경우 방어 코드 추가
            if (line == null || line.isEmpty()) {
                System.out.println("Impossible");
                continue;
            }

            StringTokenizer st = new StringTokenizer(line);

            // ✅ 두 개의 문자열이 존재하지 않으면 Impossible 출력
            if (st.countTokens() != 2) {
                System.out.println("Impossible");
                continue;
            }

            String a = st.nextToken();
            String b = st.nextToken();

            // 길이가 다르면 Impossible
            if (a.length() != b.length()) {
                System.out.println("Impossible");
                continue;
            }

            int[] arr = new int[26]; 
            boolean flag = true;
            int n = a.length();

            // ✅ i를 반복문 안에서만 사용하도록 변경
            for (int i = 0; i < n; i++) {
                arr[a.charAt(i) - 'a']++;
                arr[b.charAt(i) - 'a']--;
            }

            // ✅ 알파벳 카운트가 0이 아닌 것이 있다면 Impossible
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0) {
                    flag = false;
                    break;
                }
            }

            System.out.println(flag ? "Possible" : "Impossible");
        }
    }
}
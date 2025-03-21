import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        String target = br.readLine();

        int[] charCount = new int[26];

        // 두 문자열의 문자를 동시에 처리하여 배열 업데이트
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < target.length(); i++) {
            charCount[target.charAt(i) - 'a']--;
        }

        // 애너그램이 되기 위해 변경해야 할 문자 수 계산
        int changes = 0;
        for (int count : charCount) {
            changes += Math.abs(count);
        }

        System.out.println(changes);
    }
}
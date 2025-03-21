import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        for (int j = 0; j < target.length(); j++) {
            arr[target.charAt(j) - 'a']--;
        }

        int count = 0;

        for (int t = 0; t < 26; t++) {
            if (arr[t] != 0) {
                count+= Math.abs(arr[t]);
            }
        }

        System.out.println(count);
    }
}
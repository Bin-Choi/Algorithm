import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            String target = st.nextToken();
            
            char[] chArr1 = str.toCharArray();
            Arrays.sort(chArr1);

            String origin = new String(chArr1);

            chArr1 =target.toCharArray();
            Arrays.sort(chArr1);
            
            String compair = new String(chArr1);

            if (origin.equals(compair)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
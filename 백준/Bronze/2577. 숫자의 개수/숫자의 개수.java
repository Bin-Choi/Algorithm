import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[10];
        int sum = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        
       while(sum!=0) {
           arr[sum%10]++;
           sum/=10;
       }
        
        for (int i=0; i < 10; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }
}
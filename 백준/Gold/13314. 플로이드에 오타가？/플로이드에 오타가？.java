import java.io.*;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(100+"\n");
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == j) sb.append(0+" ");
                else if (j == 99 || i == 99) sb.append(1+" ");
                else sb.append(1000+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
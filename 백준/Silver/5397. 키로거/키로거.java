import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int time = Integer.parseInt(br.readLine());
        

        for (int i = 0; i < time; i++) {
            LinkedList<Character> list = new LinkedList<Character>();
            String str = br.readLine();
            ListIterator<Character> iter = list.listIterator();
            
            for (char c : str.toCharArray()) {
                switch (c) {
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;

                    case '>' :
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                        
                    case '-' :
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;

                    default:
                        iter.add(c);
                        break;
                }
            }

            for(char c : list) {
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
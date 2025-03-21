import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        Integer time = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<Character>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();

        while(iter.hasNext()) {
            iter.next();
        }

        for (int t = 0; t < time; t++) {
            String commnad = br.readLine();
            char c = commnad.charAt(0);

            switch (c) {
                case 'L':
                    if (iter.hasPrevious()) {
                        iter.previous();
                    }
                    break;
            
                case 'D' :
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;

                case 'B' :
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;

                case 'P' :
                    char p = commnad.charAt(2);
                    iter.add(p);

                    break;
                default:
                    break;
            }
        }
        for (Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();
    }
}
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void testCase()
    {
        int N;

        N = scanner.nextInt();
        findAnswer(N);
    }

    public static void findAnswer(int N)
    {
        int div = 2;
        int current = N, count = 0;

        while(true)
        {
            if(current == 1)
            {
                System.out.println(div + " " + count);
                break;
            }
            else if(current % div == 0)
            {
                count++;
                current = current / div;
                //System.out.println("current : " + current);
                //System.out.println("div : " + div);
                //System.out.println("count : " + count);
            }
            else
            {
                if(count == 0)
                {
                    ;
                }
                else {
                    System.out.println(div + " " + count);
                }
                div++;
                count = 0;
            }
        }
    }

    public static void main(String[] args) {
        int T, i;

        T = scanner.nextInt();
        for(i = 0; i < T; i++)
        {
            testCase();
        }

        scanner.close();
    }
}
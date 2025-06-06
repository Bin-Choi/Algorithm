import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    static int n,m;
    static int[] praise, answer;	//칭찬 수치 관련 배열
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();	//트리 관련 리스트
    public static void main(String[] args) throws IOException{
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        praise = new int[n+1];
        answer = new int[n+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<=n;i++)
            tree.add(new ArrayList<>());
        st.nextToken();
        //트리 값 저장.
        for(int i=2;i<=n;i++){
            int parent = Integer.parseInt(st.nextToken());
            tree.get(parent).add(i);
        }
        //칭찬의 수치 저장.
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int p = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());
            praise[p] += degree;
        }
        //DFS 탐색.
        DFS(1, 0);
        //각 직원들의 칭찬 수치 BufferedWriter 저장
        for(int i = 1;i<=n;i++)
            bw.write(answer[i] + " ");

        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //칭찬의 수치가 누적되도록 진행되면서 DFS탐색을 진행하는 함수
    static void DFS(int cur, int degree){
        degree += praise[cur];		//칭찬 수치 누적
        answer[cur] = degree;		//칭찬 수치 저장
        //부하 직원들 탐색
        for(int child : tree.get(cur))
            DFS(child, degree);
    }
}
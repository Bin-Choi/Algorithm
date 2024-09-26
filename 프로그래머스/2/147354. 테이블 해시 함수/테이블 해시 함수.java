import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> (o1[col-1] == o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col-1]));
        int answer = 0;
        for (int i = row_begin-1; i < row_end; i++) {
            int s_cnt = 0;
            for (int j = 0; j < data[i].length; j++) {
                s_cnt += (data[i][j]%(i+1));
            }
            answer ^= s_cnt;
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int cnt = 0;
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        ArrayList<Integer> values = new ArrayList<>(map.values());
        
        Collections.sort(values, Collections.reverseOrder());
        for (int v: values) {
            if (sum + v >= k) {
                cnt ++;
                break;
            } else {
                sum += v;
                cnt++;
            }
        }
    
        return cnt;
    }
}
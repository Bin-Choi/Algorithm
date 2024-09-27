class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long x = 0; x <= d; x += k) {
            long rangeY = (long) Math.sqrt((long)d*d - (long)x*x);
            answer += (rangeY / k+1);
        }
        return answer;
    }
}

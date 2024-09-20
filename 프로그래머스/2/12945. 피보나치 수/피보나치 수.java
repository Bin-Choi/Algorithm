class Solution {
    public int solution(int n) {
        int[] N = new int[n+1];
        N[0] = 0;
        N[1] = 1;
        for (int i = 2; i <= n; i++) {
            N[i] = (N[i-2] + N[i-1]) % 1234567;
        }
        return N[n];
    }
}
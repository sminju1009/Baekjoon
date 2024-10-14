class Solution {
    public long solution(int n) {
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 3;
        
        for (int i = 4; i<=n; i+=2) {
            dp[i] = (dp[i-2]*4%1000000007 - dp[i-4]%1000000007 + 1000000007)%1000000007;
        }
        return dp[n];
    }
}
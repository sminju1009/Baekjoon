class Solution {
    public int solution(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;

        // 모든 문자 자체는 팰린드롬
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 두 문자로 된 팰린드롬 처리
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
            }
        }

        // 길이가 3 이상인 부분 문자열에 대해 DP 처리
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }
}

import java.util.*;

class Solution {

    public long solution(int[] sequence) {
        long answer = 0;
        
        int n = sequence.length;
        
        if (n==1) {
            return Math.abs(sequence[0]);
        }
        
        long[] perse1 = new long[n];
        long[] perse2 = new long[n];
        perse1[0] = 1;
        perse2[0] = -1;

        for (int i = 1; i < n; i++) {
            perse1[i] = -perse1[i-1];
            perse2[i] = -perse2[i-1];
        }
        
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        dp1[0] = perse1[0] * sequence[0];
        dp2[0] = perse2[0] * sequence[0];
        if (dp1[0] < 0) {
            dp1[0] = 0;
        }
        if (dp2[0] < 0) {
            dp2[0] = 0;
        }
        
        for (int i = 1; i<n; i++) {
            dp1[i] = dp1[i-1] + perse1[i] * sequence[i];
            dp2[i] = dp2[i-1] + perse2[i] * sequence[i];
            answer = Math.max(answer, dp1[i]);
            answer = Math.max(answer, dp2[i]);
            if (dp1[i]<0) {
                dp1[i] = 0;
            }
            if (dp2[i]<0) {
                dp2[i] = 0;
            }
        }
        
        
        return answer;
    }
}

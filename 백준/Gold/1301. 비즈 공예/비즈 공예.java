import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] glass = new int[6];
    static int total;
    static long[][][][][][][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            glass[i] = Integer.parseInt(br.readLine());
            total += glass[i];
        }
        
        dp = new long[glass[1] + 1][glass[2] + 1][glass[3] + 1][glass[4] + 1][glass[5] + 1][6][6];
        
        for (int i = 0; i <= glass[1]; i++) {
            for (int j = 0; j <= glass[2]; j++) {
                for (int k = 0; k <= glass[3]; k++) {
                    for (int l = 0; l <= glass[4]; l++) {
                        for (int m = 0; m <= glass[5]; m++) {
                            for (int p1 = 0; p1 < 6; p1++) {
                                for (int p2 = 0; p2 < 6; p2++) {
                                    dp[i][j][k][l][m][p1][p2] = -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(dfs(0, 0, 0, 0, 0, 0, 0));
    }
    
    public static long dfs(int num1, int num2, int num3, int num4, int num5, int prev1, int prev2) {
        if (num1 + num2 + num3 + num4 + num5 == total) {
            return 1;
        }
        
        if (dp[num1][num2][num3][num4][num5][prev1][prev2] != -1) {
            return dp[num1][num2][num3][num4][num5][prev1][prev2];
        }
        
        long count = 0;

        if (num1 < glass[1] && prev1 != 1 && prev2 != 1) {
            count += dfs(num1 + 1, num2, num3, num4, num5, 1, prev1);
        }
        
        if (num2 < glass[2] && prev1 != 2 && prev2 != 2) {
            count += dfs(num1, num2 + 1, num3, num4, num5, 2, prev1);
        }
        
        if (num3 < glass[3] && prev1 != 3 && prev2 != 3) {
            count += dfs(num1, num2, num3 + 1, num4, num5, 3, prev1);
        }
        
        if (n >= 4 && num4 < glass[4] && prev1 != 4 && prev2 != 4) {
            count += dfs(num1, num2, num3, num4 + 1, num5, 4, prev1);
        }
        
        if (n >= 5 && num5 < glass[5] && prev1 != 5 && prev2 != 5) {
            count += dfs(num1, num2, num3, num4, num5 + 1, 5, prev1);
        }

        dp[num1][num2][num3][num4][num5][prev1][prev2] = count;
        return count;
    }
}
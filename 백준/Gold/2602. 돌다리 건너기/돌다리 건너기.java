import java.util.*;
import java.io.*;

public class Main {

    static String paper, angel, devil;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        paper = br.readLine();
        angel = br.readLine();
        devil = br.readLine();

        dp = new int[angel.length()][paper.length()][2];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < paper.length(); j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < angel.length(); i++) {
            if (angel.charAt(i) == paper.charAt(0)) {
                result += dfs(i, 0, 1);
            }
        }
        for (int i = 0; i < devil.length(); i++) {
            if (devil.charAt(i) == paper.charAt(0)) {
                result += dfs(i, 0, 0);
            }
        }

        System.out.println(result);
    }

    public static int dfs(int idx, int level, int isAngel) {
        if (level == paper.length() - 1) {
            return 1;
        }

        if (dp[idx][level][isAngel] != -1) {
            return dp[idx][level][isAngel];
        }

        int result = 0;
        String currentBridge = (isAngel == 1) ? angel : devil;
        String otherBridge = (isAngel == 1) ? devil : angel;

        char nextChar = paper.charAt(level + 1);

        for (int i = idx + 1; i < otherBridge.length(); i++) {
            if (otherBridge.charAt(i) == nextChar) {
                result += dfs(i, level + 1, 1 - isAngel);
            }
        }

        return dp[idx][level][isAngel] = result;
    }
}
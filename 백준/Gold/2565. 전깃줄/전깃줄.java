import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dp;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n];
        Arrays.fill(dp, -1);

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, elec(i));
        }

        System.out.println(n - answer);
    }

    public static int elec(int num) {
        if (dp[num] != -1) return dp[num];

        dp[num] = 1; 
        for (int i = num + 1; i < dp.length; i++) {
            if (arr[num][1] < arr[i][1]) {
                dp[num] = Math.max(dp[num], elec(i) + 1);
            }
        }
        return dp[num];
    }
}
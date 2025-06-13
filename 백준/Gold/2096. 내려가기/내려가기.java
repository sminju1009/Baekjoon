import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
        for (int i = 1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] minDp = new int[n+1][3];
        int[][] maxDp = new int[n+1][3];

        for (int i = 1; i<=n; i++) {
            minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + arr[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]) + arr[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + arr[i][2];

            maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + arr[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]) + arr[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + arr[i][2];
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i<3; i++) {
            min = Math.min(min, minDp[n][i]);
            max = Math.max(max, maxDp[n][i]);
        }
        System.out.println(max + " " + min);
    }
}
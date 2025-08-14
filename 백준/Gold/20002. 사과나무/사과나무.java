import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static int[][] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        prefixSum = new int[n+1][n+1];
        for (int i = 1;  i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + arr[i][j];
            }
        }
        int answer = Integer.MIN_VALUE;
        int k = -1;
        while (k++<n) {
            for (int i = 1; i<n-k+1; i++) {
                for (int j = 1; j<n-k+1; j++) {
                    int profit = prefixSum[i+k][j+k] - prefixSum[i-1][j+k] - prefixSum[i+k][j-1] + prefixSum[i-1][j-1];
                    answer = Math.max(answer, profit);
                }
            }
        }
        System.out.println(answer);
    }
}
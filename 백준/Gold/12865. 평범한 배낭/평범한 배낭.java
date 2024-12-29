import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] knapsack = new int[n + 1][k + 1];

        int[][] item = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st.nextToken());
            item[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                int w = item[i - 1][0];
                int value = item[i - 1][1];
                if (j < w) {
                    knapsack[i][j] = knapsack[i - 1][j];
                } else {
                    knapsack[i][j] = Math.max(knapsack[i - 1][j], value + knapsack[i - 1][j - w]);
                }
            }
        }
        System.out.println(knapsack[n][k]);
    }
}
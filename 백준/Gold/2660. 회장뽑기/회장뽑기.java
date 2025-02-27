import java.util.*;
import java.io.*;

public class Main {
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i != j) arr[i][j] = INF;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            arr[a][b] = arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int leaderScore = INF;

        int[] score = new int[n+1];
        for (int i = 1; i<=n; i++) {
            int temp = 0;
            for (int j = 1; j<=n; j++) {
                if (arr[i][j] != INF) {
                    temp = Math.max(temp, arr[i][j]);
                }
            }
            score[i] = temp;
            leaderScore = Math.min(leaderScore, temp);
        }

        sb.append(leaderScore + " ");

        int leaderCount = 0;

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i<=n; i++) {
            if (leaderScore == score[i]) {
                leaderCount++;
                result.add(i);
            }
        }

        sb.append(leaderCount + "\n");
        for (int i: result) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
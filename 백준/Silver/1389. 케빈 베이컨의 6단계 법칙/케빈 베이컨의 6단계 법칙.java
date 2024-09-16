import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n+1][n+1];

        // 거리 배열 초기화
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                if (i!=j) {
                    dist[i][j] = 1000000;
                }
            }
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dist[start][end] = 1;
            dist[end][start] = 1;
        }

        // 3중 for문 돌면서 배열 업데이트
        for (int k = 1; k<=n; k++) {
            for (int i = 1; i<=n; i++) {
                for (int j = 1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int[] result = new int[n+1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i<=n; i++) {
            int temp = 0;
            for (int j = 1; j<=n; j++) {
                temp += dist[i][j];
            }
            result[i] = temp;
            min = Math.min(min, temp);
        }
        for (int i = 1; i<=n; i++) {
            if (result[i] == min) {
                System.out.println(i);
                break;
            }
        }

    }
}
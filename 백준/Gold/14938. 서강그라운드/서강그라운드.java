import java.util.*;
import java.io.*;

public class Main {

    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++) {
                if (i==j) continue;
                arr[i][j] = INF;
            }
        }

        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[s][e] = d;
            arr[e][s] = d;
        }

        for (int k = 1; k<=n; k++) {
            for (int i = 1; i<=n; i++) {
                for (int j = 1; j<=n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int result = 0;
        int cnt = 0;
        for (int i = 1; i<=n; i++) {
            cnt = 0;
            for (int j = 1; j<=n; j++) {
                if (arr[i][j]<=m) cnt += items[j];
            }
            result = Math.max(cnt, result);
        }

        System.out.println(result);
    }
}
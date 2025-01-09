import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (i!=j) {
                    arr[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a-1][b-1] = Math.min(arr[a-1][b-1], c);
        }



        for (int k = 0; k<n; k++) {
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (arr[i][k] != 10000001 && arr[k][j] != 10000001) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (arr[i][j] == 10000001) {
                    sb.append("0 ");
                } else {
                    sb.append(arr[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
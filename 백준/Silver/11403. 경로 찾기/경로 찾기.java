import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k<n; k++) {
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (arr[i][k]==1 && arr[k][j]==1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
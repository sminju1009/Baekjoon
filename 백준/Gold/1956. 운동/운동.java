import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] arr = new int[v][v];
        for (int i = 0; i<v; i++) {
            for (int j = 0; j<v; j++) {
                arr[i][j] = 987654321;
            }
        }
        for (int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            arr[start][end] = weight;
        }
        for (int k = 0; k<v; k++) {
            for (int i = 0; i<v; i++) {
                for (int j = 0; j<v; j++) {
                    if (i!=j) {
                        if (arr[i][j] > arr[i][k] + arr[k][j]) {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i<v; i++) {
            for (int j = 0; j<v; j++) {
                if (arr[i][j] != 987654321 && arr[j][i] != 987654321) {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }

        System.out.println((answer!=Integer.MAX_VALUE) ? answer : -1);
    }
}
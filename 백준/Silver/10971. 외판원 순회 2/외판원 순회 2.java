import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static long answer = Integer.MAX_VALUE;

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

        for (int i = 0; i<n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            backtracking(0, i, i, 0);
        }
        System.out.println(answer);
    }

    public static void backtracking(int level, int start, int now, long result) {
        if (level==n-1) {
            if (arr[now][start]!=0) {
                answer = Math.min(answer, result+arr[now][start]);
            }
            return;
        }
        for (int i = 0; i<n; i++) {
            if (!visited[i] && arr[now][i]!=0) {
                visited[i] = true;
                backtracking(level+1, start, i, result+arr[now][i]);
                visited[i] = false;
            }
        }
    }
}
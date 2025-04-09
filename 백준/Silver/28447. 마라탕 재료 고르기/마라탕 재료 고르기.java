import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static boolean[] visited;
    static int[][] arr;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int level) {
        int temp = 0;
        if (level==k) {
            for (int i = 0; i<n-1; i++) {
                for (int j = i+1; j<n; j++) {
                    if (visited[i] && visited[j]) {
                        temp += arr[i][j];
                    }
                }
            }
            answer = Math.max(answer, temp);
            return;
        }
        for (int i = 0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(level+1);
                visited[i] = false;
            }
        }
    }
}
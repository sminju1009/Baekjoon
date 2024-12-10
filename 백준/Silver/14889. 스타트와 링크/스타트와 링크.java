import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

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
        visited = new boolean[n];
        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int level, int idx) {
        if (level==n/2) {
            int startScore = 0;
            int linkScore = 0;
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<n; j++) {
                    if (visited[i] && visited[j]) {
                        startScore += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        linkScore += arr[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(startScore-linkScore));
            return;
        }
        for (int i = idx; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(level+1, i+1);
                visited[i] = false;
            }
        }
    }
}
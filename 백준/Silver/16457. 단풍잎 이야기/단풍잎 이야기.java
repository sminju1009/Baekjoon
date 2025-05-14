import java.util.*;
import java.io.*;

public class Main {

    static int n, m, k;
    static boolean[] visited; 
    static int result = Integer.MIN_VALUE;
    static boolean[] checked;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[2*n+1];
        checked = new boolean[m];
        arr = new int[m][k];
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<k; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1);
        System.out.println(result);
    }

    public static void dfs(int level, int start) {
        if (level == n) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                int flag = 0;
                for (int j = 0; j < k; j++) {
                    if (visited[arr[i][j]]) flag++;
                }
                if (flag == k) count++;
            }
            result = Math.max(result, count);
            return;
        }

        for (int i = start; i <= 2 * n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(level+1, i+1);
                visited[i] = false;
            }
        }
    }

}
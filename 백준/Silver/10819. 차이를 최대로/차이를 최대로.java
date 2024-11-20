import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    static boolean[] visited;
    static int[] result;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);

    }

    public static void dfs(int level) {
        if (level==n) {
            int temp = 0;
            for (int i = 0; i<n-1; i++) {
                temp += Math.abs(result[i] - result[i+1]);
            }

            max = Math.max(temp, max);
        }
        for (int i = 0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[level] = arr[i];
                dfs(level+1);
                visited[i] = false;
                result[level] = 0;
            }
        }
    }
}
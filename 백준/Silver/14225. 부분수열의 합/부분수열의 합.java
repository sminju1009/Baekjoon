import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static int n;
    static int[] arr;
    static boolean[] isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        isPossible = new boolean[sum+1];
        dfs(0, 0, 0);

        boolean isOk = true;
        for (int i = 1; i<=sum; i++) {
            if (!isPossible[i]) {
                isOk = false;
                System.out.println(i);
                break;
            }
        }
        if (isOk) System.out.println(sum+1);
    }

    public static void dfs(int level, int start, int sum) {
        isPossible[sum] = true;

        for (int i = start; i<n; i++) {
            visited[i] = true;
            dfs(level+1, i+1, sum+arr[i]);
            visited[i] = false;

        }
    }
}
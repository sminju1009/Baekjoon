import java.io.*;

public class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n+1];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int level) {
        if (level==n) {
            for (int i = 0; i<n; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i<=n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[level] = i;
                dfs(level+1);
                visited[i] = false;
                arr[level] = 0;
            }
        }
    }
}
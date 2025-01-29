import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t<tc; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i<=n; i++) {
                dfs(i);
            }

            System.out.println(n-count);
            
        }
    }

    public static void dfs(int now) {
        if (visited[now]) return;

        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                count++;
                for (int i = next; i!=now; i = arr[i]) {
                    count++;
                }
            }
        }

        finished[now] = true;
    }
}
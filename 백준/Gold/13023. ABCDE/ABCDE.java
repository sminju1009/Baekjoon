import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean isCycle = false;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 0; i<n; i++) {
            if (!isCycle) {
                visited = new boolean[n];
                dfs(i, 0);
            }
        }

        int answer = (isCycle) ? 1 : 0;
        System.out.println(answer);
    }

    public static void dfs(int start, int level) {
        if (level==5) {
            isCycle = true;
            return;
        }
        for (int now: arr.get(start)){
            if (!visited[now]) {
                visited[now] = true;
                dfs(now, level+1);
                if (isCycle) return;
                visited[now] = false;
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int cost = Integer.MAX_VALUE;
    static int mp, mf, ms, mv;
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static boolean[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][5];
        visited = new boolean[n];
        result = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
            arr[i][4] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0, 0, 0, 0, 0);
        StringBuilder sb = new StringBuilder();
        if (cost!=Integer.MAX_VALUE) {
            sb.append(cost + "\n");
            for (int i = 0; i<n; i++) {
                if (result[i]) {
                    sb.append(i+1 + " ");
                }
            }
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    public static void dfs(int level, int start, int p, int f, int s, int v, int c) {
        if (c>cost) {
            return;
        }
        if (p>=mp && f>=mf && s>=ms && v>=mv && c<cost) {
            cost = Math.min(c, cost);
            result = visited.clone();
        }
        for (int i = start; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(level+1, i+1, p+arr[i][0], f+arr[i][1], s+arr[i][2], v+arr[i][3], c+arr[i][4]);
                visited[i] = false;
            }
        }
    }
}
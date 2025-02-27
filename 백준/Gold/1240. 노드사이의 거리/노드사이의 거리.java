import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int end;
        int dist;

        public Pair(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }
    }

    static int n;
    static ArrayList<ArrayList<Pair>> array = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i<n; i++) {
            array.add(new ArrayList<>());
        }
        for (int i = 0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());
            array.get(start).add(new Pair(end, dist));
            array.get(end).add(new Pair(start, dist));
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            visited = new boolean[n];
            int answer = dfs(s, e, 0);
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }

    public static int dfs(int start, int end, int dist) {
        if (start == end) return dist;

        visited[start] = true;

        for (Pair now : array.get(start)) {
            if (!visited[now.end]) {
                int result = dfs(now.end, end, dist + now.dist);
                if (result != 0) return result;
            }
        }
        return 0;
    }
}
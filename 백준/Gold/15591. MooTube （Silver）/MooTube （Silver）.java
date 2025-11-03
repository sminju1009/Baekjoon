import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int y;
        int w;
        public Pair(int y, int w) { this.y = y; this.w = w; }
    }
    static int n;
    static ArrayList<ArrayList<Pair>> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Pair(b, usado));
            arr.get(b).add(new Pair(a, usado));
        }

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new LinkedList<>();
            visited[v] = true;
            queue.add(v);
            int count = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (Pair p : arr.get(cur)) {
                    if (!visited[p.y] && p.w >= k) {
                        visited[p.y] = true;
                        queue.add(p.y);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
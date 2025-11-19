import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int INF = 987654321;
    static int[] dist;
    static int[] route;
    static class Pair implements Comparable<Pair> {
        int y, cost;

        public Pair (int y, int cost) {
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int start, end;
    static ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        route = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, INF);
        for (int i = 0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Pair(b, cost));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[end]);

        ArrayList<Integer> temp = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            temp.add(cur);
            cur = route[cur];
        }
        System.out.println(temp.size());
        for (int i = temp.size()-1; i>=0; i--) {
            System.out.print(temp.get(i) + " ");
        }
    }

    public static void dijkstra() {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 0));
        dist[start] = 0;
        route[start] = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (!visited[curr.y]) visited[curr.y] = true;
            else continue;

            for (Pair p: arr.get(curr.y)) {
                int py = p.y;
                int pcost = p.cost;

                if (dist[py] > dist[curr.y] + pcost) {
                    dist[py] = dist[curr.y] + pcost;
                    q.add(new Pair(py, dist[py]));
                    route[py] = curr.y;
                }

            }
        }
    }
}
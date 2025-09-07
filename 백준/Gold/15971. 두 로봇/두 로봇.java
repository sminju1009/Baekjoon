import java.util.*;
import java.io.*;

public class Main {

    static int n, start, end;
    static boolean[] visited;
    static class Node {
        int y, dist;

        public Node(int y, int dist) {
            this.y = y;
            this.dist = dist;
        }
    }
    static class Pair {
        int e, sumDist, maxDist;

        public Pair(int e, int sumDist, int maxDist) {
            this.e = e;
            this.sumDist = sumDist;
            this.maxDist = maxDist;
        }
    }
    static int sum = 0, max = 0;

    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        for (int i = 0 ;i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for (int i = 0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr.get(s).add(new Node(e, d));
            arr.get(e).add(new Node(s, d));
        }
        bfs();
        System.out.println(sum-max);
    }

    public static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        visited[start] = true;
        for (Node node: arr.get(start)) {
            int y = node.y;
            int dist = node.dist;
            q.add(new Pair(y, dist, dist));
        }

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.e==end) {
                sum = curr.sumDist;
                max = curr.maxDist;
                return;
            }

            for (Node node : arr.get(curr.e)) {
                int y = node.y;
                int dist = node.dist;
                if (!visited[y]) {
                    visited[y] = true;
                    q.add(new Pair(y, curr.sumDist+dist, Math.max(curr.maxDist, dist)));
                }
            }
        }
    }
}
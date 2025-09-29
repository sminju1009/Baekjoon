import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static class Node implements Comparable<Node> {
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine()); // 정점 수
        int e = Integer.parseInt(br.readLine()); // 간선 수

        parent = new int[v+1];
        for (int i = 1; i<=v; i++) {
            parent[i] = i;
        }

        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i<e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, w));
        }

        int total = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int to = find(node.to);
            int from = find(node.from);
            if (!isSameParent(to, from)) {
                total += node.value;
                union(node.to, node.from);
            }

        }
        System.out.println(total);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x!=y) parent[y] = x;
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x==y) return true;
        return false;
    }
}

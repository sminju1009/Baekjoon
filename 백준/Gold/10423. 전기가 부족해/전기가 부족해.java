import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to, from, value;

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
    static int n, m, k;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        for (int i = 0; i<=n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<k; i++) {
            int num = Integer.parseInt(st.nextToken()) - 1;
            parent[num] = n;
        }

        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
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
        if (parent[x]==x) return x;
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
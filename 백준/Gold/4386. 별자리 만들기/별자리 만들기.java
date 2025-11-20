import java.util.*;
import java.io.*;

public class Main {

    static class Pair implements Comparable<Pair>{
        int start, end;
        double dist;

        public Pair(int start, int end, double dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(this.dist, o.dist);
        }
    }
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[][] arr = new double[n][2];
        for (int i = 0 ;i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i<n-1; i++) {
            for (int j = i+1; j<n; j++) {
                double d = Math.sqrt(Math.pow(Math.abs(arr[i][0]-arr[j][0]), 2) + Math.pow(Math.abs(arr[i][1]-arr[j][1]), 2));
                pq.add(new Pair(i, j, d));
            }
        }

        parent = new int[n];
        for (int i = 0; i<n; i++) {
            parent[i] = i;
        }

        double total = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int start = find(curr.start);
            int end = find(curr.end);
            if (!isSameParent(start, end)) {
                total += curr.dist;
                union(curr.start, curr.end);
            }
        }

        System.out.printf("%.2f", total);
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
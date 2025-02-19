import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int money;
        int friend1;
        int friend2;

        public Pair(int money, int friend1, int friend2){
            this.money = money;
            this.friend1 = friend1;
            this.friend2 = friend2;
        }

    }

    static int n, k;
    static int result = 0;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 1; i<=n; i++) {
            parent[i] = i;
        }

        int[] money = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Pair> edges = new ArrayList<>();

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());
            edges.add(new Pair(0, friend1, friend2));
        }

        for (int i = 0; i<n; i++) {
            edges.add(new Pair(money[i], 0, i+1));
        }

        edges.sort(Comparator.comparingInt(o -> o.money));

        for (Pair edge : edges) {
            int cost = edge.money;
            int a = edge.friend1;
            int b = edge.friend2;

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println((result<=k) ? result : "Oh no");

    }

    public static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

}
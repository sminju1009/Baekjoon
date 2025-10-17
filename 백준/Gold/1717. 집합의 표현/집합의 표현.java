import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i<=n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cal==0) {
                union(a, b);
            } else {
                boolean flag = isSameParent(a, b);
                sb.append((flag ? "YES" : "NO") + "\n");
            }
        }

        System.out.println(sb);
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
import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int j = 0; j<tc; j++) {
            int n = Integer.parseInt(br.readLine());
            parent = new int[n];
            for (int i = 0; i<n; i++) {
                parent[i] = i;
            }
            int k = Integer.parseInt(br.readLine());
            for (int i = 0 ; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (find(a)!=find(b)) union(a, b);
            }

            sb.append("Scenario ").append(j+1).append(":\n");

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (find(a)==find(b)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

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
}
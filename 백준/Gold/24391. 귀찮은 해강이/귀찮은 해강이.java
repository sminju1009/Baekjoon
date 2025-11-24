import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for (int i = 0; i<=n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int answer = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i>0 && find(arr[i])!=find(arr[i-1])) answer++;
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if (parents[x]==x) return x;
        return parents[x] = find(parents[x]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a!=b) parents[b] = a;
    }
}
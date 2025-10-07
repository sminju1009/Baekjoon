import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m;
    static int s;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] gomgom;
    static int yes = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        for (int i = 0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
        }
        s = Integer.parseInt(br.readLine());
        gomgom = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<s; i++) {
            gomgom[Integer.parseInt(st.nextToken())] = true;
        }

        dfs(1, gomgom[1]);
        System.out.println((yes>0) ? "yes" : "Yes");
    }

    public static void dfs(int num, boolean flag) {
        if (flag) return;
        if (arr.get(num).size()==0 && !flag) {
            yes++;
            return;
        }

        visited[num] = true;
        for (int i: arr.get(num)) {
            if (!visited[i]) {
                if (gomgom[i]) {
                    dfs(i, true);
                    visited[i] = false;
                } else {
                    dfs(i, false);
                }
           }
        }

    }
}
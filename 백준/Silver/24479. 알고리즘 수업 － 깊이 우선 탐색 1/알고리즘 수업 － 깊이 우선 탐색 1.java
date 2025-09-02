import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        visited = new int[n+1];
        arr = new ArrayList<>();
        for (int i = 0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.get(s).add(e);
            arr.get(e).add(s);
        }

        for (int i = 0; i<arr.size(); i++) {
            Collections.sort(arr.get(i));
        }

        count = 1;
        visited[r] = count;
        dfs(r);

        for (int i = 1; i<=n; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void dfs(int now) {
        for (int i: arr.get(now)) {
            if (visited[i]==0) {
                count++;
                visited[i] = count;
                dfs(i);
            }
        }
    }
}
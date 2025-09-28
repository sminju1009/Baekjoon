import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now==1) {
                    arr.get(i).add(j);
                }
                if (i==j) arr.get(i).add(j);
            }
        }
        road = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ;i<m; i++) {
            road[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        boolean flag = true;
        for (int i = 0; i<m-1; i++) {
            if (!flag) break;
            flag = bfs(road[i], road[i+1]);
        }

        System.out.println((flag) ? "YES" : "NO");

    }

    public static boolean bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr==end) return true;

            for (int i: arr.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        return false;
    }
}
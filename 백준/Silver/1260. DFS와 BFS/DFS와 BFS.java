import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n, m, v;
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    static Queue<Integer> q = new LinkedList<>();

    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visitedDfs = new boolean[n+1];
        visitedBfs = new boolean[n+1];
        arr = new ArrayList<>();
        // arr 초기화
        for (int i = 0; i<=n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        // 정렬과정
        for (int i = 1; i<=n; i++) {
            if (!arr.get(i).isEmpty()) {
                Collections.sort(arr.get(i));
            }
        }

        sb.append(v + " ");
        dfs(v);
        sb.append("\n");
        bfs(v);
        System.out.println(sb);

    }
    public static void dfs(int start) {
        visitedDfs[start] = true;
        for (int node: arr.get(start)) {
            if (!visitedDfs[node]) {
                sb.append(node + " ");
                visitedDfs[node] = true;
                dfs(node);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);
        visitedBfs[start] = true;
        sb.append(start + " ");

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int no: arr.get(node)) {
                if (!visitedBfs[no]) {
                    visitedBfs[no] = true;
                    sb.append(no + " ");
                    q.add(no);
                }
            }

        }
    }
}
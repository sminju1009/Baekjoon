import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static boolean[] visited;
    static class Pair {
        int e, cost;

        public Pair(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
    static ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;
        int money = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Pair(b, c));
            arr.get(b).add(new Pair(a, c));
        }

        dfs(start, end, money, 0, 0);
        System.out.println((answer!=Integer.MAX_VALUE) ? answer : -1);
    }

    public static void dfs(int start, int end, int money, int sum, int max) {
        if (money<sum) return;

        if (money<max) return;

        if (start==end) {
            answer = Math.min(answer, sum);
            return;
        }

        visited[start] = true;

        for (Pair i: arr.get(start)) {
            int nowArrival = i.e;
            int nowCost = i.cost;
            if (!visited[nowArrival]) {
                dfs(nowArrival, end, money, Math.max(sum, nowCost), max+nowCost);
                visited[nowArrival] = false;
            }
        }
    }
}
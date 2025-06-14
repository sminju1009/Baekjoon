import java.util.*;
import java.io.*;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static class Pair{
        int num, cost;

        public Pair(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    static int n;
    static int[] costs;
    static boolean[] visited;
    static ArrayList<ArrayList<Pair>> discount = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        costs = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<n; i++) {
            discount.add(new ArrayList<>());
        }
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            for (int j = 0; j<a; j++) {
                st = new StringTokenizer(br.readLine());
                int med = Integer.parseInt(st.nextToken()) - 1;
                int coin = Integer.parseInt(st.nextToken());
                discount.get(i).add(new Pair(med, coin));
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, 1, costs[i], costs.clone());
        }

        System.out.println(answer);
    }

    public static void dfs(int num, int level, int money, int[] currentCosts) {
        if (level == n) {
            answer = Math.min(answer, money);
            return;
        }

        int[] nextCosts = currentCosts.clone();
        for (Pair discount : discount.get(num)) {
            nextCosts[discount.num] = Math.max(1, nextCosts[discount.num] - discount.cost);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, level + 1, money + nextCosts[i], nextCosts);
                visited[i] = false;
            }
        }
    }
}
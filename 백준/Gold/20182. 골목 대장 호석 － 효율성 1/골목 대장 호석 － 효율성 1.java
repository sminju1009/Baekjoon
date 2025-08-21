import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static class Pair {
        int e;
        int maxSingle;
        int sum;

        public Pair(int e, int maxSingle, int sum) {
            this.e = e;
            this.maxSingle = maxSingle;
            this.sum = sum;
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

        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            
            arr.get(a).add(new Pair(b, c, 0));
            arr.get(b).add(new Pair(a, c, 0));
        }

        solve(start, end, money);
        System.out.println((answer != Integer.MAX_VALUE) ? answer : -1);
    }

    public static void solve(int start, int end, int money) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.maxSingle - b.maxSingle);

        pq.add(new Pair(start, 0, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Pair now = pq.poll();
            int nowE = now.e;
            int nowMaxSingle = now.maxSingle;
            int nowSum = now.sum;

            if (dist[nowE] < nowMaxSingle) continue;

            if (nowE == end) {
                answer = nowMaxSingle;
                return;
            }

            for (Pair next : arr.get(nowE)) {
                int nextE = next.e;
                int nextCost = next.maxSingle;

                int newMaxSingle = Math.max(nowMaxSingle, nextCost);
                int newSum = nowSum + nextCost;

                if (newSum > money) continue;

                if (dist[nextE] > newMaxSingle) {
                    dist[nextE] = newMaxSingle;
                    pq.add(new Pair(nextE, newMaxSingle, newSum));
                }
            }
        }
    }
    
}
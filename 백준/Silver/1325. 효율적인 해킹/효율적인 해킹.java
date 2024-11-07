import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int[] memo;

    private static int dfs(int idx) {
        if (memo[idx] != -1) {
            return memo[idx];
        }
        visited[idx] = true;

        int count = 1;
        for (int next : graph.get(idx)) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
        memo[idx] = count;
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        int max = -1;
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            memo = new int[N + 1];
            Arrays.fill(memo, -1);
            int count = dfs(i);
            if (max < count) {
                answer.clear();
                answer.add(i);
                max = count;
            } else if (max == count) {
                answer.add(i);
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int n : answer) {
            sb.append(n);
            sb.append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] people;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                int b = Integer.parseInt(st.nextToken());
                arr.get(i).add(b);
            }
        }

        dfs(1);

        if (answer != Integer.MAX_VALUE) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static void dfs(int idx) {
        if (idx == n + 1) {
            ArrayList<Integer> teamA = new ArrayList<>();
            ArrayList<Integer> teamB = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (visited[i]) teamA.add(i);
                else teamB.add(i);
            }

            if (teamA.isEmpty() || teamB.isEmpty()) return;

            if (bfs(teamA) && bfs(teamB)) {
                int aSum = 0, bSum = 0;
                for (int i = 1; i <= n; i++) {
                    if (visited[i]) aSum += people[i];
                    else bSum += people[i];
                }
                answer = Math.min(answer, Math.abs(aSum - bSum));
            }
            return;
        }

        visited[idx] = true;
        dfs(idx + 1);

        visited[idx] = false;
        dfs(idx + 1);
    }

    public static boolean bfs(ArrayList<Integer> team) {
        boolean[] inTeam = new boolean[n + 1];
        for (int x : team) inTeam[x] = true;

        boolean[] v = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(team.get(0));
        v[team.get(0)] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nxt : arr.get(curr)) {
                if (inTeam[nxt] && !v[nxt]) {
                    v[nxt] = true;
                    q.add(nxt);
                    count++;
                }
            }
        }

        return count == team.size();
    }
}
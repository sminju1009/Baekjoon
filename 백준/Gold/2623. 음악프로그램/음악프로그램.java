import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            array.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 0; j<now-1; j++) {
                int k = Integer.parseInt(st.nextToken()) - 1;
                array.get(before).add(k);
                indegree[k]++;
                before = k;
            }
        }

        String ans = topologicalSort(array, indegree, n);
        System.out.println(ans);
    }

    public static String topologicalSort(ArrayList<ArrayList<Integer>> array, int[] indegree, int n) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now+1);
            for (int next: array.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (result.size()!=n) {
            return "0\n";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<result.size(); i++) {
            sb.append(result.get(i)+"\n");
        }

        return sb.toString();
    }
}
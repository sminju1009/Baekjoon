import java.io.*;
import java.util.*;

public class Main {
    static Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            String a = parts[0];
            String rel = parts[1];
            String b = parts[2];
            
            // 관계를 양방향으로 추가
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String[] query = br.readLine().split(" ");
            String start = query[0];
            String end = query[1];

            if (isRelated(start, end)) sb.append("Related\n");
            else sb.append("Not Related\n");
        }

        System.out.print(sb);
    }

    static boolean isRelated(String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end))
            return false;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals(end)) return true;

            for (String next : graph.get(cur)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                }
            }
        }

        return false;
    }
}
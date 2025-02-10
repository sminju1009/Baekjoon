import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    static List<Integer> result = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            dfs(i, i);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    public static void dfs(int start, int current) {
        if (!visited[current]) {
            visited[current] = true;
            dfs(start, arr[current]);
        } else if (current == start) {
            result.add(start);
        }
    }
}
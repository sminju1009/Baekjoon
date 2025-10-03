import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
            arr2.add(new ArrayList<>());
        }
        for (int i = 0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr.get(a).add(b);
            arr2.get(b).add(a);
        }

        for (int i = 0; i<n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, arr);
            dfs(i, arr2);
            int temp = 0;
            for (int j = 0; j<n; j++) {
                if (!visited[j]) temp++;
            }
            sb.append(temp + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int num, ArrayList<ArrayList<Integer>> array) {
        for (int i: array.get(num)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, array);
            }
        }
    }
}
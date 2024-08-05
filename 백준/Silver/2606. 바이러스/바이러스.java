import java.util.*;
import java.io.*;

public class Main {

    static int[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int pairs = Integer.parseInt(br.readLine());
        visited = new int[n+1];
        arr = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i<pairs; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1);
        int count = Arrays.stream(visited).sum();
        System.out.println(count-1);
    }
    public static void dfs(int num) {
        if (visited[num]==0) {
            visited[num] = 1;
            for (int i:arr[num]) {
                dfs(i);
            }
        }
    }
}
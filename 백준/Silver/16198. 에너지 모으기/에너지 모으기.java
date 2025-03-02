import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static List<Integer> arr = new ArrayList<>();
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr.add(a);
        }

        dfs(n, 0);
        System.out.println(result);

    }
    public static void dfs(int level, int sum) {
        if (level==2) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 1; i<level-1; i++) {
            int energy = arr.get(i-1)*arr.get(i+1);
            int temp = arr.remove(i);
            dfs(level-1, sum+energy);
            arr.add(i, temp);
        }
    }
}
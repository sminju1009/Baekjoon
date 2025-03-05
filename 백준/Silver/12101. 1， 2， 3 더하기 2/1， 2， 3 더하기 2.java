import java.util.*;
import java.io.*;

public class Main {
    static int[] numbers = {1, 2, 3};
    static int n, k;
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dfs("", 0);

        if (k > results.size()) {
            System.out.println(-1);
        } else {
            System.out.println(results.get(k - 1));
        }
    }

    public static void dfs(String current, int sum) {
        if (sum == n) {
            results.add(current.isEmpty() ? current : current.substring(0, current.length() - 1));
            return;
        }

        if (sum > n) {
            return;
        }

        for (int num : numbers) {
            dfs(current + num + "+", sum + num);
        }
    }
}
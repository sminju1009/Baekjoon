import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];
        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int level) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (result.length == 0 || Arrays.stream(result).max().getAsInt() <= i) {
                result[level] = i;
                dfs(level + 1);
                result[level] = 0;
            }
        }
    }
}
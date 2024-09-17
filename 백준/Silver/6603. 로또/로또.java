import java.util.*;
import java.io.*;

public class Main {

    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = new int[6];
            dfs(0, 0, k, arr);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int start, int level, int k, int[] arr) {
        if (level == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            result[level] = arr[i];
            dfs(i + 1, level + 1, k, arr);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int level) {
        int prev = 0;
        if (level==m) {
            for (int i = 0; i<m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i<n; i++) {
            int max = Arrays.stream(result).max().getAsInt();
            if (max<=arr[i] && prev!=arr[i]) {
                prev = arr[i];
                result[level] = arr[i];
                dfs(level+1);
                result[level] = 0;
            }
        }
    }
}
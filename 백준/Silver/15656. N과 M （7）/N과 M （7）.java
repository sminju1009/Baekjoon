import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        result = new int[m];
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int level) {
        if (level==m) {
            for (int i = 0; i<m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i<n; i++) {
            result[level] = arr[i];
            dfs(level+1);
        }
    }
}
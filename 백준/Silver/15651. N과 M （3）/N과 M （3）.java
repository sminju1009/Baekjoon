import java.util.*;
import java.io.*;

public class Main {
    static int result[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        result = new int[m];
        dfs(0, n, m);
        System.out.println(sb.toString());
    }

    public static void dfs(int level, int n, int m) {

        if (level==m) {
            for (int i = 0; i<m; i++) {
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i<n; i++) {
            result[level] = i+1;
            dfs(level+1, n, m);
            result[level] = 0;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int level, int count) {
        if (level==n) {
            answer = Math.max(answer, count);
            return;
        }
        if (arr[level][0]<=0 || count==n-1) {
            dfs(level+1, count);
            return;
        }
        int temp = count;
        for (int i = 0; i<n; i++) {
            if (i==level) continue;
            if (arr[i][0]<=0) continue;
            arr[level][0] -= arr[i][1];
            arr[i][0] -= arr[level][1];
            if (arr[level][0]<=0) count++;
            if (arr[i][0]<=0) count++;
            dfs(level+1, count);
            arr[level][0] += arr[i][1];
            arr[i][0] += arr[level][1];
            count = temp;
        }
    }
}
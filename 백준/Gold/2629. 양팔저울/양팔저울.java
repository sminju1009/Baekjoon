import java.util.*;
import java.io.*;

public class Main {

    static int n, g;
    static int[] arr;
    static boolean[][] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = new boolean[n+1][40001];

        dp(0, 0);

        g = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<g; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (result[n][a]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);



    }

    public static void dp(int cnt, int num) {
        if (result[cnt][num]) return;
        result[cnt][num] = true;

        if (cnt==n) return;

        dp(cnt+1, num+arr[cnt]);
        dp(cnt+1, num);
        dp(cnt+1, Math.abs(num-arr[cnt]));
    }
}
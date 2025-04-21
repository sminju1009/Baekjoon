import java.util.*;
import java.io.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] arr;
    static int[] op = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int level, int now) {
        if (level==n-1) {
            max = Math.max(max, now);
            min = Math.min(min, now);
            return;
        }

        for (int i = 0; i<4; i++) {
            if (op[i]>0) {
                op[i]--;
                if (i==0) {
                    dfs(level+1, now+arr[level+1]);
                } else if (i==1) {
                    dfs(level+1, now-arr[level+1]);
                } else if (i==2) {
                    dfs(level+1, now*arr[level+1]);
                } else if (i==3) {
                    dfs(level+1, now/arr[level+1]);
                }
                op[i]++;
            }
        }

    }
}
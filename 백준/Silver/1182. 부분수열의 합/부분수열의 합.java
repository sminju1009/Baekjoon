import java.util.*;
import java.io.*;

public class Main {
    static int n, s;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0);
        System.out.println(count);
    }
    public static void dfs(int now, int value, int selected) {
        if (now==n) {
            if (selected>0 && value==s) {
                count++;
            }
            return;
        }
        dfs(now+1, value+arr[now], selected+1);
        dfs(now+1, value, selected);
    }
}
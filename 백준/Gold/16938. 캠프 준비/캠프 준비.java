import java.util.*;
import java.io.*;

public class Main {
    static int n, l, r, x;
    static int[] arr;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(count);
    }
    
    public static void dfs(int idx, int selected, int sum, int min, int max) {
        if (idx == n) {
            if (selected >= 2 && sum >= l && sum <= r && max - min >= x) {
                count++;
            }
            return;
        }
        
        dfs(idx + 1, selected + 1, 
            sum + arr[idx],
            Math.min(min, arr[idx]), 
            Math.max(max, arr[idx]));
            
        dfs(idx + 1, selected, sum, min, max);
    }
}
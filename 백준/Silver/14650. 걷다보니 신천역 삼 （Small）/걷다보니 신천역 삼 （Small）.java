import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        Arrays.fill(arr, -1);
        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int level) {

        if (level==n) {
            int temp = 0;
            for (int i = 0; i<n; i++) {
                temp += arr[i];
            }
            if (temp%3==0) count++;
            return;
        }

        if (level==0) {
            for (int i = 1; i<=2; i++) {
                arr[level] = i;
                dfs(level+1);
                arr[level] = -1;
            }
        } else {
            for (int i = 0; i<=2; i++) {
                arr[level] = i;
                dfs(level+1);
                arr[level] = -1;
            }
        }
    }
}
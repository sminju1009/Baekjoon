import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int end = -1;
        int start = 0;
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        while (start < end) {
            int mid = (start+end)/2;
            if (solve(mid)<=m) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        System.out.println(end);
    }
    public static int solve(int mid) {
        int count = 1;
        int min = 987654321;
        int max = -987654321;

        for (int i = 0; i<n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max-min > mid) {
                count++;
                max = -987654321;
                min = 987654321;
                i--;
            }
        }
        return count;
    }
}
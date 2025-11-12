import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max  = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;

        while (left<=right) {
            long mid = (left+right)/2;
            int cnt = 0;

            for (int i = 0 ;i<n; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt<k) {
                right = mid-1;
            } else {
                left = mid+1;
            }

        }

        System.out.println(right);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        long min = Integer.MAX_VALUE;
        long max = Integer.MAX_VALUE;
        long answer = 0;
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(arr[i], min);
        }
        while (min<=max) {
            long mid = (min+max)/2;
            long sum = 0;
            for (int i = 0; i<n; i++) {
                if (mid>arr[i]) {
                    sum += mid - arr[i];
                }
            }
            if (k>=sum) {
                min = mid+1;
                answer = Math.max(answer, mid);
            } else {
                max = mid-1;
            }
        }
        System.out.println(answer);

    }
}
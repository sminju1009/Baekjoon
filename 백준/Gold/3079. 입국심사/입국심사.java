import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int maxTime = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(arr[i], maxTime);
        }

        long start = 1;
        long end = (long) maxTime * m;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long level = 0;

            for (int i = 0; i < n; i++) {
                level += mid / arr[i];
                if (level >= m) break;
            }

            if (level >= m) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
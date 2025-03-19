import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        int result = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (temp + arr[i] > mid) {
                    count++;
                    temp = arr[i];
                } else {
                    temp += arr[i];
                }
            }

            if (count > m) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
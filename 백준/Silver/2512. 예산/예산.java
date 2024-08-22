import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0;
        int right = arr[n - 1];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int total = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] <= mid) {
                    total += arr[i];
                } else {
                    total += mid;
                }
            }

            if (total <= max) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
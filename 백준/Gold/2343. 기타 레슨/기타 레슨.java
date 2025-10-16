import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        int answer = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int temp = 0;

            for (int i = 0; i < n; i++) {
                if (temp + arr[i] <= mid) {
                    temp += arr[i];
                } else {
                    count++;
                    temp = arr[i];
                }
            }

            if (count <= m) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
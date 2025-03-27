import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long answer = Long.MAX_VALUE;
        int start = 0, end = 0;

        while (end < n) {
            long diff = arr[end] - arr[start];

            if (diff >= m) {
                answer = Math.min(answer, diff);
                start++;
            } else {
                end++;
            }

            if (start > end) {
                end = start;
            }
        }

        System.out.println(answer);
    }
}
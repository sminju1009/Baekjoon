import java.util.*;
import java.io.*;

public class Main {

    static long result = 3000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] answer = new long[3];
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i<n-2; i++) {
            int start = i+1;
            int end = n-1;
            while (start<end) {
                long temp = arr[i] + arr[start] + arr[end];
                if (Math.abs(result) > Math.abs(temp)) {
                    result = temp;
                    answer[0] = arr[i];
                    answer[1] = arr[start];
                    answer[2] = arr[end];
                }
                if (temp<0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
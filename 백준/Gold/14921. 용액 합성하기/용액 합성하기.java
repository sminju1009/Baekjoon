import java.util.*;
import java.io.*;

public class Main {

    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        while (start<end) {
            long temp = arr[start] + arr[end];
            if (Math.abs(temp)<Math.abs(answer)) {
                answer = temp;
            }
            if (temp>=0) {
                end--;
            } else {
                start++;
            }
            if (answer==0) break;
        }
        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] answer = new int[2];

        int start = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;

        while (start<end) {
            int now = arr[end] + arr[start];
            if (Math.abs(now) < min) {
                min = Math.abs(now);
                answer[0] = arr[start];
                answer[1] = arr[end];

                if (min==0) break;
            }
            if (now<0) start++;
            else end--;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
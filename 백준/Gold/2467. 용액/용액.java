import java.util.*;
import java.io.*;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[2];
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        while (start<end) {
            if (Math.abs(arr[start] + arr[end])< min) {
                min = Math.abs(arr[start]+arr[end]);
                result[0] = arr[start];
                result[1] = arr[end];
            }

            if ((arr[start]+arr[end])>=0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int power = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        while (start <= end) {
            int temp = Math.min(arr[start], arr[end]) * (end-start-1);
            power = Math.max(temp, power);
            if (arr[start]<arr[end]) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(power);
    }
}
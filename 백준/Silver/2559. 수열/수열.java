import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int startValue = 0;
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i<k) {
                startValue += arr[i];
            }
        }
        int max = startValue;
        for (int i = 0; i<n-k; i++) {
            startValue = startValue - arr[i] + arr[i+k];
            max = Math.max(max, startValue);
        }
        System.out.println(max);
    }
}
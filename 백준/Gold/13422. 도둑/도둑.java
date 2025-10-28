import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int l = 0;
            int r = m-1;
            int sum = 0;
            for (int i = l; i<=r; i++) {
                sum += arr[i];
            }
            if (sum<k) count++;
            
            if (n == m) {
                sb.append(count+"\n");
                continue;
            }
            
            for (int i = 1; i<n; i++) {
                sum -= arr[i-1];
                int mod = (i+m-1)%n;
                sum += arr[mod];
                if (sum<k) count++;
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
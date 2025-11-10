import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] sum = new long[n];
        int[] compare = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (i==0) {
                sum[i] = a;
            } else {
                sum[i] = sum[i-1] + a;
            }
            int b = (int) ((sum[i] % m + m) % m);
            compare[b]++;
        }
        long count = 0;
        count += compare[0];
        for (int i = 0; i<m; i++) {
            long c = compare[i];
            count += c * (c - 1) / 2;
        }
        System.out.println(count);
    }
}
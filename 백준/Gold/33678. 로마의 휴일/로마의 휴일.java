import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] sum = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i!=0) {
                sum[i] = sum[i-1] + arr[i];
            } else {
                sum[i] = arr[i];
            }
        }

        int s = 0, e = 0;
        int vacation = -1;
        while (s<n && e<n) {
            int income = 0;
            if (s==0) {
                if (e==n-1) {
                    income = 0;
                } else if (e!=n-1) {
                    income = sum[n-1] - sum[e];
                }
            } else if (s!=0) {
                if (e!=n-1) {
                    income = (x * sum[s-1]) + (sum[n-1] - sum[e]);
                } else if (e==n-1) {
                    income = (x * sum[s-1]);
                }
            }
            if (income >= k) {
                vacation = Math.max(vacation, e-s+1);
                e++;
            } else {
                s++;
                if (s>e) e = s;
            }
        }
        System.out.println(vacation);
    }
}
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
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % 2;
        }
        int max = 0;
        int left = 0;
        int right = 0;
        int odd = 0; // 홀수 갯수
        while (right<n) {
            if (odd <= k) {
                if (arr[right]==1) {
                    odd++;
                }
                right++;
                if (odd <= k) {  
                    max = Math.max(max, right-left-odd);
                }
            } else {
                if (arr[left]==1) {
                    odd--;
                }
                left++;
            }
        }
        System.out.println(max);
    }
}
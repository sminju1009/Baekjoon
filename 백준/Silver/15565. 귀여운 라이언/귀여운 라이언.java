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
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        
        while (end < n) {
            if (arr[end] == 1) {
                count++;
            }
            while (count >= k) {
                min = Math.min(min, end - start + 1);
                if (arr[start] == 1) {
                    count--;
                }
                start++;
            }
            end++;
        }

        int answer = (min==Integer.MAX_VALUE) ? -1 : min;
        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int temp = arr[end];
        while (start <= end && end < n) { 
            if (temp < m) {
                answer = Math.max(answer, temp);
                if (end == n - 1) break;
                end++;
                temp += arr[end];
            } else if (temp == m) {
                answer = m;
                break;
            } else {
                temp -= arr[start];
                start++;
                if (start > end && start < n) {
                    end = start;
                    temp = arr[start];
                }
            }
        }
        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int temp = arr[0];
        while (end<n) {
            if (temp<s) {
                end++;
                if (end < n) {
                    temp += arr[end];
                }
            } else {
                answer = Math.min(answer, end-start);
                temp -= arr[start];
                start++;
            }
        }
        if (answer==Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer+1);
        }
    }
}
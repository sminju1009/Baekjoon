import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.MAX_VALUE;
        int end = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            start = Math.min(start, arr[i]);
        }

        int answer = 0;
        while (start <= end) {
            int mid = (start+end)/2;
            int cnt = 0;
            int temp = 0;
            for (int i = 0; i<n; i++) {
                temp += arr[i];
                if (temp >= mid) {
                    cnt++;
                    temp = 0;
                }
            }
            if (cnt<k) {
                end = mid-1;
            } else {
                start = mid+1;
            }
            answer = end;
        }
        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int end = 0;
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        int start = 1;
        int answer = 0;
        while (start<=end) {
            int mid = (start+end)/2;
            int cnt = 0;
            for (int i = 0; i<n; i++) {
                cnt += arr[i]/mid;
            }
            if (cnt>=m) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(answer);

    }
}
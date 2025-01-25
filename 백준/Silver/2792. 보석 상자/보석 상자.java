import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int end = 0;
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        for (int i = 0; i<m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }
        int start = 1;

        while (start<=end) {
            int count = 0;
            int mid = (start+end)/2;
            for (int i = 0; i<m; i++) {
                count += arr[i]/mid;
                if (arr[i]%mid!=0) {
                    count++;
                }
            }
            if (count>n) {
                start = mid+1;
            } else {
                end = mid-1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
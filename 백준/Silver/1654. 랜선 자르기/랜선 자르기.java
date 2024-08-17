import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long end = 0;
        for (int i = 0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (end < arr[i]) {
                end = arr[i];
            }
        }
        end++;
        long start = 0;
        long mid = 0;
        while (start<end) {
            mid = (start+end)/2;
            long count = 0;
            for (int i = 0; i<k; i++) {
                count += (arr[i] / mid);
            }
            if (count<n) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        System.out.println(start-1);
    }
}
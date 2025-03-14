import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n+1] = l;
        Arrays.sort(arr);
        int left = 1;
        int right = l-1;
        while (left<=right) {
            int count = 0;
            int mid = (left+right)/2;
            for (int i = 1; i<arr.length; i++) {
                count += (arr[i]-arr[i-1]-1)/mid;
            }
            if (count<=m) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        System.out.println(left);
    }
}
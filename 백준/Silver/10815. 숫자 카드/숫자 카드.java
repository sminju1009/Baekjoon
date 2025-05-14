import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(a, target) + " ");
        }
        System.out.println(sb);
    }
    
    public static int binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        
        while (s<=e) {
            int mid = (s+e) / 2;
            if (arr[mid]==target) {
                return 1;
            } else if (arr[mid] < target) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        
        return 0;
    }
}
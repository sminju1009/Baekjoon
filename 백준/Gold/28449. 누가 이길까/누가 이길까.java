import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        long hiWins = 0;
        for (int i = 0; i < n; i++) {
            hiWins += lowerBound(b, a[i]);
        }
        
        long arcWins = 0;
        for (int i = 0; i < m; i++) {
            arcWins += lowerBound(a, b[i]);
        }
        
        long draws = (long) n * m - hiWins - arcWins;
        
        System.out.println(hiWins + " " + arcWins + " " + draws);
    }
    
    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
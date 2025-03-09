import java.util.*;
import java.io.*;

public class Main {

    static int k;
    static int count;
    static int dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            count = 0;
            dist = Integer.MAX_VALUE;
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                int currentDist = Math.abs(k - sum);
                
                if (currentDist < dist) {  
                    dist = currentDist;
                    count = 1;  
                } else if (currentDist == dist) {  
                    count++;
                }
                
                if (sum < k) {
                    start++;  
                } else {
                    end--;    
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
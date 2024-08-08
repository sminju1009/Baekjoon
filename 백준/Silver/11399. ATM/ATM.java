import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       StringTokenizer st = new StringTokenizer(br.readLine());
       int[] arr = new int[n];
       for (int i = 0; i<n; i++) {
           int a = Integer.parseInt(st.nextToken());
           arr[i] = a;
       }
       Arrays.sort(arr);
       int sum = 0;
       for (int i=0; i<n; i++) {
           sum += arr[i] * (n-i);
       }
       System.out.println(sum);
    }
}
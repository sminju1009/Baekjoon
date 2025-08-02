import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n==0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int temp = 0;
        int count = 1;
        for (int i = 0; i<n; i++) {
            if (temp+arr[i]>m) {
                temp = arr[i];
                count++;
            } else {
                temp += arr[i];
            }
        }
        System.out.println(count);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (t > 0) {
            Arrays.sort(arr, 0, Math.min(t, n));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
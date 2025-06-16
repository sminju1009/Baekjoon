import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long count = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        arr[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i<n; i++) {
            arr[i] = arr[i-1] + Long.parseLong(st.nextToken());
        }
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) {
            if (arr[i]==k) count++;
            count += map.getOrDefault(arr[i]-k, 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(count);

    }
}
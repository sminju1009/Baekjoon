import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for (int i = 0; i<b; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[a] = true;
        }
        int cnt = 0;
        for (int i = 1; i<=k; i++) {
            if (arr[i]) cnt++;
        }
        int min = cnt;
        for (int i = 1; i+k-1<n; i++) {
            if (arr[i]) cnt--;
            if (arr[i+k]) cnt++;
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }
}
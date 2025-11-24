import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] count = new int[21];
        long answer = 0;

        for (int i = 0; i<n; i++) {
            arr[i] = br.readLine().length();
        }

        for (int i = 0; i<=k; i++) {
            count[arr[i]]++;
        }

        for (int i = 0; i<n; i++) {
            answer += count[arr[i]]-1;
            if (i+k+1<n) count[arr[i+k+1]]++;

            count[arr[i]]--;
        }

        System.out.println(answer);
    }
}
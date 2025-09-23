import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[d+1];
        int count = 1;
        sushi[c]++;

        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = k-1;
        for (int i = start; i<=end; i++) {
            sushi[arr[i]]++;
            if (sushi[arr[i]]==1) count++;
        }

        int answer = count;
        for (int i = 1; i<n; i++) {
            sushi[arr[i-1]]--;
            if (sushi[arr[i-1]]==0) count--;
            int now = (i+k-1)%n;
            sushi[arr[now]]++;
            if (sushi[arr[now]]==1) count++;
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
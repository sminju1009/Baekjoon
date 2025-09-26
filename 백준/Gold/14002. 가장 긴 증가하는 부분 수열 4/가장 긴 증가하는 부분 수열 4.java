import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        ArrayList<Integer> lis = new ArrayList<>();
        int currentLength = maxLength;

        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == currentLength) {
                lis.add(arr[i]);
                currentLength--;
            }
        }

        Collections.reverse(lis);

        System.out.println(maxLength);
        for (int i = 0; i < lis.size(); i++) {
            System.out.print(lis.get(i) + " ");
        }
    }
}
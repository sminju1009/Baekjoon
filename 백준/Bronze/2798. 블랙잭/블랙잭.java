import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 카드 개수
        int m = Integer.parseInt(st.nextToken()); // 카드의 합 최대값

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i<n-2; i++) {
            for (int j = i+1; j<n-1; j++) {
                for (int k = j+1; k<n; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if (temp == m) {
                        result = temp;
                        break;
                    }
                    if (result < temp && temp < m) {
                        result = temp;
                    }
                }
            }
        }
        System.out.println(result);
    }
}

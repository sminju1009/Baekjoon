import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int odd = 0; // 짝수 갯수
        int even = 0; // 홀수 갯수
        int answer = 0;

        for (int right = 0; right<n; right++) {
            if (arr[right]%2 == 1) {
                odd++;
            } else {
                even++;
            }
            
            while (odd>k) {
                if (arr[left]%2==1) {
                    odd--;
                } else {
                    even--;
                }
                left++;
            }
            answer = Math.max(answer, even);
        }
        System.out.println(answer);
    }
}
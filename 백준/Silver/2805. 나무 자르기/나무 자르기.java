import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = arr[n-1];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;

            // mid 높이로 잘랐을 때 얻는 나무 길이의 총합 계산
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    total += arr[i] - mid;
                }
            }

            if (total >= m) {
                // 원하는 나무 길이 M을 얻을 수 있는 경우
                result = mid;
                left = mid + 1; // 더 높은 톱날 높이를 시도
            } else {
                right = mid - 1; // 더 낮은 톱날 높이를 시도
            }
        }
        
        System.out.println(result);
    }
}
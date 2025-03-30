import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxHeight = 0;
        int maxIdx = 0;
        int maxIdxDot = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if (maxHeight<arr[i][1]) {
                maxHeight = arr[i][1];
                maxIdxDot = arr[i][0];
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        for (int i = 0; i<n; i++) {
            if (arr[i][0] == maxIdxDot) {
                maxIdx = i;
                break;
            }
        }

        int area = 0;
        int nowMaxLeft = arr[0][1];
        for (int i = 0; i<maxIdx; i++) {
            if (nowMaxLeft<arr[i][1]) {
                nowMaxLeft = arr[i][1];
            }
            area += (arr[i+1][0] - arr[i][0]) * nowMaxLeft;
        }

        area += maxHeight;

        int nowMaxRight = arr[n-1][1];

        for (int i = n-1; i>maxIdx; i--) {
            if (nowMaxRight<arr[i][1]) {
                nowMaxRight = arr[i][1];
            }
            area += (arr[i][0] - arr[i-1][0]) * nowMaxRight;
        }

        System.out.println(area);
    }
}
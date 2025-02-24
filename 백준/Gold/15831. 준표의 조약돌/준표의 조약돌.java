import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[] arr = new char[n];
        String now = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = now.charAt(i);
        }

        int count = 0;
        int left = 0;
        int right = 0;

        int black = 0;
        int white = 0;

        while (right < n) {
            if (arr[right] == 'B') {
                black++;
            } else {
                white++;
            }

            while (black > b && left <= right) {
                if (arr[left] == 'B') {
                    black--;
                } else {
                    white--;
                }
                left++;
            }

            if (white >= w && black <= b) {
                count = Math.max(count, right - left + 1);
            }

            right++;
        }

        System.out.println(count);
    }
}
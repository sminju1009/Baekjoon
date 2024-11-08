import java.util.*;
import java.io.*;

public class Main {
    static int n, m, b;
    static int[][] arr;
    static int leastTime = Integer.MAX_VALUE;
    static int maxHeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i<=256; i++) {
            int nowInventory = b;
            int nowTime = 0;
            for (int j = 0; j<n; j++) {
                for (int k = 0; k<m; k++) {
                    if (arr[j][k]>i) {
                        nowTime += 2*(arr[j][k] - i);
                        nowInventory += (arr[j][k] - i);
                    } else if (arr[j][k]<i) {
                        nowTime -= (arr[j][k] - i);
                        nowInventory += (arr[j][k] - i);
                    }
                }
            }
            if (nowInventory >= 0 && nowTime<=leastTime) {
                leastTime = nowTime;
                maxHeight = i;
            }
        }
        System.out.println(leastTime + " " + maxHeight);
    }
}
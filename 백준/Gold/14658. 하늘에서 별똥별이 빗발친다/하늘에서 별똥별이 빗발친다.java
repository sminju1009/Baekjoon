import java.util.*;
import java.io.*;

public class Main {

    static int n, m, l, k;
    static int[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int x = arr[i][0];
                int y = arr[j][1];

                int count = 0;
                for (int p = 0; p < k; p++) {
                    if (arr[p][0] >= x && arr[p][0] <= x + l &&
                            arr[p][1] >= y && arr[p][1] <= y + l) {
                        count++;
                    }
                }
                answer = Math.max(answer, count);
            }
        }

        System.out.println(k - answer);

    }


}
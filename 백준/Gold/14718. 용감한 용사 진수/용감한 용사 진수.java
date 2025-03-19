import java.util.*;
import java.io.*;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static int n, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        arr = new int[n][3];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                for (int k = 0; k<n; k++) {
                    int count = 0;
                    for (int l = 0; l<n; l++) {
                        if (arr[i][0] >=arr[l][0] && arr[j][1] >= arr[l][1] && arr[k][2]>= arr[l][2]) {
                            count++;
                        }
                    }
                    if (count>=start) min = Math.min(min, arr[i][0]+arr[j][1]+arr[k][2]);
                }
            }
        }
        System.out.println(min);
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int angle = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            for (int i = 0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            angle = (angle%360) / 45;
            if (n==1) {
                sb.append(arr[0][0] + "\n");
            } else {
                if (angle>0) {
                    for (int i = 0; i<angle; i++) {
                        clock();
                    }
                } else if (angle<0) {
                    for (int i = 0; i<Math.abs(angle); i++) {
                        anticlock();
                    }
                }
                for (int i = 0; i<n; i++) {
                    for (int j = 0; j<n; j++) {
                        sb.append(arr[i][j] + " ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static void anticlock() { // 반시계 방향
        int[] temp = new int[n/2];
        int[] temp2 = new int[n/2];
        for (int i = 0; i<n/2; i++) {
            temp[i] = arr[n/2][i];
            arr[n/2][i] = arr[i][i];
        }
        for (int i = 0; i<n/2; i++) {
            temp2[i] = arr[(n-1)-i][i];
            arr[(n-1)-i][i] = temp[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp[i] = arr[(n-1)-i][n/2];
            arr[(n-1)-i][n/2] = temp2[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp2[i] = arr[(n-1)-i][n-1-i];
            arr[(n-1)-i][n-1-i] = temp[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp[i] = arr[n/2][n-1-i];
            arr[n/2][n-1-i] = temp2[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp2[i] = arr[i][n-1-i];
            arr[i][n-1-i] = temp[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp[i] = arr[i][n/2];
            arr[i][n/2] = temp2[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp2[i] = arr[i][i];
            arr[i][i] = temp[i];
        }

    }

    public static void clock() { // 시계 방향
        int[] temp = new int[n/2];
        int[] temp2 = new int[n/2];
        for (int i = 0; i<n/2; i++) {
            temp[i] = arr[i][n/2];
            arr[i][n/2] = arr[i][i];
        }
        for (int i = 0; i<n/2; i++) {
            temp2[i] = arr[i][n-1-i];
            arr[i][n-1-i] = temp[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp[i] = arr[n/2][n-1-i];
            arr[n/2][n-1-i] = temp2[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp2[i] = arr[n-1-i][n-1-i];
            arr[n-1-i][n-1-i] = temp[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp[i] = arr[n-1-i][n/2];
            arr[n-1-i][n/2] = temp2[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp2[i] = arr[n-1-i][i];
            arr[n-1-i][i] = temp[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp[i] = arr[n/2][i];
            arr[n/2][i] = temp2[i];
        }
        for (int i = 0; i<n/2; i++) {
            temp2[i] = arr[i][i];
            arr[i][i] = temp[i];
        }
    }
}
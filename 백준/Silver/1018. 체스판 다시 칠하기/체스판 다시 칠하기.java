import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i=0; i<n-7; i++) {
            for (int j = 0; j<m-7; j++) {
                int count = solve(i, j, arr);
                if (count<result) {
                    result = count;
                }
            }
        }

        System.out.println(result);

    }

    public static int solve(int y, int x, char[][] arr) {
        int white = 0;
        int black = 0;
        for (int i=y; i<y+8; i++) {
            for (int j=x; j<x+8; j++) {
                // white
                if ((i+j)%2==0) {
                    if (arr[i][j]=='B') {
                        white++;
                    }
                    if (arr[i][j]=='W') {
                        black++;
                    }
                } else {
                    if (arr[i][j]=='W') {
                        white++;
                    }
                    if (arr[i][j]=='B') {
                        black++;
                    }
                }
            }
        }

        return Math.min(white, black);
    }
}
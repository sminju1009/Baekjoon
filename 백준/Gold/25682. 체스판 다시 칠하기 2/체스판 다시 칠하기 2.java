import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n+1][m+1];
        int[][] startBlack = new int[n+1][m+1];
        int[][] startWhite = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j-1);

                if ((i + j) % 2 == 0) {
                    startBlack[i][j] = (arr[i][j] == 'B') ? 0 : 1;
                    startWhite[i][j] = (arr[i][j] == 'W') ? 0 : 1;
                } else {
                    startBlack[i][j] = (arr[i][j] == 'B') ? 1 : 0;
                    startWhite[i][j] = (arr[i][j] == 'W') ? 1 : 0;
                }

                startBlack[i][j] += startBlack[i-1][j] + startBlack[i][j-1] - startBlack[i-1][j-1];
                startWhite[i][j] += startWhite[i-1][j] + startWhite[i][j-1] - startWhite[i-1][j-1];
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int bSum = startBlack[i][j] - startBlack[i-k][j] - startBlack[i][j-k] + startBlack[i-k][j-k];
                int wSum = startWhite[i][j] - startWhite[i-k][j] - startWhite[i][j-k] + startWhite[i-k][j-k];

                answer = Math.min(answer, Math.min(bSum, wSum));
            }
        }

        System.out.println(answer);
    }
}
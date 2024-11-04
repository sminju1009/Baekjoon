import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        
        int[][] B = new int[H+X][W+Y];
        for (int i = 0; i < H+X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W+Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] A = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i < X || j < Y) {
                    A[i][j] = B[i][j];
                } else {
                    A[i][j] = B[i][j] - A[i-X][j-Y];
                }
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
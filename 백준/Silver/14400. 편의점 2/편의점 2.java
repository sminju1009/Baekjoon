import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] y = new int[n];
        int[] x = new int[n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            y[i] = Integer.parseInt(st.nextToken());
            x[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(y);
        Arrays.sort(x);

        long distY = 0;
        long distX = 0;
        int midY = y[n/2];
        int midX = x[n/2];
        for (int i = 0; i<n; i++) {
            distY += Math.abs(midY - y[i]);
            distX += Math.abs(midX - x[i]);
        }
        long sum = distY + distX;
        System.out.println(sum);
    }
}
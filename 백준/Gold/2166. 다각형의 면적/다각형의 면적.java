import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] arr = new double[n][2];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        double sumA = 0;
        double sumB = 0;

        for (int i = 0; i<n-1; i++) {
            sumA += (arr[i][0] * arr[i+1][1]);
        }
        sumA += (arr[n-1][0] * arr[0][1]);

        for (int i = 0; i<n-1; i++) {
            sumB += (arr[i+1][0] * arr[i][1]);
        }
        sumB += (arr[0][0] * arr[n-1][1]);

        double result = Math.abs(sumA-sumB)/2;
        String answer = String.format("%.1f", result);
        System.out.println(answer);
    }
}
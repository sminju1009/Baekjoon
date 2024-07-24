import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        double[] score = new double[n];

        double avg = 0; // 평균
        double max = 0; // 최댓값
        double sum = 0; // 전체 합


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<n; i++) {
            score[i] = Double.parseDouble(st.nextToken());
            if (score[i]>max) {
                max = score[i];
            }
        }
        for (int i = 0; i<n; i++) {
            score[i] = (score[i]/max)*100;
            sum += score[i];
        }
        br.close();
        avg = sum/n;
        System.out.println(avg);
    }
}

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long start = 1;
        long end = 2;
        StringBuilder sb = new StringBuilder();
        while (end<=100000) {
            long temp = end*end - start*start;
            if (temp==n) {
                sb.append(end + "\n");
                end++;
            } else if (temp>n) {
                start++;
            } else if (temp<n) {
                end++;
            }
        }
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
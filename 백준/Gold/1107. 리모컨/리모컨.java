import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] disabled = new boolean[10];
        int result = Math.abs(n - 100);
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int a = Integer.parseInt(st.nextToken());
                disabled[a] = true;
            }
        }

        for (int i = 0; i<=999999; i++) {
            String num = String.valueOf(i);
            boolean isBreak = false;
            for (int j = 0; j<num.length(); j++) {
                if (disabled[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                int min = Math.abs(n-i) + num.length();
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}
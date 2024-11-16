import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] numbers;
    static int[] calculator = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<4; i++) {
            calculator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int level, int result) {
        if (level==n) {
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        for (int i = 0; i<4; i++) {
            if (calculator[i]>0) {
                int next = result;
                calculator[i]--;

                if (i==0) {
                    next += numbers[level];
                } else if (i==1) {
                    next -= numbers[level];
                } else if (i==2) {
                    next *= numbers[level];
                } else {
                    if (next<0) {
                        next = -(-next / numbers[level]);
                    } else {
                        next /= numbers[level];
                    }
                }

                dfs(level+1, next);
                calculator[i]++;
            }
        }
    }
}
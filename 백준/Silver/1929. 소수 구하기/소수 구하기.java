import java.util.*;
import java.io.*;

public class Main {

    static int m, n;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new boolean[n+1];

        prime();
        for (int i = m; i<=n; i++) {
            if (!arr[i]) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }

    public static void prime() {
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i<=Math.sqrt(n+1); i++) {
            if (arr[i]) continue;
            for (int j = i*i; j<arr.length; j += i) {
                arr[j] = true;
            }
        }
    }
}
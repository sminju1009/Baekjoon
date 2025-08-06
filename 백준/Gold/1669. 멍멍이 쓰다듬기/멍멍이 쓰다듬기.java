import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        if (x == y) {
            System.out.println(0);
            return;
        }

        long gap = y - x;
        for (long i = 1;; i++) {
            long sum = i * i + i;
            if (sum < gap) continue;
            System.out.println(i * 2 + (sum - i >= gap ? -1 : 0));
            break;
        }
    }
}
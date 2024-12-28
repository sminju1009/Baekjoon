import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int) ((long) y * 100 / x);
        int start = 0;
        int end = x;
        int res = x;
        if (z >= 99) {
            System.out.println(-1);
        } else {
            while (start <= end) {
                int mid = (start + end) / 2;
                if ((int)((long)(y+mid) * 100 / (x+mid)) > z) {
                    res = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println(res);
        }
    }
}
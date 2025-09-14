import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long distance = y - x;
            
            long n = (long)Math.sqrt(distance);
            
            if (n * n == distance) {
                sb.append((2 * n - 1) + "\n");
            } else if (distance <= n * n + n) {
                sb.append((2 * n) + "\n");
            } else {
                sb.append((2 * n + 1) + "\n");
            }
        }
        System.out.println(sb);
    }
}
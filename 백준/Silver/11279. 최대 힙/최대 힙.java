import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a>0) {
                q.add(a);
            } else {
                if (q.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(q.poll() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 0) {
                minQueue.add(a);
            } else {
                if (minQueue.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(minQueue.poll() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
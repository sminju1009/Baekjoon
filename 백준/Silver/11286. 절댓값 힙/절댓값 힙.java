import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> absoluteQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1)>Math.abs(o2)) {
                    return Math.abs(o1)-Math.abs(o2);
                } else if (Math.abs(o1)==Math.abs(o2)) {
                    return o1-o2;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a!=0) {
                absoluteQueue.add(a);
            } else {
                if (!absoluteQueue.isEmpty()) {
                    sb.append(absoluteQueue.poll() + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
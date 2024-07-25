import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        // 출력을 위해 넣어줄 배열
        LinkedList<Integer> arr = new LinkedList<>();

        // 큐에 전체 배열을 집어 넣음
        for (int i = 1; i<n+1; i++) {
            q.add(i);
        }

        /* 첫번째부터 n번째까지 배열을 다 뺌
        그 과정에서
         */

        while (q.size()!=0) {
            for (int i = 1; i<k; i++) {
                q.offer(q.poll());
            }
            int a = q.poll();
            arr.addLast(a);
        }

        System.out.print("<");
        for (int i = 0; i<n-1; i++) {
            System.out.print(arr.get(i) + ", ");
        }
        System.out.println(arr.get(n-1) + ">");
    }
}
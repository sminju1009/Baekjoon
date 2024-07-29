import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        // 카드 집어넣기
        for (int i = 0; i<n; i++) {
            q.add(i+1);
        }
        // 큐에 넣었다가 빼는 작업
        while (q.size()!=1) {
            // 제일 위에 있는 카드 버리기
            q.pop();
            // 제일 위에 있는 카드를 제일 아래로 옮기기
            int a = q.pop();
            q.addLast(a);
        }
        System.out.println(q.get(0));
    }
}
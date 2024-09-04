import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean isReversed = false;
            boolean errorFlag = false;

            for (int j = 0; j < func.length(); j++) {
                char cmd = func.charAt(j);
                if (cmd == 'R') {
                    isReversed = !isReversed; // 방향 반전
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast(); // 뒤에서 제거
                    } else {
                        deque.pollFirst(); // 앞에서 제거
                    }
                }
            }

            if (errorFlag) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}
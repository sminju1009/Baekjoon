import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int number;
        String nowState;

        public Pair(int number, String nowState) {
            this.number = number;
            this.nowState = nowState;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i<tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            String result = bfs(start, end);
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    public static String bfs(int start, int end) {
        boolean[] visited = new boolean[10000];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, ""));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int number = curr.number;
            String nowState = curr.nowState;

            // L, R 연산을 위한 자릿수별 숫자.
            int d1 = number/1000;
            int d2 = number/100 - (number/1000)*10;
            int d3 = (number%100-number%10)/10;
            int d4 = number%10;

            if (number==end) {
                return nowState;
            }

            for (int i = 0; i<4; i++) {
                if (i==0) {
                    int num = (2*number)%10000;
                    if (!visited[num]) {
                        String nextState = nowState + "D";
                        visited[num] = true;
                        q.add(new Pair(num, nextState));
                    }
                } else if (i==1) {
                    int num = (number != 0) ? number-1 : 9999;
                    if (!visited[num]) {
                        String nextState = nowState + "S";
                        visited[num] = true;
                        q.add(new Pair(num, nextState));
                    }
                } else if (i==2) {
                    int num = d2*1000 + d3*100 + d4*10 + d1;
                    if (!visited[num]) {
                        String nextState = nowState + "L";
                        visited[num] = true;
                        q.add(new Pair(num, nextState));
                    }
                } else if (i==3) {
                    int num = d4*1000 + d1*100 + d2*10 + d3;
                    if (!visited[num]) {
                        String nextState = nowState + "R";
                        visited[num] = true;
                        q.add(new Pair(num, nextState));
                    }
                }
            }
        }
        return "FAIL";
    }
}
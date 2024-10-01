import java.util.*;
import java.io.*;

public class Main {

    static Set<Integer> visited;

    static class Pair{
        int num;
        int level;

        public Pair(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }

    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        visited = new HashSet<>();
        int result = bfs(a, b);
        System.out.println(result);
    }

    // 1을 수의 가장 오른쪽에 추가하는 함수
    public static long plusOne(long num) {
        String answer = Long.toString(num) + '1';
        return Long.parseLong(answer);
    }

    public static int bfs(int start, int end) {
        Queue<Pair> q =  new LinkedList<>();
        q.add(new Pair(start, 1));
        visited.add(start);

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int num = curr.num;
            int level = curr.level;

            if (num == end) {
                return level;
            }

            // 1을 추가하는 연산
            long nextPlusOne = plusOne(num);
            if (nextPlusOne <= end && !visited.contains((int)nextPlusOne)) {
                visited.add((int)nextPlusOne);
                q.add(new Pair((int)nextPlusOne, level + 1));
            }

            // 2를 곱하는 연산
            long nextDouble = num * 2;
            if (nextDouble <= end && !visited.contains((int)nextDouble)) {
                visited.add((int)nextDouble);
                q.add(new Pair((int)nextDouble, level + 1));
            }
        }

        // 만들 수 없는 경우
        return -1;
    }
}
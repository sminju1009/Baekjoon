import java.util.*;
import java.io.*;

public class Main {

    static class Pair implements Comparable<Pair> {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Pair pair) {
            int thisSum = this.y + this.x;
            int otherSum = pair.y + pair.x;
            return Integer.compare(thisSum, otherSum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];
        ArrayList<Pair> dots = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            arr[y][x] = 1;
            dots.add(new Pair(y, x));
        }

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            arr[y][x] = -1;
        }

        Collections.sort(dots);

        dots.add(new Pair(n-1, m-1));

        dp[0][0] = 1;
        int prevY = 0, prevX = 0;

        for (int i = 0; i <= a; i++) {
            int y = dots.get(i).y;
            int x = dots.get(i).x;

            for (int j = prevY; j <= y; j++) {
                for (int k = prevX; k <= x; k++) {
                    if (j == prevY && k == prevX) continue;
                    if (arr[j][k] == -1) {
                        dp[j][k] = 0;
                        continue;
                    }

                    dp[j][k] = 0;
                    if (j > prevY && dp[j-1][k] > 0) {
                        dp[j][k] += dp[j-1][k];
                    }
                    if (k > prevX && dp[j][k-1] > 0) {
                        dp[j][k] += dp[j][k-1];
                    }
                }
            }

            answer.add(dp[y][x]);

            if (i < a) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[j], 0);
                }
                dp[y][x] = 1;
                prevY = y;
                prevX = x;
            }
        }

        long result = 1;
        for (long pathCount : answer) {
            result *= pathCount;
        }

        System.out.println(result);
    }
}
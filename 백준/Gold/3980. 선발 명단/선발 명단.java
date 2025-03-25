import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[] people;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            arr = new int[11][11];
            people = new boolean[11];
            answer = Integer.MIN_VALUE;

            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int level, int sum) {
        if (level == 11) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!people[i] && arr[level][i] > 0) {
                people[i] = true;
                dfs(level + 1, sum + arr[level][i]);
                people[i] = false;
            }
        }
    }
}
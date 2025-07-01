import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int days;
    static int[][] arr;
    static int[] path;
    static boolean[][] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        days = Integer.parseInt(br.readLine());
        arr = new int[days][];
        path = new int[days];
        memo = new boolean[days][10];
        for (int i = 0; i<days; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(st.nextToken());
            arr[i] = new int[rows];
            for (int j = 0; j<rows; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (dfs(0, 0)) {
            for (int i = 0; i<days; i++) {
                sb.append(path[i] + "\n");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

    }

    public static boolean dfs(int day, int prev) {
        if (day==days) {
            return true;
        }

        if (memo[day][prev]) {
            return false;
        }

        for (int i: arr[day]) {
            if (i != prev) {
                path[day] = i;
                if (dfs(day+1, i)) {
                    return true;
                }
            }
        }

        memo[day][prev] = true;
        return false;
    }

}
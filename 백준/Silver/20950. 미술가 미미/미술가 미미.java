import java.util.*;
import java.io.*;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    static int n;
    static int[] gomduri = new int[3];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        visited = new boolean[n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<3; i++) {
            gomduri[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, 0, 0);
        System.out.println(answer);

    }

    public static void dfs(int level, int start, int r, int g, int b) {
        if (level>=2) {
            answer = Math.min(Math.abs(gomduri[0]-r/level) + Math.abs(gomduri[1]-g/level) + Math.abs(gomduri[2]-b/level), answer);
        }

        if (start==n) return;

        if (level==n || level==7) return;

        // 이 물감 선택했을 때
        dfs(level+1, start+1, r+arr[start][0], g+arr[start][1], b+arr[start][2]);

        // 이 물감 선택하지 않았을 때
        dfs(level, start+1, r, g, b);
    }
}
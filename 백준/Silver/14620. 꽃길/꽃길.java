import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int cost = Integer.MAX_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(cost);

    }

    public static void dfs(int level, int money) {
        if (level==3) {
            cost = Math.min(cost, money);
            return;
        }
        for (int i = 1; i<n-1; i++) {
            for (int j = 1; j<n-1; j++) {
                if (isAble(i, j)) {
                    visited[i][j] = true;
                    visited[i-1][j] = true;
                    visited[i+1][j] = true;
                    visited[i][j+1] = true;
                    visited[i][j-1] = true;
                    dfs(level+1, money+calculateMoney(i, j));
                    visited[i][j] = false;
                    visited[i-1][j] = false;
                    visited[i+1][j] = false;
                    visited[i][j+1] = false;
                    visited[i][j-1] = false;
                }
            }
        }
    }

    public static boolean isAble(int y, int x) { // 방문 가능여부 체크하는 배열
        // 한곳이라도 방문되어 있다면 여기는 방문할 수 없음
        if (visited[y][x] || visited[y][x-1] || visited[y][x+1] || visited[y-1][x] || visited[y+1][x]) {
            return false;
        }
        // 그게 아니라면 방문 가능
        return true;
    }

    public static int calculateMoney(int y, int x) { // 해당 위치에 씨앗 심는데 들어가는 비용 계산하기
        return arr[y][x] + arr[y-1][x] + arr[y+1][x] + arr[y][x-1] + arr[y][x+1];
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0, 1);
        System.out.println(count);
    }

    public static void dfs(int sy, int sx, int ey, int ex) {
        if (ey==n-1 && ex==n-1) {
            count++;
            return;
        }
        // 1. 시작이 가로방향
        if (sy==ey && sx!=ex) {
            // 1-1. 가로로 다시 놓는 경우
            if (ex+1<n && arr[ey][ex+1]==0) dfs(ey, ex, ey, ex+1);
            // 1-2. 대각선으로 놓는 경우
            if (ey+1<n && ex+1<n && arr[ey+1][ex+1]==0 && arr[ey][ex+1]==0 && arr[ey+1][ex]==0) dfs(ey, ex, ey+1, ex+1);
        }
        // 2. 시작이 세로방향
        else if (sy!=ey && sx==ex) {
            // 2-1. 다시 세로로 놓는 경우
            if (ey+1<n && arr[ey+1][ex]==0) dfs(ey, ex, ey+1, ex);
            // 2-2. 대각선으로 놓는 경우
            if (ey+1<n && ex+1<n && arr[ey+1][ex+1]==0 && arr[ey][ex+1]==0 && arr[ey+1][ex]==0) dfs(ey, ex, ey+1, ex+1);
        }
        // 3. 시작이 대각선 방향
        else if (sy!=ey && sx!=ex) {
            // 3-1. 가로로 놓는 경우
            if (ex+1<n && arr[ey][ex+1]==0) dfs(ey, ex, ey, ex+1);
            // 3-2. 세로로 놓는 경우
            if (ey+1<n && arr[ey+1][ex]==0) dfs(ey, ex, ey+1, ex);
            // 3-3. 대각선으로 놓는 경우
            if (ey+1<n && ex+1<n && arr[ey+1][ex+1]==0 && arr[ey][ex+1]==0 && arr[ey+1][ex]==0) dfs(ey, ex, ey+1, ex+1);
        }
    }
}
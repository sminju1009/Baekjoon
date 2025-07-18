import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[4][18];
        for (int i = 0; i<4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<18; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i<4; i++) {
            answer = 0;
            if (!isPossible(arr[i])) {
                sb.append("0 ");
            } else {
                dfs(0, 1, arr[i]);
                sb.append(answer + " ");
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int level, int nxt, int[] arr) {
        if (answer==1) return;

        if (level==5) {
            answer = 1;
            return;
        }

        if (arr[level*3]>0 && arr[nxt*3+2]>0) {
            arr[level*3]--;
            arr[nxt*3+2]--;
            if (nxt==5) {
                dfs(level+1, level+2, arr);
            } else {
                dfs(level, nxt+1, arr);
            }
            arr[level*3]++;
            arr[nxt*3+2]++;
        }

        if (arr[level*3+1]>0 && arr[nxt*3+1]>0) {
            arr[level*3+1]--;
            arr[nxt*3+1]--;
            if (nxt==5) {
                dfs(level+1, level+2, arr);
            } else {
                dfs(level, nxt+1, arr);
            }
            arr[level*3+1]++;
            arr[nxt*3+1]++;
        }

        if (arr[level*3+2]>0 && arr[nxt*3]>0) {
            arr[level*3+2]--;
            arr[nxt*3]--;
            if (nxt==5) {
                dfs(level+1, level+2, arr);
            } else {
                dfs(level, nxt+1, arr);
            }
            arr[level*3+2]++;
            arr[nxt*3]++;
        }
    }

    public static boolean isPossible(int[] arr) {
        for (int i = 0; i<18; i+=3) {
            int temp = arr[i] + arr[i+1] + arr[i+2];
            if (temp!=5) return false;
        }
        return true;
    }
}
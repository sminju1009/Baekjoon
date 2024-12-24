import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int index, int level) {
        if (level > 0 && level < n) {
            int linkScore = 0;
            int startScore = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        linkScore += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        startScore += arr[i][j];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(linkScore - startScore));
        }

        for (int i = index; i < n; i++) {
            visited[i] = true;
            dfs(i + 1, level + 1);
            visited[i] = false; 
        }
    }
}
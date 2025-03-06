import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static int maxSongs = 0;
    static boolean[][] isAvailable;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isAvailable = new boolean[n][m];
        visited = new boolean[n];
        result = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String guitar = st.nextToken();
            String isOk = st.nextToken();
            for (int j = 0; j < m; j++) {
                if (isOk.charAt(j) == 'Y') {
                    isAvailable[i][j] = true;
                }
            }
        }

        dfs(0, 0);  
        System.out.println((maxSongs > 0) ? answer : -1); 
    }

    public static void dfs(int level, int count) {
        int playCount = 0;
        for (int i = 0; i < m; i++) {
            if (result[i] > 0) playCount++;
        }

        if (playCount > maxSongs) {
            maxSongs = playCount;
            answer = count; 
        } else if (playCount == maxSongs) {
            answer = Math.min(answer, count); 
        }

        if (level == n) return; 

        for (int i = level; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                for (int j = 0; j < m; j++) {
                    if (isAvailable[i][j]) {
                        result[j]++;
                    }
                }
                dfs(i + 1, count + 1);  
                visited[i] = false;
                for (int j = 0; j < m; j++) {
                    if (isAvailable[i][j]) {
                        result[j]--;
                    }
                }
            }
        }
    }
}
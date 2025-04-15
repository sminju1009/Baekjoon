import java.util.*;
import java.io.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        visited = new boolean[n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 1, 0);
        System.out.println(answer);
    }

    public static void dfs(int start, int acid, int bitter) {
        for (int i = start; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int tempAcid = acid * arr[i][0];
                int tempBitter = bitter + arr[i][1];
                answer = Math.min(answer, Math.abs(tempAcid - tempBitter));
                dfs(i+1, tempAcid, tempBitter);
                visited[i] = false;
            }
        }
    }
}
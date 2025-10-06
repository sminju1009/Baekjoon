import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, k;
    static char[][] arr;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int maxLen = 0;
    static String[] strings;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            for (int j = 0; j<m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        strings = new String[k];
        for (int i = 0; i<k; i++) {
            String s = br.readLine();
            strings[i] = s;
            map.put(s, 0);
            maxLen = Math.max(maxLen, s.length());
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                dfs(i, j, 0, String.valueOf(arr[i][j]));
            }
        }

        for (int i = 0; i<k; i++) {
            System.out.println(map.get(strings[i]));
        }

    }

    public static void dfs(int y, int x, int level, String string) {
        if (map.get(string) != null) {
            map.put(string, map.get(string) + 1);
        }

        if (level==maxLen) {
            return;
        }

        for (int d = 0; d<8; d++) {
            int ny = y+dy[d];
            int nx = x+dx[d];
            if (ny<0) ny = n-1;
            if (nx<0) nx = m-1;
            if (ny>=n) ny = 0;
            if (nx>=m) nx = 0;
            String temp = string + String.valueOf(arr[ny][nx]);

            dfs(ny, nx, level+1, temp);
        }
    }
}
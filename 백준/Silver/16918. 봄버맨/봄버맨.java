import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static ArrayList<Pair> bombList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'O') {
                    bombList.add(new Pair(i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        
        if (n == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        } else if (n % 2 == 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append('O');
                }
                sb.append("\n");
            }
        } else if (n % 4 == 3) {
            char[][] result = new char[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(result[i], 'O');
            }
            
            for (Pair bomb : bombList) {
                int y = bomb.y;
                int x = bomb.x;
                int[] dy = {0, 0, 1, 0, -1};
                int[] dx = {0, 1, 0, -1, 0};
                for (int i = 0; i < 5; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                        result[ny][nx] = '.';
                    }
                }
            }
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(result[i][j]);
                }
                sb.append("\n");
            }
        } else {
            char[][] temp = new char[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(temp[i], 'O');
            }
            
            for (Pair bomb : bombList) {
                int y = bomb.y;
                int x = bomb.x;
                int[] dy = {0, 0, 1, 0, -1};
                int[] dx = {0, 1, 0, -1, 0};
                for (int i = 0; i < 5; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                        temp[ny][nx] = '.';
                    }
                }
            }
            
            ArrayList<Pair> newBombList = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (temp[i][j] == 'O') {
                        newBombList.add(new Pair(i, j));
                    }
                }
            }
            
            char[][] result = new char[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(result[i], 'O');
            }
            
            for (Pair bomb : newBombList) {
                int y = bomb.y;
                int x = bomb.x;
                int[] dy = {0, 0, 1, 0, -1};
                int[] dx = {0, 1, 0, -1, 0};
                for (int i = 0; i < 5; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                        result[ny][nx] = '.';
                    }
                }
            }
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(result[i][j]);
                }
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
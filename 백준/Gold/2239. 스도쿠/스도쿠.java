import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr = new int[9][9];
    static boolean end;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<9; i++) {
            String line = br.readLine();
            for (int j = 0; j<9; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        dfs(0);
        for (int i = 0; i<9; i++) {
            for (int j = 0; j<9; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int level) {
        if (level==81) {
            end = true;
            return;
        }
        int y = level/9;
        int x = level%9;
        if (arr[y][x]!=0) {
            dfs(level+1);
        } else {
            for (int i = 1; i<=9; i++) {
                if (!isValid(y, x, i)) continue;
                arr[y][x] = i;
                dfs(level+1);
                if (end) return;
                arr[y][x] = 0;
            }
        }
    }

    public static boolean isValid(int y, int x, int n) {
        for (int i = 0; i<9; i++) {
            if (arr[y][i]==n || arr[i][x]==n) return false;
        }
        int ny = y/3 * 3;
        int nx = x/3 * 3;
        for (int i = ny; i<ny+3; i++) {
            for (int j = nx; j<nx+3; j++) {
                if (arr[i][j] == n) return false;
            }
        }
        return true;
    }
}
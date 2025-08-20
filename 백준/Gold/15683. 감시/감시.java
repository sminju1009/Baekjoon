import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static ArrayList<int[]> cctvs = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0 ;i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (arr[i][j]>=1 && arr[i][j]<=5) {
                    cctvs.add(new int[]{i, j});
                }
            }
        }

        dfs(0, arr);
        System.out.println(answer);
    }

    public static void dfs(int count, int[][] array) {
        if (count == cctvs.size()) {
            answer = Math.min(answer, countZero(array));
            return;
        }

        int[][] temp;

        int y = cctvs.get(count)[0], x = cctvs.get(count)[1];
        if (array[y][x]==1) {
            temp = tempArray(array);
            moveRight(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveLeft(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveUp(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveDown(temp, y, x);
            dfs(count+1, temp);
        } else if (array[y][x]==2) {
            temp = tempArray(array);
            moveRight(temp, y, x);
            moveLeft(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveDown(temp, y, x);
            moveUp(temp, y, x);
            dfs(count+1, temp);
        } else if (array[y][x]==3) {
            temp = tempArray(array);
            moveDown(temp, y, x);
            moveRight(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveDown(temp, y, x);
            moveLeft(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveUp(temp, y, x);
            moveRight(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveUp(temp, y, x);
            moveLeft(temp, y, x);
            dfs(count+1, temp);
        } else if (array[y][x]==4) {
            temp = tempArray(array);
            moveUp(temp, y, x);
            moveLeft(temp, y, x);
            moveRight(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveDown(temp, y, x);
            moveLeft(temp, y, x);
            moveRight(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveDown(temp, y, x);
            moveUp(temp, y, x);
            moveRight(temp, y, x);
            dfs(count+1, temp);

            temp = tempArray(array);
            moveDown(temp, y, x);
            moveUp(temp, y, x);
            moveLeft(temp, y, x);
            dfs(count+1, temp);
        } else if (array[y][x]==5) {
            temp = tempArray(array);
            moveDown(temp, y, x);
            moveUp(temp, y, x);
            moveLeft(temp, y, x);
            moveRight(temp, y, x);
            dfs(count+1, temp);
        }

    }

    public static int[][] tempArray(int[][] array) {
        int[][] result = new int[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                result[i][j] = array[i][j];
            }
        }
        return result;
    }

    public static void moveRight(int[][] array, int y, int x) {
        for (int i = x+1; i<m; i++) {
            if (array[y][i]==6) return;
            if (array[y][i]==0) array[y][i] = 7;
        }
    }

    public static void moveLeft(int[][] array, int y, int x) {
        for (int i = x-1; i>=0; i--) {
            if (array[y][i]==6) return;
            if (array[y][i]==0) array[y][i] = 7;
        }
    }

    public static void moveUp(int[][] array, int y, int x) {
        for (int i = y-1; i>=0; i--) {
            if (array[i][x]==6) return;
            if (array[i][x]==0) array[i][x] = 7;
        }
    }

    public static void moveDown(int[][] array, int y, int x) {
        for (int i = y+1; i<n; i++) {
            if (array[i][x]==6) return;
            if (array[i][x]==0) array[i][x] = 7;
        }
    }

    public static int countZero(int[][] array) {
        int count = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (array[i][j]==0) count++;
            }
        }
        return count;
    }
}
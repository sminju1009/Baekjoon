import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static char[][] arr;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(2 * j);
            }
        }

        dfs(0, 0, arr[0][0] - '0', 0);
        System.out.println(max + " " + min);
    }

    public static int operate(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return a / b;
    }

    public static void dfs(int y, int x, int value, int flag) {
        if (y == n - 1 && x == n - 1) {
            if (y > 0 && flag == 1) {
                char op = arr[y - 1][x];
                value = operate(value, arr[y][x] - '0', op);
            } else if (x > 0 && flag == 0) {
                char op = arr[y][x - 1];
                value = operate(value, arr[y][x] - '0', op);
            }
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        if ((y + x) % 2 == 0) {
            int curr = arr[y][x] - '0';
            if (y > 0 && flag == 1) {
                char op = arr[y - 1][x];
                curr = operate(value, curr, op);
            } else if (x > 0 && flag == 0) {
                char op = arr[y][x - 1];
                curr = operate(value, curr, op);
            }

            if (y + 1 < n) dfs(y + 1, x, curr, 1);
            if (x + 1 < n) dfs(y, x + 1, curr, 0);
        } else {
            if (y + 1 < n) dfs(y + 1, x, value, 1);
            if (x + 1 < n) dfs(y, x + 1, value, 0);
        }
    }
}

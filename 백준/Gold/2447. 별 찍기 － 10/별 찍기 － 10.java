import java.util.*;
import java.io.*;

public class Main {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n>1) {
            n /= 3;
            count++;
        }

        char[][] star = new char[1][1];
        star[0][0] = '*';
        dfs(0, star);

        System.out.println(sb);
    }

    public static void dfs(int level, char[][] arr) {
        if (level==count) {
            for (int i = 0; i<arr.length; i++) {
                for (int j = 0; j<arr[i].length; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            return;
        }

        int tCount = (int) Math.pow(3, level+1);
        int div = tCount/3;
        char[][] temp = new char[tCount][tCount];

        for (int i = 0; i<tCount; i++) {
            for (int j = 0; j<tCount; j++) {
                if (i/div==1 && j/div==1) {
                    temp[i][j] = ' ';
                } else {
                    if (level==0) {
                        temp[i][j] = '*';
                    } else {
                        temp[i][j] = arr[i%div][j%div];
                    }
                }
            }
        }

        dfs(level+1, temp);
    }
}
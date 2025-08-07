import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr = new int[10][10];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        for (int i = 0; i<10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==1) flag = false;
            }
        }
        if (flag) {
            System.out.println(0);
        } else {
            dfs(5, 5, 5, 5, 5);
            System.out.println((answer==Integer.MAX_VALUE) ? -1 : answer);
        }
    }

    public static void dfs(int count1, int count2, int count3, int count4, int count5) {
        if (isPossible()) {
            answer = Math.min(answer, 25-count1-count2-count3-count4-count5);
            return;
        }

        int used = 25-count1-count2-count3-count4-count5;
        if (used >= answer) return;

        for (int i = 0; i<10; i++) {
            for (int j = 0; j<10; j++) {
                if (arr[i][j]==1) {
                    if (count5>0 && canMake(i, j, 5)) {
                        for (int y = i; y<i+5; y++) {
                            for (int x = j; x<j+5; x++) {
                                arr[y][x]=0;
                            }
                        }
                        dfs(count1, count2, count3, count4, count5-1);
                        for (int y = i; y<i+5; y++) {
                            for (int x = j; x<j+5; x++) {
                                arr[y][x]=1;
                            }
                        }
                    }
                    if (count4>0 && canMake(i, j, 4)) {
                        for (int y = i; y<i+4; y++) {
                            for (int x = j; x<j+4; x++) {
                                arr[y][x]=0;
                            }
                        }
                        dfs(count1, count2, count3, count4-1, count5);
                        for (int y = i; y<i+4; y++) {
                            for (int x = j; x<j+4; x++) {
                                arr[y][x]=1;
                            }
                        }

                    }
                    if (count3>0 && canMake(i, j, 3)) {
                        for (int y = i; y<i+3; y++) {
                            for (int x = j; x<j+3; x++) {
                                arr[y][x]=0;
                            }
                        }
                        dfs(count1, count2, count3-1, count4, count5);
                        for (int y = i; y<i+3; y++) {
                            for (int x = j; x<j+3; x++) {
                                arr[y][x]=1;
                            }
                        }

                    }
                    if (count2>0 && canMake(i, j, 2)) {
                        for (int y = i; y<i+2; y++) {
                            for (int x = j; x<j+2; x++) {
                                arr[y][x]=0;
                            }
                        }
                        dfs(count1, count2-1, count3, count4, count5);
                        for (int y = i; y<i+2; y++) {
                            for (int x = j; x<j+2; x++) {
                                arr[y][x]=1;
                            }
                        }
                    }
                    if (count1>0) {
                        arr[i][j] = 0;
                        dfs(count1-1, count2, count3, count4, count5);
                        arr[i][j] = 1;
                    }
                    return;
                }
            }
        }

    }

    public static boolean isPossible() {
        for (int i = 0; i<10; i++) {
            for (int j = 0; j<10; j++) {
                if (arr[i][j]==1) return false;
            }
        }

        return true;
    }

    public static boolean canMake(int y, int x, int size) {
        if (y+size>10 || x+size>10) return false;

        for (int i = y; i<y+size; i++) {
            for (int j = x; j<x+size; j++) {
                if (arr[i][j]==0) return false;
            }
        }

        return true;
    }

}
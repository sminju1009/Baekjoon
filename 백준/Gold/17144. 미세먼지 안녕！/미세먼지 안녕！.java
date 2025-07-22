import java.util.*;
import java.io.*;

public class Main {
    static int r, c;
    static int[][] arr;
    static int air1 = 0, air2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==-1) {
                    if (air1==0) {
                        air1 = i;
                    } else {
                        air2 = i;
                    }
                }
            }
        }
        for (int i = 0; i<t; i++) {
            spread();
            clean();
        }
        int answer = 0;
        for (int i = 0; i<r; i++) {
            for (int j = 0; j<c; j++) {
                if (arr[i][j]>0) answer+= arr[i][j];
            }
        }
        System.out.println(answer);
    }

    // 1. 미세먼지 확산
    public static void spread() {
        int[][] tempArr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tempArr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i<r; i++) {
            for (int j = 0; j<c; j++) {
                if (arr[i][j]==-1 || arr[i][j]==0) continue;
                int temp = 0;
                if (i-1>=0 && i-1<r && arr[i-1][j]!=-1) { // 위칸이 공청기가 아닌 경우
                    temp += arr[i][j]/5;
                    tempArr[i-1][j] += arr[i][j]/5;
                }
                if (i+1>=0 && i+1<r && arr[i+1][j]!=-1) { // 아래칸이 공청기가 아닌 경우
                    temp += arr[i][j]/5;
                    tempArr[i+1][j] += arr[i][j]/5;
                }
                if (j-1>=0 && j-1<c && arr[i][j-1]!=-1) { // 왼쪽 칸이 공청기가 아닌 경우
                    temp += arr[i][j]/5;
                    tempArr[i][j-1] += arr[i][j]/5;
                }
                if (j+1>=0 && j+1<c && arr[i][j+1]!=-1) { // 오른쪽 칸이 공청기가 아닌 경우
                    temp += arr[i][j]/5;
                    tempArr[i][j+1] += arr[i][j]/5;
                }
                tempArr[i][j] = tempArr[i][j] - temp;
            }
        }

        arr = tempArr;
    }

    // 2. 공청기 작동하는 함수
    public static void clean() {
        int top = air1;

        for (int i = top-1; i>0; i--) {
            arr[i][0] = arr[i-1][0];
        }
        for (int j = 0; j<c-1; j++) {
            arr[0][j] = arr[0][j+1];
        }
        for (int i = 0; i<top; i++) {
            arr[i][c-1] = arr[i+1][c-1];
        }
        for (int j = c-1; j>1; j--) {
            arr[top][j] = arr[top][j-1];
        }
        arr[top][1] = 0;

        // 아래쪽 공기청정기 (시계 방향)
        int bottom = air2;
        for (int i = bottom+1; i < r-1; i++) {
            arr[i][0] = arr[i+1][0];
        }
        for (int j = 0; j < c - 1; j++) {
            arr[r-1][j] = arr[r-1][j+1];
        }
        for (int i = r-1; i > bottom; i--) {
            arr[i][c-1] = arr[i-1][c-1];
        }
        for (int j = c-1; j > 1; j--) {
            arr[bottom][j] = arr[bottom][j-1];
        }
        arr[bottom][1] = 0;

        arr[air1][0] = -1;
        arr[air2][0] = -1;
    }

}
import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean flag = true;
    static int[][] reverseArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        reverseArr = new int[m][n];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<r; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (a==1) {
                one();
            } else if (a==2) {
                two();
            } else if (a==3){
                 three();
            } else if (a==4) {
                four();
            } else if (a==5) {
                five();
            } else if (a==6) {
                six();
            }
        }

        StringBuilder sb = new StringBuilder();

        if (flag) {
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<m; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        } else {
            for (int i = 0; i<m; i++) {
                for (int j = 0; j<n; j++) {
                    sb.append(reverseArr[i][j] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void one() { // 상하반전
        if (flag) {
            for (int i = 0; i<n/2; i++) {
                for (int j = 0; j<m; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[n-1-i][j];
                    arr[n-1-i][j] = temp;
                }
            }
        } else {
            for (int i = 0; i<m/2; i++) {
                for (int j = 0; j<n; j++) {
                    int temp = reverseArr[i][j];
                    reverseArr[i][j] = reverseArr[m-1-i][j];
                    reverseArr[m-1-i][j] = temp;
                }
            }
        }
    }

    public static void two() { // 좌우반전
        if (flag) {
            for (int i = 0; i<n; i++) {
                for (int j = 0; j<m/2; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[i][m-1-j];
                    arr[i][m-1-j] = temp;
                }
            }
        } else {
            for (int i = 0; i<m; i++) {
                for (int j = 0; j<n/2; j++) {
                    int temp = reverseArr[i][j];
                    reverseArr[i][j] = reverseArr[i][n-1-j];
                    reverseArr[i][n-1-j] = temp;
                }
            }
        }
    }

    public static void three() { // 90도 회전(오른쪽)
        flag = !flag;
        if (flag) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    arr[i][j] = reverseArr[m-j-1][i];
                }
            }
        } else {
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    reverseArr[i][j] = arr[n-j-1][i];
                }
            }
        }
    }

    public static void four() { // 90도 회전(왼쪽)
        flag = !flag;
        if (flag) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    arr[i][j] = reverseArr[j][n-1-i];
                }
            }
        } else {
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    reverseArr[i][j] = arr[j][m-1-i];
                }
            }
        }
    }

    public static void five() {
        int[][] temp;
        if (flag) {
            temp = new int[n/2][m/2];
            for (int i = 0; i<n/2; i++) {
                for (int j = 0; j<m/2; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            for (int i = 0; i<n/2; i++) {
                for (int j = 0; j<m/2; j++) {
                    arr[i][j] = arr[i+n/2][j];
                }
            }
            for (int i = n/2; i<n; i++) {
                for (int j = 0; j<m/2; j++) {
                    arr[i][j] = arr[i][j+m/2];
                }
            }
            for (int i = n/2; i<n; i++) {
                for (int j = m/2; j<m; j++) {
                    arr[i][j] = arr[i-n/2][j];
                }
            }
            for (int i = 0; i<n/2; i++) {
                for (int j = m/2; j<m; j++) {
                    arr[i][j] = temp[i][j-m/2];
                }
            }
        } else {
            temp = new int[m/2][n/2];
            for (int i = 0; i<m/2; i++) {
                for (int j = 0; j<n/2; j++) {
                    temp[i][j] = reverseArr[i][j];
                }
            }
            for (int i = 0; i<m/2; i++) {
                for (int j = 0; j<n/2; j++) {
                    reverseArr[i][j] = reverseArr[i+m/2][j];
                }
            }
            for (int i = m/2; i<m; i++) {
                for (int j = 0; j<n/2; j++) {
                    reverseArr[i][j] = reverseArr[i][j+n/2];
                }
            }
            for (int i = m/2; i<m; i++) {
                for (int j = n/2; j<n; j++) {
                    reverseArr[i][j] = reverseArr[i-m/2][j];
                }
            }
            for (int i = 0; i<m/2; i++) {
                for (int j = n/2; j<n; j++) {
                    reverseArr[i][j] = temp[i][j-n/2];
                }
            }
        }
    }

    public static void six() {
        int[][] temp;
        if (flag) {
            temp = new int[n/2][m/2];
            for (int i = 0; i<n/2; i++) {
                for (int j = 0; j<m/2; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            for (int i = 0; i<n/2; i++) {
                for (int j = 0; j<m/2; j++) {
                    arr[i][j] = arr[i][j+m/2];
                }
            }
            for (int i = 0; i<n/2; i++) {
                for (int j = m/2; j<m; j++) {
                    arr[i][j] = arr[i+n/2][j];
                }
            }
            for (int i = n/2; i<n; i++) {
                for (int j = m/2; j<m; j++) {
                    arr[i][j] = arr[i][j-m/2];
                }
            }
            for (int i = n/2; i<n; i++) {
                for (int j = 0; j<m/2; j++) {
                    arr[i][j] = temp[i-n/2][j];
                }
            }
        } else {
            temp = new int[m/2][n/2];
            for (int i = 0; i<m/2; i++) {
                for (int j = 0; j<n/2; j++) {
                    temp[i][j] = reverseArr[i][j];
                }
            }
            for (int i = 0; i<m/2; i++) {
                for (int j = 0; j<n/2; j++) {
                    reverseArr[i][j] = reverseArr[i][j+n/2];
                }
            }
            for (int i = 0; i<m/2; i++) {
                for (int j = n/2; j<n; j++) {
                    reverseArr[i][j] = reverseArr[i+m/2][j];
                }
            }
            for (int i = m/2; i<m; i++) {
                for (int j = n/2; j<n; j++) {
                    reverseArr[i][j] = reverseArr[i][j-n/2];
                }
            }
            for (int i = m/2; i<m; i++) {
                for (int j = 0; j<n/2; j++) {
                    reverseArr[i][j] = temp[i-m/2][j];
                }
            }
        }
    }
}
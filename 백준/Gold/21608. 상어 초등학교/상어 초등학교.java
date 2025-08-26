import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static ArrayList<ArrayList<Integer>> favorites = new ArrayList<>(); // 자리 선호도 저장 배열
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i<=n*n; i++) {
            favorites.add(new ArrayList<>());
        }

        for (int i = 0; i<n*n; i++) {
            flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            for (int j = 0; j<4; j++) {
                int t = Integer.parseInt(st.nextToken());
                favorites.get(now).add(t);
            }
            int[][] temp = new int[n][n];

            // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
            ArrayList<int[]> friends = new ArrayList<>();
            int answer = 0;
            for (int j = 0; j<n; j++) {
                for (int k = 0; k<n; k++) {
                    if (arr[j][k]!=0) continue;
                    temp[j][k] = isCountFriends(j, k, now);
                    if (temp[j][k]>answer) {
                        friends.clear();
                        friends.add(new int[]{j, k});
                        answer = temp[j][k];
                    } else if (temp[j][k]==answer) {
                        friends.add(new int[]{j, k});
                    }
                }
            }

            if (friends.size()==1) {
                int y = friends.get(0)[0], x = friends.get(0)[1];
                arr[y][x] = now;
                flag = true;
            }

            // 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            ArrayList<int[]> vacants = new ArrayList<>();
            if (!flag) {
                int tempPlace = 0;
                for (int[] friend: friends) {
                    int y = friend[0], x = friend[1];
                    int vacant = 0;
                    for (int d = 0; d<4; d++) {
                        int ny = y+dy[d], nx = x+dx[d];
                        if (ny<0 || ny>=n || nx<0 || nx>=n) continue;
                        if (arr[ny][nx]==0) {
                            vacant++;
                        }
                    }
                    if (vacant>tempPlace) {
                        vacants.clear();
                        tempPlace = vacant;
                        vacants.add(new int[]{y, x});
                    } else if (vacant==tempPlace) {
                        vacants.add(new int[]{y, x});
                    }
                }

                if (vacants.size()==1) {
                    int y = vacants.get(0)[0], x = vacants.get(0)[1];
                    arr[y][x] = now;
                    flag = true;
                }
            }

            // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
            if (!flag) {
                Collections.sort(vacants, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        if (a[0] != b[0]) {
                            return Integer.compare(a[0], b[0]);
                        }
                        return Integer.compare(a[1], b[1]);
                    }
                });
                arr[vacants.get(0)[0]][vacants.get(0)[1]] = now;
                flag = true;
            }
        }

        int[] result = new int[5];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                int count = 0;
                for (int d = 0; d<4; d++) {
                    int ny = i+dy[d], nx = j+dx[d];
                    if (ny<0 || ny>=n || nx<0 || nx>=n) continue;
                    if (favorites.get(arr[i][j]).contains(arr[ny][nx])) count++;
                }
                result[count]++;
            }
        }

        int ans = 0 * result[0] + result[1] + 10 * result[2] + 100 * result[3] + 1000 * result[4];
        System.out.println(ans);
    }

    public static int isCountFriends(int y, int x, int now) {
        int count = 0;
        for (int d = 0; d<4; d++) {
            int ny = y+dy[d];
            int nx = x+dx[d];
            if (ny<0 || ny>=n || nx<0 || nx>=n) continue;
            if (arr[y][x]==0 && favorites.get(now).contains(arr[ny][nx])) count++;
        }
        return count;
    }

}
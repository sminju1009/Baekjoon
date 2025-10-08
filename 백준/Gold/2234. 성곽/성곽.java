import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m;
    static int[][] arr;
    static int count = 0;
    static int maxSize = 0;
    static boolean[][] visited;
    static int[][] area;
    static ArrayList<Integer> sizes = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        area = new int[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if ((i-1>=0) && area[i][j] != area[i-1][j]) {
                    answer = Math.max(answer, sizes.get(area[i][j]-1) + sizes.get(area[i-1][j]-1));
                }
                if ((i+1<n) && area[i][j] != area[i+1][j]) {
                    answer = Math.max(answer, sizes.get(area[i][j]-1) + sizes.get(area[i+1][j]-1));
                }
                if ((j-1>=0 && area[i][j] != area[i][j-1])) {
                    answer = Math.max(answer, sizes.get(area[i][j]-1) + sizes.get(area[i][j-1]-1));
                }
                if ((j+1<m) && area[i][j] != area[i][j+1]) {
                    answer = Math.max(answer, sizes.get(area[i][j]-1) + sizes.get(area[i][j+1]-1));
                }
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        int size = 0;
        area[i][j] = count+1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0], x = curr[1];
            size++;

            // 서쪽이 뚫려 있는지(1) => 벽이 있는 경우 비트연산 진행 시 1이 나옴
            if ((x-1>=0) && ((1 & arr[y][x]) == 0) && !visited[y][x-1]) {
                visited[y][x-1] = true;
                q.add(new int[]{y, x-1});
                area[y][x-1] = count+1;
            }

            // 북쪽이 뚫려 있는지(2)
            if ((y-1>=0) && ((2 & arr[y][x]) == 0) && !visited[y-1][x]) {
                visited[y-1][x] = true;
                q.add(new int[]{y-1, x});
                area[y-1][x] = count+1;
            }

            // 동쪽이 뚫려 있는지(4)
            if ((x+1<m) && ((4 & arr[y][x]) == 0) && !visited[y][x+1]) {
                visited[y][x+1] = true;
                q.add(new int[]{y, x+1});
                area[y][x+1] = count+1;
            }

            // 남쪽이 뚫려 있는지(8)
            if ((y+1<n) && ((8 & arr[y][x]) == 0) && !visited[y+1][x]) {
                visited[y+1][x] = true;
                q.add(new int[]{y+1, x});
                area[y+1][x] = count+1;
            }
        }
        maxSize = Math.max(size, maxSize);
        sizes.add(size);
    }

}
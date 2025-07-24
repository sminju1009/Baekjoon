import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] group;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Map<Integer, Integer> groupSize = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        group = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int groupId = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && group[i][j] == 0) {
                    int size = bfs(i, j, groupId);
                    groupSize.put(groupId, size);
                    groupId++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    Set<Integer> nearGroups = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                            int gid = group[ny][nx];
                            if (gid > 0) {
                                nearGroups.add(gid);
                            }
                        }
                    }
                    int sum = 1;
                    for (int gid : nearGroups) {
                        sum += groupSize.get(gid);
                    }
                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int bfs(int y, int x, int groupId) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        group[y][x] = groupId;
        int size = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cy = curr[0], cx = curr[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (arr[ny][nx] == 0 && group[ny][nx] == 0) {
                        group[ny][nx] = groupId;
                        q.add(new int[]{ny, nx});
                        size++;
                    }
                }
            }
        }

        return size;
    }
}
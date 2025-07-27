import java.util.*;
import java.io.*;

public class Main {
    static char[][][] arr;
    static boolean[][][] visited;
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static class Pair {
        int y, x, z, level;

        public Pair (int y, int x, int z, int level) {
            this.y = y;
            this.x = x;
            this.z = z;
            this.level = level;
        }
    }
    static int sy = 0, sx = 0, sz = 0;
    static int ey = 0, ex = 0, ez = 0;
    static int l, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l==0 || r==0 || c==0) break;
            arr = new char[l][r][c];
            visited = new boolean[l][r][c];
            for(int i=0; i<l; i++) {
                for(int j=0; j<r; j++) {
                    String line = br.readLine();
                    for(int k=0; k<c; k++) {
                        arr[i][j][k] = line.charAt(k);
                        if(arr[i][j][k] == 'S') {
                            sz = i; sy = j; sx = k; 
                        } else if (arr[i][j][k] == 'E') {
                            ez = i; ey = j; ex = k;  
                        }
                    }
                }
                br.readLine();
            }
            int answer = bfs();
            if (answer==-1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in " + answer + " minute(s).\n");
            }
        }
        System.out.println(sb);
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sy, sx, sz, 0));
        visited[sz][sy][sx] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y, x = curr.x, z = curr.z, level = curr.level;
            if (y==ey && x==ex && z==ez) return level;

            for (int dir = 0; dir<6; dir++) {
                int ny = y+dy[dir];
                int nx = x+dx[dir];
                int nz = z+dz[dir];

                if (ny<0 || ny>=r || nx<0 || nx>=c || nz<0 || nz>=l) continue;

                if (!visited[nz][ny][nx] && arr[nz][ny][nx]!='#') { 
                    q.add(new Pair(ny, nx, nz, level+1));
                    visited[nz][ny][nx] = true;
                }
            }
        }

        return -1;
    }
}
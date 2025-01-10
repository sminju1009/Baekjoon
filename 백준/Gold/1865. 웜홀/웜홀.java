import java.util.*;
import java.io.*;

class Road {
    int end;
    int weight;

    public Road(int end, int weight)  {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static int n, m, w;
    static int[] dist;
    static ArrayList<ArrayList<Road>> road;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dist = new int[n+1];
            road = new ArrayList<>();
            for (int i = 0; i<=n; i++) {
                road.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                road.get(s).add(new Road(e, t));
                road.get(e).add(new Road(s, t));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                road.get(s).add(new Road(e, -t));
            }

            boolean isMinusCycle = false;
            for (int i = 1; i<=n; i++) {
                if (bellmanFord(i)) {
                    isMinusCycle = true;
                    System.out.println("YES");
                    break;
                }
            }

            if (!isMinusCycle) {
                System.out.println("NO");
            }

        }
    }

    public static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        for (int i = 1; i<n; i++) {
            update = false;
            for (int j = 1; j<=n; j++) {
                for (Road r: road.get(j)) {
                    if (dist[j] != INF && dist[r.end] > dist[j] + r.weight) {
                        dist[r.end] = dist[j] + r.weight;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        if (update) {
            for (int i = 1; i<=n; i++) {
                for (Road r : road.get(i)) {
                    if (dist[i] != INF && dist[r.end] > dist[i] + r.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
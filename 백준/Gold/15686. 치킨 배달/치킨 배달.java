import java.io.*;
import java.util.*;

class Point {
    int y, x;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n, m;
    static int[][] arr;
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> home = new ArrayList<>();
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];
        answer = 2 * n * n;
        dfs(0, new ArrayList<>());
        System.out.println(answer);
    }

    public static void dfs(int level, ArrayList<Point> selected) {
        if (selected.size() + (chicken.size() - level) < m) { 
            return;
        }
        if (level == chicken.size()) { 
            if (selected.size() == m) { 
                answer = Math.min(answer, calculate(selected));
            }
            return;
        }

        selected.add(chicken.get(level));
        dfs(level + 1, selected);
        selected.remove(selected.size() - 1);

        dfs(level + 1, selected);
    }

    public static int calculate(ArrayList<Point> selected) {
        int sum = 0;
        for (Point h : home) {
            int minDist = 2 * n;
            for (Point c : selected) {
                int dist = Math.abs(h.y - c.y) + Math.abs(h.x - c.x);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        return sum;
    }
}

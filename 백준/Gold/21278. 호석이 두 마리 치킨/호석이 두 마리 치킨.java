import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static int[] dist1, dist2;
    static int[] distResult;
    static ArrayList<ArrayList<Integer>> arr;
    static int n, m;
    static int building1 = 0, building2 = 0, distSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            arr.get(start).add(end);
            arr.get(end).add(start);
        }

        for (int i = 0; i<n-1; i++) {
            for (int j = i+1; j<n; j++) {
                dist1 = new int[n];
                dist2 = new int[n];
                distResult = new int[n];
                visited = new boolean[n];
                dfs(i, 0, 1);
                visited = new boolean[n];
                dfs(j, 0, 2);
                int temp = 0;
                for (int k = 0; k<n; k++) {
                    distResult[k] = Math.min(dist1[k], dist2[k]);
                    temp += distResult[k];
                }
                if (temp<distSum) {
                    building1 = i+1;
                    building2 = j+1;
                    distSum = temp;
                }
            }
        }
        System.out.println(building1 + " " + building2 + " " + distSum*2);
    }

    public static void dfs(int chicken, int dist, int num) {

        visited[chicken] = true;
        for (int i: arr.get(chicken)) {
            if (!visited[i]) {
                visited[i] = true;
                if (num==1) {
                    dist1[i] = dist+1;
                    dfs(i, dist+1, num);
                } else {
                    dist2[i] = dist+1;
                    dfs(i, dist+1, num);
                }
            }
        }

    }
}
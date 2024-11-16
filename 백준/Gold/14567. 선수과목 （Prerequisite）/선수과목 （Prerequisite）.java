import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> dist;
    static int[] result; // 이수하는 학기를 저장할 배열
    static int[] indegree; // 진입 차수 배열 
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n+1];
        result = new int[n+1];
        dist = new ArrayList<>(n+1);
        for (int i = 0; i<n+1; i++) {
            dist.add(new ArrayList<>());
        }
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist.get(a).add(b);
            indegree[b]++;
        }
        
        topologicalSort();
        
        for (int i = 1; i<=n; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }

    public static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i<=n; i++) {
            if (indegree[i]==0) {
                q.offer(i);
                result[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();


            for (int i: dist.get(node)) {
                indegree[i]--;
                
                result[i] = Math.max(result[i], result[node] + 1);
                
                if (indegree[i]==0) {
                    q.offer(i);
                }
            }

        }
    }
}
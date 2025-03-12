import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n==k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        parent[n] = -1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            int[] nextDist = {curr-1, curr+1, curr*2};
            for (int next: nextDist) {
                if (next>=0 && next<=100000 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = curr;
                    q.add(next);
                    
                    if (next==k) break;
                }
            }
        }
        
        Stack<Integer> path = new Stack<>();
        for (int i = k; i!=-1; i=parent[i]) {
            path.push(i);
        }
        sb.append(path.size()-1 + "\n");
        while (!path.isEmpty()) {
            sb.append(path.pop() + " ");
        }
        System.out.println(sb);

    }
}
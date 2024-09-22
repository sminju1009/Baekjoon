import java.util.*;
import java.io.*;

public class Main {
    static class Pair {
        int x;
        int time;
        public Pair(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    
    static int n, k;
    static int[] time;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);
        
        bfs();
        
        System.out.println(time[k]);
    }
    
    static void bfs() {
        Deque<Pair> dq = new LinkedList<>();
        dq.offer(new Pair(n, 0));
        time[n] = 0;
        
        while (!dq.isEmpty()) {
            Pair curr = dq.poll();
            int x = curr.x;
            
            if (x == k) return;
            
            if (x * 2 <= 100000 && time[x * 2] > time[x]) {
                time[x * 2] = time[x];
                dq.addFirst(new Pair(x * 2, time[x * 2]));
            }
            
            if (x + 1 <= 100000 && time[x + 1] > time[x] + 1) {
                time[x + 1] = time[x] + 1;
                dq.addLast(new Pair(x + 1, time[x + 1]));
            }
            
            if (x - 1 >= 0 && time[x - 1] > time[x] + 1) {
                time[x - 1] = time[x] + 1;
                dq.addLast(new Pair(x - 1, time[x - 1]));
            }
        }
    }
}
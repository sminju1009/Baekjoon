import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m;
    static boolean[] know;
    static ArrayList<Integer>[] parties; 
    static boolean[][] graph; 
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        know = new boolean[n];
        graph = new boolean[n][n];
        parties = new ArrayList[m];
        
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        while (a-->0) {
            know[Integer.parseInt(st.nextToken())-1] = true;
        }
        
        for (int i = 0; i<m; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j<p; j++) {
                int person = Integer.parseInt(st.nextToken())-1;
                parties[i].add(person);
            }
            
            for (int j = 0; j<parties[i].size(); j++) {
                for (int k = 0; k<parties[i].size(); k++) {
                    graph[parties[i].get(j)][parties[i].get(k)] = true;
                }
            }
        }
        
        for (int i = 0; i<n; i++) {
            if (know[i]) dfs(i);
        }
        
        int count = 0;
        for (int i = 0; i<m; i++) {
            boolean canLie = true;
            for (int person : parties[i]) {
                if (know[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }
        
        System.out.println(count);
    }
    
    public static void dfs(int now) {
        for (int i = 0; i<n; i++) {
            if (graph[now][i] && !know[i]) {
                know[i] = true;
                dfs(i);
            }
        }
    }
}
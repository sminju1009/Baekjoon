import java.util.*;
import java.io.*;

public class Main {

    static int n, delete;
    static int[] nodes;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = 0;
        n = Integer.parseInt(br.readLine());
        nodes = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
            if (nodes[i]==-1) root=i;
        }
        delete = Integer.parseInt(br.readLine());
        // 지워야 할 노드 지우기
        deleteNode(delete);
        // 리프 세기
        countNode(root);
        System.out.println(count);
    }

    // 지워야 될 노드를 지우는 메서드
    public static void deleteNode(int node) {
        nodes[node] = -2;
        for (int i = 0; i<n; i++) {
            if (nodes[i]==node) {
                deleteNode(i);
            }
        }
    }

    // 노드 계산하는 메서드
    public static void countNode(int num) {
        boolean isLeaf = true;
        visited[num] = true;
        if (nodes[num]!=-2) {
            for (int i = 0; i<n; i++) {
                if (nodes[i]==num && !visited[i]) {
                    countNode(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) count++;
        }

    }
}
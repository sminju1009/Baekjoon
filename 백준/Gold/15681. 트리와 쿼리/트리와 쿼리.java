import java.util.*;
import java.io.*;

public class Main {

    static int n, r, q;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for (int i = 0 ;i<=n; i++) {
            tree.add(new ArrayList<>());
            arr.add(new ArrayList<>());
        }
        size = new int[n+1];

        for (int i = 0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        makeTree(r, -1);
        countSubtreeNodes(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<q; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(size[a] + "\n");
        }
        System.out.println(sb);

    }

    public static void makeTree(int curNode, int parent) {
        for (int i: tree.get(curNode)) {
            if (i != parent) {
                arr.get(curNode).add(i);
                makeTree(i, curNode);
            }
        }
    }

    public static void countSubtreeNodes(int curNode) {
        size[curNode] = 1;
        for (int i: arr.get(curNode)) {
            countSubtreeNodes(i);
            size[curNode] += size[i];
        }
    }
}
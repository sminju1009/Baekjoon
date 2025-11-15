import java.util.*;
import java.io.*;

public class Main {

    static int n, k, s, e;
    static char[][] arr;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static class Pair {
        int y;
        ArrayList<Integer> array;

        public Pair(int y, ArrayList<Integer> array) {
            this.y = y;
            this.array = array;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[n][k];
        visited = new boolean[n];
        for (int i = 0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i<n; i++) {
            String str = br.readLine();
            for (int j = 0; j<k; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken())-1;
        e = Integer.parseInt(st.nextToken())-1;
        for (int i = 0; i<n-1; i++) {
            for (int j = i+1; j<n; j++) {
                int count = 0;
                for (int l = 0; l<k; l++) {
                    if (arr[i][l]!=arr[j][l]) count++;
                    if (count>=2) break;
                }
                if (count==1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        ArrayList<Integer> answer = bfs();

        if (answer.size()==0) {
            System.out.println(-1);
        } else {
            if (answer.get(0)==s) {
                for (int i = 0; i<answer.size(); i++) {
                    System.out.print((answer.get(i)+1) + " ");
                }
            } else {
                for (int i = answer.size()-1; i>=0; i--) {
                    System.out.print((answer.get(i)+1) + " ");
                }
            }
        }
    }

    public static ArrayList<Integer> bfs() {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> startList = new ArrayList<>();
        startList.add(s);
        q.add(new Pair(s, startList));
        visited[s] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.y;
            ArrayList<Integer> temp = curr.array;
            if (y == e) return temp;

            for (int i: list.get(y)) {
                if (!visited[i]) {
                    visited[i] = true;
                    ArrayList<Integer> nextPath = new ArrayList<>(temp);
                    nextPath.add(i);
                    q.add(new Pair(i, nextPath));
                }
            }
        }

        return new ArrayList<>();
    }
}
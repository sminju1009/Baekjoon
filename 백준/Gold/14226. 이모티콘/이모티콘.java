import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static class Pair {
        int emoticons;
        int level;
        int clipboard;

        public Pair(int emoticons, int level, int clipboard) {
            this.emoticons = emoticons;
            this.level = level;
            this.clipboard = clipboard;
        }
    }
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[2001][2001];
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0, 0));
        visited[1][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int emoticons = curr.emoticons, level = curr.level, clipboard = curr.clipboard;

            if (emoticons == n) {
                return level;
            }

            // 1. 화면에 있는 이모티콘을 복사해서 붙여넣기
            if (!visited[emoticons][emoticons]) {
                q.add(new Pair(emoticons, level+1, emoticons));
                visited[emoticons][emoticons] = true;
            }

            // 2. 클립보드에 있는 이모티콘을 화면에 붙여넣기 하기
            if (emoticons + clipboard <= 2000 && !visited[emoticons][emoticons+clipboard] && clipboard !=0) {
                q.add(new Pair(emoticons+clipboard, level+1, clipboard));
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다
            if (emoticons-1>=0 && !visited[emoticons][emoticons-1]) {
                visited[emoticons][emoticons-1] = true;
                q.add(new Pair(emoticons-1, level+1, clipboard));
            }

        }


        return -1;
    }
}
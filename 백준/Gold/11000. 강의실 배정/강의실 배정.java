import java.util.*;
import java.io.*;

public class Main {

    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
             this.start = start;
             this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);

        for (int i = 1; i<n; i++) {
            if (pq.peek() <= lectures[i].start) {
                pq.poll();
            }
            pq.offer(lectures[i].end);
        }

        System.out.println(pq.size());
    }
}
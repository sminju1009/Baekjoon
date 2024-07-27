import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>(); // 큐 구현

        for (int i=0; i<n; i++) {
            String a = br.readLine();
            if (a.equals("front")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.get(0));
                }
            } else if (a.equals("back")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.get(q.size()-1));
                }
            } else if (a.equals("empty")) {
                if (q.isEmpty()) { // 큐가 비어있으면 1을 출력
                    System.out.println(1);
                } else { // 큐가 비어있으면 0을 출력
                    System.out.println(0);
                }
            } else if (a.equals("size")) {
                System.out.println(q.size()); // 큐의 길이 출력
            } else if (a.equals("pop")) {
                if (q.isEmpty()) {
                    System.out.println(-1); // 큐가 비어있는 경우에는 pop을 할 수 없으므로 -1 출력
                } else {
                    System.out.println(q.pop()); // 가장 앞의 객체를 빼고 그 객체를 출력
                }
            } else { // push x의 형태로 입력받게 되는 경우
                String[] result = a.split(" "); // 공백으로 구분하기
                q.addLast(Integer.valueOf(result[1]));
            }
        }
    }
}
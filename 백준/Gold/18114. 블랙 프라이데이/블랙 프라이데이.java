import java.util.*;
import java.io.*;

public class Main {

    static int n, c;
    static ArrayList<Integer> arr = new ArrayList<>();

    static int isOk = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 물건 무게가 c인 물건이 있는 경우
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == c) {
                isOk = 1;
            }
        }

        if (isOk == 1) {
            System.out.println(1);
        } else {
            Collections.sort(arr);
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int weight = arr.get(start) + arr.get(end);
                if (weight > c) {
                    end--;
                } else if (weight == c) {
                    isOk = 1;
                    break;
                } else {
                    int index = arr.indexOf(c - weight);
                    if (index > start && index < end) {
                        isOk = 1;
                        break;
                    }
                    start++;
                }
            }
            if (isOk == 1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
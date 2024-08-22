import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0]: o1[1] - o2[1]);
        int count = 0;
        int prevEndTime = 0;
        // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같으면 갱신
        for (int i = 0; i<n; i++) {
            if (prevEndTime<=arr[i][0]) {
                count++;
                prevEndTime = arr[i][1];
            }
        }
        System.out.println(count);
    }
}

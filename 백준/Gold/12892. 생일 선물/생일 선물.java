import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int start = 0;
        int end = 0;
        long answer = arr[start][1];
        long temp = arr[start][1];
        while (end<n) {
            if (arr[end][0]-arr[start][0]<d) {
                answer = Math.max(answer, temp);
                end++;
                if (end<n) temp += arr[end][1];
            } else {
                temp -= arr[start][1];
                start++;
            }
        }
        System.out.println(answer);
    }
}

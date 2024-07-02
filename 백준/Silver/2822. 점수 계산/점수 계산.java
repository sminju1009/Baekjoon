import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 점수를 입력받을 배열
        int[][] arr = new int[8][2];
        int[] result = new int[5];
        int answer = 0;

        for (int i = 0; i<8; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i+1;
        }

        // 람다식을 이용한 정렬
        Arrays.sort(arr, (o1, o2) -> (o1[0]==o2[0]?o2[1]-o1[1]:o2[0]-o1[0]));

        for (int i = 0; i<5; i++) {
            answer += arr[i][0];
            result[i] = arr[i][1];
        }

        Arrays.sort(result);
        System.out.println(answer);
        for (int i = 0; i<5; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
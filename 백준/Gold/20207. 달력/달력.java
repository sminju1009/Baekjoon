import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int min = Integer.MAX_VALUE;
        int[] arr = new int[366];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            max = Math.max(max, end);
            min = Math.min(min, start);
            for (int j = start; j<=end; j++) {
                arr[j]++;
            }
        }
        int answer = 0; 
        int pointer = 0;
        int range = 0;
        for (int i = min; i<=max; i++) {
            if (arr[i]!=0) {
                range++;
                pointer = Math.max(pointer, arr[i]);
            }
            else if (arr[i]==0) {
                answer += pointer*range;
                range = 0;
                pointer = 0;
            }
        }
        answer += range*pointer;
        System.out.println(answer);
    }
}
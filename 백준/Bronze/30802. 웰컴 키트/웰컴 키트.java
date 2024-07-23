import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); // 티셔츠
        int p = Integer.parseInt(st.nextToken()); // 펜 묶음 수

        for (int i = 0; i<6; i++) {
            count += arr[i]/t;
            if (arr[i]%t!=0) {
                count ++;
            }
        }

        int result = n/p;
        int mod = n%p;
        
        System.out.println(count);
        System.out.println(result + " " + mod);
    }
}
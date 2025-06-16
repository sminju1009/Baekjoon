import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];
        for (int i = 0; i<n; i++) {
            arr[i] = br.readLine();
        }
        int k = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i<n; i++) {
            int temp = 1;
            int zerocount = 0;
            for (int j = 0; j<n ;j++) {
                if (i!=j && arr[i].equals(arr[j])) temp++;
            }
            for (int j = 0; j<m; j++) {
                if (arr[i].charAt(j)=='0') zerocount++;
            }
            if (zerocount<=k && (zerocount-k)%2==0) {
                answer = Math.max(answer, temp);
            }
        }
        System.out.println(answer);
    }
}
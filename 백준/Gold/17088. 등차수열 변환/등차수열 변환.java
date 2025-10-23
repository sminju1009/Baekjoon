import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n<=2) {
            System.out.println(0);
            System.exit(0);
        }

        for (int d1 = -1; d1<=1; d1++) {
            for (int d2 = -1; d2<=1; d2++) {
                int first = arr[0] + d1;
                int second = arr[1] + d2;
                int diff = second - first;
                
                int count = (d1==0 ? 0 : 1) + (d2==0? 0 : 1);
                boolean flag = true;
                
                for (int i = 2; i<n; i++) {
                    int now = first + diff*i;
                    int delta = now - arr[i];
                    if (delta<-1 || delta>1) {
                        flag = false;
                        break;
                    }
                    if (delta!=0) {
                        count++;
                    }
                    
                }
                if (flag) answer = Math.min(answer, count);
            }
        }

        System.out.println((answer!=Integer.MAX_VALUE) ? answer : -1);
    }
}
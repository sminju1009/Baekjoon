import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       int l = Integer.parseInt(st.nextToken());
       int[] cakes = new int[m+1];
       for(int i=0;i<m;i++){
           cakes[i] = Integer.parseInt(br.readLine());
       }
       cakes[m] = l;

       for(int i = 0 ; i<n;i++){
           int answer = 0;
           int q = Integer.parseInt(br.readLine());
           int low = 0;
           int high = l;
           while(low<=high) {
               int mid = (low+high)/2;
               if (check(low, high, mid, cakes, q)) {
                   low = mid + 1;
                   answer = Math.max(mid, answer);
               } else {
                   high = mid - 1;
               }
           }
           System.out.println(answer);
       }

    }

    public static boolean check(int low, int high, int mid, int[] cakes,int q){
        int prev=0;
        for(int i=0;i<cakes.length;i++){
            if(cakes[i]-prev >= mid){
                q--;
                prev = cakes[i];
            }
        }
        return q <0 ? true : false;
    }
}
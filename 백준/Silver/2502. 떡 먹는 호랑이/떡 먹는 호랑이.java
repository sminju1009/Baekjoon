import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        if(d == 3) {
            System.out.println(1);
            System.out.println(k-1);
        } else {
            int x = 1, y = 1;
            for(int i = 4; i <= d; i++){
                int temp = y;
                y = x + y;
                x = temp;
            }
            
            int size = k/y;
            for(int i = size-1; i >= 0; i--){
                if((k - (i*y)) % x == 0){
                    System.out.println((k - (i*y)) / x);
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
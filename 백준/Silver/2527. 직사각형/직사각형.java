import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sy1 = Integer.parseInt(st.nextToken());
            int sx1 = Integer.parseInt(st.nextToken());
            int ey1 = Integer.parseInt(st.nextToken());
            int ex1 = Integer.parseInt(st.nextToken());
            int sy2 = Integer.parseInt(st.nextToken());
            int sx2 = Integer.parseInt(st.nextToken());
            int ey2 = Integer.parseInt(st.nextToken());
            int ex2 = Integer.parseInt(st.nextToken());
            if (sx1>ex2 || ex1<sx2 || sy1>ey2 || ey1<sy2) {
                sb.append("d\n");
            } else if (ey1==sy2 || sy1==ey2) {
                if (ex1==sx2 || sx1==ex2) {
                    sb.append("c\n");
                } else {
                    sb.append("b\n");
                }
            } else if (ex1==sx2 || sx1==ex2) {
                sb.append("b\n");
            } else {
                sb.append("a\n");
            }
        }
        System.out.println(sb);
    }
}
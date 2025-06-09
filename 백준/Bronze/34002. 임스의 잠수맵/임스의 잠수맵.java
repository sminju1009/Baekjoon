import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int eventMap = Integer.parseInt(st.nextToken()); 
        int mind = Integer.parseInt(st.nextToken());
        int vip = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int mindPass = Integer.parseInt(st.nextToken()); 
        int vipPass = Integer.parseInt(st.nextToken());
        int nowLevel = Integer.parseInt(br.readLine());

        int needExp = (250 - nowLevel) * 100;
        int needTime = 0; 
        
        while (vipPass > 0 && needExp > 0) {
            int timeToUse = Math.min(30, (int)Math.ceil((double)needExp / vip));
            needExp -= timeToUse * vip;
            needTime += timeToUse;
            vipPass--;
        }

        while (mindPass > 0 && needExp > 0) {
            int timeToUse = Math.min(30, (int)Math.ceil((double)needExp / mind));
            needExp -= timeToUse * mind;
            needTime += timeToUse;
            mindPass--;
        }

        if (needExp > 0) {
            needTime += (int)Math.ceil((double)needExp / eventMap);
        }

        System.out.println(needTime);
    }
}
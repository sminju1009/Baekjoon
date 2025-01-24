import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1000];
        int answer = 0;
        for (int i = 123; i<=987; i++) {
            String str = Integer.toString(i);
            if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2) ||
                str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
                arr[i] = -1;
            }
        }

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t<tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String number = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());


            for (int idx = 123; idx<=987; idx++) {
                if (arr[idx] != -1) {
                    int strikeCnt = 0;
                    int ballCnt = 0;
                    String strIdx = Integer.toString(idx);
                    for (int j = 0; j<3; j++) {
                        if (number.charAt(j) == strIdx.charAt(j)) strikeCnt++;
                    }

                    for (int p = 0; p<3; p++) {
                        for (int q = 0; q<3; q++) {
                            if ((p!=q) && (number.charAt(p) == strIdx.charAt(q))) ballCnt++;
                        }
                    }

                    if ((strike!=strikeCnt) || (ball!=ballCnt)) {
                        arr[idx] = -1;
                        continue;
                    }

                    if ((strike==strikeCnt) && (ball==ballCnt)) {
                        arr[idx]++;
                    }
                }
            }
        }

        for (int i = 123; i<=987; i++) {
            if (arr[i] == tc) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][3];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<3; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[j][a-1]++;
            }
        }
        int[] scores = new int[3];
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                scores[i] += arr[i][j] * (j+1);
            }
        }

        int max = 0;
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i<3; i++) {
            if (scores[i]>max) {
                count.clear();
                max = scores[i];
                count.add(i);
            } else if (scores[i]==max) {
                count.add(i);
            }
        }
        
        if (count.size()==1) {
            System.out.println((count.get(0)+1) + " " + max);
        } else {
            boolean flag = false;

            int maxPerson = 0;
            int maxNumber3 = 0;
            int maxNumber2 = 0;
            ArrayList<Integer> number3 = new ArrayList<>();
            ArrayList<Integer> number2 = new ArrayList<>();
            for (int i: count) {
                if (arr[i][2]>maxNumber3) {
                    maxNumber3 = arr[i][2];
                    number3.clear();
                    number3.add(i);
                } else if (arr[i][2]==maxNumber3) {
                    number3.add(i);
                }
            }
            if (number3.size()==1) {
                flag = true;
                maxPerson = number3.get(0) + 1;
            }

            if (!flag) {
                for (int i: count) {
                    if (arr[i][1]>maxNumber2) {
                        maxNumber2 = arr[i][1];
                        number2.clear();
                        number2.add(i);
                    } else if (arr[i][1]==maxNumber2) {
                        number2.add(i);
                    }
                }
                if (number2.size()==1) {
                    flag = true;
                    maxPerson = number2.get(0) + 1;
                }
            }

            System.out.println(maxPerson + " " + max);


        }
    }
}
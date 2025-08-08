import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y, idx;
        Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Point[] points = new Point[N];
        Point[] vx = new Point[N];
        Point[] vy = new Point[N];
        Map<Integer, Integer> xmp = new HashMap<>();
        Map<Integer, Integer> ymp = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            points[i] = new Point(x, y, i);
            vx[i] = new Point(x, y, i);
            vy[i] = new Point(x, y, i);
            
            xmp.put(x, xmp.getOrDefault(x, 0) + 1);
            ymp.put(y, ymp.getOrDefault(y, 0) + 1);
        }
        
        Arrays.sort(vx, (a, b) -> Integer.compare(a.x, b.x));  
        Arrays.sort(vy, (a, b) -> Integer.compare(a.y, b.y));
        
        Set<Integer> candSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            candSet.add(vx[i].idx);
            candSet.add(vy[i].idx);
            candSet.add(vx[N - i - 1].idx);
            candSet.add(vy[N - i - 1].idx);
        }
        
        List<Integer> cand = new ArrayList<>(candSet);
        Collections.sort(cand);
        
        long ans = 2000000000L;
        
        for (int i = 0; i < cand.size(); i++) {
            for (int j = i + 1; j < cand.size(); j++) {
                for (int k = j + 1; k < cand.size(); k++) {
                    int p1 = cand.get(i);
                    int p2 = cand.get(j);
                    int p3 = cand.get(k);
                    
                    decrementMap(xmp, points[p1].x);
                    decrementMap(xmp, points[p2].x);
                    decrementMap(xmp, points[p3].x);
                    decrementMap(ymp, points[p1].y);
                    decrementMap(ymp, points[p2].y);
                    decrementMap(ymp, points[p3].y);
                    
                    if (!xmp.isEmpty() && !ymp.isEmpty()) {
                        int minX = Collections.min(xmp.keySet());
                        int maxX = Collections.max(xmp.keySet());
                        int minY = Collections.min(ymp.keySet());
                        int maxY = Collections.max(ymp.keySet());
                        
                        long xlen = Math.abs(maxX - minX);
                        long ylen = Math.abs(maxY - minY);
                        ans = Math.min(ans, xlen * ylen);
                    }
                    
                    xmp.put(points[p1].x, xmp.getOrDefault(points[p1].x, 0) + 1);
                    xmp.put(points[p2].x, xmp.getOrDefault(points[p2].x, 0) + 1);
                    xmp.put(points[p3].x, xmp.getOrDefault(points[p3].x, 0) + 1);
                    ymp.put(points[p1].y, ymp.getOrDefault(points[p1].y, 0) + 1);
                    ymp.put(points[p2].y, ymp.getOrDefault(points[p2].y, 0) + 1);
                    ymp.put(points[p3].y, ymp.getOrDefault(points[p3].y, 0) + 1);
                }
            }
        }
        
        System.out.println(ans);
    }
    
    static void decrementMap(Map<Integer, Integer> map, int key) {
        int count = map.get(key) - 1;
        if (count == 0) {
            map.remove(key);
        } else {
            map.put(key, count);
        }
    }
}
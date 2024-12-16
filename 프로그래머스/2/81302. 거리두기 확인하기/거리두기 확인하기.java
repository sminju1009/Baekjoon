import java.util.*;

class Pair {
    int y;
    int x;
    
    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Dots {
    int sy;
    int sx;
    int ey;
    int ex;
    
    public Dots(int sy, int sx, int ey, int ex) {
        this.sy = sy;
        this.sx = sx;
        this.ey = ey;
        this.ex = ex;
    }
}

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i<=4; i++) {
            boolean isTrue = true;
            ArrayList<Pair> dots = new ArrayList<>();
            ArrayList<Dots> partition = new ArrayList<>();
            for (int j = 0; j<5; j++) {
                for (int k = 0; k<5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        dots.add(new Pair(j, k));
                    }
                }
            }
            
            // 좌석이 0이나 1인 경우는 고려할 필요 없음(어떻게든 조건 충족함)
            if (dots.size() > 1) {
                // 맨해튼 거리 계산하기
                for (int start = 0; start<dots.size()-1; start++) {
                    for (int end = start+1; end<dots.size(); end++) {
                        int sy = dots.get(start).y;
                        int sx = dots.get(start).x;
                        int ey = dots.get(end).y;
                        int ex = dots.get(end).x;
                        int manhattanDist = Math.abs(ey-sy) + Math.abs(ex-sx);
                        if (manhattanDist == 1) {
                            isTrue = false;
                            break;
                        } else if (manhattanDist == 2) {
                            partition.add(new Dots(sy, sx, ey, ex));
                        }
                    }
                }
                
                // isTrue가 true이면서 partition 사이즈가 1 이상인 경우
                if (isTrue && partition.size()>=1) {
                    for (Dots dot: partition) {
                        if (!part(dot, places, i)) {
                            isTrue = false;
                            break;
                        }
                    }
                }
            }
            
            
            answer[i] = (isTrue) ? 1 : 0;
        }
        return answer;
    }
    
    public boolean part(Dots nowDot, String[][] places, int i) {
        int sy = nowDot.sy;
        int sx = nowDot.sx;
        int ey = nowDot.ey;
        int ex = nowDot.ex;
        // y가 차이나지 않고 x 차이가 2인 경우
        if (Math.abs(ey-sy)==0 && Math.abs(ex-sx)==2) {
            if (places[i][ey].charAt((ex+sx)/2) == 'O') {
                return false;
            }
            return true;
        }
        // y가 2 차이나고 x가 차이나지 않는 경우
        else if (Math.abs(ey-sy)==2 && Math.abs(ex-sx)==0) {
            if (places[i][(ey+sy)/2].charAt(sx) == 'O') {
                return false;
            }
            return true;
        }
        // 각각 1씩 차이나는 경우
        else if (Math.abs(ey-sy)== 1 && Math.abs(ex-sx) == 1) {
            if (places[i][ey].charAt(ex)=='O') {
                return false;
            } else if (places[i][ey].charAt(sx)=='O') {
                return false;
            } else if (places[i][sy].charAt(ex)=='O') {
                return false;
            } else if (places[i][sy].charAt(sx)=='O') {
                return false;
            }
            return true;
        }
        return true;
    }
}
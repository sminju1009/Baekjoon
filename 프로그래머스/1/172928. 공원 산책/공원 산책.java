class Solution {
    int nowY = 0;
    int nowX = 0;
    String[][] park;
    
    public void move(String dir, int dist) {
        boolean flag = true;
        
        // East
        if (dir.equals("E")) {
            if (nowX + dist >= park[0].length) {
                return;
            }
            for (int i = nowX + 1; i <= nowX + dist; i++) {
                if (park[nowY][i].equals("X")) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                nowX += dist;
            }
        }
        // South
        else if (dir.equals("S")) {
            if (nowY + dist >= park.length) {
                return;
            }
            for (int i = nowY + 1; i <= nowY + dist; i++) {
                if (park[i][nowX].equals("X")) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                nowY += dist;
            }
        }
        // West
        else if (dir.equals("W")) {
            if (nowX - dist < 0) {
                return;
            }
            for (int i = nowX - 1; i >= nowX - dist; i--) {
                if (park[nowY][i].equals("X")) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                nowX -= dist;
            }
        }
        // North
        else if (dir.equals("N")) {
            if (nowY - dist < 0) {
                return;
            }
            for (int i = nowY - 1; i >= nowY - dist; i--) {
                if (park[i][nowX].equals("X")) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                nowY -= dist;
            }
        }
    }
    
    public int[] solution(String[] parkArray, String[] routes) {
        park = new String[parkArray.length][];
        for (int i = 0; i < parkArray.length; i++) {
            park[i] = parkArray[i].split("");
        }
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("S")) {
                    nowY = i;
                    nowX = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            String[] splitRoute = route.split(" ");
            String direction = splitRoute[0];
            int distance = Integer.parseInt(splitRoute[1]);
            move(direction, distance);
        }
        
        return new int[]{nowY, nowX};
    }
}

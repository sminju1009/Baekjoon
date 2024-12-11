class Solution {
    public int[] solution(String[] wallpaper) {
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) { 
                if (wallpaper[i].charAt(j) == '#') { 
                    maxY = Math.max(maxY, i);
                    maxX = Math.max(maxX, j);
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                }
            }
        }
        
        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }
}

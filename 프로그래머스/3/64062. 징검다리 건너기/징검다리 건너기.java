class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 200000001;
        
        while (start<=end) {
            int mid = (start+end)/2;
            if (canAcrossRiver(stones, k, mid)) {
                start = mid+1;
                answer = Math.max(answer, mid);
            } else {
                end = mid-1;
            }
            
        }
        return answer;
    }
    
    public boolean canAcrossRiver(int[] stones, int k, int friends) {
        int skip = 0;
        for (int stone: stones) {
            if (stone<friends) {
                skip++;
            } else {
                skip = 0;
            }
            
            if (skip>=k) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public long solution(int n, int[] times) {
        long maxTime = 0;
        for (int i: times) {
            maxTime = Math.max(maxTime, (long) i);
        }
        long start = 1;
        long end = (long) maxTime * n;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long level = 0;

            for (int i = 0; i < times.length; i++) {
                level += mid / times[i];
                if (level >= n) break;
            }

            if (level >= n) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return result;
    }
}
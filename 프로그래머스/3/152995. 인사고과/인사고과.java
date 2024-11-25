import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // 완호의 점수
        int wanhoSum = scores[0][0] + scores[0][1];
        int wanhoFirst = scores[0][0];
        int wanhoSecond = scores[0][1];

        // 점수를 첫 번째 점수 기준 내림차순, 두 번째 점수 기준 오름차순으로 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // 첫 번째 점수 내림차순
            return a[1] - b[1]; // 두 번째 점수 오름차순
        });

        int maxSecond = 0; // 두 번째 점수의 최댓값 추적
        int rank = 1; // 완호의 석차
        boolean isWanhoValid = true;

        for (int[] score : scores) {
            int currentSum = score[0] + score[1];

            // 현재 직원이 다른 직원에게 지배당하는지 확인
            if (score[1] < maxSecond) {
                // 완호가 지배당하는 경우 바로 탈락
                if (score[0] == wanhoFirst && score[1] == wanhoSecond) {
                    isWanhoValid = false;
                    break;
                }
                continue; // 유효하지 않은 직원은 건너뜀
            }

            // 두 번째 점수의 최댓값 갱신
            maxSecond = Math.max(maxSecond, score[1]);

            // 완호보다 점수 합계가 높은 경우 석차 증가
            if (currentSum > wanhoSum) {
                rank++;
            }
        }

        return isWanhoValid ? rank : -1;
    }
}
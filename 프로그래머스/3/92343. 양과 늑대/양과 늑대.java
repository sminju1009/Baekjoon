import java.util.*;

class Solution {
    static int sheepCount = 0;
    static int[] globalInfo;
    static ArrayList<ArrayList<Integer>> graph;
    
    public int solution(int[] info, int[][] edges) {
        globalInfo = info;
        
        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        // 시작 노드(0)를 포함한 방문 가능 리스트로 시작
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        
        dfs(0, 0, 0, nextNodes);
        
        return sheepCount;
    }
    
    public void dfs(int current, int sheep, int wolf, List<Integer> nextNodes) {
        // 현재 노드의 양/늑대 계산
        if (globalInfo[current] == 0) sheep++;
        else wolf++;
        
        // 늑대가 양보다 많으면 더 진행할 수 없음
        if (wolf >= sheep) return;
        
        // 양의 최대 수 갱신
        sheepCount = Math.max(sheepCount, sheep);
        
        // 다음에 방문할 수 있는 노드들 계산
        List<Integer> newNextNodes = new ArrayList<>(nextNodes);
        newNextNodes.remove(Integer.valueOf(current));  // 현재 노드 제거
        newNextNodes.addAll(graph.get(current));       // 현재 노드의 자식들 추가
        
        // 방문 가능한 모든 노드에 대해 재귀 호출
        for (int next : newNextNodes) {
            dfs(next, sheep, wolf, newNextNodes);
        }
    }
}
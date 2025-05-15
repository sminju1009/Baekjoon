import java.util.*;

class Solution {
    static class Pair{
        String word;
        int level;
        
        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int answer = bfs(begin, target, words);
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, 0));
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.word;
            int level = curr.level;
            
            if (word.equals(target)) {
                return level;
            }
            
            for (int i = 0; i<words.length; i++) {
                if (!visited[i]) {
                    int dist = 0;
                    
                    for (int j = 0; j<word.length(); j++) {
                        if (words[i].charAt(j) != word.charAt(j)) dist++;
                    }
                    if (dist==1){
                        visited[i] = true;
                        q.add(new Pair(words[i], level+1));
                    }
                }
            }
        }
        return 0;
    }
}
import java.util.*;

class Solution {
    
    static String[] arr;
    static boolean[] visited;
    static HashSet<String> ban = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {        
        arr = new String[banned_id.length];
        visited = new boolean[user_id.length];
        
        permutation(0, user_id, banned_id);
        return ban.size();
    }
    
    public void permutation(int cnt, String[] user_id, String[] banned_id) {
        if (cnt == banned_id.length) {
            ArrayList<String> a = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                a.add(arr[i]);
            }
            Collections.sort(a);
            String str = "";
            for (String s : a) str += s;
            
            ban.add(str);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {  // <= 여기 수정 (<= → <)
            if (visited[i] || !isChecked(user_id[i], banned_id[cnt])) continue;
            visited[i] = true;
            arr[cnt] = user_id[i];
            permutation(cnt + 1, user_id, banned_id);
            visited[i] = false;
        }
    }
    
    public boolean isChecked(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}

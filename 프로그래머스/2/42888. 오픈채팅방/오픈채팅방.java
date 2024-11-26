import java.util.*;

class Solution {
    public ArrayList solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        
        HashMap<String, String> account = new HashMap<>(); // uid, 이름 순

        for (int i = 0; i<record.length; i++) {
            String[] temp = record[i].split(" ");
            String command = temp[0];
            String id = temp[1];
            if (command.equals("Enter")|| command.equals("Change")) {
                String name = temp[2];
                account.put(id, name);
            }
        }
        
        for (int i = 0; i<record.length; i++) {
            String[] temp = record[i].split(" ");
            String command = temp[0];
            String id = temp[1];
            if (command.equals("Enter")) {
                String name = account.get(id);
                answer.add(name + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                String name = account.get(id);
                answer.add(name + "님이 나갔습니다.");
            }
        }
        
        
        return answer;
    }
}
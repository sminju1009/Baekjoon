class Solution {
    
    static int videoLen;
    static int posTime;
    static int opStart;
    static int opEnd;
    static int nowTime = 0;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        // 1. 시간을 정수 형태로 변환하기
        videoLen = getTime(video_len);
        posTime = getTime(pos);
        opStart = getTime(op_start);
        opEnd = getTime(op_end);

        // 2. 시작 위치 설정(오프닝 끝나는 위치보다 시작 위치가 빠르면 오프닝으로 이동)
        nowTime = (ifOpening(posTime)) ? opEnd : posTime;
        
        // 3. 명령 실행하기
        for (String command: commands) {
            nowTime = move(nowTime, command);
            if (ifOpening(nowTime)) {
                nowTime = opEnd;
            }
        }
        
        int m = nowTime/60;
        int s = nowTime%60;
        
        String min = "";
        if (0<=m && m<10) {
            min = "0" + String.valueOf(m);
        } else {
            min = String.valueOf(m);
        }
        
        String sec = "";
        if (0<=s && s<10) {
            sec = "0" + String.valueOf(s);
        } else {
            sec = String.valueOf(s);
        }
        
        answer = min + ":" + sec;
        return answer;
    }
    
    // (1) 제시된 시간을 정수 형태로 변환하는 메서드
    public int getTime(String time) { 
        String[] now = time.split(":");
        int min = Integer.parseInt(now[0]);
        int sec = Integer.parseInt(now[1]);
        return min*60+sec;
    }
    
    // (2) 오프닝 구간 안에 있는지 판단하는 메서드
    public boolean ifOpening(int time) {
        if (opStart<=time && opEnd>=time) { // 오프닝 구간 안에 있다면 true 반환
            return true;
        }
        return false; // 아니라면 false 반환
    }
    
    // (3) 재생바 이동하는 메서드
    public int move(int time, String command) {
        if (command.equals("next")) {
            if (time+10>videoLen) {
                return videoLen;
            }
            return time+10;
        } else {
            if (time-10<0) {
                return 0;
            }
            return time-10;
        }
    }
    
}
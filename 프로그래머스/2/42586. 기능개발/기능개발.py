def solution(progresses, speeds):
    answer = []
    days = []  # 작업에 필요한 일수를 집어 넣는 배열
    n = len(progresses)
    
    # 1. 작업에 필요한 일수 구하기
    for i in range(n):
        if (100 - progresses[i]) % speeds[i] == 0:
            day = (100 - progresses[i]) // speeds[i]
        else:
            day = (100 - progresses[i]) // speeds[i] + 1
        days.append(day)
    
    # 2. 언제 배포 가능한지 구하기
    max_day = days[0]
    cnt = 1
    
    for i in range(1, n):
        if days[i] <= max_day:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
            max_day = days[i]
    
    answer.append(cnt)  # 마지막 남은 작업들에 대한 배포 추가
    
    return answer

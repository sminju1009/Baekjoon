def solution(plans):
    answer = [] # 완료된 과제를 넣을 배열
    # 1. int형으로 바꿔 받아야 하는 자료들 변환 진행
    n = len(plans)
    for i in range(n):
        a, b = plans[i][1].split(":")
        a, b = int(a), int(b)
        plans[i][1] = a*60 + b
        plans[i][2] = int(plans[i][2])
    
    # 2. lambda 식 이용해서 sort 진행
    plans.sort(key=lambda x: x[1])
    
    # 3. 순차적으로 과제 진행하기
    remains = []
    for i in range(n - 1):
        current_end_time = plans[i][1] + plans[i][2]
        next_start_time = plans[i + 1][1]
        
        # 새로운 과제를 시작해야 하는데 기존에 진행 중이던 과제가 있는 경우
        if current_end_time > next_start_time:
            remains.append([plans[i][0], current_end_time - next_start_time])
        # 그렇지 않은 경우 기존 과제 완료했으므로 answer에 append하기
        else:
            answer.append(plans[i][0])
        
        # 만약 기존 과제와 새 과제의 텀이 남아있는 경우
        time_gap = next_start_time - current_end_time
        if time_gap > 0:
            # remains 배열에 남아있는 것이 있는 경우
            while remains and time_gap > 0:
                last_task = remains.pop()
                if last_task[1] > time_gap:
                    remains.append([last_task[0], last_task[1] - time_gap])
                    time_gap = 0
                else:
                    time_gap -= last_task[1]
                    answer.append(last_task[0])
    
    # 마지막 과제는 무조건 밀리지 않고 끝나게 되므로 append 진행
    answer.append(plans[-1][0])
    
    # 남아있는 과제 탐색
    # 문제 조건에서 최근에 멈춘 과제를 먼저 시작해야 한다고 했으므로 역순으로 탐색하기
    while remains:
        answer.append(remains.pop()[0])
    
    return answer

from collections import defaultdict

def solution(fees, records):
    end_time = 23*60+59
    d = defaultdict(list)
    answer = []
    
    for i in records:
        arr = i.split()
        car_number, flag = arr[1], arr[2]
        temp = arr[0].split(":")
        time = int(temp[0])*60+int(temp[1])
        d[car_number].append(time)
    
    parking_records = dict(sorted(d.items()))
    
    time = [] # 차량별 주차시간 배열
    for key, value in parking_records.items():
        temp_time = 0
        if len(value)%2==0: # 홀수일 때
            for i in range(0, len(value), 2):
                temp_time += value[i+1]-value[i]
        else:
            value.append(end_time)
            for i in range(0, len(value), 2):
                temp_time += value[i+1]-value[i]
        time.append(temp_time)
        
    # 시간 계산하기
    base_time, base_fee, least_time, least_fee = fees[0], fees[1], fees[2], fees[3]
    for i in time:
        if i<=base_time:
            answer.append(base_fee)
        else:
            temp = base_fee
            now_time = i-base_time
            if now_time%least_time==0:
                temp += (now_time//least_time)*least_fee
            else:
                temp += (now_time//least_time+1)*least_fee
            answer.append(temp)
                
    return answer
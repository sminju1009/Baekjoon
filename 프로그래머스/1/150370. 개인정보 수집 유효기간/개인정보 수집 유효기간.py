from collections import defaultdict

def solution(today, terms, privacies):
    answer = []
    
    # 1. today를 일자로 변환하기(day)
    today_arr = today.split(".")
    day = int(today_arr[0])*12*28 + int(today_arr[1])*28 + int(today_arr[2])
    
    # 2. terms 변환하기(term)
    term = defaultdict(int)
    for i in terms:
        a = i.split(" ")
        term[a[0]] = int(a[1])*28
    
    # 3. privacies 배열에서 유효기간 지났는지 구하기
    for idx, i in enumerate(privacies):
        a = i.split(" ") # 날짜와 약관 분리하기(a)
        # a[1] = terms의 key
        b = a[0].split(".") # 날짜 부분만 추출함 (b)
        start_day = int(b[0])*12*28+int(b[1])*28+int(b[2]) # 날짜를 일자 단위로 변환
        c = term.get(a[1]) # 필요한 규정 호출하기(c)
        if start_day+c<=day:
            answer.append(idx+1)
        
    return answer
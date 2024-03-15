def solution(s):
    strings = s.split()
    
    # 문자 형태로 저장된 숫자를 변환하기
    for i in range(len(strings)):
        strings[i] = int(strings[i])
        
    # 문자열 형태로 저장하기
    answer = str(min(strings)) + ' ' + str(max(strings))
    return answer
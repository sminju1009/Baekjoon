def solution(s):
    num_list = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    str_list = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    answer = ""
    for i in range(len(s)):
        for j in range(i, len(s)+1):
            if s[i] in num_list:
                answer += s[i]
                break
            elif s[i:j] in str_list:
                idx = str_list.index(s[i:j])
                answer += num_list[idx]
                break
            
    return int(answer)
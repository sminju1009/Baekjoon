def solution(lottos, win_nums):
    
    def rank(num):
        if num==6:
            return 1
        elif num==5:
            return 2
        elif num==4:
            return 3
        elif num==3:
            return 4
        elif num==2:
            return 5
        else:
            return 6
        
    min_count = 0
    zero_count = 0
    for i in range(6):
        if lottos[i]==0:
            zero_count += 1
        for j in range(6):
            if lottos[i]==win_nums[j]:
                min_count += 1
                break
                
    max_count = min_count + zero_count
    
    return [rank(max_count), rank(min_count)]
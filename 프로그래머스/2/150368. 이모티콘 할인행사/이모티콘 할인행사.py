def solution(users, emoticons):
    answer = []
    
    # 1. 할인행사 돌아가는 순열 구하는 함수
    def dfs(temp, level):
        discount = [10, 20, 30, 40]
        if level == len(emoticons):
            result.append(temp[:])
            return
        for i in discount:
            temp.append(i)
            dfs(temp, level + 1)
            temp.pop()
    
    result = [] # 순열 넣을 배열
    dfs([], 0) # 1. 할인행사 돌아가는 순열 구하기
    
    # 2. 할인행사 돌아가는 경우 계산하기
    n = len(users)
    for discounts in result:
        cnt = 0 # 이모티콘 플러스 산 사람 수
        total_cost = 0 # 총 이모티콘 판매액
        for user in users:
            user_discount, user_max_cost = user
            user_total = 0
            for emoticon_price, discount in zip(emoticons, discounts):
                if discount >= user_discount:
                    user_total += emoticon_price * (100 - discount) // 100
            
            if user_total >= user_max_cost:
                cnt += 1
            else:
                total_cost += user_total
        
        answer.append([cnt, total_cost])
    
    # 3. 람다식으로 정렬해서 가장 첫번째 원소 구하기
    answer.sort(key=lambda x: (-x[0], -x[1]))
    
    return answer[0]
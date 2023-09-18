import heapq
n = int(input())
card = []

for i in range(n):
    heapq.heappush(card, int(input()))# 입력받자마자 heap push까지 같이

answer = 0
while len(card)>1:      # 카드 한장 남을 때까지 계속 반복
    temp1 = heapq.heappop(card)
    temp2 = heapq.heappop(card)
    answer += (temp1+temp2)
    heapq.heappush(card, temp1+temp2)
    
print(answer)
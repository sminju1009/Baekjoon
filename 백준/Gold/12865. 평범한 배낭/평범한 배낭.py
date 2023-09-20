# 강사님 풀이

n,k=map(int,input().split())
knapsack=[[0 for _ in range(k+1)] for _ in range(n+1)]

item=[[0,0]]
for i in range(1,n+1):  # 아이템 입력
    item.append(list(map(int,input().split())))

for i in range(1,n+1):  # 아이템의 개수 만큼 반복
    for j in range(1,k+1): # 최대 무게까지 반복
        w=item[i][0]
        value=item[i][1]
        if j<w: # 가방에 넣을 수 없다면..
            knapsack[i][j]=knapsack[i-1][j]
        else: # 가방에 넣을 수 있다면..
            knapsack[i][j]=max(knapsack[i-1][j],value+knapsack[i-1][j-w])
                               # 위에값     vs   현재아이템 가치+전 단계에서 구한 남은 무게 가치
print(knapsack[n][k])

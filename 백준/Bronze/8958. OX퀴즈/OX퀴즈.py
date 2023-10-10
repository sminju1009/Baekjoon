
n = int(input())
for _ in range(n):
    arr = list(input())
    score = 0
    sum_score = 0
    for ox in arr:
        if ox=='O':
            score += 1
            sum_score += score
        else:
            score = 0
    print(sum_score)
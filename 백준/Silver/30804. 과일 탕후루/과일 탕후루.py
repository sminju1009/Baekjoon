from collections import defaultdict

n = int(input())
tanghuru = list(map(int, input().split()))
start, end, count = 0, 0, 0
huru_count = defaultdict(int)
answer = 0

while end<n:
    if huru_count[tanghuru[end]]==0:
        count += 1
    huru_count[tanghuru[end]] += 1

    while count>2:
        huru_count[tanghuru[start]]-=1
        if huru_count[tanghuru[start]]==0:
            count -= 1
        start += 1

    answer = max(answer, end-start+1)
    end += 1

print(answer)
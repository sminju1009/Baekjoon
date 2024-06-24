document = input()
word = input()

n = len(document)
m = len(word)

clear = []

cnt = 0
for i in range(n-m+1):
    if document[i:i+m] == word and all(j not in clear for j in range(i, i+m)):
        cnt += 1
        clear.extend(range(i, i+m))

print(cnt)
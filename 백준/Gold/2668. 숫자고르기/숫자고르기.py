# 출처 https://velog.io/@deannn/BOJ-%EB%B0%B1%EC%A4%80-2668%EB%B2%88-%EC%88%AB%EC%9E%90%EA%B3%A0%EB%A5%B4%EA%B8%B0-Python

N = int(input())			# 입력
arr = [0]				# 두번째 줄 숫자 담을 리스트.
for _ in range(N):
    arr.append(int(input()))
answer = set()				# 결과 담을 set

# dfs 정의
def dfs(first, second, num):
    first.add(num)			# 첫번째 줄 집합에 num 추가
    second.add(arr[num])		# 두번째 줄 집합에 arr[num] 추가
    if arr[num] in first:		# arr[num]이 첫번째 줄 집합에 있을 때
        if first == second:		# 첫번째 줄 집합과 두번째 줄 집합이 같다면
            answer.update(first)	# 결과 업데이트
            return True
        return False
    return dfs(first, second, arr[num])	# 아니라면 다음 dfs 실행

# dfs 실행
for i in range(1, N+1):
    if i not in answer:			# i가 결과 집합 안에 없는 경우만 실행 
        dfs(set(), set(), i)

print(len(answer))
print(*sorted(list(answer)), sep='\n')
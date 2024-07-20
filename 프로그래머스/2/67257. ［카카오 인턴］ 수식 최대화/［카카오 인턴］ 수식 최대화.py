def cal(a, b, flag):
    if flag == '+':
        return str(int(a) + int(b))
    elif flag == '-':
        return str(int(a) - int(b))
    elif flag == '*':
        return str(int(a) * int(b))


def solution(expression):
    # 연산 우선순위 배열
    order_cal = [
        ["+", "-", "*"], ["+", "*", "-"],
        ["-", "+", "*"], ["-", "*", "+"],
        ["*", "+", "-"], ["*", "-", "+"]
    ]

    # 계산에 이용할 배열
    calculation = []

    # 배열 순회하기
    cal_list = ["+", "-", "*"]
    number = ""
    for i in expression:
        if i in cal_list:
            calculation.append(number)
            calculation.append(i)
            number = ""
        else:
            number += i
    if number:
        calculation.append(number)

    answer = 0

    # 계산 진행하기
    for order in order_cal:
        temp_calc = calculation[:]
        # 첫 번째 우선순위 연산
        for op in order:
            stack = []
            while temp_calc:
                token = temp_calc.pop(0)
                if token == op:
                    operand1 = stack.pop()
                    operand2 = temp_calc.pop(0)
                    stack.append(cal(operand1, operand2, token))
                else:
                    stack.append(token)
            temp_calc = stack

        result = int(temp_calc[0])
        answer = max(answer, abs(result))

    # 최종 정답
    return answer
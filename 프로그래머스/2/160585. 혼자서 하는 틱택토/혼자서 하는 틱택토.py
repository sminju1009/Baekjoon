def solution(board):
    answer = -1
    victory_o, victory_x = False, False
    
    cnt_o, cnt_x = 0, 0
    
    # 1. o와 x의 갯수 확인
    def o_or_x():
        nonlocal cnt_o, cnt_x
        for i in range(3):
            for j in range(3):
                if board[i][j]=="O":
                    cnt_o += 1
                elif board[i][j]=="X":
                    cnt_x += 1
        # 말의 개수가 규칙에 맞는지 확인
        if cnt_o == cnt_x or cnt_o == cnt_x + 1:
            return True
        else:
            return False
        
    # 2. 게임이 승리하는 경우 1) 가로로 만족하는 경우
    def row(num, param):
        nonlocal victory_o, victory_x
        if all(board[num][i] == param for i in range(3)):
            if param == "O":
                victory_o = True
            else:
                victory_x = True
                
    # 3. 게임이 승리하는 경우 1) 세로로 만족하는 경우
    def col(num, param):
        nonlocal victory_o, victory_x
        if all(board[i][num] == param for i in range(3)):
            if param == "O":
                victory_o = True
            else:
                victory_x = True
            
    # 4. 대각선 (좌상 -> 우하)
    def cross_start_left(param):
        nonlocal victory_o, victory_x
        if all(board[i][i] == param for i in range(3)):
            if param == "O":
                victory_o = True
            else:
                victory_x = True
    
    # 5. 대각선 (우상 -> 좌하)
    def cross_start_right(param):
        nonlocal victory_o, victory_x
        if all(board[i][3-i-1] == param for i in range(3)):
            if param == "O":
                victory_o = True
            else:
                victory_x = True
        
    # 말의 개수가 올바른지 확인
    if o_or_x():
        for i in range(3):
            row(i, "O")
            row(i, "X")
            col(i, "O")
            col(i, "X")
        cross_start_left("O")
        cross_start_left("X")
        cross_start_right("O")
        cross_start_right("X")

        # O와 X가 동시에 이긴 경우
        if victory_o and victory_x:
            answer = 0
        # O가 이겼을 때
        elif victory_o:
            if cnt_o == cnt_x + 1:
                answer = 1
            else:
                answer = 0
        # X가 이겼을 때
        elif victory_x:
            if cnt_o == cnt_x:
                answer = 1
            else:
                answer = 0
        # 승리한 사람이 없는 경우
        else:
            answer = 1
    else:
        answer = 0
    
    return answer
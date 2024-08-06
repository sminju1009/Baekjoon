def solution(n):
    def is_valid(board, row, col):
        for i in range(row):
            if board[i] == col or abs(board[i] - col) == row - i:
                return False
        return True

    def solve_n_queens(board, row, n):
        if row == n:
            return 1
        count = 0
        for col in range(n):
            if is_valid(board, row, col):
                board[row] = col
                count += solve_n_queens(board, row + 1, n)
        return count

    board = [-1] * n
    return solve_n_queens(board, 0, n)

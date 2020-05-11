public class Sudoku {

    private int [][] sudoku;

    public Sudoku() {
        sudoku = new int[][] {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
    }

    public Sudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public boolean checkRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBox(int row, int col, int number) {
        int r = row - row%3;
        int c = col - col%3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (sudoku[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean possible(int row, int col, int number) {
        return !(checkRow(row,number) || checkCol(col, number) || checkBox(row, col, number));
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sudoku[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (possible(row, col, number)) {
                            sudoku[row][col] = number;
                            if (solve()) {
                                return true;
                            } else {
                                sudoku[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void showSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + sudoku[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

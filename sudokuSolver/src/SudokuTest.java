import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    // Tester om "number" er i den række
    @org.junit.jupiter.api.Test
    void checkRow() {
        Sudoku sudoku = new Sudoku();
        assertTrue(sudoku.checkRow(0,5));

        assertFalse(sudoku.checkRow(0,1));
    }

    // Tester om "number" er i den kolonne
    @org.junit.jupiter.api.Test
    void checkCol() {
        Sudoku sudoku = new Sudoku();
        assertTrue(sudoku.checkCol(0,8));

        assertFalse(sudoku.checkCol(0,2));
    }

    // Tester om "number" er i den 3x3 box
    @org.junit.jupiter.api.Test
    void checkBox() {
        Sudoku sudoku = new Sudoku();

        assertTrue(sudoku.checkBox(6, 2,6));

        assertFalse(sudoku.checkBox(6, 2,5));
    }

    // Tester om det er muligt at placere "number" i den række/kolonne
    @org.junit.jupiter.api.Test
    void possible() {
        Sudoku sudoku = new Sudoku();

        assertTrue(sudoku.possible(0, 2, 2));

        assertFalse(sudoku.possible(0, 8, 5));
    }

    // Tester om der er en løsning til sudokuen
    @org.junit.jupiter.api.Test
    void solve() {
        Sudoku sudoku = new Sudoku();

        assertTrue(sudoku.solve());
    }
}
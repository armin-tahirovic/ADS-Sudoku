public class Main {


    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        if (s.solve()) {
            s.showSudoku();
        } else {
            System.out.println("Unsuccessful");
        }
    }
}

package sudokusolver;

public class SudokuSolverV2 {

    public static int[][] lol = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

    public static void main(String umi[]){
        ExtraForGitFun sudoku = new ExtraForGitFun();
        System.out.println("Solve this shit :");
        sudoku.move(lol);
        sudoku.display();
        
        if (sudoku.solve()) {
            System.out.println("Solved");
            sudoku.display();
        }
        else{
            System.out.println("Cannot Solve");
        }
    }
}

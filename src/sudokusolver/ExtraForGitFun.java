package sudokusolver;

public class ExtraForGitFun {
    
    private int[][] board;
    public static final int EMPTY = 0;
    public static final int SIZE = 9;
    //static variable...nonit open constructor
    
    //Sudoku SolverV2
    void move(int[][] lol) {
        this.board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = lol[i][j];
            }
        }
    }
    
    boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }
    
    boolean isInCol(int col, int number) {
        for (int j = 0; j < SIZE; j++) {
            if (board[j][col] == number) {
                return true;
            }
        }
        return false;
    }
    
    boolean isInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean isOK(int row,int col,int number){
        return !isInRow(row,number) && !isInCol(col,number) && !isInBox(row,col,number);
    }
    
    boolean solve(){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOK(row,col,number)) {
                            board[row][col] = number;  
                            
                            if (solve()) {
                                return true;
                            }
                            else{
                                board[row][col] = EMPTY;
                            }
                        }  
                    }          
                    return false; 
                }
            } 
        }
        return true;
    }
    
    void display(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " +board[i][j]);
            }
         System.out.println();   
        }
       System.out.println(); 
    }
       
    
    //<------------------------------------------------------------------------------------------------------------->
    //Sudoku Solver 
    boolean isSafe(int[][] board, int row, int col, int num) {
        // row has the unique (row-clash) 
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        // column has the unique numbers (column-clash) 
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        // corresponding square has 
        // unique number (box-clash) 
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
                r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                    d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe 
        return true;
    }
    
    
    boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    // we still have some remaining missing values in Sudoku 
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // no empty space left 
        if (isEmpty) {
            return true;
        }

        // else for each-row backtrack 
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) { 
                    return true;
                } else {
                    board[row][col] = 0; // replace it 
                }
            }
        }
        return false;
    }
    
    void print(int[][] board, int N) {
        // we got the answer, just print it 
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    } 
}

package org.example;

public class SudokuBoard {
    private SudokuCell[][] board; // Matriz de células do tabuleiro - valor inicial 0 e editável

    // Construtor da classe SudokuBoard
    // Recebe uma matriz de inteiros e preenche o tabuleiro
    public SudokuBoard(int[][] matrix) {
        board = new SudokuCell[9][9];
        fillBoard(matrix);
    }

    // Preenche o tabuleiro com os valores da matriz
    private void fillBoard(int[][] matrix) {
        if (!verifyMatrixSize(matrix)) {
            throw new IllegalArgumentException("Invalid matrix size");
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col] = new SudokuCell();
                if (matrix[row][col] != 0) {
                    board[row][col].setValue(matrix[row][col]);
                    board[row][col].setNotEditable();
                }
            }
        }
    }

    // Verifica se a matriz tem o tamanho correto 9x9
    private boolean verifyMatrixSize(int[][] matrix) {
        if (matrix.length != 9) {
            return false;
        }
        for (int[] row : matrix) {
            if (row.length != 9) {
                return false;
            }
        }
        return true;
    }

    // Retorna a matriz do tabuleiro
    public int[][] getBoard() {
        int[][] matrix = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                matrix[row][col] = board[row][col].getValue();
            }
        }
        return matrix;
    }

    // Retorna o valor de uma célula específica
    public int getCellValue(int row, int col) {
        return board[row][col].getValue();
    }

    // Define um valor na célula do tabuleiro - retorna true em caso de sucesso
    public boolean setCellValue(int row, int col, int value) {
        if (board[row][col].isEditable()) {
            board[row][col].setValue(value);
            return true;
        }
        return false;
    }

    // Verifica se um valor é válido para uma célula específica (na linha, na coluna e no quadrado)
    public boolean isValidMove(int row, int col, int value) {
        // Verifica se o valor já existe na linha
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getValue() == value && i != col) {
                return false;
            }
        }
        // Verifica se o valor já existe na coluna
        for (int i = 0; i < 9; i++) {
            if (board[i][col].getValue() == value && i != row) {
                return false;
            }
        }
        // Verifica se o valor já existe no quadrado
        int subGridStartRow = row - row % 3;
        int subGridStartCol = col - col % 3;
        for (int i = subGridStartRow; i < subGridStartRow + 3; i++) {
            for (int j = subGridStartCol; j < subGridStartCol + 3; j++) {
                if (board[i][j].getValue() == value && (i != row || j != col)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Verifica se o tabuleiro está completamente preenchido
    public boolean isBoardFull() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}

package org.example;

public class SudokuGame {
    private SudokuBoard board; // Tabuleiro de jogo

    // Construtor da classe SudokuGame
    // Recebe uma matriz de inteiros e cria um tabuleiro de jogo
    public SudokuGame(int[][] initialBoard) {
        this.board = new SudokuBoard(initialBoard);
    }

    // Faz uma jogada no tabuleiro atual
    // Só avança se o input for válido, se a célula for editável e se a jogada for válida
    // Retorna true em caso de sucesso
    public boolean makeMove(int row, int col, int value) {
        if (isValidInput(row, col, value) && board.setCellValue(row, col, value) && board.isValidMove(row, col, value)) {
            return true;
        }
        return false;
    }

    // Apaga uma célula do tabuleiro atual - só avança se a célula for editável
    // Retorna true em caso de sucesso
    public boolean eraseCell(int row, int col) {
        if (board.setCellValue(row, col, 0)) {
            return true;
        }
        return false;
    }

    // Verifica se o input é válido
    private boolean isValidInput(int row, int col, int value) {
        return row >= 0 && row < 9 && col >= 0 && col < 9 && value >= 1 && value <= 9;
    }

    // Verifica se o jogo terminou
    public boolean isGameFinished() {
        return board.isBoardFull();
    }

    // Retorna a matriz do tabuleiro
    public int[][] getBoard() {
        return board.getBoard();
    }

    // Retorna o valor de uma célula específica
    public int getCellValue(int row, int col) {
        return board.getCellValue(row, col);
    }
}

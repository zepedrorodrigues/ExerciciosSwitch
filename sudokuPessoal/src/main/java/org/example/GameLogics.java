package org.example;

public class GameLogics {
    private Board board; //guard o Board
    private Player player; //guarda o Player
    public GameLogics(int[][] board) { //construtor
        if (!validBoard(board))
            throw new IllegalArgumentException("Invalid board");
        this.board = new Board(board);
        this.player = new Player();}

    private boolean validBoard(int[][]board){ //verifica se o board é válido
        return (board.length==9&&isSquare(board));}
    private boolean isSquare(int[][]board){ //verifica se o board é quadrado
        for (int[] ints : board) {
            if (ints.length != 9)
                return false;
        }
        return true;}
    private boolean checkWin(){ //verifica se o jogo acabou
        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getValuebyIndex(i,j) == 0)
                    return false;}}
        return true;}

    private void addValue(int line, int column, int value){ //adiciona um valor
        if(checkValidAdd(line, column, value)){ //verifica se o valor é válido
            board.validAdd(line, column, value);}
        else{System.out.println("Invalid move");}} //se não for válido, imprime "Invalid move"
    private boolean checkValidAdd(int line, int column, int value){ //verifica se o valor é válido
        if (board.getMaskbyIndex(line, column) == 1 || board.getValuebyIndex(line, column) != 0)
            return false;
        if (value < 1 || value > 9)
            return false;
        return(checkLine(line, value)&&checkColumn(column, value)&&checkSquare(line,column,value));}
        //verifica se o valor é válido na linha, coluna e quadrado
    private void removeValue(int line, int column){ //remove um valor
        if(checkValidRemove(line, column)){ //verifica se o valor é válido
            board.validRemove(line, column);}
        else{System.out.println("Invalid move");}} //se não for válido, imprime "Invalid move"
    private boolean checkValidRemove(int line, int column){ //verifica se o valor é válido de remover
        return (board.getMaskbyIndex(line, column) == 2);}

    private boolean checkLine(int line, int value){ //verifica se o valor é válido na linha
        for (int i = 0; i < 9; i++) {
            if (board.getValuebyIndex(line, i) == value)
                return false;}
        return true;}

    private boolean checkColumn(int column, int value){ //verifica se o valor é válido na coluna
        for (int i = 0; i < 9; i++) {
            if (board.getValuebyIndex(i, column) == value)
                return false;}
        return true;}

    private boolean checkSquare(int line, int column, int value){ //verifica se o valor é válido no quadrado
        int[] square = getSquare(line, column); //cria um array com os valores do quadrado
        for (int i = 0; i < 9; i++) {
            if (square[i] == value) //verifica se o valor já existe no quadrado
                return false;}
        return true;}
    private int[] getSquare(int line, int column){ //cria um array com os valores do quadrado
        int[] square = new int[9];
        int index = 0;
        int lineSquare = line - (line % 3); //encontra o primeiro valor da linha do quadrado
        int columnSquare = column - (column % 3); //encontra o primeiro valor da coluna do quadrado
        for (int i = lineSquare; i < lineSquare + 3; i++) {
            for (int j = columnSquare; j < columnSquare + 3; j++) {
                square[index] = board.getValuebyIndex(i, j); //adiciona os valores do quadrado ao array
                index++;}}
        return square;}

    public void play(){ //joga o jogo
        while (!checkWin()) { //enquanto o jogo não acabar
            board.printBoard(); //imprime o board
            int[] input = player.playerInput(); //pede input ao jogador
            if(input== null)
                continue;
            if (input[0] == 1) //se o input for 1, adiciona um valor
                addValue(input[1], input[2], input[3]);
            if (input[0] == 2) //se o input for 2, remove um valor
                removeValue(input[1], input[2]);}
        System.out.println("Congratulations, you won!");}
}

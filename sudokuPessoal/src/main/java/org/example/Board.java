package org.example;
public class Board {
    private int[][] board;
    private int[][] matrizMascara;

    /**Construtor*/
    public Board(int[][] board){
        this.board = deepCopy(board);
        this.matrizMascara = createMaskMatrix(board);}
    private int[][] deepCopy(int[][] original) {
        final int[][] result = new int[original.length][original.length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++)
                result[i][j] = original[i][j];}
        return result;}

    /** Cria Matriz Máscara*/
    private int[][] createMaskMatrix(int[][] board) {
        int size = board.length;
        int[][] mask = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0)
                    mask[i][j] = 0; //se o valor for 0, a posição não está fixada
                else
                    mask[i][j] = 1;}} //se o valor for diferente de 0, a posição está fixada
        //se for 1 é sinal de que foi dos valores da matriz de inicialização
        return mask;}

    /**Matriz Máscara para Valor X*/
    public int[][] createMaskMatrixValue(int value){
        int[][] maskValue = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == value) //se o valor for igual ao valor desejado
                    maskValue[i][j] = 1; //na matriz mascara de valor fica 1
                else{
                    maskValue[i][j] = 0;}}}
        return maskValue;}
    public int[][] getMaskMatrix(){ //retorna a matriz máscara
        return matrizMascara;}

    /**Métodos de modificação de Valor na Matriz*/
    public boolean addValue(int line, int column, int value){
        if (checkValidAdd(line, column, value)){
            board[line][column] = value;
            return true;}
        return false;}
    public boolean removeValue(int line, int column){
        if (checkValidRemove(line, column)){
            board[line][column] = 0;
            return true;}
        return false;}

    /**Métodos de Avaliação de Validade de Adição*/
    //Coordenador dos Restantes Métodos
    private boolean checkValidAdd(int line, int column, int value){
        if (getMaskMatrix()[line][column] == 1||getMaskMatrix()[line][column]==2)
            return false; //se a posição estiver fixada, retorna falso
        if (value < 1 || value > 9)
            return false; //se o valor não estiver entre 1 e 9, retorna falso
        return(checkLine(line, value) && checkColumn(column, value) && checkSquare(line,column,value));}

    //verifica se o valor é válido na linha
    private boolean checkLine(int line, int value){
        for (int i = 0; i < 9; i++) {
            if (createMaskMatrixValue(value)[line][i] == value)
                return false;}
        return true;}

    //verifica se o valor é válido na coluna
    private boolean checkColumn(int column, int value){ //verifica se o valor é válido na coluna
        for (int i = 0; i < 9; i++) {
            if (createMaskMatrixValue(value)[i][column] == value) //se o valor estiver na coluna falso
                return false;}
        return true;} //se o valor não estiver na coluna retorna true

    //verifica se o valor é válido no quadrado
    private boolean checkSquare(int line, int column, int value){
        int[][] maskMatrixValue = createMaskMatrixValue(value); //cria um array com a máscara do valor value
        int firstLine = line - (line % 3); //primeira linha do quadrado
        int firstColumn = column - (column % 3); //primeira coluna do quadrado
        for (int i = firstLine; i < firstLine + 3; i++) { //percorre as linhas do quadrado
            for (int j = firstColumn; j < firstColumn + 3; j++) { //percorre as colunas do quadrado
                if (maskMatrixValue[i][j] == value) //se o valor estiver no quadrado
                    return false;}}
        return true;} //se o valor não estiver no quadrado retorna true

    /**Seguintes Método Avalia se a Remoção é Válida*/
    public boolean checkValidRemove(int line, int column){ //verifica se o valor é válido de remover
        return (getMaskMatrix()[line][column] == 2);}

    /**Imprime o Board no Terminal*/
    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println(" -----------------------");}
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");}
                System.out.print(board[i][j] == 0 ? "  " : board[i][j] + " ");}
            System.out.println("|");}
        System.out.println(" -----------------------");}
}




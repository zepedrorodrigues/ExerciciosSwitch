package org.example;

public class Game {

    /** guarda o Board*/
    private Board board;

    /**Construtor*/
    public Game(int[][] board) {
        if (!validBoard(board))
            throw new IllegalArgumentException("Invalid board");
        this.board = new Board(board);}

    /**Os 3 Métodos Seguintes verificam a VALIDADE DA MATRIZ RECEBIDA*/
    //Coordenador dos Restantes Métodos
    private boolean validBoard(int[][]board){
        return (board.length==9&&isSquare(board)&&allValuesOk(board));}
    //verifica se o board é quadrado
    private boolean isSquare(int[][]board){
        for (int[] ints : board) {
            if (ints.length != 9)
                return false;}
        return true;}
    //verifica se os valores do board são válidos
    private boolean allValuesOk(int[][]board){
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt < 0 || anInt > 9)
                    return false;
            }
        }
        return true;}

    /**Métodos conectores do UI com o Board*/
    public void add(int line, int column, int value){
        if(!board.addValue(line,column,value)){System.out.println("Invalid value");}}
    public void remove(int line, int column){
        if(!board.removeValue(line,column)){System.out.println("Invalid value");}}
    /**Verifica se o jogador ganhou o Jogo (tabuleiro Cheio)*/
    public boolean checkWin(){
        int[][] mask = board.getMaskMatrix(); //cria um array com a máscara
        for(int[] line: mask)
            for(int number: line){
                if(number == 0) //se houver algum 0 na máscara (por preencher)
                    return false;}
        return true;} //se não houver nenhum 0 na máscara, retorna true
    public void printBoard(){
        board.printBoard();}
}

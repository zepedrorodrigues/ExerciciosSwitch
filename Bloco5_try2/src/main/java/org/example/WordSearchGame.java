package org.example;
public class WordSearchGame {
    private UserInterface ui;
    private Board board;

    public WordSearchGame(Board board){
        this.board = board;
        this.ui = new UserInterface(board);}

    public void play(){
        while(board.getWords().length > 0){
            ui.printBoard();
            String word = ui.askWord();
            if(board.checkWord(word)){
                ui.foundWord(board.getWord(word));}
            else
                ui.notFoundWord();}}

    private String askWord(){
        return ui.askWord();}
}

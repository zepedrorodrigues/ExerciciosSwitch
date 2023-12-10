package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Word> wordList = new ArrayList<>();
        //adicionar palavras!
        Game game = new Game(wordList);
        while(!game.checkWin()){
            game.printBoard();
            System.out.println("Escreva a palavra que encontrou: ");
            String word = sc.nextLine().strip().toUpperCase();
            Word w = game.checkWord(word);
            if(w==null){
                System.out.println("Palavra não encontrada!");}
            else{
                int[][] positions = getPlayerInput();
                if(game.findWord(word, positions)){
                    System.out.println("Palavra encontrada!");}
                else{
                    System.out.println("Palavara não encontrada!");}}}
        System.out.println("Parabéns! Ganhou o jogo!");}

    private static int[][] getPlayerInput(){
        Scanner sc = new Scanner(System.in);
        int[][] positions = new int[2][2];
        System.out.println("Escreva as coordenadas da primeira letra: ");
        System.out.println("Linha: ");
        positions[0][0] = sc.nextInt() -1;
        System.out.println("Coluna: ");
        positions[0][1] = sc.nextInt() -1;
        System.out.println("Escreva as coordenadas da última letra: ");
        System.out.println("Linha: ");
        positions[1][0] = sc.nextInt() -1;
        System.out.println("Coluna: ");
        positions[1][1] = sc.nextInt() -1;
        return positions;
    }
}
package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class UserInterface {

    public static void UI() {
        int[][] board = new int[][]{
                {1, 3, 4, 5, 6, 7, 8, 2, 9},
                {5, 8, 6, 1, 3, 2, 7, 9, 4},
                {6, 7, 2, 8, 9, 4, 5, 3, 1},
                {0, 7, 0, 0, 6, 0, 0, 0, 8},
                {0, 0, 0, 9, 0, 1, 0, 0, 5},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 1},
                {0, 4, 0, 0, 1, 3, 2, 5, 6}};

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(board);
        while(!game.checkWin()){
            game.printBoard();
            System.out.println("Choose an option:");
            System.out.println("1 - Add value");
            System.out.println("2 - Remove value");
            try{
                int option = scanner.nextInt();
                if(option==1||option==2){
                    chooseLine(game, option);}
                else{
                    System.out.println("Invalid option");
                    scanner.nextInt();}
            }catch (InputMismatchException e) {
                System.out.println("Invalid option");
                scanner.nextInt();}}
        System.out.println("Congratulations! You won!");}

    public static void chooseLine(Game game, int option){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the line");
        try{
            int line = scanner.nextInt();
            if(line < 1 || line > 9)
                System.out.println("Invalid line");
            else
                chooseColumn(game, option, line-1);
        }catch (InputMismatchException e) {
            System.out.println("Invalid line");}}

    public static void chooseColumn(Game game, int option, int line){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the column");
        try{
            int column = scanner.nextInt();
            if(column < 1 || column > 9)
                System.out.println("Invalid column");
            else{
                if(option==1){
                    chooseValue(game, line, column-1);}
                else{
                    game.remove(line, column-1);}}
        }catch (InputMismatchException e) {
            System.out.println("Invalid column");}}

    private static void chooseValue(Game game, int line, int column){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value");
        try{
            int value = scanner.nextInt();
            if(value < 1 || value > 9)
                System.out.println("Invalid value");
            else
                game.add(line, column, value);
        }catch (InputMismatchException e) {
            System.out.println("Invalid value");}
    }

}
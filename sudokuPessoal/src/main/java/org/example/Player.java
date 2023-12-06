package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    public Player(){
        //construtor vazio porque cria um novo objeto pessoa
        //sem carateristicas e que não guarda nada, só faz métodos
        }
    public int[] playerInput(){

        System.out.println("What do you want to do?");
        System.out.println("1 - Add a value");
        System.out.println("2 - Remove a value");
        try {
            int option = scanner.nextInt();
            if(option == 1 || option == 2)
                return getLine(option);
            System.out.println("Invalid option");}
        catch (InputMismatchException e) {
            System.out.println("Invalid option");}
        return new int[0];}

    private int[] getLine(int option){
        System.out.println("Enter the line");
        try {
            int line = scanner.nextInt();
            if(line < 1 || line > 9)
                System.out.println("Invalid line");
            else
                return getColumn(option, line-1);
        } catch (InputMismatchException e) {
            System.out.println("Invalid line");}
        return new int[0];}

    private int[] getColumn(int option, int line){
        System.out.println("Enter the column");
        try {
            int column = scanner.nextInt();
            if(column < 1 || column > 9)
                System.out.println("Invalid column");
            else
                return getvalue(option, line, column-1);
        } catch (InputMismatchException e) {
            System.out.println("Invalid column");}
        return new int[0];}

    private int[] getvalue(int option, int line, int column){
        System.out.println("Enter the value");
        try {
            int value = scanner.nextInt();
            if(value < 1 || value > 9)
                System.out.println("Invalid value");
            else
                return new int[]{option, line, column, value};
        } catch (InputMismatchException e) {
            System.out.println("Invalid value");}
        return new int[0];
    }

}

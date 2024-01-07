package org.example;

public class SudokuCell {
    private int value;
    private boolean isEditable;

    // Construtor da classe SudokuCell
    // Inicialmente cada célula é criada com valor 0 e editável
    public SudokuCell() {
        this.value = 0;
        this.isEditable = true;
    }

    // Define que a célula não é editável
    public void setNotEditable() {
        this.isEditable = false;
    }

    // Verifica se a célula é editável
    public boolean isEditable() {
        return this.isEditable;
    }

    // Retorna o valor da célula
    public int getValue() {
        return value;
    }

    // Define um novo valor para a célula
    public void setValue(int value) {
        this.value = value;
    }

    // Verifica se a célula está vazia
    public boolean isEmpty() {
        return value == 0;
    }
}

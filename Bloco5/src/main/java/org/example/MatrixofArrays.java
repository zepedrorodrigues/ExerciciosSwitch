package org.example;

import java.util.Arrays;

public class MatrixofArrays {
    private Array[] matrix;
    private static final String outofBounds = "Out of bounds";
    private static final String emptyMatrix = "Empty matrix";

    public MatrixofArrays(){
        this.matrix = new Array[0];}
    public MatrixofArrays(int[][]matrix){
        this.matrix = copyofArray(matrix);}

    private Array[] copyofArray(int[][]matrix){
        Array[] copy = new Array[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            copy[i] = new Array(matrix[i]);}
        return copy;}

    public void add(int value, int line) throws ArrayIndexOutOfBoundsException, IllegalArgumentException{
        if(matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        if (line < 0 || line >= matrix.length)
            throw new ArrayIndexOutOfBoundsException(outofBounds);
    }
}

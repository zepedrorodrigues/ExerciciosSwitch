package org.example;

public class MatrixofArrays {
    private Array[] matrix;
    private static final String outofBounds = "Out of bounds";
    private static final String emptyMatrix = "Empty matrix";
    private static final String notFound = "Value not found";
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
        matrix[line].add(value);}
    public void removeFirstValue(int value)throws IllegalArgumentException{
        if(matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        for (Array array : matrix) {
            for (int j = 0; j < array.getSize(); j++) {
                if (array.returnElement(j) == value) {
                    array.removeFirstValue(value);
                    return;}}}
        throw new IllegalArgumentException(notFound);}
    public double average() throws ArrayIndexOutOfBoundsException, IllegalArgumentException{
        if(matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        double sum = 0;
        int count = 0;
        for (Array array : matrix) {
            for (int j = 0; j < array.getSize(); j++) {
                sum += array.returnElement(j);
                count++;}}
        return sum / count;}
    public Array sumLines() throws IllegalArgumentException{
        if(matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        int[] sum = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j = 0; j < matrix[i].getSize(); j++){
                sum[i] += matrix[i].returnElement(j);}}
        return new Array(sum);}
    public Array sumColumns() throws IllegalArgumentException{
        if(matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        int max = matrix[0].getSize();
        for(Array array : matrix)
            max = Math.max(max, array.getSize());
        int[] sum = new int[max];
        for (Array array : matrix) {
            for (int j = 0; j < array.getSize(); j++) {
                sum[j] += array.returnElement(j);}}
        return new Array(sum);}
}

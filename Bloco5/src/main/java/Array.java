import java.util.Arrays;
import java.util.Collections;

public class Array {
    private int[] array1;
    private int size;
    private static final String error = "Invalid Argument";
    public Array() {
        array1 = new int[0];}

    public Array(int[] array) throws InstantiationException {
        if (!validConstructorArgument(array))
            throw new InstantiationException(error);
        this.size = array.length;
        this.array1 = array;}

    private boolean validConstructorArgument(int[] array1) {
        return array1 != null;}

    public int[] addElement(int x) {
        array1 = Arrays.copyOf(array1, array1.length + 1);
        array1[array1.length - 1] = x;
        return array1;}

    public int[] removeElement(int x) {
        if (detectElementwithValue(x) == -1)
            return array1;
        int[] newArray = new int[array1.length - 1];
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == x)
                continue;
            newArray[i] = array1[i];
        }
        array1 = newArray;
        return array1;}

    private int detectElementwithValue(int x) {
        int contador = 0;
        for (int value : array1) {
            if (value == x)
                return contador;
            contador++;}
        return -1;}

    public int getMenorElemento() throws InstantiationException {
        if (array1.length == 0)
            throw new InstantiationException(error);
        int menor = array1[0];
        for (int value : array1)
            menor = Math.min(value, menor);
        return menor;}

    public int getMaiorElemento() throws InstantiationException {
        if (array1.length == 0)
            throw (new InstantiationException(error));
        int maior = array1[0];
        for (int value : array1)
            maior = Math.max(value, maior);
        return maior;}

    public int getSize() {
        return size;}

    public int getElementbyIndex(int index) {
        if (index < 0 || index >= array1.length)
            return -1;
        return array1[index];}

    public int counterMultiplesofNumber(int mult, boolean yesorNo) throws InstantiationException{
        if(mult == 0)
            throw new InstantiationException(error);
        int counter = 0;
        if(yesorNo)
            for (int value : array1) {
                if (value % mult == 0)
                    counter++;}
        if(!yesorNo)
            for (int value : array1) {
                if (value % mult != 0)
                    counter++;}
        return counter;}

    public int averageArray(int[] array) throws InstantiationException{
        if(array.length == 0)
            throw new InstantiationException(error);
        return sumOfArray(array) / array.length;}
    public int sumOfArray(int[] array) {
        int sum = 0;
        for (int value : array)
            sum += value;
        return sum;}

    public int[] getmultiplesofNumber(int mult, boolean multiOrNot) throws InstantiationException {
        if (mult == 0)
            throw new InstantiationException(error);
        int[] multiplesArray = new int[counterMultiplesofNumber(mult,true)];
        int counter = 0;
        if(multiOrNot){
            for (int value : array1) {
                if (value % mult == 0) {
                    multiplesArray[counter] = value;
                    counter++;}}}
        else{
            multiplesArray = new int[counterMultiplesofNumber(mult, false)];
            for (int value : array1) {
                if (value % mult != 0) {
                    multiplesArray[counter] = value;
                    counter++;}}}
        return multiplesArray;}

    public int[] getSortedArray(boolean ascending){
        if(ascending){
            Arrays.sort(array1);
            return array1;}
        Integer[] array2 = new Integer[array1.length];
        for(int i = 0; i < array1.length; i++)
            array2[i] = array1[i];
        Arrays.sort(array2, Collections.reverseOrder());
        for(int i = 0; i < array1.length; i++)
            array1[i] = array2[i];
        return array1;}
    public boolean hasXElements(int x)throws InstantiationException{
        if(x<0)
            throw new InstantiationException(error);
        return size == x;}
    public boolean isAllEvensorOdds(boolean evens) throws InstantiationException{
        if(array1.length == 0)
            throw new InstantiationException(error);
        if(!evens)
            return (getmultiplesofNumber(2,false).length==array1.length);
        return (getmultiplesofNumber(2,true).length==array1.length);}
    public boolean valoresRepetidos(){
        if(array1.length == 0)
            return false;
        for(int i = 0; i < array1.length; i++){
            for(int j = i + 1; j < array1.length; j++){
                if(array1[i] == array1[j])
                    return true;}}
        return false;}
    public int howManyDigits(int testNumber){
        if(testNumber == 0)
            return 1;
        int contador=0;
        while(testNumber != 0){
            testNumber /= 10;
            contador++;}
        return contador;}
    public int[] arrayofNumberstoArrayofDigits(){
        int[] array2 = new int[array1.length];
        for(int i = 0; i < array1.length; i++){
            array2[i] = howManyDigits(array1[i]);}
        return array2;}
    public double averageDigits()throws InstantiationException{
        if (array1.length == 0)
            throw new InstantiationException(error);
        int[] arrayofDigits = arrayofNumberstoArrayofDigits();
        return (double)sumOfArray(arrayofDigits) / arrayofDigits.length;}
    public int counterElementsMoreDigitsThanAverage()throws InstantiationException{
        if(array1.length == 0)
            throw new InstantiationException(error);
        int counter = 0;
        double averageDigit = averageDigits();
        for(int value: array1){
            if(howManyDigits(value) > averageDigit)
                counter++;}
        return counter;}

    public int[] getElementsWithMoreDigitsThanAverage() throws InstantiationException{
        if(array1.length == 0)
            throw new InstantiationException(error);
        double averageDigits = averageDigits();
        int[] array2 = new int[counterElementsMoreDigitsThanAverage()];
        int counter = 0;
        for(int value: array1){
            if(howManyDigits(value) > averageDigits){
                array2[counter] = value;
                counter++;}}
        return array2;}
    public double percentageofEvenAlgarisms(int numberTest){
        int counter = 0;
        int numberofDigits = howManyDigits(numberTest);
        while(numberTest != 0){
            if(numberTest % 2 == 0)
                counter++;
            numberTest /= 10;}
        return counter * 100 / (double)numberofDigits;}

    public double averagePercentageofEvenAlgarisms(){
        double sum = 0;
        for(int value: array1){
            sum += percentageofEvenAlgarisms(value);}
        return sum / array1.length;}
    public int counterElementsMoreEvenAlgarismsThanTheAverage()throws InstantiationException{
        if(array1.length == 0)
            throw new InstantiationException(error);
        int counter = 0;
        for(int value: array1){
            if(percentageofEvenAlgarisms(value) > averagePercentageofEvenAlgarisms())
                counter++;}
        return counter;}

    public int[] getElementsMoreEvenAlgarismsThanAverage() throws InstantiationException{
        if(array1.length == 0)
            throw new InstantiationException(error);
        int[] array2 = new int[counterElementsMoreEvenAlgarismsThanTheAverage()];
        int counter = 0;
        for(int value: array1){
            if(percentageofEvenAlgarisms(value) > averagePercentageofEvenAlgarisms()){
                array2[counter] = value;
                counter++;}}
        return array2;}

    }

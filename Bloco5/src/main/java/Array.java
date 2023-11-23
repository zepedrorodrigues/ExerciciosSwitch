import java.util.Arrays;
import java.util.Collections;

public class Array {
    private int[] array1;
    private int size;
    private static final String error = "Invalid Argument";
    private static final String arrayVazio = "Array Vazio";

    public Array() {
        array1 = new int[0];
    }

    public Array(int[] array) throws InstantiationException {
        if (!validConstructorArgument(array))
            throw new InstantiationException(error);
        this.size = array.length;
        this.array1 = array;
    }

    private boolean validConstructorArgument(int[] array1) {
        return array1 != null;
    }

    public void addElement(int element) {
        array1 = Arrays.copyOf(array1, array1.length + 1);
        array1[array1.length - 1] = element;
    }

    public void removeElement(int x) throws IllegalArgumentException {
        if (detectElementwithValue(x) == -1)
            throw new IllegalArgumentException(error);
        int[] newArray = new int[array1.length - 1];
        int contador = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == x)
                continue;
            newArray[contador] = array1[i];
            contador++;
        }
        array1 = newArray;}

    private int detectElementwithValue(int x) {
        int contador = 0;
        for (int value : array1) {
            if (value == x)
                return contador;
            contador++;}
        return -1;}

    public int getMenorElemento() throws IllegalArgumentException {
        if (array1.length == 0)
            throw new IllegalArgumentException(arrayVazio);
        int menor = array1[0];
        for (int value : array1)
            menor = Math.min(value, menor);
        return menor;
    }

    public int getMaiorElemento() throws IllegalArgumentException {
        if (array1.length == 0)
            throw (new IllegalArgumentException(arrayVazio));
        int maior = array1[0];
        for (int value : array1)
            maior = Math.max(value, maior);
        return maior;
    }

    public int getSize() {
        return size;
    }

    public int getElementbyIndex(int index) {
        if (index < 0 || index >= array1.length)
            return -1;
        return array1[index];
    }

    private int counterMultiplesofNumber(int mult, boolean yesorNo) {
        int counter = 0;
        if (yesorNo)
            for (int value : array1) {
                if (value % mult == 0)
                    counter++;
            }
        if (!yesorNo)
            for (int value : array1) {
                if (value % mult != 0)
                    counter++;
            }
        return counter;
    }

    public int averageArray(int[] array) throws IllegalArgumentException {
        if (array.length == 0)
            throw new IllegalArgumentException(arrayVazio);
        return sumOfArray(array) / array.length;
    }

    public int sumOfArray(int[] array) {
        int sum = 0;
        for (int value : array)
            sum += value;
        return sum;
    }

    public int[] getmultiplesofNumber(int mult, boolean multiOrNot) throws InstantiationException {
        if (mult == 0)
            throw new InstantiationException(error);
        int[] multiplesArray = new int[counterMultiplesofNumber(mult, true)];
        int counter = 0;
        if (multiOrNot) {
            for (int value : array1) {
                if (value % mult == 0) {
                    multiplesArray[counter] = value;
                    counter++;}}}
        else {
            multiplesArray = new int[counterMultiplesofNumber(mult, false)];
            for (int value : array1) {
                if (value % mult != 0) {
                    multiplesArray[counter] = value;
                    counter++;}}}
        return multiplesArray;
    }

    public int[] getSortedArray(boolean ascending) {
        int[] sortedArray = Arrays.copyOf(array1, array1.length);
        Arrays.sort(sortedArray);
        if (!ascending) {
            for (int i = 0; i < sortedArray.length / 2; i++) {
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[sortedArray.length - 1 - i];
                sortedArray[sortedArray.length - 1 - i] = temp;
            }
        }
        return sortedArray;}


}

import java.util.Arrays;

public class Array {

    private int[] array1;
    private int size;
    private static final String error = "Invalid Argument";

    public Array(){
        array1 = new int[0];}
    public Array(int[] array)throws InstantiationException {
        if(!validConstructorArgument(array))
            throw new InstantiationException(error);
        this.size= array.length;
    }
    private boolean validConstructorArgument(int[] array1)
        {return array1 != null;}
    public int[] addElement(int x){
        array1 = Arrays.copyOf(array1, array1.length + 1);
        array1[array1.length-1] = x;
        return array1;}
    public int[] removeElement(int x){
        if(detectElementwithValue(x)==-1)
            return array1;
        int[] newArray = new int[array1.length-1];
        for(int i=0; i<array1.length; i++){
            if(array1[i] == x)
                continue;
            newArray[i] = array1[i];}
        array1 = newArray;
        return array1;}
    private int detectElementwithValue(int x){
        int contador = 0;
        for(int value: array1){
            if(value == x)
                return contador;
            contador++;}
        return -1;}
    public int getMenorElemento()throws InstantiationException{
        if(array1.length == 0)
            throw new InstantiationException(error);
        int menor = array1[0];
        for(int value: array1)
            menor=Math.min(value, menor);
        return menor;}
    public int getMaiorElemento()throws InstantiationException{
        if(array1.length == 0)
            throw(new InstantiationException(error));
        int maior = array1[0];
        for(int value: array1)
            maior=Math.max(value, maior);
        return maior;}
    public int getSize(){
        return size;}
    public int getElementbyIndex(int index){
        if(index < 0 || index >= array1.length)
            return -1;
        return array1[index];}


}

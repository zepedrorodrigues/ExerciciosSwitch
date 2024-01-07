package org.example;

public class Ex11 {
    public static String[] estenderArraycomStrings(String[]array) {
        String[] novo_array = new String[array.length+1];
        for(int i=0; i<array.length;i++) {
            novo_array[i] = array[i];
        }
        return novo_array;
    }
    public static String[] devolveArraycomNotas (int[] notas) {
        String [] notasQualitativas = new String[0];
        int ind = 0;
        for(int value:notas) {
            if(value<0||value>20)
                return notasQualitativas;
            else{
                switch(value) {
                    case 0: case 1: case 2: case 3: case 4:
                        notasQualitativas = estenderArraycomStrings(notasQualitativas);
                        String n = String.format("%d. Mau",(ind+1));
                        notasQualitativas[ind++] = n;
                        break;
                    case 5: case 6: case 7: case 8: case 9:
                        notasQualitativas = estenderArraycomStrings(notasQualitativas);
                        n = String.format("%d. Medíocre",(ind+1));
                        notasQualitativas[ind++] = n;
                        break;
                    case 10: case 11: case 12: case 13:
                        notasQualitativas = estenderArraycomStrings(notasQualitativas);
                        n = String.format("%d. Suficiente",(ind+1));
                        notasQualitativas[ind++] = n;
                        break;
                    case 14: case 15: case 16: case 17:
                        notasQualitativas = estenderArraycomStrings(notasQualitativas);
                        n = String.format("%d. Bom",(ind+1));
                        notasQualitativas[ind++] = n;
                        break;
                    default:
                        notasQualitativas = estenderArraycomStrings(notasQualitativas);
                        n = String.format("%d. Muito Bom",(ind+1));
                        notasQualitativas[ind++] = n;
                        break;}}}
        return notasQualitativas;
    }
}

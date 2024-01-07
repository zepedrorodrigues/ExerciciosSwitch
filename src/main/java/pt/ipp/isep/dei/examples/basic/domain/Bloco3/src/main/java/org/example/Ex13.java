package org.example;

public class Ex13 {
    public static int verificarRacaoAdequada(double pesoAnimal) {
        if (pesoAnimal <= 0)
            return -1;
        if (pesoAnimal <= 10)
            return 100;
        if (pesoAnimal <= 25)
            return 250;
        if (pesoAnimal <= 45)
            return 300;
        return 500;
    }

    // alinea a
    public static int compararRacao(double pesoAnimal, double pesoRacao) {
        int racaoAdequada = verificarRacaoAdequada(pesoAnimal);
        if (racaoAdequada == -1)
            return 2;
        if (pesoRacao > racaoAdequada)
            return 1;
        if (pesoRacao == racaoAdequada)
            return 0;
        return -1;
    }

    // alinea b
    public static int[] compararRacaoDadosVariaveis(double[] pesoAnimal, double[] pesoRacao) {
        int[] arrayConjuntoCaes = new int[0];
        for (int i = 0; i < pesoAnimal.length; i++) {
            if (pesoAnimal[i] <= 0)
                return arrayConjuntoCaes;
            arrayConjuntoCaes = Ex2.estenderArray1lugar(arrayConjuntoCaes);
            arrayConjuntoCaes[i] = compararRacao(pesoAnimal[i], pesoRacao[i]);
        }
        return arrayConjuntoCaes;
    }
}

package org.example;

public class Ex2 {
    public static int[] multiplosOuNaodeXnumIntervalo(int x, int y, int multi, boolean opcao) {
        int[] multiplos = new int[0];
        if (multi == 0)
            return arrayInvalido();
        int[] ordenados = maiorde2Numeros(x, y);
        int n = 0;
        if (opcao == true)
            return loopEstenderArraycomOutroArrayMultiploOuNao(ordenados, multiplos, n, multi, opcao);
        return loopEstenderArraycomOutroArrayMultiploOuNao(ordenados, multiplos, n, multi, opcao);
    }

    public static int[] loopEstenderArraycomOutroArrayMultiploOuNao(int[] arrayminmax, int[] arrayfinal, int index, int mult, boolean opcao) {
        if (mult == 0) {
            return arrayInvalido();
        }
        if (opcao == true) {
            for (int i = arrayminmax[0]; i <= arrayminmax[1]; i++) {
                if (i % mult == 0) {
                    arrayfinal = estenderArray1lugar(arrayfinal);
                    arrayfinal[index] = i;
                    index += 1;
                }
            }
        }
        if (opcao == false) {
            for (int i = arrayminmax[0]; i <= arrayminmax[1]; i++) {
                if (i % mult != 0) {
                    arrayfinal = estenderArray1lugar(arrayfinal);
                    arrayfinal[index] = i;
                    index += 1;
                }
            }
        }
        return arrayfinal;
    }

    public static int[] estenderArray1lugar(int[] array) {
        int[] new_array = new int[array.length + 1];
        for (int y = 0; y < array.length; y++)
            new_array[y] = array[y];
        return new_array;
    }

    public static int[] arrayInvalido() {
        int[] invalido = new int[1];
        invalido[0] = -1;
        return invalido;
    }

    public static int somadeNumerosdeumArray(int[] array) {
        if (array.length == 0)
            return 0;
        int x = 0;
        for (int i = 0; i < array.length; i++)
            x += array[i];
        return x;
    }

    public static int[] valoresComuns2Arrays(int[] array1, int[] array2) {
        int[] multiplos_de_ambos = new int[0];
        int index = 0;
        for (int v : array1) {
            for (int i = 0; i < array2.length; i++)
                if (array2[i] == v) {
                    multiplos_de_ambos = estenderArray1lugar(multiplos_de_ambos);
                    multiplos_de_ambos[index] = v;
                    index += 1;
                }
        }
        return multiplos_de_ambos;
    }

    public static int[] multiplosde2NumerosNumIntervalo(int min, int max, int x, int y) {
        if (x == 0 || y == 0)
            return arrayInvalido();
        int[] multiplosX = multiplosOuNaodeXnumIntervalo(min, max, x, true), multiplosY = multiplosOuNaodeXnumIntervalo(min, max, y, true);
        return valoresComuns2Arrays(multiplosX, multiplosY);
    }

    public static int[] maiorde2Numeros(int x, int y) {
        int[] maior = {x, y};
        if (x > y) {
            maior[0] = y;
            maior[1] = x;
        }
        return maior;
    }

    public static int numeroMultiplosdeXeY(int min, int max, int x, int y) {
        int[] novoarray = multiplosde2NumerosNumIntervalo(min, max, x, y);
        if (novoarray.length == 1 && novoarray[0] == -1)
            return 0;
        return novoarray.length;
    }

    public static int numeroMultiplosdeX(int min, int max, int x, boolean opcao) {
        int[] novoArray = multiplosOuNaodeXnumIntervalo(min, max, x, opcao);
        if (novoArray.length == 1 && novoArray[0] == -1)
            return -1;
        return novoArray.length;
    }

    public static int somaNumerosMultiplosdeXeYnumintervalo(int min, int max, int x, int y) {
        int[] multiplos = multiplosde2NumerosNumIntervalo(min, max, x, y);
        if (multiplos.length == 1 && multiplos[0] == -1)
            return 0;
        return somadeNumerosdeumArray(multiplos);
    }
}
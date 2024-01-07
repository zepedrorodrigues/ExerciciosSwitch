package org.example;

public class Ex14 {
    public static int produtoEscalarEntre2Vetores(int[] vetor1, int[] vetor2) {
        if (vetor1.length != vetor2.length) {
            return Integer.MIN_VALUE;}
        int produtoEscalar = 0;
        for (int i = 0; i < vetor1.length; i++) {
            produtoEscalar += vetor1[i] * vetor2[i];}
        return produtoEscalar;}
}
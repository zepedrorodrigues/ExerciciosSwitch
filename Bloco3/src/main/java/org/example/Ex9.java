package org.example;

public class Ex9 {
    public static String descricaoDeProdutos(int codigo) {
        if (codigo == 1)
            return "Alimento não perecível";
        if (codigo > 1 && codigo <= 4)
            return "Alimento perecível";
        if (codigo > 4 && codigo <= 6)
            return "Vestuário";
        if (codigo == 7)
            return "Higiene Pessoal";
        if (codigo > 7 && codigo <= 15)
            return "Limpeza e Utensílios Domésticos";
        return "Código Inválido";
    }
}

public class Ex2 {
    public static int menorDistancia(int[][]matrizDistancias,String[]nomesCidades, String nomeCidadeA, String nomeCidadeB){
        if(nomeCidadeA.equals(nomeCidadeB))
            return 0;
        int contador = 0;
        for(String nomeCidade:nomesCidades){
            if(nomeCidade.equals(nomeCidadeA) || nomeCidade.equals(nomeCidadeB))
                contador++;}
        if(contador != 2)
            return -1;
        int cidadeA=0;
        int cidadeB=0;
        for(int i=0;i<nomesCidades.length;i++){
            if(nomesCidades[i].equals(nomeCidadeA))
                cidadeA=i;
            if(nomesCidades[i].equals(nomeCidadeB))
                cidadeB=i;}
        return matrizDistancias[cidadeA][cidadeB];}

    public static int menorDistanciaAlgumasDistanciasNaoExistem(int[][]matrizDistancias,String[]nomesCidades, String nomeCidadeA, String nomeCidadeB){
        int menorDistancia = menorDistancia(matrizDistancias,nomesCidades,nomeCidadeA,nomeCidadeB);
        if(menorDistancia==-1)return -1;
        int cidadeA = lookforCidadeX(nomesCidades,nomeCidadeA);
        int cidadeB = lookforCidadeX(nomesCidades,nomeCidadeB);
        if(cidadeB==cidadeA)return 0;
        if(matrizDistancias[cidadeA][cidadeB]==0 && matrizDistancias[cidadeB][cidadeA]==0){
            int distanciaMin = Integer.MAX_VALUE;
            for(int i=0;i<matrizDistancias.length;i++){
                if(i==cidadeA||i==cidadeB)
                    continue;
                distanciaMin = Math.min(distanciaMin,matrizDistancias[cidadeA][i]+matrizDistancias[i][cidadeB]);}
            for(int i=0;i<matrizDistancias.length;i++){
                if(i==cidadeA||i==cidadeB)
                    continue;
                distanciaMin = Math.min(distanciaMin,matrizDistancias[cidadeB][i]+matrizDistancias[i][cidadeA]);}
            return distanciaMin;}
        if(matrizDistancias[cidadeA][cidadeB]==0)
            return matrizDistancias[cidadeB][cidadeA];
        return matrizDistancias[cidadeA][cidadeB];}

    private static int lookforCidadeX(String[] list, String name){
        for(int i =0;i<list.length;i++){
            if(list[i]==name)
                return i;}
        return -1;}
}

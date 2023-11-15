package org.example;
public class Bloco1 {
    public static double processamento(int rosas, int tulipas, double precoRosa, double precoTulipa){
    // preço de ramo de rosas + tulipas conforme combo de tulipas e rosas, tendo em conta o preço de ambos
        if(rosas<0||tulipas<0||precoRosa<0||precoTulipa<0)
            return -1.00;
        return rosas * precoRosa + tulipas * precoTulipa;}
    public static double litros(double altura_metros, double raio){// volume de água que cabe num cilindro com altura e raio pré-definidos
        if (altura_metros<=0||raio<=0)
            return -1.00;
        return (altura_metros*Math.PI*Math.pow(raio,2)*1000);}
    public static double distancerelampago(double tempo_segundos){// calcular a distância do raio ao local onde é ouvido a partir do tempo que demora o som a chegar
        if(tempo_segundos<0)
            return -1.00;
        return tempo_segundos*(340);}
    public static double altura(double tempo) {
        //calcular altura de prédio a partir do tempo de queda de um objeto por equação do movimento retilíneo uniformemente acelerado
        if(tempo<0)
            return -1.00;
        return 0*tempo+((9.8*Math.pow(tempo,2.00))/(2));}
    public static double altura_Tales(double altura_pessoa_metros, double sombra_pessoa_metros, double sombra_predio_metros){//calcular altura de prédio a partir da sombra do prédio comparativamente à de um objeto menor
        if(altura_pessoa_metros<=0||sombra_pessoa_metros<=0||sombra_predio_metros<=0)
            return -1.00;
        else{
        return sombra_predio_metros*altura_pessoa_metros/sombra_pessoa_metros;
    }}
    public static double distancia_Ze (double tempo_Ze_horas, double tempo_Ze_minutos,double tempo_Ze_Segundos, double distancia_Manel_metros, double tempo_MAnel_horas, double tempo_Manel_minutos, double tempo_Manel_Segundos){ //distancia que o Ze percorreu a correr a mesma velocidade do Manel.
        if(tempo_Ze_horas<0||tempo_Ze_minutos<0||tempo_Ze_Segundos<0)
            return -1.00;
        else{
            if(tempo_MAnel_horas<0||tempo_Manel_minutos<0||tempo_Manel_Segundos<0||distancia_Manel_metros<0)
                return -1.00;
        else
        {
            double tempo_Ze = tempo_Ze_Segundos+(tempo_Ze_minutos*60)+(tempo_Ze_horas*3600);
            double tempo_Manel = tempo_Manel_Segundos+(tempo_MAnel_horas*3600)+(tempo_Manel_minutos*60);
            double velocidade_Manel = distancia_Manel_metros/tempo_Manel;
            return velocidade_Manel*tempo_Ze;
        }}}
    public static double distancia_eletricistas(double angulo, double distancia_a, double distancia_b){//distancia eletricistas tendo em conta o comproimento dos fios e o angulo dos fios com o poste
        if (distancia_a<0||distancia_b<0||angulo<0)
            return -1.00;
        return Math.sqrt((Math.pow(distancia_a,2)+(Math.pow(distancia_b,2))-(2*distancia_a*distancia_b*Math.cos(angulo* (Math.PI)/180))));}
    public static double perimetro(double A, double B){//calculo do perimetro de um retangulo
        if(A<0||B<0)
            return -1;
        return 2*A+2*B;}
    public static double hipotenusa (double cateto_a, double cateto_b){//a caminho de siracusa disse pitágoras aos seus netos
        if (cateto_a<=0||cateto_b<=0)
            return -1;
        else{
        return Math.sqrt(Math.pow(cateto_a,2)+Math.pow(cateto_b,2));
    }}
    public static double equacao2ograu(double x){// equaçao segundo grau do enunciado ((x^2)-3x + 1)
        if (!Double.isNaN(x)){
            return -1;}
        return Math.pow(x,2)-3*x+1;}
    public static double temperatura_Farenheit(double temperatura_Celsius) {//conversor para Farenheit de temperatura em Celsius
        if(temperatura_Celsius<-273.15)
            return -1;
        return (temperatura_Celsius*1.8) + 32;
    }
    public static int minutosPassados(int H, int M){ //minutos passados
        if(H<0||M<0)
            return -1;
        else{
        return H*60+M;
    }}
    public static long fatorial(int x){//Calcular valor fatorial de X
        if (x==0)
            return 1;
        else{
            if (x<0||x>20)
                return -1;
            else{
            return x*fatorial(x-1);
        }
    }}
    public static long findLargestFactorial(long x, long x_fatorial) {//Encontrar valor mais alto cujo fatorial cabe em Long
        while(x_fatorial*(x+1)>0){
            x_fatorial=x_fatorial*(x+1);
            x=x+1;
        }
        return x;
}}

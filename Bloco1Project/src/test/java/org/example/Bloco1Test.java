package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Bloco1Test {
    @Test
    public void processamentoFlores(){   //Arrange
        double rosasSucesso = 5, tulipasSucesso = 6, precoRosasSucesso = 5, precoTulipasSucesso=10, resultadoSucesso=85;
        double rosasFronteira = 0, tulipasFronteira = 1, precoRosasFronteira = 10, precoTulipasFronteira = 5, resultadoFronteira = 5;
        double rosasInsucesso = -1, tulipasInsucesso = 0, precoRosasInsucesso = 10, precoTulipasInsucesso = 7, resultadoInsucesso = -1.00;
        //Act
        double expectedSucesso = Bloco1.processamento(5,6,5,10);
        double expectedFronteira = Bloco1.processamento(0,1,10,5);
        double expectedInsucesso = Bloco1.processamento(-1,0,10,7);
        //Assert
        assertEquals(expectedSucesso,resultadoSucesso,0.01);
        assertEquals(expectedFronteira,resultadoFronteira,0.01);
        assertEquals(expectedInsucesso,resultadoInsucesso,0.01);
    }
    @Test
    public void litrosSucesso(){
    //Arrange
        double altura_metrosSucesso = 1;
        double raioSucesso=4;
        double resultadoSucesso = 50265.48245743669;
    //Act
        double expectedSucesso = Bloco1.litros(altura_metrosSucesso,raioSucesso);
    //Assert
    assertEquals(expectedSucesso, resultadoSucesso, 0.01);}
    @Test
    public void litrosFronteira(){   //Arrange
        double altura_metrosFronteira = 0.00000000001;
        double raioFronteira = 10;
        double expectedFronteira = 3.141592653589793E-6;
        //Act
        double resultFronteira = Bloco1.litros(altura_metrosFronteira,raioFronteira);
        //Assert
        assertEquals(expectedFronteira,resultFronteira,0.01);
    }
    @Test
    public void litrosInsucesso(){   //Arrange
        double altura_metrosInsucesso = 0;
        double raioInsucesso = 1;
        double expectedInsucesso = -1.00;
        //Act
        double resultInsucesso = Bloco1.litros(altura_metrosInsucesso,raioInsucesso);
        //Assert
        assertEquals(expectedInsucesso, resultInsucesso, 0.01);
    }
    @Test
    public void distanciarelampagoSucesso() {
        //Arrange
        double tempo_sucesso = 14.7;
        double expectedSucesso = 4998;
        //Act
        double resultSucesso = Bloco1.distancerelampago(14.7);
        //Assert
        assertEquals(expectedSucesso, resultSucesso, 0.01);}
    @Test
    public void distanciarelampagoFronteira(){
        //Arrange
        double tempo_segundos = 0;
        double expectedFronteira = 0;
        //Act
        double resultFronteira = Bloco1.distancerelampago(tempo_segundos);
        //Assert
        assertEquals(expectedFronteira, resultFronteira, 0.01);}
    @Test
    public void distanciarelampagoInsucesso(){
        //Arrange
        double tempo_segundos = -1;
        double expectedInsucesso = -1.00;
        //Act
        double resultInsucesso = Bloco1.distancerelampago(tempo_segundos);
        //Assert
        assertEquals(expectedInsucesso, resultInsucesso, 0.01);}
    @Test
    public void alturaprediomovimentoretilineoSucesso() {
        //Arrange
        double tempo = 1;
        double expectedSucesso = 9.8*Math.pow(1,2)/(2);
        //Act
        double resultSucesso = Bloco1.altura(tempo);
        //Assert
        assertEquals(expectedSucesso, resultSucesso, 0.01);
    }
    @Test
    public void alturaprediomovimentoretilineoFronteira(){
        //Arrange
        double tempo = 0;
        double expectedFronteira = 0;
        //Act
        double resultFronteira = Bloco1.altura(0);
        //Assert
        assertEquals(expectedFronteira,resultFronteira,0.01);}
    @Test
    public void alturaprediomovimentoretilineoInsucesso(){
        //Arrange
        double tempo =-2;
        double expectedInsucesso = -1;
        //Act
        double resultInsuceso =Bloco1.altura(-2);
        //Assert
        assertEquals(expectedInsucesso, resultInsuceso, 0.01);}
    @Test
    public void altura_Tales_predioSucesso() {
        //Arrange
        double altura_pessoa_metros = 2, sombra_pessoa_metros =4, sombra_predio_metros = 40;
        double expectedSucesso = 20;
        //Act
        double resultSucesso = Bloco1.altura_Tales(altura_pessoa_metros,sombra_pessoa_metros,sombra_predio_metros);
        //Assert
        assertEquals(expectedSucesso, resultSucesso, 0.01);
    }
    @Test
    public void alturaTalesPredioFronteira(){
        //Arrange
        double altura_pessoa_metros = 0.01, sombra_pessoa_metros = 4, sombra_predio_metros = 400;
        double expectedFronteira =1;
        //Act
        double resultFronteira = Bloco1.altura_Tales(altura_pessoa_metros,sombra_pessoa_metros,sombra_predio_metros);
        //Assert
        assertEquals(expectedFronteira,resultFronteira);}
    @Test
    public void alturaTalesPredioInsucesso(){
        //Arrange
        double altura_pessoa_metros = 0, sombra_pessoa_metros = 5, sombra_predio_metros = 10;
        double expectedInsucesso = -1;
        //Act
        double resultInsucesso = Bloco1.altura_Tales(altura_pessoa_metros,sombra_pessoa_metros,sombra_predio_metros);
        assertEquals(expectedInsucesso,resultInsucesso);}
    @Test
    public void distancia_Ze_TestSucesso() {
        //Arrange
        double tempo_Ze_horas = 1, tempo_Ze_minutos = 5, tempo_Ze_segundos = 0;
        double tempo_Manelhoras = 4, tempo_manel_minutos= 2, tempo_manel_segundos = 10;
        double distancia_Manel_metros = 42195;
        double expectedSucesso = 11325.5677907777;
        //Act
        double resultSucesso = Bloco1.distancia_Ze(tempo_Ze_horas,tempo_Ze_minutos,tempo_Ze_segundos,distancia_Manel_metros,tempo_Manelhoras,tempo_manel_minutos,tempo_manel_segundos);
        assertEquals(expectedSucesso, resultSucesso, 0.01);
    }
    @Test
    public void distanciaZeTestFronteira(){
        double tempo_Ze_horas = 0, tempo_Ze_minutos = 0, tempo_Ze_segundos = 1, distancia_Manel = 4000, tempo_Manel_Horas = 1, tempo_Manel_minutos =1, tempo_Manel_segundos =1;
        double expectedFronteira = 1.092597650915051;
        //Act
        double resultFronteira = Bloco1.distancia_Ze(tempo_Ze_horas,tempo_Ze_minutos,tempo_Ze_segundos,distancia_Manel,tempo_Manel_Horas,tempo_Manel_minutos,tempo_Manel_segundos);
        assertEquals(expectedFronteira,resultFronteira,0.01);}
    @Test
    public void distanciaZeTestInsucesso(){
        //Arrange
        double tempo_Ze_horas = -1, tempo_Ze_minutos = 60, tempo_Ze_segundos = 3;
        double tempo_Manel_horas = 4, tempo_Manel_minutos = 4, tempo_Manel_segundos = 7;
        double distancia_Manel = 7000;
        double expected_distancia_Ze = -1.00;
        //Act
        double result_distancia_Ze = -1.00;
        //Assert
        assertEquals(expected_distancia_Ze,result_distancia_Ze,0.01);
    }
    @Test
    public void distancia_eletricistas_Sucesso() {
        //Arrange
        double angulo = 60, distancia_a = 40, distancia_b = 60;
        double expected = 52.91;
        //Act
        double result = Bloco1.distancia_eletricistas(angulo,distancia_a,distancia_b);
        //Assert
        assertEquals(expected, result, 0.01);
    }
    @Test
    public void distancia_eletricistas_Fronteira(){
        //Arrange
        double angulo = 30, distancia_a = 0, distancia_b = 30;
        double expected = Math.sqrt((Math.pow(0,2)+(Math.pow(30,2))-(2*0*30*Math.cos(30*(Math.PI)/180))));
        //Act
        double result = Bloco1.distancia_eletricistas(angulo,distancia_a,distancia_b);
        //Assert
        assertEquals(result,expected,0.01);
    }
    @Test
    public void distancia_eletricistas_Insucesso(){
        //Arrange
        double angulo = -1, distancia_a = 4, distancia_b = 12;
        double expected = -1;
        //Act
        double result = Bloco1.distancia_eletricistas(angulo,distancia_a,distancia_b);
        //Assert
        assertEquals(expected,result,0.01);
    }
    @Test
    public void perimetro_Test_Sucesso() {
        //Arrange
        double lado_a = 2, lado_b =3;
        double expected = 10.00;
        //Act
        double result = Bloco1.perimetro(lado_a,lado_b);
        //Assert
        assertEquals(expected, result, 0.01);
    }
    @Test
    public void perimetro_Test_Fronteira()
    {   //Arrange
        double lado_a = 0, lado_b = 5;
        double expected =10;
        //Act
        double result = Bloco1.perimetro(lado_a,lado_b);
        //Assert
        assertEquals(result,expected,0.01);

    }
    @Test
    public void perimetro_Test_Insucesso(){
        //Arrange
        double lado_a = -1, lado_b = 3;
        double expected = -1;
        //Act
        double result = Bloco1.perimetro(lado_a,lado_b);
        //Assert
        assertEquals(expected,result,0.01);
    }
    @Test
    public void hipotenusa_Test_Sucesso() {
        //Arrange
        double cateto_a = 2, cateto_b = 3;
        double expected = Math.sqrt(13);
        //Act
        double result = Bloco1.hipotenusa(cateto_a,cateto_b);
        assertEquals(expected, result, 0.01);
    }
    @Test
    public void hipotenusa_Test_Fronteira(){
        //Arrange
        double cateto_a = 0.1, cateto_b = 0.5;
        double expected = Math.sqrt(0.26);
        //Act
        double result = Bloco1.hipotenusa(cateto_a,cateto_b);
        //Assert
        assertEquals(expected,result,0.01);
    }
    @Test
    public void hipotenusa_Test_Insucesso(){
        //Arrange
        double cateto_a = 0, cateto_b = 3, expected=-1;
        //Act
        double result = Bloco1.hipotenusa(cateto_a,cateto_b);
        //Assert
        assertEquals(result,expected,0.01);
    }
    @Test
    public void equacao_Test_Sucesso() {
        //Arrange
        int x = 3;
        double expected = Math.pow(3, 2) - 3 * 3 + 1;
        //Act
        double result = Bloco1.equacao2ograu(x);
        assertEquals(expected, result, 0.01);
    }
    @Test
    public void equacao_Test_Fronteiro(){
        //Arrange
        double x= 0, expected = 1;
        //Act
        double result = Bloco1.equacao2ograu(x);
        //Assert
        assertEquals(expected,result,0.01);
    }
    @Test
    public void temperatura_Farenheit_test_Sucesso() {
        //Arrange
        double x = 25;
        double expected = 77.0;
        //Act
        double result = Bloco1.temperatura_Farenheit(x);
        assertEquals(expected, result, 0.01);
    }
    @Test
    public void temperatura_Farenheit_test_Fronteira(){
        //Arrange
        double x=0, expected = 32;
        //Act
        double result = Bloco1.temperatura_Farenheit(x);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    public void temperatura_Farenheit_test_Insucesso(){
        //Arrange
        double x =-274.15, expected = -1;
        //Act
        double result = Bloco1.temperatura_Farenheit(x);
        //assert
        assertEquals(result,expected,0.01);
    }
    @Test
    public void minutos_passados_test_sucesso() {
        //Arrange
        int h = 1, m =1;
        int expected = 61;
        //Act
        int result = Bloco1.MinutosPassados(h,m);
        //Assert
        assertEquals(expected, result);
    }
    @Test
    public void minutos_passados_test_fronteira(){
        //Arrange
        int h=0, m=0, expected = 0;
        //Act
        int result = Bloco1.MinutosPassados(h,m);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    public void minutos_passados_test_insucesso(){
        //Arrange
        int h=-1, m=6, expected = -1;
        //Act
        int result = Bloco1.MinutosPassados(h,m);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    public void fatorialSucesso(){
        //Arrange
        int x = 6;
        long expected =720;
        //Act
        long result = Bloco1.fatorial(x);
        //Assert
        assertEquals(expected,result,0.01);
    }
    @Test
    public void fatorialFronteira(){
        //Arrange
        int x=20;
        long expected=20*Bloco1.fatorial(19);
        //Act
        long result = Bloco1.fatorial(x);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    public void fatorialInsucesso(){
        //Arrange
        int x=-1;
        long expected = -1;
        //Act
        long result = Bloco1.fatorial(x);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    public void fatorial_maximo(){
        //Arrange
        long expected = 20;
        //Act
        long result = Bloco1.findLargestFactorial(1,1);
        //Assert
        assertEquals(expected,result,0.01);
    }

}
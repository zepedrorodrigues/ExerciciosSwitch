import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex2Test {

    @Test
    void menorDistanciaPortoLisboa() {
        //Arrange
        int[][]distancias = {{0,300},{300,0}};
        String[] cidades = {"Porto","Lisboa"};
        //Act
        int distanciaReal = Ex2.menorDistancia(distancias,cidades,"Porto","Lisboa");
        int distanciaEsperada = 300;
        //Assert
        assertEquals(distanciaReal,distanciaEsperada);}

    @Test
    void menorDistanciaPortoBragaBragaNaoExiste(){
        //Arrange
        int[][]distancias = {{0,300},{300,0}};
        String[] cidades = {"Porto","Lisboa"};
        //Act
        int distanciaEsperada =-1;
        int distanciaReal = Ex2.menorDistancia(distancias,cidades,"Porto","Braga");
        //Assert
        assertEquals(distanciaReal,distanciaEsperada);}

    @Test
    void menorDistanciaPossivelDistanciaPortoBragaNaoExiste(){
        //Arrange
        int[][]matrizDistancias = {{0,300,0},{300,0,350},{0,350,0}};
        String[] cidades = {"Porto","Lisboa","Braga"};
        //Act
        //Assert
        assertEquals(650,Ex2.menorDistanciaAlgumasDistanciasNaoExistem(matrizDistancias,cidades,"Porto","Braga"));}
    @Test
    void menorDistanciaPossivelDistanciaPortoBragaExisteMasSoPortoBraga(){
        //Arrange
        int[][]matrizDistancias = {{0,300,50},{300,0,350},{0,350,0}};
        String[] cidades = {"Porto", "Lisboa","Braga"};
        //Act
        int exp = 50;
        int result = Ex2.menorDistanciaAlgumasDistanciasNaoExistem(matrizDistancias,cidades,"Porto","Braga");
        //Assert
        assertEquals(exp,result);}

    @Test
    void menorDistanciaPossivelDistanciaPortoParisParisNaoExiste(){
        //Arrange
        int[][]matrizDistancias = {{0,300},{300,0}};
        String[]cidades = {"Porto","Lisboa"};
        //Act
        int exp = -1;
        int result = Ex2.menorDistanciaAlgumasDistanciasNaoExistem(matrizDistancias,cidades,"Porto","Paris");
        //Assert
        assertEquals(exp,result);}

    @Test
    void menorDistanciaPossivelDistanciaPortoPorto(){
        //Arrange
        int[][]matrizDistancias={{0,300},{300,0}};
        String[]cidades = {"Porto","Lisboa"};
        //Act
        int exp =0;
        int result= Ex2.menorDistanciaAlgumasDistanciasNaoExistem(matrizDistancias,cidades,"Porto","Porto");
        //Assert
        assertEquals(exp,result);}

}
package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Bloco2Test {
    @Test
    void main_sucesso() {
        //Arrange
        int nota1 = 9, nota2 = 11, nota3 = 10, peso1 = 1, peso2 = 1, peso3 = 1;
        double expected = 10;
        //Act
        double result = Bloco2.main(nota1, nota2, nota3, peso1, peso2, peso3);
        //Assert
        assertEquals(expected, result, 0.01);
    }
    @Test
    void main_insucesso() {
        //Arrange
        int nota1 = -2, nota2 = 8, nota3 = 15, peso1 = 3, peso2 = 5, peso3 = 4;
        double expected = -1;
        //Act
        double result = Bloco2.main(nota1, nota2, nota3, peso1, peso2, peso3);
        //Assert
        assertEquals(expected, result, 0.01);
    }
    @Test
    void main_fronteira() {
        //Arrange
        int nota1 = 0, nota2 = 0, nota3 = 10, peso1 = 1, peso2 = 0, peso3 = 9;
        double expected = 9;
        //Act
        double result = Bloco2.main(nota1, nota2, nota3, peso1, peso2, peso3);
        //Assert
        assertEquals(expected, result, 0.01);
    }
    @Test
    void passa_Test_Sucesso() {
        //Arrange
        int nota1 = 20, nota2 = 20, nota3 = 20, peso1 = 33, peso2 = 33, peso3 = 33;
        boolean expected = true;
        //Act
        boolean result = Bloco2.passa(nota1, nota2, nota3, peso1, peso2, peso3);
        //Assert
        assertEquals(expected, result);
    }
    @Test
    void passa_Test_Insucesso() {
        int nota1 = 1, nota2 = 1, nota3 = 1, peso1 = 1, peso2 = 1, peso3 = 1;
        boolean expected = false;
        boolean result = Bloco2.passa(nota1, nota2, nota3, peso1, peso2, peso3);
        assertEquals(expected, result);
    }
    @Test
    void passa_Test_Fronteira() {
        int nota1 = 8, nota2 = 8, nota3 = 8, peso1 = 1, peso2 = 1, peso3 = 1;
        boolean expected = true, result = Bloco2.passa(nota1, nota2, nota3, peso1, peso2, peso3);
        assertEquals(expected, result);
    }
    @Test
    void digitos_sucesso() {
        //Arrange
        int numero = 789;
        String expected = "7 8 9. O número é ímpar.";
        //Act
        String result = Bloco2.digitos(numero);
        //Assert
        assertEquals(expected, result);
    }
    @Test
    void digitos_sucesso_par() {
        int numero = 788;
        String expected = "7 8 8. O número é par.";
        String result = Bloco2.digitos(numero);
        assertEquals(expected, result);
    }
    @Test
    void digitos_fronteira() {
        //Arrange
        int numero = 999;
        String expected = "9 9 9. O número é ímpar.";
        //Act
        String result = Bloco2.digitos(numero);
        //Assert
        assertEquals(expected, result);
    }
    @Test
    void digitos_insucesso() {
        //Arrange
        int numero = 10;
        String expected = "Inválido";
        //Act
        String result = Bloco2.digitos(numero);
        //Assert
        assertEquals(expected, result);
    }
    @Test
    void distancia_pontos_sucesso() {
        //Arrange
        float x1 = 1, x2 = 2, y1 = 1, y2 = 2;
        double expected = Math.sqrt(2);
        //Act
        double result = Bloco2.distancia_pontos(x1, x2, y1, y2);
        //Assert
        assertEquals(expected, result, 0.01);
    }
    @Test
    void distancia_pontos_fronteira() {
        //Arrange
        float x1 = 0, y1 = 0, x2 = 0.1f, y2 = 0.1f;
        double expected = Math.sqrt(0.02);
        //Act
        double result = Bloco2.distancia_pontos(x1, x2, y1, y2);
        //Assert
        assertEquals(expected, result, 0.01);
    }
    @Test
    void equacao_segundo_grau_teste_xMenorqueZero() {
        double x = -10;
        double expected = -10, result = Bloco2.equacao_segundo_grau_ex4(x);
        assertEquals(expected, result, 0.01);

    }
    @Test
    void equacao_segundo_grau_teste_xMaiorqueZero() {
        float x = 2;
        double expected = 0, result = Bloco2.equacao_segundo_grau_ex4(x);
        assertEquals(expected, result);
    }
    @Test
    void equacao_segundo_grau_teste_xIgualaZero() {
        float x = 0;
        double expected = 0, result = Bloco2.equacao_segundo_grau_ex4(x);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void volume_cubo_Grande() {
        double area = 9000;
        String expected = "Volume do cubo = 58094.75. Cubo Grande";
        String result = Bloco2.volume_cubo(area);
        assertEquals(expected, result);
    }
    @Test
    void volume_cubo_Médio() {
        double área = 639.36134206;
        String expected = "Volume do cubo = 1100.00. Cubo Médio";
        String result = Bloco2.volume_cubo_calculos(área);
        assertEquals(expected, result);
    }
    @Test
    void volume_cubo_Pequeno() {
        double área = 559.301851072;
        String expected = "Volume do cubo = 900.00. Cubo Pequeno";
        String result = Bloco2.volume_cubo(área);
        assertEquals(expected, result);
    }
    @Test
    void volume_cubo_área_negativa() {
        double área = -2;
        String expected = "Valor de área incorrecto.", result = Bloco2.volume_cubo(área);
        assertEquals(expected, result);
    }
    @Test
    void relógio_greeting_noite5h59m59s() {
        int segundos = 21599;
        String expected = "Boa noite. São 5 horas, 59 minutos e 59 segundos.", result = Bloco2.greeting(segundos);
        assertEquals(expected, result);
    }
    @Test
    void relógio_greeting_manhã6h0m1s() {
        int segundos = 21601;
        String expected = "Bom dia. São 6 horas, 0 minutos e 1 segundos.", result = Bloco2.greeting(segundos);
        assertEquals(expected, result);
    }
    @Test
    void relógio_greeting_manhã12h0m0s() {
        int segundos = 43200;
        String expected = "Bom dia. São 12 horas, 0 minutos e 0 segundos.", result = Bloco2.greeting(segundos);
        assertEquals(expected, result);
    }
    @Test
    void relógio_greeting_tarde_12h0m1s() {
        int segundos = 43201;
        String expected = "Boa tarde. São 12 horas, 0 minutos e 1 segundos.", result = Bloco2.greeting(segundos);
        assertEquals(expected, result);
    }
    @Test
    void relógio_greeting_tarde20h0m0s() {
        int segundos = 72000;
        String expected = "Boa tarde. São 20 horas, 0 minutos e 0 segundos.", result = Bloco2.greeting(segundos);
        assertEquals(expected, result);
    }
    @Test
    void relógio_greeting_noite_20h0m1s() {
        int segundos = 72001;
        String expected = "Boa noite. São 20 horas, 0 minutos e 1 segundos.", result = Bloco2.greeting(segundos);
        assertEquals(expected, result);
    }
    @Test
    void relógio_greeting_tempo_negativo() {
        int segundos = -10;
        String expected = "Tempo inválido", result = Bloco2.greeting(segundos);
        assertEquals(expected, result);
    }
    @Test
    void custos_totais_negativo() {
        double áreaEdifício = -3, custoLitroTinta = 5, RendimentoLitro = 3, saláriodiaPintor = 40;
        String opcao = "Ttl";
        double expected = -1d, result = Bloco2.custos_totais(áreaEdifício, custoLitroTinta, RendimentoLitro, saláriodiaPintor, opcao);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void custos_totais_pintores_custoZero() {
        double áreaEdifício = 100, custoLitroTinta = 5, RendimentoLitro = 3, salárioDiaPintor = 0;
        String opcao = "Ttl";
        double expected = 166.667;
        double result = Bloco2.custos_totais(áreaEdifício, custoLitroTinta, RendimentoLitro, salárioDiaPintor, opcao);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void custos_totais_sómãodeObra() {
        double área = 1, custolitro = 4, rendimento = 5, salário = 6;
        String opcao = "MdO";
        double expected = 6, result = Bloco2.custos_totais(área, custolitro, rendimento, salário, opcao);
        assertEquals(expected, result);
    }
    @Test
    void custos_totais_sóTinta() {
        double área = 200, custoLitro = 3, Rendimento = 4, salário = 35;
        String opcao = "Tinta";
        double expected = 150, result = Bloco2.custos_totais(área, custoLitro, Rendimento, salário, opcao);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void custos_totais_normal() {
        double área = 200, custoLitro = 2, rendimento = 5, salário = 40;
        String opcao = "Ttl";
        double expected = 640, result = Bloco2.custos_totais(área, custoLitro, rendimento, salário, opcao);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void custos_totais_edificio_grande() {
        double área = 301, custoLitroTinta = 5, RendimentoLitro = 3, salárioDiaPintor = 50;
        String opcao = "Ttl";
        double expected = 1551.67, result = (Math.round((Bloco2.custos_totais(área, custoLitroTinta, RendimentoLitro, salárioDiaPintor, opcao)) * 100)) / 100.00;
        assertEquals(expected, result);
    }
    @Test
    void custos_totais_edificio_enorme() {
        double área = 1001, custoLitro = 1, Rendimento = 1, salarioDia = 1;
        String opcao = "Ttl";
        double expected = 64 + 1001, result = Bloco2.custos_totais(área, custoLitro, Rendimento, salarioDia, opcao);
        assertEquals(expected, result);
    }
    @Test
    void custos_totais_budget_inexistente(){
        double área = 1000, custo = 3, rendimento =10, salário =67;
        String opcao = "Wewddfojwef";
        double expected = -1d, result = Bloco2.custos_totais(área,custo,rendimento,salário,opcao);
        assertEquals(expected,result,0.01);
    }
    @Test
    void check_multiplicador_exercício8_inteiro() {
        float x = 10, y = 2;
        String expected = "10.0 é múltiplo de 2.0", result = Bloco2.x_e_y_exercício_8(x, y);
        assertEquals(expected, result);
    }
    @Test
    void check_multiplicador_exercicio8_decimal() {
        float x = 9.2f, y = 2.3f;
        String expected = "9.2 é múltiplo de 2.3", result = Bloco2.x_e_y_exercício_8(x, y);
        assertEquals(expected, result);
    }
    @Test
    void check_multiplicador_exercicio8_yé0() {
        float x = 2.0f, y = 0;
        String expected = "0.0 é múltiplo de 2.0", result = Bloco2.x_e_y_exercício_8(x, y);
        assertEquals(expected, result);
    }
    @Test
    void check_multiplicador_exercicio8_yMAiorqueX() {
        float x = 3, y = 6;
        String expected = "6.0 é múltiplo de 3.0", result = Bloco2.x_e_y_exercício_8(x, y);
        assertEquals(expected, result);
    }
    @Test
    void check_multiplicador_exercicio8_NaoÉMúltiplo() {
        float x = 14, y = 3;
        String expected = "14.0 não é múltiplo nem divisor de 3.0", result = Bloco2.x_e_y_exercício_8(x, y);
        assertEquals(expected, result);
    }
    @Test
    void numero_3_digitos_crescente_exercicio9_norma() {
        int num = 789;
        String expected = "Algarismos crescentes", result = Bloco2.número_3_dígitos_crescente(num);
    }
    @Test
    void numero_3_digitos_crescente_exercicio9_invalido() {
        int num = 99;
        String expected = "Número inválido", result = Bloco2.número_3_dígitos_crescente(num);
        assertEquals(expected, result);
    }
    @Test
    void numero_3_digitos_crescente_exercicio9_100() {
        int num = 100;
        String expected = "Algarismos não crescentes", result = Bloco2.número_3_dígitos_crescente(num);
        assertEquals(expected, result);
    }
    @Test
    void numero_3_digitos_crescentes_exercicio9_191() {
        int num = 191;
        String expected = "Algarismos não crescentes", result = Bloco2.número_3_dígitos_crescente(num);
        assertEquals(expected, result);
    }
    @Test
    void preco_saldos_exercicio10_negativo() {
        double precoinicial = -3, expected = -1, result = Bloco2.preco_com_saldo(precoinicial);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void preco_saldos_exercicio10_invalido() {
        double precoInicial = -3.0990809, expected = -1, result = Bloco2.preco_com_saldo(precoInicial);
        assertEquals(expected, result);
    }
    @Test
    void preco_saldos_exercicio10_normal_menos50() {
        double p = 45, expected = 36, result = Bloco2.preco_com_saldo(p);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void preco_saldos_exercicio10_normal_50a100() {
        double p = 60, expected = 42, result = Bloco2.preco_com_saldo(p);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void preco_saldos_exercicio10_normal_100a200() {
        double preco = 150, expected = 90, result = Bloco2.preco_com_saldo(preco);
        assertEquals(expected, result, 0.01);
    }
    @Test
    void preco_saldos_exercicio10_normal_200plus() {
        double num = 250, expected = 100, result = Bloco2.preco_com_saldo(num);
        assertEquals(expected, result);
    }
    @Test
    void proporcao_aprovados_ex11_invalido() {
        double p = -3, f = 0.2, r = 0.5, b = 0.7, e = 0.9;
        String expected = "Valor Inválido", resultado = Bloco2.avaliacao_turma_exercicio11(p, f, r, b, e);
        assertEquals(expected, resultado);
    }
    @Test
    void propporcao_aprovados_ex11_Boa() {
        double p = 0.8, f = 0.2, r = 0.5, b = 0.7, e = 0.9;
        String expected = "Turma Boa", result = Bloco2.avaliacao_turma_exercicio11(p, f, r, b, e);
        assertEquals(result, expected);
    }
    @Test
    void proporcao_aprovados_ex11_Má() {
        double p = 0.1, f = 0.2, r = 0.5, b = 0.7, e = 0.9;
        String expected = "Turma Má", result = Bloco2.avaliacao_turma_exercicio11(p, f, r, b, e);
        assertEquals(expected, result);
    }
    @Test
    void proporcao_aprovados_ex11_fraca() {
        double p = 0.4, f = 0.2, r = 0.5, b = 0.7, e = 0.9;
        String expected = "Turma Fraca", result = Bloco2.avaliacao_turma_exercicio11(p, f, r, b, e);
        assertEquals(expected, result);
    }
    @Test
    void proporcao_aprovados_ex11_razoavel() {
        double p = 0.6, f = 0.2, r = 0.5, b = 0.7, e = 0.9;
        String expected = "Turma Razoável", result = Bloco2.avaliacao_turma_exercicio11(p, f, r, b, e);
        assertEquals(expected, result);
    }
    @Test
    void proporcao_aprovados_ex11_excelente() {
        double p = 0.95, f = 0.2, r = 0.5, b = 0.7, e = 0.9;
        String exp = "Turma Excelente", raz = Bloco2.avaliacao_turma_exercicio11(p, f, r, b, e);
        assertEquals(exp, raz);
    }
    @Test
    void poluicao_ex12_normal() {
        int grupo = 1;
        double poluicao = 0.2;
        String expected = "Índice de Poluição Adequado", result = Bloco2.avisoPoluicaoex12(poluicao, grupo);
    }
    @Test
    void poluicao_ex12_invalido() {
        int grupo = 3;
        double poluicao = -3;
        String expected = "Input Inválido", result = Bloco2.avisoPoluicaoex12(poluicao, grupo);
        assertEquals(expected, result);
    }
    @Test
    void poluicao_ex12_paralisaratividades(){
        int grupo =2;
        double poluicao = 0.9;
        String expected = "Paralisem Atividades. Índice de Poluiçao inaceitável", result = Bloco2.avisoPoluicaoex12(poluicao,grupo);
        assertEquals(expected,result);
    }
    @Test
    void poluicao_ex12_paralisaratividadesmassógrupo1(){
        double indice_poluicao = 0.4d;
        int grupo = 2;
        String expected = "Índice de Poluição Adequado", result = Bloco2.avisoPoluicaoex12(indice_poluicao,grupo);
        assertEquals(expected,result);
    }
    @Test
    void jardinagem_ex13_normal(){
        int grama = 2, árvores= 10, arbustos = 5, preco_hora = 10;
        String expected = "Custos totais por 2 horas de serviço: 315.0 euros";
        String result = Bloco2.gestao_custos(grama,árvores,arbustos,preco_hora);
        assertEquals(expected,result);
    }
    @Test
    void jardinagem_ex13_invalido(){
        int grama = -1, árvores = 2, arbustos = 5, preco = 10;
        String expected = "Valor Inválido", result = Bloco2.gestao_custos(grama,árvores,arbustos,preco);
        assertEquals(expected,result);
    }
    @Test
    void jadinagem_ex12_zeroMetrosQuadrados() {
        int gr = 0, arv=4,arb=3,preco=10;
        String exp = "Custos totais por 1 horas de serviço: 135.0 euros";
        String result = Bloco2.gestao_custos(gr,arv,arb,preco);
        assertEquals(exp,result);
    }
    @Test
    void milestoKm_ex14_all3miles(){
        double mld1=3,mld2=3,mld3=3,mld4=3,mld5=3;
        double expected = 3*1.609, result = Bloco2.km_médios_diários(mld1,mld2,mld3,mld4,mld5);
        assertEquals(expected,result,0.01);
    }
    @Test
    void milestokm_ex14_invalid(){
        double m1=-4,m2=4,m3=6,m4=7,m5=2;
        double exp = -1.00, res = Bloco2.km_médios_diários(m1,m2,m3,m4,m5);
        assertEquals(exp,res,0.01);
    }
    @Test
    void milestoKm_ex14_2days0Miles(){
        double m1=0,m2=0,m3=4,m4=5,m5=1;
        double expected=((4+5+1)*1.609)/5;
        double result = Bloco2.km_médios_diários(m1,m2,m3,m4,m5);
        assertEquals(expected,result,0.01);
    }
    @Test
    void triangulo_lados_negativo(){
        float a=2,b=-4,c=3;
        String expected = "Não é um triângulo válido", result = Bloco2.lados_triangulo(a,b,c);
    }
    @Test
    void triangulo_lados_equilatero(){
        float a=1,b=1,c=1;
        String exp = "Equilátero", res = Bloco2.lados_triangulo(a,b,c);
        assertEquals(exp,res);
    }
    @Test
    void triangulo_lados_escaleno(){
        float a=1,b=2,c=5/2f;
        String expected = "Escaleno", result = Bloco2.lados_triangulo(a,b,c);
        assertEquals(expected,result);
    }
    @Test
    void triangulo_lados_isosceles(){
        float a=1,b=2,c=2;
        String exp="Isósceles", res =Bloco2.lados_triangulo(a,b,c);
    }
    @Test
    void triangulo_lados_umMaiorQueOsoutrosDois(){
        float a=4,b=2,c=1;
        String exp = "Não é um Triângulo válido", res = Bloco2.lados_triangulo(a,b,c);
        assertEquals(exp,res);
    }
    @Test
    void triangulo_angulos_angulosinvalido(){
        float a=181,b=1,c=3;
        String exp = "Triângulo Inválido", res = Bloco2.angulos_triangulo(a,b,c);
        assertEquals(res,exp);
    }
    @Test
    void triangulo_angulos_acutangulo(){
        float a=60,b=70,c=50;
        String exp = "Triângulo acutângulo", res = Bloco2.angulos_triangulo(a,b,c);
        assertEquals(exp,res);
    }
    @Test
    void triangulo_angulos_retangulo(){
        float a=90,b=45,c=45;
        String exp = "Triângulo Retângulo", res = Bloco2.angulos_triangulo(a,b,c);
        assertEquals(exp,res);
    }
    @Test
    void triangulo_angulos_obstusangulo(){
        float a=91,b=44,c=45;
        String expected = "Triângulo obtusângulo", res = Bloco2.angulos_triangulo(a,b,c);
    }
    @Test
    void horas_chegada_ex17_normal(){
        int hs=19,ms=30,hv=1,mv=30;
        String exp = "Hora de chegada: 21horas e 0minutos. Chega no próprio dia.";
        String result = Bloco2.hora_de_chegada(hs,ms,hv,mv);
        assertEquals(exp,result);
    }
    @Test
    void horas_chegada_ex17_invalido(){
        int hs=27, ms=0,hv=13,mv=59;
        String exp = "Dados Inválidos", result = Bloco2.hora_de_chegada(hs,ms,hv,mv);
        assertEquals(exp,result);
    }
    @Test
    void horas_chegada_ex17_dia_seguinte(){
        int hs = 20, ms=0, hv = 5, mv = 40;
        String expected = "Hora de chegada: 1horas e 40minutos. Chega no dia seguinte.";
        String result = Bloco2.hora_de_chegada(hs,ms,hv,mv);
        assertEquals(expected,result);
    }
    @Test
    void horas_chegada_ex17_minutosMaiorqueSessenta(){
        int hs=10,ms=40,hv=0,mv=21;
        String exp = "Hora de chegada: 11horas e 1minutos. Chega no próprio dia";
        String res = Bloco2.hora_de_chegada(hs,ms,hv,mv);
    }
    @Test
    void tempos_processamento_ex18_normal(){
        int hi = 19, mi =30, si = 45, dur = 3600;
        String exp = "Hora de fim: 20h, 30min e 45seg.";
        String res = Bloco2.processamento_máquina(hi,mi,si,dur);
        assertEquals(exp,res);
    }
    @Test
    void tempos_processammento_ex18_inválido(){
        int hi = -3, mi = 10, si = 34,dur= 676;
        String exp = "Dados inválidos", res = Bloco2.processamento_máquina(hi,mi,si,dur);
        assertEquals(exp,res);
    }
    @Test
    void tempos_processamento_ex18_depoisdaMeiaNoite(){
        int hi=23,mi=59,si=59,dur=2;
        String exp = "Hora de fim: 0h, 0min e 1seg.", res = Bloco2.processamento_máquina(hi,mi,si,dur);
        assertEquals(exp,res);
    }
    @Test
    void calcularsalarioHorasExtra_ex19_normal(){
        int h = 52;
        float exp =485, res = Bloco2.calcularsalarioHorasExtra(h);
        assertEquals(exp,res);
    }
    @Test
    void calcularsalarioHorasExtra_ex19_invalido(){
        int h = 999999999;
        float exp = -1, res = Bloco2.calcularsalarioHorasExtra(h);
        assertEquals(exp,res);
    }
    @Test
    void calcularsalarioHorasExtra_ex19_normal_extraMenor41(){
        int h = 40;
        float exp = 36*7.5f+40, res = Bloco2.calcularsalarioHorasExtra(h);
        assertEquals(exp,res);
    }
    @Test
    void calcularsalarioHorasExtra_ex19_abaixo36(){
        int h =30;
        float exp = 30*7.5f, res = Bloco2.calcularsalarioHorasExtra(h);
        assertEquals(exp,res);
    }
    @Test
    void dias_semana_aluguer_ex20_invalido(){
        String dia = "Segunda", TipoKit = "A";
        int dist = -3;
        int expected = -1, result = Bloco2.valor_aluguer(dia, TipoKit,dist);
        assertEquals(expected,result);
    }
    @Test
    void dias_semana_aluguer_ex20_normal_semana_comdeslocacao(){
        String dia = "Terça", tipoKit="B";
        int distanciakm = 3, expected = 56, result = Bloco2.valor_aluguer(dia,tipoKit,distanciakm);
        assertEquals(expected,result);
    }
    @Test
    void dias_semana_aluguer_ex20_normal_fim_de_semana(){
        String dia = "Sábado", kit = "C";
        int dist = 4, exp = 148, res = Bloco2.valor_aluguer(dia,kit,dist);
        assertEquals(exp,res);
    }
    @Test
    void dias_semana_aluguer_ex20_normal_semana_semdeslocacao(){
        String dia = "Quarta", kit = "A";
        int dist = 0, exp =30, res = Bloco2.valor_aluguer(dia,kit,dist);
        assertEquals(exp,res);}
    @Test
    void dias_semana_aluguer_ex20_inválido_diaInexistente(){
        String dia = "Setúbal", kit = "B";
        int dist = 7, exp = -1, res = Bloco2.valor_aluguer(dia,kit,dist);
        assertEquals(exp,res);
    }
}


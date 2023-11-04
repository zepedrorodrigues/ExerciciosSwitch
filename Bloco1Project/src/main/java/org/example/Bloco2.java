package org.example;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
public class Bloco2 {
    public static double main(int nota1, int nota2, int nota3, int peso1, int peso2, int peso3) {
        if (nota1 < 0 || nota2 < 0 || nota3 < 0 || peso1 < 0 || peso2 < 0 || peso3 < 0)
            return -1;
        double mediafinal = mediaPesada(nota1, nota2, nota3, peso1, peso2, peso3);
        return mediafinal;}

    public static double mediaPesada(int nota1, int nota2, int nota3, int peso1, int peso2, int peso3) {
        return (double) (peso1 * nota1 + peso2 * nota2 + peso3 * nota3) / (peso1 + peso2 + peso3);
    }

    public static boolean passa(int nota1, int nota2, int nota3, int peso1, int peso2, int peso3) {
        double x = mediaPesada(nota1, nota2, nota3, peso1, peso2, peso3);
        return (x >= 8);
    }

    public static String digitos(int numero) {
        String processado = processamento(numero);
        return processado;
    }

    public static String processamento(int numero) {
        if (numero < 100 || numero > 999)
            return "Inválido";
        int digito1 = numero % 10, digito2 = (numero / 10) % 10, digito3 = (numero / 100) % 10;
        String digitos_separados = digito3 + " " + digito2 + " " + digito1;
        String par = "O número é ímpar.";
        if (digito1 % 2 == 0)
            par = "O número é par.";
        return digitos_separados + ". " + par;
    }

    public static double distancia_pontos(float x1, float x2, float y1, float y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y2 - y1, 2));
    }

    public static double equacao_segundo_grau_ex4(double x) {
        if (x < 0d) {
            return x;
        } else {
            if (x == 0) {
                return 0;
            } else {
                return Math.pow(x, 2) - (2 * x);
            }
        }
    }

    public static String volume_cubo(double área) {
        if (área > 0) {
            return volume_cubo_calculos(área);
        }
        return "Valor de área incorrecto.";
    }

    public static String volume_cubo_calculos(double área) {
        double aresta = Math.sqrt(área / 6), volume = Math.pow(aresta, 3);
        String tamanho = "Pequeno";
        if (volume > 1000 && volume <= 2000) {
            tamanho = "Médio";
        }
        if (volume > 2000) {
            tamanho = "Grande";
        }
        return String.format(Locale.US, "Volume do cubo = %.2f. Cubo %s", volume, tamanho);

    }

    public static String greeting(int segundos) {
        int horas = segundos / 3600, minutos = (segundos - (horas * 3600)) / 60, segundos_final = segundos - (horas * 3600) - (minutos * 60);
        if (segundos < 0)
            return "Tempo inválido";
        if (horas >= 6 && horas < 12 || horas == 12 && segundos_final < 1)
            return "Bom dia. São " + horas + " horas, " + minutos + " minutos e " + segundos_final + " segundos.";
        if (horas >= 12 && horas < 20 || horas == 20 && segundos_final < 1)
            return "Boa tarde. São " + horas + " horas, " + minutos + " minutos e " + segundos_final + " segundos.";
        else {
            return "Boa noite. São " + horas + " horas, " + minutos + " minutos e " + segundos_final + " segundos.";
        }
    }
    public static double custos_totais(double áreaEdifício, double custoLitroTinta, double RendimentoLitro, double salárioDiaPintor, String opcao) {
        if (áreaEdifício <= 0 || custoLitroTinta < 0 || RendimentoLitro <= 0 || salárioDiaPintor < 0)
            return -1d;
        int pintores = número_pintores(áreaEdifício);
        double totalDias = totalDias_contas(pintores, áreaEdifício);
        double costs_pintores_final = custo_pintores_total(pintores, salárioDiaPintor, totalDias);
        double costs_tinta_total = custo_tinta_total(áreaEdifício, custoLitroTinta, RendimentoLitro);
        if (opcao == "Ttl")
            return costs_tinta_total + costs_pintores_final;
        if (opcao == "MdO")
            return costs_pintores_final;
        if(opcao =="Tinta")
            return costs_tinta_total;
        return -1d;
    }

    public static int número_pintores(double áreaEdifício) {
        if (áreaEdifício < 100)
            return 1;
        if (áreaEdifício < 300 && áreaEdifício >= 100)
            return 2;
        if (áreaEdifício >= 300 && áreaEdifício < 1000)
            return 3;
        else {
            return 4;
        }
    }

    public static long totalDias_contas(int pintores, double áreaEdifício) {
        double dias = áreaEdifício / (pintores * 16), sobras = dias % 1;
        if (sobras < 0.5)
            return Math.round(dias) + 1;
        else {
            return Math.round(dias);
        }
    }

    public static double custo_pintores_total(int pintores, double salárioDiaPintor, double totalDias) {
        return totalDias * ((pintores * salárioDiaPintor));
    }

    public static double custo_tinta_total(double áreaEdifício, double custoLitroTinta, double RendimentoLitro) {
        double custoMetroQuadradoTinta = custoLitroTinta / RendimentoLitro;
        return áreaEdifício * custoMetroQuadradoTinta;
    }

    public static String x_e_y_exercício_8(float x, float y) {
        float maior = x, menor = y;
        if (menor == 0 || y > x) {
            maior = y;
            menor = x;
        }
        if(menor ==0)
            return "Impossível dividir por 0.";
        boolean check = maior % menor == 0;
        if (check == true) {
            return maior + " é múltiplo de " + menor;
        }
        return maior + " não é múltiplo nem divisor de " + menor;
    }

    public static String número_3_dígitos_crescente(int numero) {
        if (numero < 100 || numero > 999)
            return "Número inválido";
        int x = 10;
        boolean check = true;
        for (int i = 1; i <= 3; i++) {
            int resto = numero % 10;
            if (resto > x)
                check = false;
            x = resto;
            numero = numero / 10;
        }
        if (check == true)
            return "Algarismos crescentes";
        return "Algarismos não crescentes";
    }
    public static double preco_com_saldo(double preco_inicial) {
        if (preco_inicial < 0 || (preco_inicial * 1000) % 1 != 0)
            return -1.00;
        if (preco_inicial > 200)
            return 0.4 * preco_inicial;
        if (preco_inicial > 100)
            return 0.6 * preco_inicial;
        if (preco_inicial > 50)
            return 0.7 * preco_inicial;
        return 0.8 * preco_inicial;
    }
    public static String avaliacao_turma_exercicio11(double proporcao_aprovados, double limite_fraca, double limite_razoável, double limite_boa, double limite_excelente) {
        if (proporcao_aprovados < 0 || proporcao_aprovados > 1)
            return "Valor Inválido";
        String resultado = feedback_notas(proporcao_aprovados, limite_fraca, limite_razoável, limite_boa, limite_excelente);
        return resultado;
    }
    public static String feedback_notas(double proporcao_aprovados, double limite_fraca, double limite_razoável, double limite_boa, double limite_excelente) {
        if (proporcao_aprovados < limite_fraca)
            return "Turma Má";
        if (proporcao_aprovados < limite_razoável)
            return "Turma Fraca";
        if (proporcao_aprovados < limite_boa)
            return "Turma Razoável";
        if (proporcao_aprovados < limite_excelente)
            return "Turma Boa";
        return "Turma Excelente";
    }
    public static String avisoPoluicaoex12(double indice_poluicao, int grupo) {
        if (indice_poluicao < 0)
            return "Input Inválido";
        if (indice_poluicao > 0.5 || grupo == 1 && indice_poluicao > 0.3 || grupo == 2 && indice_poluicao > 0.4)
            return "Paralisem Atividades. Índice de Poluiçao inaceitável";
        return "Índice de Poluição Adequado";
    }
    public static String gestao_custos(int gramaMetroQuadrado, int árvores, int arbustos, int preco_hora) {
        if (gramaMetroQuadrado < 0 || árvores < 0 || arbustos < 0 || preco_hora < 0)
            return "Valor Inválido";
        double custo_material = custo_material_contas(gramaMetroQuadrado, árvores, arbustos);
        long total_horas = horas_contas(gramaMetroQuadrado, árvores, arbustos);
        double custo_tempo = custo_tempo_contas(gramaMetroQuadrado, árvores, arbustos, preco_hora);
        double custo_total = custo_material + custo_tempo;
        return "Custos totais por " + total_horas + " horas de serviço: " + (Math.round(custo_total * 100)) / 100.00 + " euros";
    }
    public static double custo_material_contas(double grama_M2, int árvores, int arbustos) {
        return 10 * grama_M2 + 20 * árvores + 15 * arbustos;
    }
    public static long horas_contas(int grama_M2, int árvores, int arbustos) {
        float horas = (300 * grama_M2 + 600 * árvores + 400 * arbustos) / 3600;
        return Math.round(horas + 0.49);
    }
    public static double custo_tempo_contas(int gramaM2, int árvores, int arbustos, int preco_hora) {
        long horas = horas_contas(gramaM2, árvores, arbustos);
        return horas * preco_hora;
    }
    public static double km_médios_diários(double milesd1, double milesd2, double milesd3, double milesd4, double milesd5) {
        if (milesd1 < 0 || milesd2 < 0 || milesd3 < 0 || milesd4 < 0 || milesd5 < 0)
            return -1.00;
        return ((milesd1 + milesd2 + milesd3 + milesd4 + milesd5) * 1.609) / 5;
    }
    public static String lados_triangulo(float a, float b, float c) {
        if (a > b + c || b > a + c || c > a + b)
            return "Não é um Triângulo válido";
        if (a == b && b == c)
            return "Equilátero";
        if (a != b && b != c)
            return "Escaleno";
        return "Isósceles";
    }
    public static String angulos_triangulo(float a, float b, float c) {
        if (a + b + c != 180 || a <= 0 || b <= 0 || c <= 0)
            return "Triângulo Inválido";
        if (a == 90 || b == 90 || c == 90)
            return "Triângulo Retângulo";
        if (a > 90 || b > 90 || c > 90)
            return "Triângulo Obstusângulo";
        return "Triângulo acutângulo";
    }
    public static String hora_de_chegada(int HoraSaida, int MinutosSaida, int HorasViagem, int MinutosViagem) {
        if (HoraSaida < 0 || MinutosSaida < 0 || HorasViagem < 0 || MinutosViagem < 0 || MinutosViagem > 59 || HorasViagem > 23 || HoraSaida > 23 || MinutosSaida > 59)
            return "Dados Inválidos";
        return calculos_horas(HoraSaida, MinutosSaida, HorasViagem, MinutosViagem);
    }
    public static String calculos_horas(int HS, int MS, int HV, int MV) {
        int[] Chegada = new int[2];
        Chegada[0] = HS + HV;
        Chegada[1] = MS + MV;
        String Dia = "no próprio dia.";
        if (Chegada[1] >= 60) {
            Chegada[1] -= 60;
            Chegada[0] += 1;
        }
        if (Chegada[0] >= 24) {
            Dia = "no dia seguinte.";
            Chegada[0] -= 24;
        }
        return String.format("Hora de chegada: %dhoras e %dminutos. Chega %s", Chegada[0], Chegada[1], Dia);
    }
    public static String processamento_máquina(int hi, int mi, int si, int durseg) {
        if (hi < 0 || hi >= 24 || mi < 0 || mi >= 60 || si >= 60 || si < 0 || durseg < 0)
            return "Dados inválidos";
        int horas = calcularHoras(hi, durseg);
        int minutos = calcularMinutos(hi, mi, durseg, horas);
        int segundos = calcularSegundos(hi, mi, si, durseg, horas, minutos);
        if (segundos >= 60) {
            minutos += 1;
            segundos -= 60;
        }
        if (minutos >= 60) {
            horas += 1;
            minutos -= 60;
        }
        if (horas >= 24) {
            horas -= 24;
        }
        return String.format("Hora de fim: %dh, %dmin e %dseg.", horas, minutos, segundos);
    }
    public static int calcularHoras(int hi, int durseg) {
        return hi + durseg / 3600;
    }
    public static int calcularMinutos(int hi, int mi, int durseg, int horas) {
        return mi + (durseg - ((horas - hi) * 3600)) / 60;
    }
    public static int calcularSegundos(int hi, int mi, int si, int durseg, int horas, int minutos) {
        return si + (durseg - ((horas - hi) * 3600) - ((minutos - mi) * 60)) / 1;
    }
    public static float calcularsalarioHorasExtra(int horas) {
        if (horas < 0 || horas > 7 * 24)
            return -1;
        if (horas <= 36)
            return horas * 7.5f;
        if (horas <= 41)
            return 36 * 7.5f + (horas - 36) * 10;
        return 36 * 7.5f + 5 * 10 + (horas - 41) * 15;}
    public static int valor_aluguer(String dia_semana, String TipoKit, int distanciakm){
        boolean valido = dia_valido_e_kit_valido(dia_semana,TipoKit);
        if(distanciakm<0||valido== false)
            return -1;
        int kit_A =30, kit_B=50,kit_C=100;
        boolean dia_util = dia_util_check(dia_semana);
        if (dia_util==false){
            kit_A = 40;
            kit_B = 70;
            kit_C = 140;}
        if(TipoKit=="A")
            return kit_A+2*distanciakm;
        if(TipoKit=="B")
            return kit_B+2*distanciakm;
        return kit_C+2*distanciakm;
    }
    public static boolean dia_valido_e_kit_valido(String dia_semana, String TipoKit){
        String[] dias = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo", "Feriado"};
        String[] kits = {"A","B","C"};
        List dias_semana = Arrays.asList(dias), kits_validos = Arrays.asList(kits);
        boolean dia_valido = dias_semana.contains(dia_semana);
        boolean kit_valido = kits_validos.contains(TipoKit);
        if(dia_valido==true&&kit_valido==true)
            return true;
        return false;
    }
    public static boolean dia_util_check(String dia_semana){
        String[] dias_uteis = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        List dias_semana = Arrays.asList(dias_uteis);
        boolean dia_util = dias_semana.contains(dia_semana);
        return dia_util;
    }
}

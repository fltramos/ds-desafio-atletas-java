import java.util.Locale;
import java.util.Scanner;

public class Desafio_imposto_Java {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int quantidade;
        char sexo;
        String nomeAtleta, nomeAtletaMaisAlto;
        double pesoMedio, peso, porcentagemHomens, alturaMediaMulheres, atletaMaisAlto, quantidadeHomens;
        double quantidadeMulheres, somaAlturaMulheres, alturaAtleta, somaPeso;


        quantidadeHomens = 0.0;
        quantidadeMulheres = 0.0;
        alturaAtleta = 0.0;
        atletaMaisAlto = 0.0;
        somaPeso = 0.0;
        somaAlturaMulheres = 0.0;
        alturaMediaMulheres = 0.0;
        nomeAtletaMaisAlto = "";

        System.out.print("Qual a quantidade de atletas? ");
        quantidade = sc.nextInt();

        
        for (int i = 1; i <= quantidade; i++) {
            System.out.printf("Digite os dados do atleta numero %d: ", i);
            System.out.println();

            sc.nextLine();

            System.out.print("Nome: ");
            nomeAtleta = sc.nextLine();

            System.out.print("Sexo: ");
            sexo = sc.next().charAt(0);
            while (sexo != 'F' && sexo != 'M') {
                System.out.print("Valor invalido! Favor digitar F ou M: ");
                sexo = sc.next().charAt(0);
            }

            System.out.print("Altura: ");
            alturaAtleta = sc.nextDouble();
            while (alturaAtleta <= 0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                alturaAtleta = sc.nextDouble();
            }

            System.out.print("Peso: ");
            peso = sc.nextDouble();
            while (peso <= 0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
            }

            somaPeso = somaPeso + peso;
            if (atletaMaisAlto < alturaAtleta) {
                atletaMaisAlto = alturaAtleta;
                nomeAtletaMaisAlto = nomeAtleta;
            }

            if (sexo == 'M') {
                quantidadeHomens = quantidadeHomens + 1;
            }

            if (sexo == 'F') {
                quantidadeMulheres = quantidadeMulheres + 1;
                somaAlturaMulheres = somaAlturaMulheres + alturaAtleta;
            }
        }
        pesoMedio = somaPeso / quantidade;
        porcentagemHomens = quantidadeHomens * 100 / quantidade;

        System.out.println();
        System.out.println("RELATÓRIO:");
        System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);
        System.out.println("Atleta mais alto:" + nomeAtletaMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f%%%n", porcentagemHomens);

        if (quantidadeMulheres == 0.0) {
            System.out.println("Não há mulheres cadastradas");
        }else {
            alturaMediaMulheres = somaAlturaMulheres / quantidadeMulheres;
            System.out.printf("Altura média das mulheres: %.2f%n", alturaMediaMulheres);
        }

                sc.close();
    }
}

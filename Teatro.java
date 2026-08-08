import java.util.Scanner;

public class Teatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] assentos = new int[20][20];

        System.out.print("Digite o valor do ingresso inteiro: R$ ");
        double valorIngresso = scanner.nextDouble();

        double valorReserva = valorIngresso * 0.40;

        System.out.printf("Valor da reserva: R$ %.2f\n", valorReserva);// %.2f é para ele colocar só 2 numetos dps da
                                                                       // virgula

        int escolha = 0;

        do {
            System.out.println(
                    "\nOlá como deseja continuar?\n\n1 - Visualizar teatro\n2 - Reservar assento(s)\n3 - Comprar assento(s)\n4 - Cancelar reserva\n5 - Relatório financeiro\n0 - Encerrar\n");
            System.out.print("opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    visualizar_teatro(assentos);
                    break;

                case 2:
                    reservar_assentos(assentos, scanner, valorReserva);
                    break;

                case 3:
                    comprar_assentos(assentos, scanner, valorIngresso);
                    break;

                case 4:
                    cancelar_reserva(assentos, scanner);
                    break;

                case 5:
                    relatorio_financeiro(assentos, valorIngresso, valorReserva);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente");
                    break;
            }
        } while (escolha != 0);

        scanner.close();
    }

    public static void visualizar_teatro(int[][] assentos) {
        System.out.println("\nBem vindo ao Teatro Devisate!!\n\nL - Livre | V - Vendido | R - Reservado\n");

        System.out.print("    ");

        for (int colunas = 0; colunas <= 19; colunas++) {
            if (colunas + 1 < 10) {
                System.out.print((colunas + 1) + "   ");
            } else {
                System.out.print((colunas + 1) + "  ");
            }
        }

        System.out.println();

        for (int i = 0; i < assentos.length; i++) {
            int numeroLinha = i + 1;

            if (numeroLinha < 10) {
                System.out.print(numeroLinha + "   ");
            } else {
                System.out.print(numeroLinha + "  ");
            }

            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j] == 0) {
                    System.out.print("L   ");
                } else if (assentos[i][j] == 1) {
                    System.out.print("R   ");
                } else {
                    System.out.print("V   ");
                }
            }

            System.out.println();
        }
    }

    public static void reservar_assentos(int[][] assentos, Scanner scanner, double valorReserva) {
        System.out.print("\nQuantos assentos deseja reservar? ");
        int quantidade = scanner.nextInt();

        double valorTotal = 0;

        for (int i = 0; i < quantidade; i++) {
            System.out.print("\nInforme a linha: ");
            int linha = scanner.nextInt();

            System.out.print("Informe a coluna: ");
            int coluna = scanner.nextInt();

            if (linha < 1 || linha > 20 || coluna < 1 || coluna > 20) {
                System.out.println("Assento indisponível.");
            } else if (assentos[linha - 1][coluna - 1] != 0) {
                System.out.println("Assento indisponível.");
            } else {
                assentos[linha - 1][coluna - 1] = 1;

                valorTotal += valorReserva;

                System.out.println("Reserva realizada com sucesso!");
            }
        }

        System.out.printf("\nValor da reserva: R$ %.2f\n", valorTotal);
    }

    public static void comprar_assentos(int[][] assentos, Scanner scanner, double valorIngresso) {
        System.out.print("\nQuantos assentos deseja comprar? ");
        int quantidade = scanner.nextInt();

        double valorTotal = 0;

        for (int i = 0; i < quantidade; i++) {
            System.out.print("\nInforme a fileira: ");
            int fileira = scanner.nextInt();

            System.out.print("Informe a cadeira: ");
            int cadeira = scanner.nextInt();

            if (fileira < 1 || fileira > 20 || cadeira < 1 || cadeira > 20) {
                System.out.println("Assento indisponível.");
            } else if (assentos[fileira - 1][cadeira - 1] != 0) {
                System.out.println("Assento indisponível.");
            } else {
                assentos[fileira - 1][cadeira - 1] = 2;

                valorTotal += valorIngresso;

                System.out.println("Compra realizada com sucesso!");
            }
        }

        System.out.printf("\nValor pago: R$ %.2f\n", valorTotal);
    }

    public static void cancelar_reserva(int[][] assentos, Scanner scanner) {
        System.out.print("\nInforme a fileira: ");
        int fileira = scanner.nextInt();

        System.out.print("Informe a cadeira: ");
        int cadeira = scanner.nextInt();

        if (fileira < 1 || fileira > 20 || cadeira < 1 || cadeira > 20) {
            System.out.println("Este assento não possui reserva.");
        } else if (assentos[fileira - 1][cadeira - 1] == 1) {
            assentos[fileira - 1][cadeira - 1] = 0;

            System.out.println("Reserva cancelada com sucesso.");
        } else {
            System.out.println("Este assento não possui reserva.");
        }
    }

    public static void relatorio_financeiro(int[][] assentos, double valorIngresso, double valorReserva) {
        int livres = 0;
        int reservados = 0;
        int vendidos = 0;

        double totalReservas = 0;
        double totalVendas = 0;

        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {

                if (assentos[i][j] == 0) {
                    livres++;
                } else if (assentos[i][j] == 1) {
                    reservados++;
                    totalReservas += valorReserva;
                } else {
                    vendidos++;
                    totalVendas += valorIngresso;
                }
            }
        }

        double arrecadacaoTotal = totalReservas + totalVendas;

        System.out.println("\n      RELATÓRIO FINANCEIRO      \n");

        System.out.println("Assentos livres.......: " + livres);
        System.out.println("Assentos reservados...: " + reservados);
        System.out.println("Assentos vendidos.....: " + vendidos);

        System.out.printf("Total das reservas....: R$ %.2f\n", totalReservas);
        System.out.printf("Total das vendas......: R$ %.2f\n", totalVendas);
        System.out.printf("Arrecadação total.....: R$ %.2f\n", arrecadacaoTotal);
    }
}

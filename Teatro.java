import java.util.Scanner;

public class Teatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] assentos = new int[20][20];
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

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    
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
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos.length; j++) {
                if (assentos[i][j] == 0) {
                    System.out.print("[L]" + " ");
                } else if (assentos[i][j] == 1) {
                    System.out.print("[R]" + " ");
                } else {
                    System.out.print("[V]" + " ");
                }

            }
            System.out.println();
        }
    }
}

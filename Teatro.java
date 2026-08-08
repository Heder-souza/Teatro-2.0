import java.util.Scanner;

public class Teatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] assentos = new int[20][20];
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};

        int escolha = 0;

        do {

            System.out.println(
                    "\nOlá como deseja continuar?\n\n1 - Visualizar teatro\n2 - Reservar assento(s)\n3 - Comprar assento(s)\n4 - Cancelar reserva\n5 - Relatório financeiro\n0 - Encerrar\n");
            System.out.print("opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    visualizar_teatro(assentos, letras);
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

    
    public static void visualizar_teatro(int[][] assentos, char[] letras) {
        System.out.println("\nBem vindo ao Teatro Devisate!!\n\nL - Livre | V - Vendido | R - Reservado\n");

        System.out.print("   ");
        for (int colunas = 0; colunas <= 19; colunas++) {
                        if (colunas < 10) {
                System.out.print(colunas+1 + "    "); 
            } else {
                System.out.print(colunas+1 + "   ");
            }
        
        }
        System.out.println();
        for (int i = 0; i < assentos.length; i++) {
            System.out.print(letras[i]);
            for (int j = 0; j < assentos.length; j++) {

                if (assentos[i][j] == 0) {
                    System.out.print("  [L]");
                } else if (assentos[i][j] == 1) {
                    System.out.print("  [R]");
                } else {
                    System.out.print("  [V]");
                }

            }
            System.out.println();
        }
    }
}

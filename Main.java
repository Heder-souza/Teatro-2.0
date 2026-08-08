public static void main(String[] args) {
    int [][] assentos = new int[20][20];

    System.out.println("Bem vindo ao Teatro Devisate!!\n\n");
    for(int i = 0; i <= assentos.length;i++){
        for (int j = 0; j < assentos.length; j++) {
            System.out.print(assentos[i][j]+" ");
        }
        System.out.println();
    }
    
}
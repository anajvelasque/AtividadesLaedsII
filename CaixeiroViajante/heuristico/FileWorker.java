import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWorker {
    public static int[][] extrairMatrizDeAdjacencia(String nomeDoArquivo, int tamanho, boolean matrizBaixa) {
        File file = new File(nomeDoArquivo);
        int[][] matrizDeAdjacencia = new int[tamanho][tamanho];
        
        try {
            Scanner scanner = new Scanner(file);      
            while (!scanner.next().equals("EDGE_WEIGHT_SECTION")) {}
            
            int i, j;
            for (i = 0; i < tamanho; i++) {
                if(matrizBaixa) {                    
                    for (j = 0; j <= i; j++) {
                        matrizDeAdjacencia[i][j] = matrizDeAdjacencia[j][i] = scanner.nextInt();
                    }                    
                } else {                    
                    for (j = i; j < tamanho; j++) {
                        matrizDeAdjacencia[i][j] = matrizDeAdjacencia[j][i] = scanner.nextInt();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao abrir o arquivo '"+nomeDoArquivo+"'");
        }
        return matrizDeAdjacencia;
    }
}
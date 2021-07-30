/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Item.Item;
import heap.FPHeapMax;
import heap.OrdenaFPHeapMax;
import java.util.Random;

/**
 *
 * @author anajv
 */
public class Main {
    public static void main(String[] args) {
      int n = 10000; // é necessário mudar N para o numero de elementos que você quer por vez
      Item x;
      Item vetor[] = new Item[n];
      
      // Preenche o vetor com números ordenados de 1 a n
      for (int i = 0; i < n; i++)
      {
        x = new Item (i);
        vetor[i] = x;
      }
      
      aleatorio(vetor);

      //Cria a heap e ordena
      FPHeapMax dicionario = new FPHeapMax (vetor);
      OrdenaFPHeapMax heapsort = new OrdenaFPHeapMax();
      dicionario = heapsort.ordenacao(vetor, n - 1, dicionario);
      //aleatorio(vetor);
      System.out.println(n + " elementos");
      System.out.println(dicionario.getComparacoes()+" comparações");
    }
    
    public static double rand0a1 (Random rand) {
      rand.setSeed (System.currentTimeMillis ());
      return rand.nextDouble ();
    }

    public static void aleatorio(Item vetor[]){
      Random rand = new Random();
      for (int i = 0; i < vetor.length; i++) {
        int j = (int) (((double) i * rand0a1 (rand)) + 1.0);
        Item b = vetor[i]; 
        vetor[i] = vetor[j]; 
        vetor[j] = b;
      }
    }

}

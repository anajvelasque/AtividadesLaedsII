/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;
import Item.Item;
import heap.FPHeapMax;

/**
 *
 * @author anajv
 */


public class OrdenaFPHeapMax { // Estrutura de dados fila de prioridades implementada utilizando um heap
  public FPHeapMax ordenacao (Item v[], int n, FPHeapMax fpHeapMax) {
    FPHeapMax fpHeap = new FPHeapMax (v);
    int dir = n;
    fpHeap.constroi (); //Constói o nosso heap
    
    while (dir > 1) { //Ordena o nosso vetor em ordem crescente
      Item x = v[1]; 
      v[1] = v[dir]; 
      v[dir] = x;
      dir--; 
      fpHeap.refaz (1, dir);
    }
    
    /*while (dir < 1) { //Ordena o nosso vetor ordem decrescente
      Item x = v[1]; 
      v[1] = v[dir]; 
      v[dir] = x;
      dir++; 
      fpHeap.refaz (1, dir);
    }*/
    
    return fpHeap;
  }
}


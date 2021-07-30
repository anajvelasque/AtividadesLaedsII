/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;
import Item.Item;

/**
 *
 * @author anajv
 */
public class FPHeapMax {
  private Item v[];
  private int  n;
  private int comparacoes;

  public int getComparacoes(){ //Para pegarmos as comparações 
    return this.comparacoes;
  }

  public FPHeapMax (Item v[]) { //Cria uma fila de prioridades vazia
    this.v = v; 
    this.n = this.v.length - 1;
  }
  
  public void refaz (int esq, int dir) { //Refaz o noss heap
    int aux = esq*2; 
    Item x = this.v[esq];
    while (aux <= dir) {
      this.comparacoes++;
      if ((aux < dir) && (this.v[aux].compara (this.v[aux + 1]) < 0)){
          aux++;
      }
      if (x.compara (this.v[aux]) >= 0){
          break;
      }
      this.v[esq] = this.v[aux];
      esq = aux; 
      aux = esq*2;
    }
    this.v[esq] = x;
  }
  
  public void constroi () { //Constroi o nosso heap
    int esq = n/2 + 1;
    while (esq > 1) {
      esq--; 
      this.refaz (esq, this.n);
    }
  }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author Ana Julia Velasque
 */
public class Lista {
  private static class Celula { 
      Object item; 
      Celula prox; 
  }
  
  private Celula primeiro, ultimo, pos;
  
  public Lista () { //Cria uma Lista vazia
    this.primeiro = new Celula (); this.pos = this.primeiro;
    this.ultimo = this.primeiro; this.primeiro.prox = null;    
  }
  
  public Object pesquisa (Object chave) {
    if (this.vazia () || chave == null) return null;
    Celula aux = this.primeiro;
    while (aux.prox != null) {
      if (aux.prox.item.equals (chave)) return aux.prox.item;
      aux = aux.prox;
    }    
    return null;
  }
  
  public void insere (Object x) {
    this.ultimo.prox = new Celula (); 
    this.ultimo = this.ultimo.prox;
    this.ultimo.item = x; 
    this.ultimo.prox = null;
  }
  
  // Insere antes do primeiro item da lista
  public void inserePrimeiro (Object item) {
    Celula aux =  this.primeiro.prox;
    this.primeiro.prox = new Celula ();
    this.primeiro.prox.item = item;
    this.primeiro.prox.prox = aux;
  }
  
  public Object retira (Object chave) throws Exception {
    if (this.vazia () || (chave == null))
      throw new Exception ("CHAVE INVALIDA");
    Celula aux = this.primeiro;
    while (aux.prox != null && !aux.prox.item.equals (chave)) 
      aux = aux.prox;
    if (aux.prox == null) 
        return null; // Chave nao encontrada 
    Celula q = aux.prox; 
    Object item = q.item; 
    aux.prox = q.prox;
    if (aux.prox == null) 
        this.ultimo = aux;
    return item;
  }
  
  public Object retiraPrimeiro () throws Exception {
    if (this.vazia ()) throw new Exception ("LISTA VAZIA");    
    Celula aux = this.primeiro; 
    Celula q = aux.prox;
    Object item = q.item; 
    aux.prox = q.prox;
    if (aux.prox == null) 
        this.ultimo = aux;
    return item;
  }
  
  public boolean vazia () { return (this.primeiro == this.ultimo); } 
  public void imprime () {
    Celula aux = this.primeiro.prox;
    while (aux != null) {
      System.out.println (aux.item.toString ()); 
      aux = aux.prox;
    }
  }
  
  public boolean estaNaLista (Object chave) {
    Object obj = this.pesquisa (chave);
    return (obj != null);
  }
  
  public Object primeiro () {
    // Retorna o primeiro item da lista
    this.pos = this.primeiro; 
    return this.proximo ();
  }

  public Object proximo () {
    // Retorna o proximo item da lista
    this.pos = this.pos.prox;
    if (this.pos == null) 
        return null; 
    else 
        return this.pos.item;
  }

}

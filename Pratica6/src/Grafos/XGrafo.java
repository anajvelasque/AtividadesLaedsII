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
public class XGrafo {
    public static class Aresta {
    private int vertice1, vertice2, peso;
    public Aresta (int v1, int v2, int peso) {
      this.vertice1 = v1; this.vertice2 = v2; this.peso = peso;
    }
    public int peso () { return this.peso; }
    public int v1 () { return this.vertice1; }
    public int v2 () { return this.vertice2; }
  }  
  private static class Celula {
    int vertice, peso;
    
    public Celula (int v, int p) {
        this.vertice = v; this.peso = p;
    }
    
    public boolean equals (Object obj) {
      Celula item = (Celula) obj;
      return (this.vertice == item.vertice);
    }
    
  }  
  private Lista adj[]; 
  private int numVertices;
  
  public XGrafo (int numVertices) {
    this.adj = new Lista[numVertices]; 
    this.numVertices = numVertices; 
    for (int i = 0; i < this.numVertices; i++) 
        this.adj[i] = new Lista();
  }
  
  public void insereAresta (int v1, int v2, int peso) {
    Celula item = new Celula (v2, peso); 
    this.adj[v1].insere (item); 
  }  
  
  public boolean existeAresta (int v1, int v2) {
    Celula item = new Celula (v2, 0);
    return (this.adj[v1].pesquisa (item) != null);
  }
  
  public boolean listaAdjVazia (int v) {
    return this.adj[v].vazia ();
  }
  
  public Aresta primeiroListaAdj (int v) {
    // Retorna a primeira aresta que o vertice v participa ou se a lista de adjacencia de v for vazia
    Celula item = (Celula) this.adj[v].primeiro ();    
    return item != null ? new Aresta (v, item.vertice, item.peso) : null;
  }
  
  public Aresta proxAdj (int v) {
    // Retorna a proxima aresta que o vertice v participa ou se a lista de adjacencia de v estiver no fim
    Celula item = (Celula) this.adj[v].proximo ();    
    return item != null ? new Aresta (v, item.vertice, item.peso) : null;
  }
  
  public Aresta retiraAresta (int v1, int v2) throws Exception {
    Celula chave = new Celula (v2, 0);
    Celula item = (Celula) this.adj[v1].retira (chave);
    return item != null ? new Aresta (v1, v2, item.peso) : null;
  }
  
  public void imprime () {
    for (int i = 0; i < this.numVertices; i++) { 
      System.out.println ("Vertice " + i + ":");
      Celula item = (Celula) this.adj[i].primeiro ();
      while (item != null) {
        System.out.println ("  " + item.vertice + " (" +item.peso+ ")");
        item = (Celula) this.adj[i].proximo ();
      }
    }
  }
  public int numVertices () { 
      return this.numVertices; 
  }
  public XGrafo grafoTransposto () {
    XGrafo grafoT = new XGrafo (this.numVertices); 
    for (int v = 0; v < this.numVertices; v++)
      if (!this.listaAdjVazia (v)) {
        Aresta adj = this.primeiroListaAdj (v);
        while (adj != null) {
          grafoT.insereAresta (adj.v2 (), adj.v1 (), adj.peso ());
          adj = this.proxAdj (v);
        }
      }
    return grafoT;
  } 
}

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
public class XAGM { // Para obter a arvore geradora minima
  private int antecessor[];
  private double p[];
  private XGrafo xgrafo;

  public XAGM (XGrafo grafo) { 
      this.xgrafo = grafo; 
  }  
  
  public void obterAgm (int raiz) throws Exception {
    int numVertices = this.xgrafo.numVertices();
    this.p = new double[numVertices]; // Peso dos vertices
    int vs[] = new int[numVertices+1]; // Vertices
    boolean itensHeap[] = new boolean[numVertices]; 
    this.antecessor = new int[numVertices];
    
    for (int u = 0; u < numVertices; u ++) {
      this.antecessor[u] = -1;
      p[u] = Double.MAX_VALUE; // Infinito
      vs[u+1] = u; // Heap indireto a ser construído
      itensHeap[u] = true;
    }
    
    p[raiz] = 0;
    FPHeapMinIndireto heap = new FPHeapMinIndireto (p, vs); 
    heap.constroi ();
    
    while (!heap.vazio ()) {
      int u = heap.retiraMin (); itensHeap[u] = false;
      
      if (!this.xgrafo.listaAdjVazia (u)) {
        XGrafo.Aresta adj = xgrafo.primeiroListaAdj (u);
        
        while (adj != null) {
          int v = adj.v2 ();
          
          if (itensHeap[v] && (adj.peso () < this.peso (v))) {
            antecessor[v] = u; heap.diminuiChave (v, adj.peso ());
          }
          
          adj = xgrafo.proxAdj(u);
        }
      }
    }
  }
  
  public int antecessor (int u) { 
      return this.antecessor[u]; 
  }
  
  public double peso (int u) { 
      return this.p[u]; 
  }
  
  public void imprime () {
    for (int u = 0; u < this.p.length; u++)
      if (this.antecessor[u] != -1) 
        System.out.println ("(" +antecessor[u]+ "," +u+ ") -- p:" + peso (u));
  }
  
}

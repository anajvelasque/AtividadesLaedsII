/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica6;

import Grafos.XAGM;
import Grafos.XGrafo;

/**
 *
 * @author Ana Julia Velasque
 */

public class Pratica6 {
    public static final byte A  = 0;
    public static final byte B  = 1;
    public static final byte C  = 2;
    public static final byte D  = 3;
    public static final byte E  = 4;
    public static final byte F  = 5;
    public static final byte G  = 6;
    public static final byte H  = 7;
    public static final byte K  = 8;

    
    public static void main(String[] args) throws Exception {
        XGrafo grafo1 = new XGrafo(9);
        
        grafo1.insereAresta(A, B, 5);
        grafo1.insereAresta(A, H, 10);
        grafo1.insereAresta(A, E, 5);
        grafo1.insereAresta(A, D, 10);
        grafo1.insereAresta(A, G, 10);
        
        grafo1.insereAresta(B, H, 5);
        grafo1.insereAresta(B, K, 10);
        grafo1.insereAresta(B, F, 5);
        
        grafo1.insereAresta(H, K, 20);
        grafo1.insereAresta(E, K, 10);
        grafo1.insereAresta(E, D, 5);
        grafo1.insereAresta(E, C, 10);
        
        grafo1.insereAresta(C, D, 5);
        grafo1.insereAresta(C, G, 5);
        grafo1.insereAresta(D, G, 10);
        
        grafo1.insereAresta(G, F, 15);
        
        XAGM xagm1;
        xagm1 = new XAGM(grafo1);
        xagm1.obterAgm(A);
        
        System.out.println("\n------------------");
        System.out.println("\nExemplo 1");
        
        // Descobrindo os antecessores
        System.out.println("B - " + xagm1.antecessor(B));
        System.out.println("C - " + xagm1.antecessor(C));
        System.out.println("D - " + xagm1.antecessor(D));
        System.out.println("E - " + xagm1.antecessor(E));
        System.out.println("F - " + xagm1.antecessor(F));
        System.out.println("G - " + xagm1.antecessor(G));
        System.out.println("H - " + xagm1.antecessor(H));
        System.out.println("K - " + xagm1.antecessor(K));
        
        // Calculando o peso das arestas
        System.out.println("Peso de A-B: " + xagm1.peso(B));
        System.out.println("Peso de A-E: " + xagm1.peso(E));
        System.out.println("Peso de A-G: " + xagm1.peso(G));
        System.out.println("Peso de B-F: " + xagm1.peso(F));
        System.out.println("Peso de B-H: " + xagm1.peso(H));
        System.out.println("Peso de E-C: " + xagm1.peso(C));
        System.out.println("Peso de E-D: " + xagm1.peso(D));
        System.out.println("Peso de E-K: " + xagm1.peso(K));
        
        
        System.out.println("\n------------------");
        System.out.println("\nExemplo 2");
        XGrafo grafo2 = new XGrafo(9);
        
        grafo2.insereAresta(1, 2, 8);
        grafo2.insereAresta(1, 3, 2);
        grafo2.insereAresta(1, 7, 9);
        
        grafo2.insereAresta(3, 2, 3);
        grafo2.insereAresta(3, 4, 9);
        grafo2.insereAresta(3, 7, 6);
        
        grafo2.insereAresta(4, 2, 2);
        grafo2.insereAresta(4, 5, 6);
        grafo2.insereAresta(4, 7, 2);
        
        grafo2.insereAresta(5, 2, 7);
        grafo2.insereAresta(5, 6, 5);
        grafo2.insereAresta(5, 7, 4);
        
        grafo2.insereAresta(6, 2, 5);
        grafo2.insereAresta(6, 8, 6);
        grafo2.insereAresta(6, 7, 4);
        
        grafo2.insereAresta(8, 2, 6);
        grafo2.insereAresta(8, 7, 3);
        
        XAGM xagm2 = new XAGM(grafo2);
        xagm2.obterAgm(1);
        
        // Descobrindo os antecessores
        System.out.println("2 - " + xagm2.antecessor(2));
        System.out.println("3 - " + xagm2.antecessor(3));
        System.out.println("4 - " + xagm2.antecessor(4));
        System.out.println("5 - " + xagm2.antecessor(5));
        System.out.println("6 - " + xagm2.antecessor(6));
        System.out.println("7 - " + xagm2.antecessor(7));
        System.out.println("8 - " + xagm2.antecessor(8));
        
        // Calculando o peso das arestas
        System.out.println("Peso de 1-3: " + xagm2.peso(3));
        System.out.println("Peso de 3-2: " + xagm2.peso(2));
        System.out.println("Peso de 3-4: " + xagm2.peso(4));
        System.out.println("Peso de 3-7: " + xagm2.peso(7));
        System.out.println("Peso de 4-5: " + xagm2.peso(5));
        System.out.println("Peso de 5-6: " + xagm2.peso(6));
        System.out.println("Peso de 6-8: " + xagm2.peso(8));
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ArvoreSbb.ArvoreSbb;

/**
 *
 * @author Ana Julia Velasque
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random numeroAleatorio = new Random();
        ArvoreSbb[] vetorOrdenado = new ArvoreSbb[10]; //criando o vetor de arvores ordenadas
        ArvoreSbb[] vetorAleatorio = new ArvoreSbb[10]; //criando o vetor de arvores aleatorias
        
        for(int indice = 0; indice < 10; indice++){ //inserindo os itens de forma ordenada
            vetorOrdenado[indice] = new ArvoreSbb();
            int aux = (indice+1) * 10000;
            for(int itemArvore = 1; itemArvore <= aux; itemArvore++){
                vetorOrdenado[indice].insere(new Item(itemArvore));
            }
            long testeTempo = System.nanoTime();//calculando o tempo gasto até o momento do código
            vetorOrdenado[indice].pesquisa(new Item(100001));//fazendo a pesquisa do item inexistente
            testeTempo = Math.abs(testeTempo - System.nanoTime());//vendo a diferença de tempo para ver o tempo gasto na pesquisa
            System.out.println("Tempo = " + Long.toString(testeTempo) + " Comparacoes: " + ArvoreSbb.getComparar());
        }
        
        System.out.println("Arvores Aleatorias: ");
        
        for(int indice = 0; indice < 10; indice++){ //inserindo os itens de forma aleatoria
            vetorAleatorio[indice] = new ArvoreSbb();
            int aux = (indice+1) * 10000;
            for(int itemArvore = 1; itemArvore <= aux; itemArvore++){
                vetorAleatorio[indice].insere(new Item(numeroAleatorio.nextInt(1000000)));
            }
            long testeTempo = System.nanoTime(); //calculando o tempo gasto até o momento do código
            vetorAleatorio[indice].pesquisa(new Item(10000001));//fazendo a pesquisa do item inexistente
            testeTempo = Math.abs(testeTempo - System.nanoTime());//vendo a diferença de tempo para ver o tempo gasto na pesquisa
            System.out.println("Tempo = " + Long.toString(testeTempo) + " Comparacoes: " + ArvoreSbb.getComparar());
        }
    }
    
}

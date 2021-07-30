/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Item.Item;
import arvoreb.ArvoreB;

/**
 *
 * @author Ana Julia Velasque
 */
public class Main {
    public static void main(String[] args) {
        ArvoreB[] ordem2 = new ArvoreB[10];
        for(int i = 0; i < 10; i++){
            ordem2[i] = new ArvoreB(2);
            int tamanho = (i+1) * 10000;
            for(int j = 1; j <= tamanho; j++){
                ordem2[i].insere(new Item(j));
            }
            ordem2[i].pesquisa(new Item(1000000));
            System.out.println("Ordem2 "+(i+1)+": Páginas = "+ordem2[i].getPaginasVisitadas()+" Comparações = "+ordem2[i].getNumeroComparacoes());
        }
        
        System.out.println("--------------------------------------------------");
        
        ArvoreB[] ordem4 = new ArvoreB[10];
        for(int i = 0; i < 10; i++){
            ordem4[i] = new ArvoreB(4);
            int tamanho = (i+1) * 10000;
            for(int j = 1; j <= tamanho; j++){
                ordem4[i].insere(new Item(j));
            }
            ordem4[i].pesquisa(new Item(1000000));
            System.out.println("Ordem4 "+(i+1)+": Páginas = "+ordem4[i].getPaginasVisitadas()+" Comparações = "+ordem4[i].getNumeroComparacoes());
        }
        System.out.println("--------------------------------------------------");
        
        ArvoreB[] ordem6 = new ArvoreB[10];
        for(int i = 0; i < 10; i++){
            ordem6[i] = new ArvoreB(6);
            int tamanho = (i+1) * 10000;
            for(int j = 1; j <= tamanho; j++){
                ordem6[i].insere(new Item(j));
            }
            ordem6[i].pesquisa(new Item(1000000));
            System.out.println("Ordem6 "+(i+1)+": Páginas = "+ordem6[i].getPaginasVisitadas()+" Comparações = "+ordem6[i].getNumeroComparacoes());
        }
        System.out.println("--------------------------------------------------");
    }
}

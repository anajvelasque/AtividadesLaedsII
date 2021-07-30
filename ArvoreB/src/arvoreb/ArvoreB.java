/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvoreb;

import Item.Item;

/**
 *
 * @author Ana Julia Velasque
 */
public class ArvoreB {
    private Pagina pagRaiz;
    private final int minimoRegistrosPagina, maximoRegistrosPagina;
    private boolean arvoreDesbalanceada;
    private Item regRetorno;
    private int paginasVisitadas;
    private int numeroComparacoes;
    
    //inicializa os atributos e raiz
    public ArvoreB (int qtdeminimaRegistros) {
        this.pagRaiz = null ;
        this.minimoRegistrosPagina = qtdeminimaRegistros;
        this.maximoRegistrosPagina = 2 * qtdeminimaRegistros;
        this.arvoreDesbalanceada = false ;
        this.regRetorno = new Item(-1);
        paginasVisitadas = 0;
        numeroComparacoes = 0;
    }
    
    private static class Pagina{
        int numeroCorrenteItens; 
        Item itensPagina[]; 
        Pagina paginasFilhas[];
        public Pagina(int qtdemaximaRegistros){
            this.numeroCorrenteItens = 0;
            this.itensPagina = new Item[qtdemaximaRegistros];
            this.paginasFilhas = new Pagina [qtdemaximaRegistros + 1];
        }
    }
    
    private void insereNaPagina(Pagina paginaAtual, Item registro, Pagina filhaDireita){
        int k = paginaAtual.numeroCorrenteItens - 1;
        while((k>= 0) && (registro.compara(paginaAtual.itensPagina[k]) < 0)){
            paginaAtual.itensPagina[k+1] = paginaAtual.itensPagina[k];
            paginaAtual.paginasFilhas[k + 2] = paginaAtual.paginasFilhas[k + 1];
            k--;
        }
        paginaAtual.itensPagina[k + 1] = registro ;
        paginaAtual.paginasFilhas[k + 2] = filhaDireita ;
        paginaAtual.numeroCorrenteItens ++;
    }
    
    public void insere(Item reg){
        Pagina retorno = insere(reg, pagRaiz);
        if(arvoreDesbalanceada){
            Pagina temp = new Pagina(maximoRegistrosPagina);
            temp.itensPagina[0] = regRetorno;
            temp.paginasFilhas[0] = this.pagRaiz;
            temp.paginasFilhas[1] = retorno;
            this.pagRaiz = temp;
            this.pagRaiz.numeroCorrenteItens++;
        }
        else{
            this.pagRaiz = retorno;
        }
    }
    
    //faz a inserção do registro na árvore
    private Pagina insere (Item registro,Pagina paginaAtual) {
        Pagina paginaRetorno = null ;
        if (paginaAtual == null) {
            arvoreDesbalanceada = true ;
            regRetorno = registro ;
        }else {
            int i = 0;
            while ((i < paginaAtual.numeroCorrenteItens - 1) && registro.compara(paginaAtual.itensPagina[i]) > 0) {
                i ++;
            }
            if(registro.compara(paginaAtual.itensPagina[i]) == 0) {
                //System.out.println ("Erro : Registro já existente ") ;
                arvoreDesbalanceada = false ;
            } else {
                if (registro.compara(paginaAtual.itensPagina[i]) > 0) {
                    i ++;
                }
                paginaRetorno = insere (registro, paginaAtual.paginasFilhas[i]) ;
                if (arvoreDesbalanceada) {
                    if(paginaAtual.numeroCorrenteItens < this.maximoRegistrosPagina) {
                        this.insereNaPagina(paginaAtual, regRetorno, paginaRetorno);
                        arvoreDesbalanceada = false;
                        paginaRetorno = paginaAtual;
                    }
                    else {
                        Pagina apTemp = new Pagina ( this . maximoRegistrosPagina ) ;
                        apTemp . paginasFilhas [0] = null ;
                        if ( i <= this . minimoRegistrosPagina ) {
                            this . insereNaPagina ( apTemp , paginaAtual . itensPagina [ this
                            . maximoRegistrosPagina - 1] , paginaAtual . paginasFilhas [ this
                            . maximoRegistrosPagina ]) ;
                            paginaAtual.numeroCorrenteItens --;
                            this . insereNaPagina ( paginaAtual , regRetorno ,
                            paginaRetorno ) ;
                        } else {
                            this . insereNaPagina ( apTemp , regRetorno , paginaRetorno ) ;
                        }
                        for (int j = this . minimoRegistrosPagina + 1; j < this .
                            maximoRegistrosPagina ; j ++) {
                            this . insereNaPagina ( apTemp , paginaAtual . itensPagina [ j ] ,
                            paginaAtual . paginasFilhas [ j + 1]) ;
                            paginaAtual . paginasFilhas [ j + 1] = null ;
                        }
                        paginaAtual . numeroCorrenteItens = this . minimoRegistrosPagina ;
                        apTemp . paginasFilhas [0] = paginaAtual . paginasFilhas [ this .
                        minimoRegistrosPagina + 1];
                        regRetorno = paginaAtual . itensPagina [ this . minimoRegistrosPagina ];
                        paginaRetorno = apTemp ;
                    }
                }
            }
        }
        return ( arvoreDesbalanceada ? paginaRetorno : paginaAtual ) ;
    }
    
    public Item pesquisa(Item reg){
        this.numeroComparacoes = 0;
        this.paginasVisitadas = 0;
        return pesquisa(reg, pagRaiz);
    }
    
    private Item pesquisa(Item reg, Pagina ap){
        if(ap == null)
            return new Item(-1);
        int i = 0;
        this.paginasVisitadas++;
        while((i < ap.numeroCorrenteItens -1) && (reg.compara(ap.itensPagina[i]) > 0)){
            this.numeroComparacoes++;
            i++;
        }
        if(reg.compara(ap.itensPagina[i]) == 0){
            this.numeroComparacoes++;
            return ap.itensPagina[i];
        }                
        else if(reg.compara(ap.itensPagina[i]) < 0){
            this.numeroComparacoes++;
            return pesquisa(reg, ap.paginasFilhas[i]);
        }                
        else{
            this.numeroComparacoes++;
            return pesquisa(reg, ap.paginasFilhas[i+1]);
        }
    }
    
    //retorna o número de páginas visitadas ao pesquisar
    public int getPaginasVisitadas(){
        return this.paginasVisitadas;
    }
    
    //obtém a quantidade de comparações necessárias para encontrar uma chave ou determinar que ela não está na árvore
    public int getNumeroComparacoes(){
        return numeroComparacoes;
    }
    
}

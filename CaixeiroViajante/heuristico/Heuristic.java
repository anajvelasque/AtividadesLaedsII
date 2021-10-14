import java.util.ArrayList;
import java.util.Stack;

// https://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/

public class Heuristic {

    private int[][] matrizDeAdjacencia;
    private int tamanho;
    MST mst = new MST();

    public Heuristic(int[][] matrizDeAdjacencia, int size) {
        this.matrizDeAdjacencia = matrizDeAdjacencia;
        this.tamanho = size;
    }

    private class MST {

        int pai[];
        int chave[];

        private int minKey(int chave[], Boolean mstSet[]) {
        	//Inicializa o valor minimo
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < tamanho; v++) {
                if (mstSet[v] == false && chave[v] < min) {
                    min = chave[v];
                    min_index = v;
                }
            }

            return min_index;
        }
        
        private void primMST(int grafo[][]) {
        	//Array para o MST
            pai = new int[tamanho];
            //Valores chaves para pegar o menor peso
            chave = new int[tamanho];
            //Para representar os vertices não incluidos no MST ainda
            Boolean mstSet[] = new Boolean[tamanho];
            //Inicializa todas as chaves como infinito 
            for (int i = 0; i < tamanho; i++) {
                chave[i] = Integer.MAX_VALUE;
                mstSet[i] = false;
            }
            
            chave[0] = 0; //Setando a chave como zero para selecionar o primeiro vertice
            pai[0] = -1;
            //MST vai ter V vertices
            for (int count = 0; count < tamanho - 1; count++) {
            	//Pegando chave minima
                int u = minKey(chave, mstSet);
                //Adicionando vertice selecionado
                mstSet[u] = true;
                //Atualizando valor da chave e index do pai do adjacente
                for (int v = 0; v < tamanho; v++)
                {
                    if (grafo[u][v] != 0 && mstSet[v] == false
                            && grafo[u][v] < chave[v]) {
                        pai[v] = u;
                        chave[v] = grafo[u][v];
                    }
                }
            }
        }
    }

    public void calculaHeuristica() {
    	//Calcula AGM na matriz
        this.mst.primMST(matrizDeAdjacencia);

        ArrayList<Integer> listaAdj[] = (ArrayList<Integer>[]) new ArrayList[tamanho];
        int i;
        for (i = 0; i < tamanho; i++) {
            if (listaAdj[i] == null) {
                listaAdj[i] = new ArrayList<>();
            }
            if (this.mst.pai[i] != -1) {
                listaAdj[i].add(this.mst.pai[i]);
                if (listaAdj[this.mst.pai[i]] == null) {
                    listaAdj[this.mst.pai[i]] = new ArrayList<>();
                }
                listaAdj[this.mst.pai[i]].add(i);
            }
        }
        
        int start = 1;
        //Encontra o primeiro verice
        for (i = 0; i < tamanho; i++) {
            if (listaAdj[i].size() == 1) {
                start = i;
            }
        }

        boolean cidadeVisitada[] = new boolean[tamanho];

        int cidade = start;
        cidadeVisitada[start] = true;
        int custo = 0;
        int cidadesVisitadas = 1;
        
        Stack<Integer> caminho = new Stack();
        caminho.push(cidade);
        
        while (cidadesVisitadas <= tamanho) {
            boolean cidadeEncontrada = false;
            for (int c : listaAdj[cidade]) {
                if (cidadeVisitada[c]) {
                    continue;
                }
                cidadesVisitadas++;
                cidadeVisitada[c] = true;
                custo += matrizDeAdjacencia[cidade][c];
                cidade = c;
                cidadeEncontrada = true;
                caminho.push(cidade);
            }
            if (!cidadeEncontrada) {
                if (caminho.empty()) {
                    System.out.println("Numero final de cidades: " + cidadesVisitadas);
                    System.out.println("Custo final: " + custo);
                    break;
                }
                
                int cidadeAnterior = caminho.pop();
                if (cidadeAnterior == cidade) {
                    cidadeAnterior = caminho.pop();
                }
                cidade = cidadeAnterior;
            }
        }
    }
}
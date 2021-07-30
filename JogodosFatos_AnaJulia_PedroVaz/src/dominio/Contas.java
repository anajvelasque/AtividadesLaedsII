
package dominio;

import java.util.Random;

/**
 *
 * @author anajv
 */
public final class Contas {
    
    private int vetorOperadores[];
    private char vetorOp[];
    private int resultado; 
    private Random gerador;
    private char opEscolhida;
    
    public Contas(){
        vetorOperadores = new int[2];
        vetorOp = new char[3];
        vetorOp[0] = '+';
        vetorOp[1] = '-';
        vetorOp[2] = '*';
        gerador = new Random();
        geraValores();
    }
    
    public void geraValores(){
        
        vetorOperadores[0] = Math.abs(gerador.nextInt()%1000);
        vetorOperadores[1] = Math.abs(gerador.nextInt()%1000);
        
        opEscolhida = vetorOp[Math.abs((gerador.nextInt()%3))];
        
        if(vetorOperadores[0] < vetorOperadores[1]){
            int aux = vetorOperadores[0];
            vetorOperadores[0] = vetorOperadores[1];
            vetorOperadores[1] = aux;
        }
        
        if(opEscolhida == '+')
            this.resultado = (vetorOperadores[0] + vetorOperadores[1]);
        
        if(opEscolhida == '-')
            this.resultado = (vetorOperadores[0] - vetorOperadores[1]);
        
        if(opEscolhida == '*')
            this.resultado = (vetorOperadores[0] * vetorOperadores[1]);
        
    }
    
    public int[] getOperadores(){
        return vetorOperadores;
    }
    
    public int getResultado(){
        return resultado;
    }
    
    public char getOpEscolhida(){
        return opEscolhida;
    }
}

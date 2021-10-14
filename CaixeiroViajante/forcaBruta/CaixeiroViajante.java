import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CaixeiroViajante {
	private Grafo grafo;
	
	public CaixeiroViajante(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public ArrayList<ArestaDirecionada> resolcao_forcaBruta(){
		HashMap<Vertice, Boolean> verticesVisitados = new HashMap<Vertice, Boolean>();
		ArrayList<ArestaDirecionada> caminhoCaixeiero = new  ArrayList<ArestaDirecionada>();
		
		HashSet<Vertice> vertices = grafo.getVertices();
		Iterator<Vertice> iteratorVertices = vertices.iterator();
		
		// Preenche vertices como nao visitados
		Vertice verticeInicial = iteratorVertices.next();
		verticesVisitados.put(verticeInicial, false);
		while (iteratorVertices.hasNext()) {
			verticesVisitados.put(iteratorVertices.next(), false);
		}
		
		return this.resolcao_forcaBruta(verticeInicial, verticeInicial, verticesVisitados, caminhoCaixeiero);
	}
	
	private ArrayList<ArestaDirecionada> resolcao_forcaBruta(Vertice verticeOrigem, Vertice verticeAtual, HashMap<Vertice, Boolean> verticesVisitados, ArrayList<ArestaDirecionada> caminhoCaixeiero){
		
		// Verifica se todos os vertices foram visitados
		if( !verticesVisitados.containsValue(false) && verticeOrigem.equals(verticeAtual) ) {
			return caminhoCaixeiero;
		}
		
		ArrayList<ArestaDirecionada> melhorCaminho = null;
		
		HashSet<ArestaDirecionada> possiveisCaminhos = grafo.getArestaQuePartemDoVertice(verticeAtual);
		Iterator<ArestaDirecionada> iteratorPossiveisCaminhos = possiveisCaminhos.iterator();
		while (iteratorPossiveisCaminhos.hasNext()) {
			ArestaDirecionada arestaAtual = iteratorPossiveisCaminhos.next();
			
			if ( verticesVisitados.get(arestaAtual.destino) == false ) {
				HashMap<Vertice, Boolean> verticesVisitados_clone = (HashMap<Vertice, Boolean>) verticesVisitados.clone();
				verticesVisitados_clone.put(arestaAtual.destino, true);
				
				ArrayList<ArestaDirecionada> caminhoCaixeiero_clone = (ArrayList<ArestaDirecionada>) caminhoCaixeiero.clone();
				caminhoCaixeiero_clone.add(arestaAtual);
				
				ArrayList<ArestaDirecionada> caminhoAtual = this.resolcao_forcaBruta(verticeOrigem, arestaAtual.destino, verticesVisitados_clone, caminhoCaixeiero_clone);
				
				if (melhorCaminho == null) {
					melhorCaminho = caminhoAtual;
				} else if (melhorCaminho != null && caminhoAtual != null) {
					if (pesoDeUmCaminho(caminhoAtual) < pesoDeUmCaminho(melhorCaminho)) {
						melhorCaminho = caminhoAtual;
					}
				}
				
			}
		}
		
		return melhorCaminho;
	}
	
	private int pesoDeUmCaminho(ArrayList<ArestaDirecionada> caminho) {
		int peso = 0;
		for(int indiceAresta = 0; indiceAresta < caminho.size(); indiceAresta++) {
			peso += caminho.get(indiceAresta).peso;
		}
		
		return peso;
	}
	
	

}

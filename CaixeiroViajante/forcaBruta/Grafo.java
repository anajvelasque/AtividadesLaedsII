
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Grafo {
	public HashSet<Vertice> vertices;
	public HashSet<ArestaDirecionada> arestas;

	public Grafo(HashSet<ArestaDirecionada> arestas) {
		this.vertices = new HashSet<Vertice>();
		this.arestas = new HashSet<ArestaDirecionada>();
		this.arestas = arestas;

		// Extrai vertices
		ArrayList<ArestaDirecionada> arrayArestas = new ArrayList<ArestaDirecionada>(this.arestas);
		for (int i = 0; i < arrayArestas.size(); i++) {
			this.vertices.add(arrayArestas.get(i).origem);
			this.vertices.add(arrayArestas.get(i).destino);
		}
	}
	
	public Grafo(Integer [][] matrizAdjacencia, ArrayList<Vertice> relacaoIndiceVertice) {
		this.vertices = new HashSet<Vertice>();
		this.arestas = new HashSet<ArestaDirecionada>();
		this.interpretarMatrizDeAdjacencia(matrizAdjacencia, relacaoIndiceVertice);
	}
	
	private void interpretarMatrizDeAdjacencia(Integer [][] matrizAdjacencia, ArrayList<Vertice> relacaoIndiceVertice) {
		// Extrai vertices
		for(int i = 0; i < matrizAdjacencia.length; i++) {
			this.vertices.add(relacaoIndiceVertice.get(i));
		}

		// Aresta na matriz: [origem][destino]
		// Extrai arestas
		for(int linha = 0; linha < matrizAdjacencia.length; linha++) {
			Vertice vertice1 = relacaoIndiceVertice.get(linha);
			for(int coluna = 0; coluna < matrizAdjacencia.length; coluna++) {
				
				int peso = matrizAdjacencia[linha][coluna];
				if (peso > 0) {
					Vertice vertice2 = relacaoIndiceVertice.get(coluna);
					this.arestas.add(new ArestaDirecionada(vertice1, vertice2, peso));
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public HashSet<Vertice> getVertices() {
		return (HashSet<Vertice>) this.vertices.clone();
	}

	@SuppressWarnings("unchecked")
	public HashSet<ArestaDirecionada> getArestas() {
		return (HashSet<ArestaDirecionada>) this.arestas.clone();
	}

	public HashSet<ArestaDirecionada> getArestaQuePartemDoVertice(Vertice origem) {
		HashSet<ArestaDirecionada> arestasDoVertice = new HashSet<ArestaDirecionada>();

		Iterator<ArestaDirecionada> iteratorAresta = this.arestas.iterator();
		while (iteratorAresta.hasNext()) {
			ArestaDirecionada aresta = iteratorAresta.next();
			if (aresta.origem.equals(origem)) {
				arestasDoVertice.add(aresta);
			}
		}

		return arestasDoVertice;
	}

	public HashSet<ArestaDirecionada> getArestaQueChegamNoVertice(Vertice verticeDestino) {
		HashSet<ArestaDirecionada> arestasDoVertice = new HashSet<ArestaDirecionada>();

		Iterator<ArestaDirecionada> iteratorAresta = arestas.iterator();
		while (iteratorAresta.hasNext()) {
			ArestaDirecionada aresta = iteratorAresta.next();
			if (aresta.destino.equals(verticeDestino)) {
				arestasDoVertice.add(aresta);
			}
		}

		return arestasDoVertice;
	}

	
		
	
	
}

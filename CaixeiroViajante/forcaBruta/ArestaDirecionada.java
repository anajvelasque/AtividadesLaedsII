import java.util.HashSet;

public class ArestaDirecionada {
	public Vertice origem;
	public Vertice destino;
	public int peso;
	
	public ArestaDirecionada(Vertice vertice1, Vertice vertice2, int peso) {
		this.origem = vertice1;
		this.destino = vertice2;
		this.peso = peso;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof ArestaDirecionada) {
			ArestaDirecionada aresta = (ArestaDirecionada) o;
			if ( aresta.origem.equals(this.origem) && aresta.destino.equals(this.destino) ) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contemVertice(Vertice vertice) {
		if(origem.equals(vertice) || destino.equals(vertice)) {
			return true;
		}
		return false;
	}
	
	public boolean contemSomenteUmDosVerticesDaArvore(HashSet<Vertice> verticesDaArvore) {
		if(verticesDaArvore.contains(origem) && !verticesDaArvore.contains(destino)) {
			return true;
		} else if(verticesDaArvore.contains(destino) && !verticesDaArvore.contains(origem)) {
			return true;
		} else {
			return false;
		}
	}
	
}
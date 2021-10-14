
public class Vertice {
	public String idenficicacao;
	
	public Vertice(String identificacaoVertice) {
		this.idenficicacao = identificacaoVertice;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vertice) {
			Vertice vertice = (Vertice) obj;
			return vertice.idenficicacao.equals(this.idenficicacao);
		}
		return false;
	}
}

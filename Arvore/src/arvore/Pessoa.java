package arvore;

public class Pessoa {
	private String nome;
	private Pessoa mae;
	private Pessoa pai;
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	public Pessoa(String nome, Pessoa mae, Pessoa pai) {
		this.nome = nome;
		this.pai = pai;
		this.mae = mae;
	}
	
	@Override
	public boolean equals(Object pessoa) {
		
		if(pessoa instanceof Pessoa) {
			if( this.comparaNome( ( (Pessoa) pessoa).getNome()) ) {
				if( this.pai.comparaNome( ( (Pessoa) pessoa).getPai().getNome() ) && this.mae.comparaNome( ( (Pessoa) pessoa).getMae().getNome() ) )
					return true;
			}
		}
		
		return false;
	}
	
	public Pessoa getMae(){
		return this.mae;
	}
	
	public Pessoa getPai(){
		return this.pai;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void resetNome(String nome){
		this.nome = nome;
	}
	
	public void setMae(Pessoa mae){
		this.mae = mae;
	}
	
	public void setPai(Pessoa pai){
		this.pai = pai;
	}
	
	public Boolean comparaNome(String nome) {
		return this.nome.equalsIgnoreCase(nome);

	}
	
	public Boolean verificaIrmandade(Pessoa pessoa) {
		if( this.nome.equalsIgnoreCase(pessoa.getNome()) ) 
			return Boolean.FALSE;
				
		if( this.pai.getNome() != null && this.pai.getNome().equalsIgnoreCase(pessoa.getPai().getNome()) ) {
			if( this.mae.getNome() != null && this.mae.getNome().equalsIgnoreCase(pessoa.getMae().getNome()) )
				return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
	
	public Boolean verificaAncestralidade(Pessoa outraPessoa) {
		if(outraPessoa.getNome() == null)
			return Boolean.FALSE;
		
		/* Verifica se a outraPessoa é um dos pais */
		Boolean ehPai = Boolean.FALSE;
		Boolean ehMae = Boolean.FALSE;
		if(this.pai != null)
			ehPai = this.pai.comparaNome(outraPessoa.getNome() );
			
		if(this.mae != null)
			ehMae = this.mae.comparaNome(outraPessoa.getNome() );
		
		if(ehPai || ehMae) 
			return Boolean.TRUE;
		else if(this.mae != null && this.pai != null) 
			return ( mae.verificaAncestralidade(outraPessoa) || this.pai.verificaAncestralidade(outraPessoa) );
		else if(this.mae == null && this.pai != null) 
			return this.pai.verificaAncestralidade(outraPessoa);
		else if(this.mae != null && this.pai == null) 
			return this.mae.verificaAncestralidade(outraPessoa);
		
		return Boolean.FALSE; 
	}
	
}
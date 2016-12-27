import java.util.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;


public class Leilao {

	private String vendedor;
	private HashMap<Comprador, float> licitadores;
	private float preçoInicial;
	private float maxLicitacao;
	// acrescentar um float para a maxLicitacao 
	// acrescentar uma string para a licitação

	public Leilao() {
		vendedor = "";
		licitadores = new HashMap<Comprador, float>();
		preçoInicial = 0.0;
		maxLicitacao = 0.0;
	}

	public Leilao(int idleilao, HashMap<Comprador, float> licitadores, float preçoInicial, float maxLicitacao) {
		this.vendedor = vendedor;
		this.licitadores = licitadores.entrySet()
									  .stream()
									  .collect(toMap(e->e.getKey().clone(), e->e.getValue().clone()));
		this.preçoInicial = preçoInicial;
		this.maxLicitacao = maxLicitacao;
	}
	
	public Leilao(Leilao l) {
		this.idleilao = l.getId();
		this.licitadores = l.getLicitadores();
		this.preçoInicial = l.getInicial();
		this.maxLicitacao = l.getMaxLicitacao
	}

	public int getId() {
		return idleilao;
	}

	public Map<Comprador, int> getLicitadores() {
		return licitadores;
	}

	public float getInicial() {
		return preçoInicial;
	}

	public float getMaxLicitacao() {
		return maxLicitacao;
	}

	public void setId(int idleilao) {
		this.idleilao = idleilao;
	}

	public void setLicitadores(Map<Comprador, int> licitadores) {
		this.licitadores = licitadores;
	}

	public void setInicial(float preçoInicial) {
		this.preçoInicial = preçoInicial;
	}

	public void setMaxLicitacao(float maxLicitacao) {
		this.maxLicitacao = maxLicitacao;
	}

	public boolean equals(Object o) {
		if(this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		Leilao m = (Leilao) o;
		return (this.vendedor.equals(o.vendedor) &&
				this.preçoInicial == preçoInicial &&
				this.maxLicitacao == maxLicitacao);				
	}

	// toString()
	public String toString() {
		StringBuilder s = new StringBuilder("---|Leilao|---\n");
		s.append("Vendedor: " + this.getId() + "\n");
		s.append("Preço Inicial: " + this.getInicial() + "\n");
		s.append("Licitação Máxima: " + this.getMaxLicitacao()+"\n")
		return s.toString();
	}

	public Leilao clone(){
		return new Leilao(this);
	}


}
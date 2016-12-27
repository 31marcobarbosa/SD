import java.util.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;


public class Leilao {

	private int idleilao;
	private Map<Comprador, int> licitadores;
	private float preçoInicial;
	// acrescentar um float para a maxLicitacao 
	// acrescentar uma string para a licitação

	public Leilao() {
		idleilao = 0;
		licitadores = new HashMap<Comprador, int>();
		preçoInicial = 0.0;
	}

	public Leilao(int idleilao, Map<Comprador, int> licitadores, float preçoInicial) {
		this.idleilao = idleilao;
		this.licitadores = licitadores.entrySet()
									  .stream()
									  .collect(toMap(e->e.getKey().clone(), e->e.getValue().clone()));
		this.preçoInicial = preçoInicial;
	}
	
	public Leilao(Leilao l) {
		this.idleilao = l.getId();
		this.licitadores = l.getLicitadores();
		this.preçoInicial = l.getInicial();
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

	public void setId(int idleilao) {
		this.idleilao = idleilao;
	}

	public void setLicitadores(Map<Comprador, int> licitadores) {
		this.licitadores = licitadores;
	}

	public void setInicial(float preçoInicial) {
		this.preçoInicial = preçoInicial;
	}

	public boolean equals(Object o) {
		if(this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		Leilao m = (Leilao) o;
		return (this.idleilao == idleilao &&
				this.preçoInicial == preçoInicial);				
	}

	public String toString() {
		StringBuilder s = new StringBuilder("---|Leilao|---\n");
		s.append("Id: " + this.getId()+"\n");
		s.append("Preço Inicial: "+this.getInicial+"\n");
		return s.toString();
	}

	public Leilao clone(){
		return new Leilao(this);
	}
}
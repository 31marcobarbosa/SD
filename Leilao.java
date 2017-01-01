package trabSD;


import java.util.HashMap;
import java.util.Objects;

public class Leilao {

        private String vendedor;
        private HashMap<Comprador, Float> licitadores;
        private float preçoInicial;
        private float maxLicitacao;
        private int idleilao;
        private String maxLicitador;
        // acrescentar um float para a maxLicitacao 
        // acrescentar uma string para a licitação

        public Leilao() {
            vendedor = "";
            licitadores = new HashMap<Comprador, Float>();
            preçoInicial = (float) 0.0;
            maxLicitacao = (float) 0.0;
            maxLicitador = "";
        }

        public Leilao(int idleilao, HashMap<Comprador, Float> licitadores, float preçoInicial, float maxLicitacao,String maxLicitador) {
            this.vendedor = vendedor;
            this.licitadores = licitadores;
            this.preçoInicial = preçoInicial;
            this.maxLicitacao = maxLicitacao;
            this.maxLicitador = maxLicitador;
        }

        public Leilao(Leilao l) {
                this.idleilao = l.getId();
                this.licitadores = l.getLicitadores();
                this.preçoInicial = l.getInicial();
                this.maxLicitacao = l.getMaxLicitacao();
                this.maxLicitador = l.getMaxLicitador();
        }

    public void setMaxLicitador(String maxLicitador) {
        this.maxLicitador = maxLicitador;
    }

    public String getMaxLicitador() {
        return maxLicitador;
    }

        public int getId() {
            return idleilao;
        }

        public HashMap<Comprador, Float> getLicitadores() {
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

        public void setLicitadores(HashMap<Comprador, Float> licitadores) {
            this.licitadores = licitadores;
        }
        
        public void setInicial(float preçoInicial) {
            this.preçoInicial = preçoInicial;
        }

	public void setMaxLicitacao(float maxLicitacao) {
            this.maxLicitacao = maxLicitacao;
        }

    @Override
    public String toString() {
        return "Leilao{" + "vendedor=" + vendedor + ", licitadores=" + licitadores + ", pre\u00e7oInicial=" + preçoInicial + ", maxLicitacao=" + maxLicitacao + ", idleilao=" + idleilao + ", maxLicitador=" + maxLicitador + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Leilao other = (Leilao) obj;
        if (Float.floatToIntBits(this.preçoInicial) != Float.floatToIntBits(other.preçoInicial)) {
            return false;
        }
        if (Float.floatToIntBits(this.maxLicitacao) != Float.floatToIntBits(other.maxLicitacao)) {
            return false;
        }
        if (this.idleilao != other.idleilao) {
            return false;
        }
        if (!Objects.equals(this.vendedor, other.vendedor)) {
            return false;
        }
        if (!Objects.equals(this.maxLicitador, other.maxLicitador)) {
            return false;
        }
        if (!Objects.equals(this.licitadores, other.licitadores)) {
            return false;
        }
        return true;
    }


    
    public Leilao clone(){
        return new Leilao(this);
    }


}
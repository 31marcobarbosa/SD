
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;	

public class CasaLeiloes {

    private HashMap<String, Comprador> compradores; // Map com o username dos Compradores e as suas informações
    private HashMap<String, Vendedor> vendedores; // Map com o username dos Vendedores e as suas informações

    // Map que contem os leiloes ativos no momento
    private HashMap<String, Leilao> leiloesAtivos;

    // Lista de compradores que se encontram ativos em leilões
    private ArrayList<String> compradoresAtivos;

    // por o lock no inicio
    private Lock lock = new ReentrantLock();
    private int id=0;


    // construtores
    public CasaLeiloes () {
        this.compradores = new HashMap<>();
        this.vendedores = new HashMap<>();
        this.leiloesAtivos = new HashMap<>();
    }

    // getters
    public HashMap <String,Comprador> getCompradores () {
        return this.compradores;
    }

    public HashMap <String,Vendedor> getVendedores () {
        return this.vendedores;
    }

    public HashMap<String, Leilao> getLeiloesAtivos() {
        return leiloesAtivos;
    }

    public ArrayList<String> getCompradoresAtivos() {
        return compradoresAtivos;
    }
    // setters

    public void setCompradores(HashMap<String, Comprador> compradores) {
        this.compradores = compradores;
    }

    public void setVendedores(HashMap<String, Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public void setLeiloesAtivos(HashMap<String, Leilao> leiloesAtivos) {
        this.leiloesAtivos = leiloesAtivos;
    }

    public void setCompradoresAtivos(ArrayList<String> compradoresAtivos) {
        this.compradoresAtivos = compradoresAtivos;
    }
    
    // Registo de utilizadores
    public boolean registaComprador(String username, String password){
        boolean res = false;

        lock.lock();

        try{
            if(!this.compradores.containsKey(username)){

                Comprador c = new Comprador(username,password, false);
                this.compradores.put(username, c);
                res = true;
            }

            return res;

        }finally{

            lock.unlock();
        }

    }


    public boolean registaVendedor(String username, String password){
        boolean res = false;

        lock.lock();

        try{
            if(!this.vendedores.containsKey(username)){

                Vendedor c = new Vendedor(username,password, false);
                this.vendedores.put(username, c);
                res = true;
            }


            return res;

        }finally{

            lock.unlock();
        }
    }

    public String ConsultaLeilao () {
        String leiloes = "";
        for(Leilao l : leiloesAtivos.values()){
            leiloes = leiloes + l.toString();
        }
        return leiloes;
    }

    //Funções que verifica se o login efetuado é válido
    public boolean LoginComprador(String username, String password){
        boolean r = false;
        lock.lock();
        Comprador c = this.compradores.get(username);
        try{
            if(c != null){
            if(!c.getLogged() && this.compradores.containsKey(username)){
                if((c.getPassword().equals(password))) {
                    c.setLogged(true);
                    r = true;
                }
            }
            }
            return r;
        }finally{
            lock.unlock();
        }
    }

    public boolean LoginVendedor(String username, String password){
        boolean r = false;
        lock.lock();
        Vendedor v = this.vendedores.get(username);
        try{
            if(v != null){
            if(!v.getLogged() && this.vendedores.containsKey(username)){
                if((v.getPassword().equals(password))) {
                    v.setLogged(true);
                    r = true;
                }
            }
            }
            return r;
        }finally{
            lock.unlock();
        }
    }


    // funções sair logout
    public void logoutVendedor (String username){
        lock.lock();

        try {
            this.vendedores.get(username).setLogged(false);
        }
        finally {
            lock.unlock();
        }
    }


    public void logoutComprador (String nickname) {
        lock.lock ();

        try {
            this.compradores.get(nickname).setLogged(false);
        }
        finally {
            lock.unlock();
        }
    }
    public boolean atualizarLicitaçao(Comprador comprador, float licitacao, String vendedor) {
        boolean r = false;
        lock.lock();
        try {
            System.out.println("Actualizar");
            Leilao leilao = leiloesAtivos.get(vendedor);
            if (licitacao > leilao.getMaxLicitacao()) {
                leilao.setMaxLicitacao(licitacao);
                leilao.setMaxLicitador(comprador.getUsername());
                HashMap<Comprador, Float> licitadores = leilao.getLicitadores();
                licitadores.put(comprador, licitacao);
                leilao.setLicitadores(licitadores);
                //leilao.getLicitadores().replace(username, leilao.getLicitadores().get(username), licitacao);
                                        /*replace(Object key, Object oldValue, Object newValue) */
            }
            r = true;
            return r;
        } finally {
            lock.unlock();
        }
    }
    
    public void IniciaLeilao(String vendedor, float pInicial, float max) {
        lock.lock();
        
        try{
            HashMap<Comprador, Float> licitadores = new HashMap<>();
            System.out.println(vendedor);
            Leilao leilao = new Leilao(id, licitadores, pInicial, max, "", vendedor);
            leilao.toString();
            leiloesAtivos.put(vendedor, leilao);
            id++;
        }finally{
            lock.unlock();
        }
    }
    
    public boolean FinalizarLeilao(String vendedor) {
        boolean r = false;
        lock.lock();
        Leilao l = leiloesAtivos.get(vendedor);
        try{
            for(Comprador c : l.getLicitadores().keySet()){
                c.send("o leilão terminou! O vencedor é: " + l.getMaxLicitador());
            }
            leiloesAtivos.remove(vendedor);
            r = true;
            return r;
        }finally{
            lock.unlock();
        }
    }
    
    public boolean FazLicitaçao(Float valor, int id_leilao, Comprador comprador) {
        boolean r = false;
        lock.lock();
        try{
        Leilao leilao = null;
        System.out.println("Estou aqui");
        String vendedor = "";
        for(Leilao l: this.leiloesAtivos.values()){
            if(l.getId() == id_leilao){
                leilao = l;
                break;
            }
        }
        vendedor = leilao.getVendedor();
        if(!vendedor.equals(""))
            r = atualizarLicitaçao(comprador, valor, vendedor);
        return r;
        }finally{
            lock.unlock();
        }
    }
    
    public boolean EscolheLeilao(int id_leilao) {
        boolean r = false;
        for(Leilao l : this.leiloesAtivos.values()) {
            if(l.getId() == id_leilao) r = true;
        }
        
        return r;
    }
}
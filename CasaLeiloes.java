package trabSD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
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


    // construtores
    public CasaLeiloes () {
        this.compradores = new HashMap<>();
        this.vendedores = new HashMap<>();
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

    //Funções que verifica se o login efetuado é válido
    public boolean LoginComprador(String username, String password){
        boolean r = false;
        lock.lock();
        try{
            if(!this.compradores.get(username).getLogged() && this.compradores.containsKey(username)){
                if((this.compradores.get(username).getPassword().equals(password))) {
                    this.compradores.get(username).setLogged(true);
                    r = true;
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
        try{
            if(!this.compradores.get(username).getLogged() && this.compradores.containsKey(username)){
                if((this.compradores.get(username).getPassword().equals(password))) {
                    this.compradores.get(username).setLogged(true);
                    r = true;
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
    
    public boolean IniciaLeilao(String vendedor, float pInicial, float max) {
        boolean r = false;
        lock.lock();
        
        try{
            HashMap<Comprador, Float> licitadores = new HashMap<>();
            Leilao leilao = new Leilao(leiloesAtivos.size(), licitadores, pInicial, max, null);
            leiloesAtivos.put(vendedor, leilao);
            r = true;
            return r;
        }finally{
            lock.unlock();
        }
    }
    
    public boolean FinalizarLeilao(String vendedor) {
        boolean r = false;
        lock.lock();
        try{
            leiloesAtivos.remove(vendedor);
            r = true;
            return r;
        }finally{
            lock.unlock();
        }
    }
    
    public boolean FazLicitaçao(Float valor, String vendedor, Comprador comprador) {
        boolean r = false;
        lock.lock();
        try{
            r = atualizarLicitaçao(comprador, valor, vendedor);
            return r;
        }finally{
            lock.unlock();
        }
    }
}
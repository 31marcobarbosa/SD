package trabSD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;	

public class CasaLeiloes {

    private HashMap<String, Comprador>  compradores; // Map com o username dos Compradores e as suas informações
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

    public HashMap <String,Comprador> getVendedores () {
        return this.vendedores;
    }


    // setters
    public void setCompradores (HashMap<String,Comprador> c){
        this.compradores = c;
    }

    public void setCompradores (HashMap<String,Vendedor> v){
        this.vendedores = v;
    }



    // Registo de utilizadores
    public boolean registaUtilizadorPassageiro(String username, String password){
        boolean res = false;

        lock.lock();

        try{
            if(!this.compradores.containsKey(username)){

                Comprador c = new Comprador(username,password);
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

                Vendedor c = new Vendedor(username,password);
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

                if((this.compradores.get(username).getPassword().equals(password)) {

                    this.compradores.get(username).getLogged(true);
                    r = true;
                }
            }

            return r;
            
        }finally{
            
            lock.unlock();
        }

    public boolean LoginVendedor(String username, String password){
        boolean r = false;
        
        lock.lock();
        
        try{
            if(!this.compradores.get(username).getLogged() && this.compradores.containsKey(username)){

                if((this.compradores.get(username).getPassword().equals(password)) {

                    this.compradores.get(username).getLogged(true);
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
            this.compradores.get(nickname).setAtivo(false);
        }
        finally {
            lock.unlock();
        }

    }
}
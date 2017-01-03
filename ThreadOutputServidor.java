
import java.io.*;
import java.net.*;
import java.util.concurrent.locks.*;

public class ThreadOutputServidor extends Thread {
    private ReentrantLock lock;
    private Condition cn;
    private PrintWriter pwt;
    private BufferedReader br;
    private Mensagem mensagem;


    public ThreadOutputServidor(BufferedReader br, ReentrantLock lock, Condition cn, PrintWriter pwt, Mensagem mensagem){
        this.lock = lock;
        this.cn = cn;
        this.pwt = pwt;
        this.br = br;
        this.mensagem = mensagem;
    }


    public void run () {
        lock.lock();

        try{
            String input;
            while(true){
            input = mensagem.getMsg();
            if (input.equals("Logout") || input.equals("Utilizador já logado") || input.equals("Utilizador já registado") || input.equals("Erro") || input.equals("Sair"))
                break;
            pwt.println(input);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            lock.unlock();
        }
    	
    	
    }


}
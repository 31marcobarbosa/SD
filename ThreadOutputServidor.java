package trabSD;

import java.io.*;
import java.net.*;
import java.util.concurrent.locks.*;

public class ThreadOutputServidor extends Thread {
	private BufferedReader br;
    private Menu menu;
    private ReentrantLock lock;
    private Condition cn;
    private PrintWriter pwt;


    public ThreadOutputCliente(BufferedReader br, Menu menu, ReentrantLock lock, Condition cn){
        this.br = br;
        this.menu = menu;
        this.lock = lock;
        this.cn = cn;
    }


    public void run () {
        lock.lock();

        try{
            String input;

            while (true) {
                while ((input = br.readLine()) == null)
                    cn.await();
                if (input.equals("Sair"))
                    break;
                pws.println(input);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            lock.unlock();
        }
    	
    	
    }


}
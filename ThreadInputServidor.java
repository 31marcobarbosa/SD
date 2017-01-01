package trabSD;

import java.io.*;
import java.net.*;
import java.util.concurrent.locks.*;

public class ThreadInputServidor extends Thread {
	private Sockect s;
	private CasaLeiloes cs;
	private PrintWriter output;
	private Cliente menu;
	private BufferedReader br;
	private ReentrantLock lock;
	private Condition cn;


	public ThreadInputServidor (Socket cliente, CasaLeiloes cs, ReentrantLock lock, Condition cn, Cliente menu){
        try{
            this.s = cliente;
            this.cs = cs;
            this.output = new PrintWriter(s.getOutputStream(), true);
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.lock = lock;
            this.cn = cn;
            this.menu = menu;
         }catch(IOException e){
            System.out.println(e.getMessage());
         }
    }	

    

    public void run () {

    	try{ }

    	catch(Exception e){ 	
    		 System.out.println(e.getMessage());	
    	}
    }



    private void clear() {
    	for (int i=0;i<50;i++){
    		System.out.println();
    	}
    }



}
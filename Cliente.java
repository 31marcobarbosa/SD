

import java.io.*;
import java.net.*; 
import java.util.concurrent.locks.*;

public class Cliente{

	static public void main (String[] args) throws InterruptedException{
		ReentrantLock lock = new ReentrantLock();
		Condition cn = lock.newCondition();

		try{
			Socket c = new Socket("localhost", 6062); // Siga ligar-me ao Socket
			BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream())); // Vou ler do Socket
			//PrintWriter count = new PrintWriter(c.getOutputStream(),true);				// Vou escrever para o socket
			String input;
			Menu menu = new Menu();
			ThreadInputCliente clienteInput = new ThreadInputCliente(c, lock, cn, menu);
			ThreadOutputCliente clienteOutput = new ThreadOutputCliente(br, menu, lock, cn);

			clienteInput.start();
			clienteOutput.start();
			clienteInput.join();
			clienteOutput.join();

			br.close();
			System.out.println("A sair ..");
			c.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
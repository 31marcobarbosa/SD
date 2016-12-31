import java.io.*;
import java.net.*;

public class Handler implements Runnable {
	private final Socket s;
	private final CasaLeilões cs;
	private ObjectInputStream input;
	private PrintWriter output;

	public Handler (Socket cliente, CasaLeilões cs){
		this.s = cliente;
		this.cs = cs;
		this.input = null;
		this.output = null;
	}



	public void run () throws Exception{
		do{
			this.input = new ObjectInputStream(s.getInputStream());
			this.output = new PrintWriter(s.getOutputStream());

			EnviaAcoes ea = input.readObject();

			if ea.getAccao(),equals(Servidor.RegistarVendedor);










		}

		
	}



}
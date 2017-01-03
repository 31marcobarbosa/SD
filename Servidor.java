import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Servidor {
	private static int port = 6062;
        
	public static void main (String args[]) throws IOException  {
        Socket s;
		CasaLeiloes k = new CasaLeiloes();
        ReentrantLock lock = new ReentrantLock();

		// Exemplos de vários utilizadores
		// falta definir estas funções
		k.registaVendedor ("vend1","passvend1");
		k.registaVendedor ("vend2","passvend2");
		k.registaVendedor ("vend2","passvend2");
		k.registaVendedor ("vend2","passvend2");
		k.registaVendedor ("vend2","passvend2");

		k.registaComprador ("comp1","passcomp1");
		k.registaComprador ("comp2","passcomp2");
		k.registaComprador ("comp3","passcomp3");
		k.registaComprador ("comp4","passcomp4");
		k.registaComprador ("comp5","passcomp5");

// por esta parte a funcionar
		try{
		ServerSocket ss = new ServerSocket (port);
		while ((s=ss.accept()) != null) {
			        Mensagem mensagem = new Mensagem();
                    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    PrintWriter input = new PrintWriter(s.getOutputStream(),true);
                    Condition cn = lock.newCondition();
                    System.out.println("Entrou no servidor\n");

                    ThreadInputServidor tis = new ThreadInputServidor(br, s, k, lock, cn, input, mensagem);
                    ThreadOutputServidor tos = new ThreadOutputServidor(br, lock, cn, input, mensagem);

                    tis.start();
                    tos.start();
			// criar duas threads uma para leitura e outra para escrita
		}
		ss.close();
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
	}
}
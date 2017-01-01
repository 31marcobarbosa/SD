package trabSD;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private static int port = 6062;
	// private static (classe principal)  k = null


	// Ações do vendedor
	public static final String REGISTAR_VENDEDOR = "RegistarVendedor";
	public static final String LOGAR_VENDEDOR = "LogarVendedor";
	public static final String SAIR_VENDEDOR = "SairVendedor";
	public static final String INICIAR_LEILAO_VEND = "IniciarLeilaoVendedor";
	public static final String FINALIZAR_LEILAO_VEND = "FinalizarLeilaoVendedor";
	public static final String NOME_VENDEDOR = "NomeVendedor";
	public static final String PASS_VENDEDOR = "PassVendedor";
	//public static final String CONSULTAR_LEILAO_VEND = "ConsultarLeilaoVendedor";

	// Ações do Comprador
	public static final String REGISTAR_COMPRADOR = "RegistarComprador";
	public static final String LOGAR_COMPRADOR = "LogarComprador";
	public static final String SAIR_COMPRADOR = "SairComprador";
	public static final String FAZER_LICITACAO_COMP = "FazerLicitaçãoComprador";
	public static final String NOME_COMPRADOR = "NomeComprador";
	public static final String PASS_COMPRADOR = "PassComprador";



	public static void main (String args[]) throws IOException  {
		ServerSocket ss = new ServerSocket (port);

		CasaLeiloes k = new CasaLeiloes();

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
		while (true) {
			Socket cliente = ss.accept();
			System.out.println("Entrou no servidor\n");

			//new Thread(new Handler(cliente k)).start();
			// criar duas threads uma para leitura e outra para escrita
		}





	}





}
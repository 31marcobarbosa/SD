package trabSD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

	// vai possuir o Sockect e os menus
	private static int port = 6666;
	private static String local = "localhost";
	private static Socket clienteSocket;

	private static Scanner in = new Scanner (System.in);
	public static ObjectOutputStream o = null;
	public static ObjectInputStream i = null;
	public static HashMap <String,String> enviahash;
	public static String nickname = null;
        public static EnviaAcoes ea;


	public static void main (String args[]) throws Exception{
		clienteSocket = new Socket (local,port);
		
		menuIdentUtilizador();
	}


	public static String menuInicial(){

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> LEILÕES <<<<<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Comprador                                        #");
        System.out.println("#   2 - Vendedor                                         #");
        System.out.println("#   3 - Sair                                             #");
		System.out.println("#                                                        #");
		System.out.println("#   Escolha uma opção:                                   #");
		System.out.println("##########################################################");

        String op = in.next();

        if ( !(op.equals("1") || op.equals("2") || op.equals("3")))
				op = menuInicial();

        return op;
    }


    public static void menuIdentUtilizador() throws IOException,ClassNotFoundException{
    	String op;
    	op = menuInicial();

    	do{
    		if (op.equals("1")){
    			menuRegComprador();
    		}
    		else {
    			if (op.equals("2")) {
    				menuRegVendedor();
    			}
    			else {
    				if (op.equals("3")){
    					System.exit(0);
    				}
    			} 
    		}
    	}
    	while (true);
    }


	public static String menuLoginComprador(){
    	String op;

    	System.out.println(">>>>>>>>>>>>>>>>>>>> MENU COMPRADOR <<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Entrar                                           #");
        System.out.println("#   2 - Registar                                         #");
        System.out.println("#   0 - Sair                                             #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");
        op = in.next();

          
	      if ( !(op.equals("1") || op.equals("2") || op.equals("0"))) {
    	        op = menuLoginComprador();
       		 }
    
        return op;
      }  
    


    public static String menuLoginVendedor(){
        String op;

        System.out.println("################## MENU VENDEDOR ###################");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Entrar                                           #");
        System.out.println("#   2 - Registar                                         #");
        System.out.println("#   0 - Sair                                             #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");
        op = in.next();

        if ( !(op.equals("1") || op.equals("2") || op.equals("0")))
            op = menuLoginVendedor();

        return op;
    }  



	public static void menuPrincipalComprador() throws IOException, ClassNotFoundException {

		System.out.println("############## Menu Principal Comprador #################");
        System.out.println("#                                                        #");
        System.out.println("#   "  +  nickname  );
        System.out.println("#                                                        #");
        System.out.println("#   1 - Escolhe Leilão a Participar(Licitação)           #");
        System.out.println("#   2 - Consultar Leilão                                 #");
        System.out.println("#   3 - Logout                                           #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção                                    #");
        System.out.println("##########################################################");
        String op = in.next();

           do {
               if(op.equals("1")){
                   menuEscolheLeilao();
                }    
            	if(op.equals("2")) {
                   // função consultar leilao 
                if (op.equals("3")) {
                    logoutComprador();
                }
               }else{
               	System.out.println("Opcão inválida!");
               	menuPrincipalComprador();
           		}
        	} while(!(op.equals("1") || op.equals("2") || op.equals("3")));
      	}


	public static void menuEscolheLeilao() throws IOException, ClassNotFoundException{
	// NÃO ESTOU A VER COMO FAZER O MENU E A PARTE DE
	// ESCOLHER O LEILÃO , NÃO SEI COMO ELE A PARTIR DO
	// MENU VAI COSNEGUIR ESCOLHER UM LEILÃO ATIVO PARA 
	// LICITAR.
	}

	public static void menuPrincipalVendedor() throws IOException, ClassNotFoundException {

		System.out.println("############## Menu Principal Vendedor #################");
        System.out.println("#                                                        #");
        System.out.println("#   "  +  nickname  );
        System.out.println("#                                                        #");
        System.out.println("#   1 - Inicia Leilão                                    #");
        System.out.println("#   2 - Finaliza Leilão                                  #");
        System.out.println("#   3 - Consultar Leilão                                 #");
        System.out.println("#   4 - Logout                                           #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção                                    #");
        System.out.println("##########################################################");
        String op = in.next();

           do {
               if(op.equals("1")){
                   menuIniciaLeilao();
                }    
            	if(op.equals("2")) {
                   menuFininalizaLeilao();
               }
                if (op.equals("3")){
                	// função de consulta de leilão
                }
                if (op.equals("4")){
                    logoutVendedor();
                }
               else{
               	System.out.println("Opcão inválida!");
               	menuPrincipalComprador();
           		}
        	} while(!(op.equals("1") || op.equals("2") || op.equals("3") || op.equals("4")));
    }

     public static String menuVendLeilao(){

        System.out.println(">>>>>>>>>>>>>>>>>> MENU LEILÃO VENDEDOR  <<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Terminar Leilão                                  #");
        System.out.println("#   0 - Terminar Sessão                                  #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");

        String op = in.next();

        if ( !(op.equals("1") || op.equals("0")))
                op = menuVendLeilao();
        return op;
    }



    public static String menuCompLeilao(){

        System.out.println(">>>>>>>>>>>>>>>>>> MENU LEILÃO COMPRADOR  <<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Licitar Leilão                                   #");
        System.out.println("#   0 - Terminar Sessão                                  #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");

        String op = in.next();

        if ( !(op.equals("1") || op.equals("0")))
                op = menuVendLeilao();
        return op;
    }


    

	// falta fazer menuIniciaLeilao() , menuFinalizaLeilao() e menuEscolheLeilao()

	private static void logoutComprador() throws IOException, ClassNotFoundException {
    	enviahash = new HashMap<>();
        enviahash.put(Servidor.NOME_COMPRADOR, nickname);

        ea = new EnviaAcoes(Servidor.SAIR_COMPRADOR,enviahash);

        o = new ObjectOutputStream(clienteSocket.getOutputStream());
        o.writeObject(ea);
        o.flush();

        nickname = null;
        System.exit(0);
    }

    private static void logoutVendedor() throws IOException, ClassNotFoundException {
    	enviahash = new HashMap<>();
        enviahash.put(Servidor.NOME_VENDEDOR, nickname);

        ea = new EnviaAcoes(Servidor.SAIR_VENDEDOR,enviahash);
        
        o = new ObjectOutputStream(clienteSocket.getOutputStream());
        o.writeObject(ea);
        o.flush();

        nickname = null;
        System.exit(0);
    }  
  

   


}

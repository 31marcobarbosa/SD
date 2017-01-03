

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

	private static Scanner in = new Scanner (System.in);
	public static ObjectOutputStream o = null;
	public static ObjectInputStream i = null;
	public static HashMap <String,String> enviahash;
        public static int option = 0;

    public static int getOption() {
        return option;
    }

    public static void setOption(int option) {
        Menu.option = option;
    }

        
    public static void Manager() throws IOException, ClassNotFoundException{
            if(option == 0) menuInicial();
            if(option == 1) menuLoginComprador();
            if(option == 2) menuLoginVendedor();
            if(option == 3) menuPrincipalComprador();
            if(option == 4) menuPrincipalVendedor();
            if(option == 5) menuCompLeilao();
            if(option == 6) menuVendLeilao();
        }


    public static void menuInicial(){

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> LEILÕES <<<<<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Comprador                                        #");
        System.out.println("#   2 - Vendedor                                         #");
        System.out.println("#   0 - Sair                                             #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");
        
    }


    public static void menuLoginComprador(){
            
    	System.out.println(">>>>>>>>>>>>>>>>>>>> MENU COMPRADOR <<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Entrar                                           #");
        System.out.println("#   2 - Registar                                         #");
        System.out.println("#   0 - Sair                                             #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");
        
      }  
    


    public static void menuLoginVendedor(){

        System.out.println("################## MENU VENDEDOR ###################");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Entrar                                           #");
        System.out.println("#   2 - Registar                                         #");
        System.out.println("#   0 - Sair                                             #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");

    }  



    public static void menuPrincipalComprador(){

        System.out.println("############## Menu Principal Comprador #################");
        System.out.println("#                                                        #");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Escolhe Leilão a Participar(Licitação)           #");
        System.out.println("#   2 - Consultar Leilão                                 #");
        System.out.println("#   0 - Logout                                           #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção                                    #");
        System.out.println("##########################################################");

      	}

    public static void menuPrincipalVendedor(){

        System.out.println("############## Menu Principal Vendedor #################");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Inicia Leilão                                    #");
        System.out.println("#   2 - Consultar Leilão                                 #");
        System.out.println("#   0 - Logout                                           #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção                                    #");
        System.out.println("##########################################################");
        
    }

     public static void menuVendLeilao(){

        System.out.println(">>>>>>>>>>>>>>>>>> MENU LEILÃO VENDEDOR  <<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Terminar Leilão                                  #");
        System.out.println("#   0 - Terminar Sessão                                  #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");

    }



    public static void menuCompLeilao(){

        System.out.println(">>>>>>>>>>>>>>>>>> MENU LEILÃO COMPRADOR  <<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Licitar Leilão                                   #");
        System.out.println("#   0 - Voltar                                           #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("##########################################################");

    }


    


	/*private static void logoutComprador() throws IOException, ClassNotFoundException {
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
        System.exit(0);*/
}  

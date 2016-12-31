import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente {

	// vai possuir o Sockect e os menus
	private static int port = 6666;
	private static String local = "localhost";
	private static Socket clienteSocket;

	private Scanner in = new Scanner (System.in);
	public static ObjectOutputStream o = null;
	public static ObjectInputStream i = null;
	//public static HashMap <String,String> hash;
	public static String nickname = null;


	public static void main (String args[]) throws Exception{
		clienteSocket = new Socket (local,port);
		
		menuTipoUtilizador();
	}


	public static String menuInicial(){

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> LEILÕES <<<<<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#                      ________[_]_______                #"); 
        System.out.println("#                     /\\      _______   \\              #");
        System.out.println("#                    //_\\     \\   /\\   \\             #");
        System.out.println("#                   //___\\     \\ _/  \\  \\            #");
        System.out.println("#                  //_____\\     \\ |[]|    \\           #");
        System.out.println("#                 //_______\\     \\|__|     \\          #");
        System.out.println("#                /XXXXXXXXXX\\                \\         #");
        System.out.println("#               /_I_II  I__I_\\________________\\        #");
        System.out.println("#                 I_I|  I__I_____[]_|_[]_____I           #");
        System.out.println("#                 I_II  I__I_____[]_|_[]_____I           #");
        System.out.println("#                 I II__I  I     XXXXXXX     I           #");
        System.out.println("#              ~~~~''   ''~~~~~~~~~~~~~~~~~~~~~~~~       #");
        System.out.println("#                                                        #");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("#                                                        #");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Comprador                                        #");
        System.out.println("#   2 - Vendedor                                         #");
        System.out.println("#   3 - Sair da aplicação                                #");
	System.out.println("#                                                        #");
	System.out.println("##########################################################");

        String op = in.next();

        if ( !(op.equals("1") || op.equals("2") || op.equals("3")))
                System.out.println("Opcão Inválida!");
				op = menuInicial();

        return op;
    }


    public static void menuIdentUtilizador() throws IOException,ClassNotFoundException{
    	String op;
    	op = menuInicial();

    	do{
    		if (op.equals("1")){
    			menuComprador();
    		}
    		else {
    			if (op.equals("2")) {
    				menuVendedor();
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
    	System op;

    	System.out.println(">>>>>>>>>>>>>>>>>>>> MENU COMPRADOR <<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("#                                                        #");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Iniciar Sessão                                   #");
        System.out.println("#   2 - Registar-se                                      #");
        System.out.println("#                                                        #");
        System.out.println("##########################################################");
        op = in.next();

       
	      if ( !(op.equals("1") || op.equals("2"))){
                System.out.println("Opcão Inválida!");
    	        op = menuLoginComprador();
       		 }
    
        return op;
    }  
    

	public static void menuComprador() throws IOException,ClassNotFoundException{
	
	  String op;
	  op = menuLoginComprador();

		if (op.equals("1")){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> ENTRAR <<<<<<<<<<<<<<<<<<<<<<<<<<");
		in.nextLine();
        	System.out.println("#   Introduza um username:                               #");
        	String nick = in.nextLine();
        	System.out.println("#                                                        #");
        	System.out.println("#   Introduza a password:                                #");
        	String pass = in.nextLine();
        	System.out.println("#                                                        #");
        	System.out.println("##########################################################");
		
        	tabhash = new HashMap <>();
        	tabhash.put(Servidor.NOME_COMPRADOR,nick);
        	tabhash.put(Servidor.PASS_COMPRADOR,pass);

        	// p = new PacoteDados (Servidor.LOGAR_COMPRADOR,tabhash);

        	o = new ObjectOutputStream(clienteSocket.getOutputStream());
            o.writeObject(p);
            o.flush();

            BufferedReader sktInput = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            String result = sktInput.readLine();

            if(result.equals("Entrou")){
                nick = user;
                menuPrincipalPassageiro();
            }else{
                System.err.println("ERRO!!!!!! LOGIN INVÁLIDO COMPRADOR");
                System.exit(0);
            } 
		} else {
			  if (op.equals("2")) {
		    System.out.println(">>>>>>>>>>>>>>>>>>>>>>> REGISTAR <<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println("#                                                        #");
                    in.nextLine()
                    System.out.println("#   Defina um username                                   #");
                    String nick = in.nextLine();
                    System.out.println("#   Defina uma password                                  #");
                    String pass = in.nextLine();
                    System.out.println("#                                                        #");
                    System.out.println("##########################################################");
			  
              		tabhash = new HashMap<>();
                	tabhash.put(Servidor.NOME_PASSAGEIRO, user);
                	tabhash.put(Servidor.PW_PASSAGEIRO, pw);
                
                	// p = new PacoteDados(Servidor.REGISTAR_PASSAGEIRO,tabhash);

                	o = new ObjectOutputStream(clienteSocket.getOutputStream());
	                o.writeObject(p);
    	            o.flush();

    	            BufferedReader sktInput = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                    System.out.println("\n"+sktInput.readLine()+"\n");
			  } else {
			  		System.exit(0);
			  }
			}
		}



    public static String menuLoginVendedor(){
        String op;

        System.out.println(">>>>>>>>>>>>>>>>>>>>> MENU VENDEDOR <<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção:                                   #");
        System.out.println("#                                                        #");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Iniciar Sessão                                   #");
        System.out.println("#   2 - Registar-se                                      #");
        System.out.println("#                                                        #");
        System.out.println("##########################################################");
        op = in.next();

        if ( !(op.equals("1") || op.equals("2")))
            System.out.println("Opcão Inválida!");
            op = menuLoginVendedor();

        return op;
    }  


    public static void menuVendedor () throws IOException, ClassNotFoundException{
    	String op;
    	op = menuLoginVendedor();

    	if (op.equals("1")){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> ENTRAR <<<<<<<<<<<<<<<<<<<<<<<<<<");
                System.out.println("#                                                        #");
		in.nextLine();
        	System.out.println("#   Introduza o seu username:                            #");
        	String nick = in.nextLine();
        	System.out.println("#                                                        #");
        	System.out.println("#   Introduza a password:                                #");
        	String pass = in.nextLine();
        	System.out.println("#                                                        #");
        	System.out.println("##########################################################");
		
        	tabhash = new HashMap <>();
        	tabhash.put(Servidor.NOME_VENDEDOR,nick);
        	tabhash.put(Servidor.PASS_VENDEDOR,pass);

        	// p = new PacoteDados (Servidor.LOGAR_VENDEDOR,tabhash);

        	o = new ObjectOutputStream(clienteSocket.getOutputStream());
            o.writeObject(p);
            o.flush();

            BufferedReader sktInput = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            String result = sktInput.readLine();

            if(result.equals("Entrou")){
                nick = user;
                menuPrincipalVendedor();
            }else{
                System.err.println("ERRO!!!!!! LOGIN INVÁLIDO VENDEDOR");
                System.exit(0);
            } 
        } else {
        		if (op.equals("2")) {
		    System.out.println(">>>>>>>>>>>>>>>>>>>>>>> REGISTAR <<<<<<<<<<<<<<<<<<<<<<<<<");
                    System.out.println("#                                                        #");
                    in.nextLine();
                    System.out.println("#   Defina um username                                   #");
                    String nick = in.nextLine();
                    System.out.println("#   Defina uma password                                  #");
                    String pass = in.nextLine();
                    System.out.println("#                                                        #");
                    System.out.println("##########################################################");
        	
        			tabhash = new HashMap<>();
        			tabhash.put (Servidor.NOME_VENDEDOR,nick);
        			tabhash.put (Servidor.PASS_VENDEDOR,pass);

        			// p = new PacoteDados (Servidor.LOGAR_VENDEDOR,tabhash);

        			o = new ObjectOutputStream(clienteSocket.getOutputStream());
	                o.writeObject(p);
    	            o.flush();

    	             BufferedReader sktInput = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
	                 System.out.println("\n"+sktInput.readLine()+"\n");
		        } else {
		        	System.exit(0);
		        }
		    }            
		}


	public static void menuPrincipalComprador() throws IOException, ClassNotFoundException {

	System.out.println(">>>>>>>>>>>>>>>>>>>>> ÁREA DE COMPRADOR <<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   "  +  nickname  );
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção                                    #");
        System.out.println("#                                                        #");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Participar num Leilão(Licitar)                   #");
        System.out.println("#   2 - Logout                                           #");
        System.out.println("#                                                        #");
        System.out.println("##########################################################");
        String op = in.next();

           do {
               if(op.equals("1")){
                   menuEscolheLeilao();
                }    
            	if(op.equals("2")) {
                   logoutComprador();
               }else{
               	System.out.println("Opcão Inválida!");
               	menuPrincipalComprador();
           		}
        	} while(!(op.equals("1") || op.equals("2")));
      	}


	public static void menuEscolheLeilao() throws IOException, ClassNotFoundException{
	// NÃO ESTOU A VER COMO FAZER O MENU E A PARTE DE
	// ESCOLHER O LEILÃO , NÃO SEI COMO ELE A PARTIR DO
	// MENU VAI COSNEGUIR ESCOLHER UM LEILÃO ATIVO PARA 
	// LICITAR.
	}

	public static void menuPrincipalVendedor() throws IOException, ClassNotFoundException {

	System.out.println(">>>>>>>>>>>>>>>>>>>>> ÁREA DE VENDEDOR <<<<<<<<<<<<<<<<<<<");
        System.out.println("#                                                        #");
        System.out.println("#   "  +  nickname  );
        System.out.println("#                                                        #");
        System.out.println("#   Escolha uma opção                                    #");
        System.out.println("#                                                        #");
        System.out.println("#                                                        #");
        System.out.println("#   1 - Iniciar Leilão                                   #");
        System.out.println("#   2 - Finalizar Leilão Ativo                           #");
        System.out.println("#   3 - Logout                                           #");
        System.out.println("#                                                        #");
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
                	logoutVendedor();
                }
               else{
               	System.out.println("Opcão Inválida!");
               	menuPrincipalComprador();
           		}
        	} while(!(op.equals("1") || op.equals("2") || op.equals("3")));
    }



	// falta fazer menuIniciaLeilao() , menuFinalizaLeilao() e menuEscolheLeilao()

	private static void logoutComprador() throws IOException, ClassNotFoundException {
    	tabhash = new HashMap<>();
        tabhash.put(Servidor.NOME_COMPRADOR, nickname);

        //p = new PacoteDados(Servidor.SAIR_COMPRADOR,tabhash);

        o = new ObjectOutputStream(clienteSocket.getOutputStream());
        o.writeObject(p);
        o.flush();

        nickname = null;
        System.exit(0);
    }

    private static void logoutVendedor() throws IOException, ClassNotFoundException {
    	tabhash = new HashMap<>();
        tabhash.put(Servidor.NOME_VENDEDOR, nickname);

        //p = new PacoteDados(Servidor.SAIR_VENDEDOR,tabhash);

        o = new ObjectOutputStream(clienteSocket.getOutputStream());
        o.writeObject(p);
        o.flush();

        nickname = null;
        System.exit(0);
    }  
  



}
}
